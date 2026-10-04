'use strict';

const form = document.getElementById('consulta-form');
const button = document.getElementById('consultar');
const result = document.getElementById('resultado');
const message = document.getElementById('mensaje');
const currency = new Intl.NumberFormat('es-CO', { style: 'currency', currency: 'COP', maximumFractionDigits: 0 });
const distance = new Intl.NumberFormat('es-CO', { maximumFractionDigits: 1 });
const money = value => currency.format(value);
const date = value => {
  const [year, month, day] = value.split('-');
  return `${day}/${month}/${year}`;
};
const text = (id, value) => { document.getElementById(id).textContent = value; };

function fillTable(id, items, columns) {
  const body = document.getElementById(id);
  body.replaceChildren();
  if (!items.length) {
    const row = body.insertRow();
    const cell = row.insertCell();
    cell.colSpan = columns.length;
    cell.textContent = 'No hay registros asociados.';
    return;
  }
  for (const item of items) {
    const row = body.insertRow();
    for (const column of columns) {
      const cell = row.insertCell();
      const value = item[column.key];
      if (column.amount) cell.classList.add('amount');
      if (column.status) {
        const badge = document.createElement('span');
        badge.className = 'status-pill';
        badge.textContent = value;
        cell.append(badge);
      } else {
        cell.textContent = column.format ? column.format(value) : value;
      }
    }
  }
}

function render(data) {
  text('numero-servicio', data.numeroServicio);
  text('fecha-servicio', date(data.fechaServicio));
  text('estado-servicio', data.estadoServicio);
  for (const [id, value] of Object.entries({
    'total-ingresos': data.valorIngresos, 'total-costos': data.valorCostos,
    'valor-ingresos': data.valorIngresos, 'valor-costos': data.valorCostos,
    'valor-utilidad': data.valorUtilidad
  })) text(id, money(value));
  fillTable('facturas', data.facturas, [
    {key:'numeroFactura'}, {key:'fechaFactura',format:date},
    {key:'ingresos',format:money,amount:true}, {key:'estadoFactura',status:true}
  ]);
  fillTable('entregas', data.entregas, [
    {key:'codigoEntrega'}, {key:'fechaEntrega',format:date}, {key:'estadoEntrega',status:true}
  ]);
  fillTable('detalles', data.detallesEntrega, [
    {key:'numeroDetalleEntrega'}, {key:'codigoEntrega'}, {key:'numeroPedido'},
    {key:'distanciaKM',format:value=>distance.format(value),amount:true}
  ]);
  fillTable('costos', data.costosRecorrido, [
    {key:'numeroCosto'}, {key:'numeroDetalleEntrega'}, {key:'valorPorKM',format:money,amount:true},
    {key:'distanciaKM',format:value=>distance.format(value),amount:true},
    {key:'valorCosto',format:money,amount:true}
  ]);
}

form.addEventListener('submit', async event => {
  event.preventDefault();
  if (button.disabled) return;
  button.disabled = true;
  button.textContent = 'Consultando…';
  result.hidden = true;
  result.setAttribute('aria-busy', 'true');
  message.classList.remove('error');
  message.textContent = 'Consultando la utilidad del servicio…';
  const controller = new AbortController();
  const timeout = setTimeout(() => controller.abort(), 15000);
  try {
    const service = document.getElementById('servicio').value;
    const response = await fetch(form.dataset.apiBase + encodeURIComponent(service), {
      headers: { Accept: 'application/json' }, signal: controller.signal
    });
    if (!response.ok) throw new Error(response.status === 404
      ? 'No se encontró una utilidad para el servicio seleccionado.'
      : 'No fue posible consultar la utilidad. Intenta nuevamente.');
    render(await response.json());
    result.hidden = false;
    message.textContent = `Utilidad del servicio ${service} consultada correctamente.`;
  } catch (error) {
    message.classList.add('error');
    message.textContent = error.name === 'AbortError'
      ? 'La consulta tardó demasiado. Intenta nuevamente.'
      : error instanceof TypeError
        ? 'No se pudo conectar con el servidor. Intenta nuevamente.'
        : error.message;
  } finally {
    clearTimeout(timeout);
    button.disabled = false;
    button.textContent = 'Consultar utilidad';
    result.setAttribute('aria-busy', 'false');
  }
});
