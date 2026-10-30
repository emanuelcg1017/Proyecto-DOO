'use strict';

const consultaServicios = document.getElementById('consulta-servicios');

const mensajeServicios = document.getElementById('mensaje-servicios');

const listaServicios = document.getElementById('lista-servicios');

const enlaceUtilidad = document.getElementById('utilidad-generada');

const baseServicios = consultaServicios.dataset.apiBase;

let serviciosConsultados = [];

let estadosServicio = [];

let transicionesFinalizacion = [];

let idEstadoFinalizado = '';

let cargandoCatalogos = true;

let consultaEnCurso = false;

let finalizacionEnCurso = false;

function esIdentificadorValido(id) {

    return /^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/i.test(id)
        && id !== '00000000-0000-0000-0000-000000000000';

}

function tieneTransicionFinalizacion(servicio) {

    return transicionesFinalizacion.some(function (transicion) {

        return transicion.estadoOrigen.id === servicio.estado.id
            && transicion.estadoDestino.id === idEstadoFinalizado;

    });

}

function actualizarDisponibilidadServicios() {

    const ocupado = cargandoCatalogos || consultaEnCurso || finalizacionEnCurso;

    consultaServicios.querySelector('button').disabled = ocupado;

    for (const campo of consultaServicios.querySelectorAll('input, select')) {

        campo.disabled = ocupado;

    }

    for (const boton of document.querySelectorAll('.finalizar-servicio')) {

        const servicio = serviciosConsultados.find(function (dato) {

            return dato.id === boton.dataset.id;

        });

        boton.disabled = ocupado || !servicio || !tieneTransicionFinalizacion(servicio);

    }

    listaServicios.setAttribute('aria-busy', String(ocupado));

}

function mostrarMensajeServicios(mensaje, esError = false) {

    mensajeServicios.textContent = mensaje;

    mensajeServicios.classList.toggle('error', esError);

}

function mostrarServicios(servicios) {

    serviciosConsultados = servicios;

    document.getElementById('cantidad').textContent = `${servicios.length} ${servicios.length === 1 ? 'servicio' : 'servicios'}`;

    listaServicios.replaceChildren();

    for (const servicio of servicios) {

        const fila = listaServicios.insertRow();

        for (const valor of [servicio.numeroServicio, servicio.fechaServicio, servicio.estado.nombre]) {

            fila.insertCell().textContent = valor;

        }

        const acciones = fila.insertCell();

        if (servicio.estado.id === idEstadoFinalizado) {

            const enlace = document.createElement('a');

            enlace.className = 'ver-utilidad';

            enlace.href = `/consultar-utilidad.html?servicio=${encodeURIComponent(servicio.id)}`;

            enlace.textContent = 'Ver utilidad';

            acciones.append(enlace);

        } else {

            const boton = document.createElement('button');

            boton.type = 'button';

            boton.className = 'finalizar-servicio';

            boton.dataset.id = servicio.id;

            boton.textContent = 'Finalizar servicio';

            boton.title = tieneTransicionFinalizacion(servicio)
                ? 'El backend comprobará las entregas y generará la utilidad.'
                : 'No hay una transición de finalización configurada desde este estado.';

            boton.addEventListener('click', function () {

                finalizarServicio(servicio.id);

            });

            acciones.append(boton);

        }

    }

    if (servicios.length === 0) {

        const celda = listaServicios.insertRow().insertCell();

        celda.colSpan = 4;

        celda.className = 'empty-services';

        celda.textContent = 'No se encontraron servicios con esos filtros.';

    }

    actualizarDisponibilidadServicios();

}

