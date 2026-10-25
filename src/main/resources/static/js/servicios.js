'use strict';

const consultaServicios = document.getElementById('consulta-servicios');

const mensajeServicios = document.getElementById('mensaje-servicios');

const formularioEstado = document.getElementById('actualizar-estado');

const selectorEstado = document.getElementById('nuevo-estado');

const botonActualizar = document.getElementById('guardar-estado');

const transicionesServicio = {
    'Registrado': ['En ejecución', 'Cancelado'],
    'En ejecución': ['Finalizado'],
    'Finalizado': [],
    'Cancelado': []
};

let serviciosConsultados = [];

let consultaEnCurso = false;

let actualizacionEnCurso = false;

function actualizarDisponibilidadServicios() {

    const ocupado = consultaEnCurso || actualizacionEnCurso;

    consultaServicios.querySelector('button').disabled = ocupado;

    for (const campo of consultaServicios.querySelectorAll('input, select')) {

        campo.disabled = ocupado;

    }

    for (const boton of document.querySelectorAll('.select-service')) {

        boton.disabled = ocupado;

    }

    const id = document.getElementById('id-servicio').value;

    const estadoActual = document.getElementById('estado-actual').value;

    const opciones = transicionesServicio[estadoActual] || [];

    selectorEstado.disabled = ocupado || !id || opciones.length === 0;

    botonActualizar.disabled = ocupado || !id || !selectorEstado.value;

}

function mostrarMensajeServicios(mensaje, esError = false) {

    mensajeServicios.textContent = mensaje;

    mensajeServicios.classList.toggle('error', esError);

}

function seleccionarServicio(servicio) {

    document.getElementById('id-servicio').value = servicio.id;

    document.getElementById('numero-seleccionado').value = servicio.numeroServicio;

    document.getElementById('fecha-seleccionada').value = servicio.fechaServicio;

    document.getElementById('estado-actual').value = servicio.estado;

    const opciones = transicionesServicio[servicio.estado] || [];

    selectorEstado.replaceChildren(
        new Option(opciones.length ? 'Selecciona el nuevo estado' : 'No admite cambios', '')
    );

    for (const estado of opciones) {

        selectorEstado.add(new Option(estado, estado));

    }

    selectorEstado.disabled = opciones.length === 0;

    botonActualizar.disabled = true;

    let nota = 'Este servicio se encuentra en un estado definitivo.';

    if (opciones.includes('Finalizado')) {

        nota = 'Al finalizar se registra automáticamente la utilidad. Este cambio es definitivo.';

    } else if (opciones.length > 0) {

        nota = 'Solo se modificará el estado. El número y la fecha se conservan.';

    }

    document.getElementById('nota-estado').textContent = nota;

}

function mostrarServicios(servicios) {

    serviciosConsultados = servicios;

    document.getElementById('cantidad').textContent = `${servicios.length} ${servicios.length === 1 ? 'servicio' : 'servicios'}`;

    const lista = document.getElementById('lista-servicios');

    lista.replaceChildren();

    for (const servicio of servicios) {

        const fila = lista.insertRow();

        const valores = [servicio.numeroServicio, servicio.fechaServicio, servicio.estado];

        for (const valor of valores) {

            fila.insertCell().textContent = valor;

        }

        const boton = document.createElement('button');

        boton.type = 'button';

        boton.className = 'select-service';

        boton.textContent = 'Seleccionar';

        boton.addEventListener('click', function () {

            if (!consultaEnCurso && !actualizacionEnCurso) {

                seleccionarServicio(servicio);

            }

        });

        fila.insertCell().append(boton);

    }

    if (servicios.length === 0) {

        const celda = lista.insertRow().insertCell();

        celda.colSpan = 4;

        celda.className = 'empty-services';

        celda.textContent = 'No se encontraron servicios con esos filtros.';

    }

}

async function solicitarServicios(url, opciones) {

    return SeguridadKetra.solicitar(url, opciones);

}

consultaServicios.addEventListener('submit', async function (evento) {

    evento.preventDefault();

    if (consultaEnCurso || actualizacionEnCurso) {

        return;

    }

    consultaEnCurso = true;

    const base = consultaServicios.dataset.apiBase;

    formularioEstado.reset();

    document.getElementById('id-servicio').value = '';

    selectorEstado.disabled = true;

    botonActualizar.disabled = true;

    document.getElementById('nota-estado').textContent = 'Selecciona un servicio de los resultados.';

    const parametros = new URLSearchParams();

    const numero = document.getElementById('numero').value.trim();

    const estado = document.getElementById('filtro-estado').value;

    if (numero) {

        parametros.set('numeroServicio', numero);

    }

    if (estado) {

        parametros.set('estado', estado);

    }

    let url = base;

    if (parametros.size > 0) {

        url = `${base}/filtro?${parametros}`;

    }

    actualizarDisponibilidadServicios();

    try {

        mostrarMensajeServicios('Consultando servicios…');

        const servicios = await solicitarServicios(url, {
            headers: {
                Accept: 'application/json'
            }
        });

        mostrarServicios(servicios);

        mostrarMensajeServicios('Consulta realizada.');

    } catch (error) {

        mostrarMensajeServicios(error.message, true);

    } finally {

        consultaEnCurso = false;

        actualizarDisponibilidadServicios();

    }

});

selectorEstado.addEventListener('change', function () {

    actualizarDisponibilidadServicios();

});

formularioEstado.addEventListener('submit', async function (evento) {

    evento.preventDefault();

    if (consultaEnCurso || actualizacionEnCurso) {

        return;

    }

    const base = consultaServicios.dataset.apiBase;

    const id = document.getElementById('id-servicio').value;

    const estado = selectorEstado.value;

    if (!id || !estado || botonActualizar.disabled) {

        return;

    }

    actualizacionEnCurso = true;

    actualizarDisponibilidadServicios();

    try {

        mostrarMensajeServicios('Actualizando el estado…');

        const actualizado = await solicitarServicios(`${base}/${encodeURIComponent(id)}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            },
            body: JSON.stringify({estado: estado})
        });

        const serviciosActualizados = [];

        for (const servicio of serviciosConsultados) {

            const resultado = servicio.id === id ? actualizado : servicio;

            const filtroEstado = document.getElementById('filtro-estado').value;

            if (!filtroEstado || resultado.estado === filtroEstado) {

                serviciosActualizados.push(resultado);

            }

        }

        mostrarServicios(serviciosActualizados);

        seleccionarServicio(actualizado);

        mostrarMensajeServicios('Estado actualizado correctamente.');

    } catch (error) {

        mostrarMensajeServicios(error.message, true);

    } finally {

        actualizacionEnCurso = false;

        actualizarDisponibilidadServicios();

    }

});
