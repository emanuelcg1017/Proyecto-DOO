'use strict';

const formularioUtilidad = document.getElementById('consulta-form');

const selectorServicio = document.getElementById('servicio');

const botonConsultar = document.getElementById('consultar');

const resultadoUtilidad = document.getElementById('resultado');

const mensajeUtilidad = document.getElementById('mensaje');

let consultaUtilidadEnCurso = false;

const formatoMoneda = new Intl.NumberFormat('es-CO', {
    style: 'currency',
    currency: 'COP',
    minimumFractionDigits: 0,
    maximumFractionDigits: 2
});

const formatoDistancia = new Intl.NumberFormat('es-CO', {
    maximumFractionDigits: 2
});

function mostrarMensajeUtilidad(mensaje, esError = false) {

    mensajeUtilidad.textContent = mensaje;

    mensajeUtilidad.classList.toggle('error', esError);

}

function mostrarTexto(id, valor) {

    document.getElementById(id).textContent = valor;

}

function formatearFecha(fecha) {

    const partes = fecha.split('-');

    return `${partes[2]}/${partes[1]}/${partes[0]}`;

}

async function solicitarDatos(url) {

    return SeguridadKetra.solicitar(url);

}

async function cargarServiciosFinalizados() {

    selectorServicio.disabled = true;

    botonConsultar.disabled = true;

    try {

        const parametros = new URLSearchParams();

        parametros.set('estado', 'Finalizado');

        const servicios = await solicitarDatos(`/api/v1/servicios/filtro?${parametros}`);

        selectorServicio.replaceChildren(new Option('Seleccione un servicio', ''));

        for (const servicio of servicios) {

            selectorServicio.add(new Option(servicio.numeroServicio, servicio.id));

        }

        selectorServicio.disabled = servicios.length === 0;

        if (servicios.length === 0) {

            mostrarMensajeUtilidad('No hay servicios finalizados para consultar.');

        } else {

            mostrarMensajeUtilidad('Selecciona un servicio y consulta su utilidad.');

        }

    } catch (error) {

        selectorServicio.replaceChildren(new Option('No fue posible cargar los servicios', ''));

        mostrarMensajeUtilidad(error.message, true);

    }

}

function obtenerValorColumna(datos, clave) {

    let valor = datos;

    for (const parte of clave.split('.')) {

        valor = valor[parte];

    }

    return valor;

}

function mostrarTabla(id, filas, columnas) {

    const cuerpo = document.getElementById(id);

    cuerpo.replaceChildren();

    if (filas.length === 0) {

        const celda = cuerpo.insertRow().insertCell();

        celda.colSpan = columnas.length;

        celda.textContent = 'No hay registros asociados.';

        return;

    }

    const filasOrdenadas = filas.slice();

    filasOrdenadas.sort(function (primera, segunda) {

        return obtenerValorColumna(primera, columnas[0].clave).localeCompare(obtenerValorColumna(segunda, columnas[0].clave), 'es', {
            numeric: true
        });

    });

    for (const datos of filasOrdenadas) {

        const fila = cuerpo.insertRow();

        for (const columna of columnas) {

            const celda = fila.insertCell();

            const valor = obtenerValorColumna(datos, columna.clave);

            if (columna.importe || columna.distancia) {

                celda.classList.add('amount');

            }

            if (columna.estado) {

                const etiqueta = document.createElement('span');

                etiqueta.className = 'status-pill';

                etiqueta.textContent = valor;

                if (valor === 'Anulada' || valor === 'Cancelado') {

                    etiqueta.classList.add('status-cancelado');

                } else if (valor !== 'Pagada' && valor !== 'Entregada' && valor !== 'Finalizado') {

                    etiqueta.classList.add('status-pendiente');

                }

                celda.append(etiqueta);

            } else if (columna.importe) {

                celda.textContent = formatoMoneda.format(valor);

            } else if (columna.distancia) {

                celda.textContent = formatoDistancia.format(valor);

            } else if (columna.fecha) {

                celda.textContent = formatearFecha(valor);

            } else {

                celda.textContent = valor;

            }

        }

    }

}

