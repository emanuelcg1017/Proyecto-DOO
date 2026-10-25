'use strict';

const formularioIngreso = document.getElementById('ingresar-google');

const botonIngreso = document.getElementById('continuar-google');

const mensajeIngreso = document.getElementById('mensaje-ingreso');

const parametrosIngreso = new URLSearchParams(window.location.search);

if (parametrosIngreso.has('error')) {

    mensajeIngreso.textContent = 'No fue posible ingresar. Comprueba que estés usando una cuenta autorizada.';

    mensajeIngreso.classList.add('error');

} else if (parametrosIngreso.has('salida')) {

    mensajeIngreso.textContent = 'Tu sesión se cerró correctamente.';

} else if (parametrosIngreso.has('sesion')) {

    mensajeIngreso.textContent = 'Tu sesión terminó. Ingresa nuevamente para continuar.';

}

formularioIngreso.addEventListener('submit', function (evento) {

    if (botonIngreso.disabled) {

        evento.preventDefault();

        return;

    }

    botonIngreso.disabled = true;

    botonIngreso.textContent = 'Conectando con Google…';

});

window.addEventListener('pageshow', function () {

    botonIngreso.disabled = false;

    botonIngreso.textContent = 'Continuar con Google';

});
