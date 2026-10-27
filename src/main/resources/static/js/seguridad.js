'use strict';

window.SeguridadKetra = (function () {

    function mostrarError(mensaje) {

        const elemento = document.querySelector('[role="status"]');

        if (elemento) {

            elemento.textContent = mensaje;

            elemento.classList.add('error');

        }

    }

    async function leerRespuesta(respuesta) {

        if (respuesta.status === 401) {

            window.location.assign('/login.html?sesion');

            throw new Error('Tu sesión terminó. Inicia sesión nuevamente.');

        }

        if (respuesta.status === 204) {

            return null;

        }

        const tipo = respuesta.headers.get('Content-Type') || '';

        if (!tipo.includes('application/json')) {

            throw new Error('El servidor no pudo completar la solicitud.');

        }

        const contenido = await respuesta.json();

        if (!respuesta.ok || contenido.estado === 'ERROR') {

            const mensaje = Array.isArray(contenido.mensajes)
                ? contenido.mensajes.join(' ')
                : 'No fue posible completar la operación.';

            throw new Error(mensaje);

        }

        return contenido;

    }

    async function solicitar(url, opciones = {}) {

        const configuracion = Object.assign({}, opciones);

        const encabezados = new Headers(configuracion.headers || {});

        encabezados.set('Accept', 'application/json');

        const metodo = (configuracion.method || 'GET').toUpperCase();

        if (!['GET', 'HEAD', 'OPTIONS'].includes(metodo)) {

            const respuestaToken = await fetch('/api/v1/sesion/csrf', {
                credentials: 'same-origin',
                headers: {Accept: 'application/json'}
            });

            const respuestaCsrf = await leerRespuesta(respuestaToken);

            const token = respuestaCsrf.datos[0];

            encabezados.set(token.headerName, token.token);

        }

        configuracion.headers = encabezados;

        configuracion.credentials = 'same-origin';

        const respuesta = await fetch(url, configuracion);

        return leerRespuesta(respuesta);

    }

    async function cargarSesion() {

        try {

            const respuesta = await solicitar('/api/v1/sesion');

            const sesion = respuesta.datos[0];

            for (const nombre of document.querySelectorAll('[data-nombre-usuario]')) {

                nombre.textContent = sesion.nombre || sesion.correo;

                nombre.title = sesion.correo;

            }

        } catch (error) {

            mostrarError(error.message);

        }

    }

    async function cerrarSesion(evento) {

        const boton = evento.currentTarget;

        if (boton.disabled) {

            return;

        }

        boton.disabled = true;

        try {

            await solicitar('/logout', {method: 'POST'});

            window.location.assign('/login.html?salida');

        } catch (error) {

            mostrarError(error.message);

            boton.disabled = false;

        }

    }

    document.addEventListener('DOMContentLoaded', function () {

        cargarSesion();

        for (const boton of document.querySelectorAll('[data-cerrar-sesion]')) {

            boton.addEventListener('click', cerrarSesion);

        }

    });

    return {solicitar: solicitar};

})();
