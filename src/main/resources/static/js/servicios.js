'use strict';
const consultaServicios = document.getElementById('consulta-servicios');
const mensajeServicios = document.getElementById('mensaje-servicios');
const transicionesServicio = {'Registrado':['En ejecución','Cancelado'],'En ejecución':['Finalizado'],'Finalizado':[],'Cancelado':[]};
let serviciosConsultados = [];

function seleccionarServicio(servicio) {
  document.getElementById('id-servicio').value = servicio.id;
  document.getElementById('numero-seleccionado').value = servicio.numeroServicio;
  document.getElementById('fecha-seleccionada').value = servicio.fechaServicio;
  document.getElementById('estado-actual').value = servicio.estado;
  const selector = document.getElementById('nuevo-estado');
  selector.replaceChildren();
  const opciones = transicionesServicio[servicio.estado] || [];
  selector.add(new Option(opciones.length ? 'Selecciona el nuevo estado' : 'No admite cambios', ''));
  for (const estado of opciones) selector.add(new Option(estado, estado));
  selector.disabled = !opciones.length;
  document.getElementById('guardar-estado').disabled = true;
  document.getElementById('nota-estado').textContent = opciones.includes('Finalizado')
    ? 'Al finalizar se registra automáticamente la utilidad. Este cambio es definitivo.'
    : opciones.length ? 'Solo se modificará el estado. El número y la fecha se conservan.' : 'Este servicio se encuentra en un estado definitivo.';
}

function mostrarServicios(servicios) {
  serviciosConsultados = servicios;
  document.getElementById('cantidad').textContent = `${servicios.length} servicios`;
  const lista = document.getElementById('lista-servicios');
  lista.replaceChildren();
  for (const servicio of servicios) {
    const fila = lista.insertRow();
    for (const valor of [servicio.numeroServicio, servicio.fechaServicio, servicio.estado]) fila.insertCell().textContent = valor;
    const boton = document.createElement('button');
    boton.type = 'button'; boton.className = 'select-service'; boton.textContent = 'Seleccionar';
    boton.addEventListener('click', () => seleccionarServicio(servicio));
    fila.insertCell().append(boton);
  }
  if (!servicios.length) {
    const celda = lista.insertRow().insertCell(); celda.colSpan = 4;
    celda.className = 'empty-services'; celda.textContent = 'No se encontraron servicios con esos filtros.';
  }
}

async function solicitarServicios(url, opciones) {
  const respuesta = await fetch(url, opciones);
  const contenido = await respuesta.json();
  if (!respuesta.ok || contenido.estado === 'ERROR') throw new Error(contenido.mensajes?.join(' ') || 'No fue posible completar la operación.');
  return contenido.datos;
}

consultaServicios.addEventListener('submit', async evento => {
  evento.preventDefault();
  const base = consultaServicios.dataset.apiBase;
  if (!base) { mensajeServicios.textContent = 'La consulta de servicios no está disponible por el momento.'; return; }
  document.getElementById('id-servicio').value = '';
  document.getElementById('guardar-estado').disabled = true;
  document.getElementById('nuevo-estado').disabled = true;
  const parametros = new URLSearchParams();
  const numero = document.getElementById('numero').value.trim();
  const estado = document.getElementById('filtro-estado').value;
  if (numero) parametros.set('numeroServicio', numero);
  if (estado) parametros.set('estado', estado);
  const boton = consultaServicios.querySelector('button'); boton.disabled = true;
  try {
    mensajeServicios.textContent = 'Consultando servicios…';
    mostrarServicios(await solicitarServicios(`${base}?${parametros}`, {headers:{Accept:'application/json'}}));
    mensajeServicios.textContent = 'Consulta realizada.';
  } catch (error) { mensajeServicios.textContent = error.message; }
  finally { boton.disabled = false; }
});
document.getElementById('nuevo-estado').addEventListener('change', evento => {
  document.getElementById('guardar-estado').disabled = !evento.target.value || !document.getElementById('id-servicio').value;
});
document.getElementById('actualizar-estado').addEventListener('submit', async evento => {
  evento.preventDefault();
  const base = consultaServicios.dataset.apiBase;
  const id = document.getElementById('id-servicio').value;
  const estado = document.getElementById('nuevo-estado').value;
  if (!base || !id || !estado) return;
  const boton = document.getElementById('guardar-estado'); boton.disabled = true;
  try {
    const datos = await solicitarServicios(`${base}/${encodeURIComponent(id)}/estado`, {
      method:'PATCH', headers:{'Content-Type':'application/json',Accept:'application/json'}, body:JSON.stringify({estado})
    });
    const actualizado = datos[0];
    mostrarServicios(serviciosConsultados.map(servicio => servicio.id === id ? actualizado : servicio));
    seleccionarServicio(actualizado);
    mensajeServicios.textContent = 'Estado actualizado correctamente.';
  } catch (error) { mensajeServicios.textContent = error.message; boton.disabled = false; }
});