consultaServicios.addEventListener('submit', async function (evento) {

    evento.preventDefault();

    if (cargandoCatalogos || consultaEnCurso || finalizacionEnCurso) {

        return;

    }

    const numero = document.getElementById('numero').value.trim();

    const estado = document.getElementById('filtro-estado').value;

    if (numero.length > 30) {

        mostrarMensajeServicios('El número del servicio no puede superar los 30 caracteres.', true);

        return;

    }

    if (estado && !estadosServicio.some(function (dato) { return dato.id === estado; })) {

        mostrarMensajeServicios('Selecciona un estado del catálogo.', true);

        return;

    }

    const parametros = new URLSearchParams();

    if (numero) {

        parametros.set('numeroServicio', numero);

    }

    if (estado) {

        parametros.set('estado.id', estado);

    }

    consultaEnCurso = true;

    actualizarDisponibilidadServicios();

    try {

        mostrarMensajeServicios('Consultando servicios…');

        const respuestas = await Promise.all([
            SeguridadKetra.solicitar(`${baseServicios}?${parametros}`),
            SeguridadKetra.solicitar(`${baseServicios}/transiciones-finalizacion`)
        ]);

        transicionesFinalizacion = respuestas[1].datos;

        mostrarServicios(respuestas[0].datos);

        mostrarMensajeServicios('Consulta realizada.');

    } catch (error) {

        mostrarMensajeServicios(error.message, true);

    } finally {

        consultaEnCurso = false;

        actualizarDisponibilidadServicios();

    }

});

async function finalizarServicio(idServicio) {

    if (cargandoCatalogos || consultaEnCurso || finalizacionEnCurso) {

        return;

    }

    const servicio = serviciosConsultados.find(function (dato) { return dato.id === idServicio; });

    if (!esIdentificadorValido(idServicio) || !servicio || !tieneTransicionFinalizacion(servicio)) {

        mostrarMensajeServicios('Selecciona un servicio con una transición de finalización permitida.', true);

        return;

    }

    finalizacionEnCurso = true;

    enlaceUtilidad.hidden = true;

    actualizarDisponibilidadServicios();

    try {

        mostrarMensajeServicios('Finalizando el servicio y generando su utilidad…');

        const respuesta = await SeguridadKetra.solicitar(`${baseServicios}/${encodeURIComponent(idServicio)}/finalizacion`, {
            method: 'PUT'
        });

        const actualizado = respuesta.datos[0];

        const filtroEstado = document.getElementById('filtro-estado').value;

        const resultados = [];

        for (const anterior of serviciosConsultados) {

            const dato = anterior.id === idServicio ? actualizado : anterior;

            if (!filtroEstado || dato.estado.id === filtroEstado) {

                resultados.push(dato);

            }

        }

        mostrarServicios(resultados);

        enlaceUtilidad.href = `/consultar-utilidad.html?servicio=${encodeURIComponent(idServicio)}`;

        enlaceUtilidad.hidden = false;

        mostrarMensajeServicios(respuesta.mensajes[0]);

    } catch (error) {

        mostrarMensajeServicios(error.message, true);

    } finally {

        finalizacionEnCurso = false;

        actualizarDisponibilidadServicios();

    }

}

async function cargarCatalogosServicio() {

    actualizarDisponibilidadServicios();

    try {

        const respuestas = await Promise.all([
            SeguridadKetra.solicitar(`${baseServicios}/estados`),
            SeguridadKetra.solicitar(`${baseServicios}/estado-finalizado`),
            SeguridadKetra.solicitar(`${baseServicios}/transiciones-finalizacion`)
        ]);

        estadosServicio = respuestas[0].datos;

        idEstadoFinalizado = respuestas[1].datos[0].id;

        transicionesFinalizacion = respuestas[2].datos;

        const selector = document.getElementById('filtro-estado');

        selector.replaceChildren(new Option('Todos los estados', ''));

        for (const estado of estadosServicio) {

            selector.add(new Option(estado.nombre, estado.id));

        }

        cargandoCatalogos = false;

    } catch (error) {

        mostrarMensajeServicios(error.message, true);

    } finally {

        actualizarDisponibilidadServicios();

    }

}

cargarCatalogosServicio();