function mostrarUtilidad(utilidad) {

    if (!utilidad.id || utilidad.id === '00000000-0000-0000-0000-000000000000') {

        throw new Error('Este servicio todavía no tiene una utilidad registrada.');

    }

    const servicio = utilidad.servicio;

    mostrarTexto('numero-servicio', servicio.numeroServicio);

    mostrarTexto('fecha-servicio', formatearFecha(servicio.fechaServicio));

    mostrarTexto('estado-servicio', servicio.estado);

    mostrarTexto('total-ingresos', formatoMoneda.format(utilidad.valorIngresos));

    mostrarTexto('total-costos', formatoMoneda.format(utilidad.valorCostos));

    mostrarTexto('valor-ingresos', formatoMoneda.format(utilidad.valorIngresos));

    mostrarTexto('valor-costos', formatoMoneda.format(utilidad.valorCostos));

    mostrarTexto('valor-utilidad', formatoMoneda.format(utilidad.valorUtilidad));

    mostrarTabla('facturas', utilidad.facturas, [
        {clave: 'numeroFactura'},
        {clave: 'fechaFactura', fecha: true},
        {clave: 'ingresos', importe: true},
        {clave: 'estadoFactura', estado: true}
    ]);

    mostrarTabla('entregas', utilidad.entregas, [
        {clave: 'codigoEntrega'},
        {clave: 'fechaEntrega', fecha: true},
        {clave: 'estadoEntrega', estado: true}
    ]);

    mostrarTabla('detalles', utilidad.detallesEntrega, [
        {clave: 'numeroDetalleEntrega'},
        {clave: 'entrega.codigoEntrega'},
        {clave: 'pedido.numeroPedido'},
        {clave: 'CEDIOrigen.nombre'},
        {clave: 'direccionDestino.nombre'},
        {clave: 'distanciaKM', distancia: true}
    ]);

    mostrarTabla('costos', utilidad.costosRecorrido, [
        {clave: 'numeroCosto'},
        {clave: 'detalleEntrega.numeroDetalleEntrega'},
        {clave: 'valorPorKM', importe: true},
        {clave: 'detalleEntrega.distanciaKM', distancia: true},
        {clave: 'valorCosto', importe: true}
    ]);

}

selectorServicio.addEventListener('change', function () {

    resultadoUtilidad.hidden = true;

    botonConsultar.disabled = !selectorServicio.value;

    mostrarMensajeUtilidad('Selecciona un servicio y consulta su utilidad.');

});

formularioUtilidad.addEventListener('submit', async function (evento) {

    evento.preventDefault();

    const idServicio = selectorServicio.value;

    if (!idServicio || botonConsultar.disabled || consultaUtilidadEnCurso) {

        return;

    }

    consultaUtilidadEnCurso = true;

    botonConsultar.disabled = true;

    selectorServicio.disabled = true;

    resultadoUtilidad.hidden = true;

    resultadoUtilidad.setAttribute('aria-busy', 'true');

    try {

        mostrarMensajeUtilidad('Consultando la utilidad del servicio…');

        const url = `${formularioUtilidad.dataset.apiBase}${encodeURIComponent(idServicio)}`;

        const utilidad = await solicitarDatos(url);

        mostrarUtilidad(utilidad);

        resultadoUtilidad.hidden = false;

        mostrarMensajeUtilidad(
            `Utilidad del servicio ${utilidad.servicio.numeroServicio} consultada correctamente.`
        );

    } catch (error) {

        mostrarMensajeUtilidad(error.message, true);

    } finally {

        consultaUtilidadEnCurso = false;

        selectorServicio.disabled = false;

        botonConsultar.disabled = !selectorServicio.value;

        resultadoUtilidad.setAttribute('aria-busy', 'false');

    }

});

cargarServiciosFinalizados();
