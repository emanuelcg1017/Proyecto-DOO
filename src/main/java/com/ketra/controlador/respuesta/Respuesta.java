package com.ketra.controlador.respuesta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public abstract class Respuesta<D> {

	private final LocalDateTime timestamp;

	private final String correlationId;

	private List<String> mensajes;

	private List<D> datos;

	private EstadoRespuesta estado;

	protected Respuesta(List<String> mensajes, List<D> datos, EstadoRespuesta estado) {

		setMensajes(mensajes);

		setDatos(datos);

		setEstado(estado);

		this.timestamp = UtilFecha.generarFechaHoraActual();

		this.correlationId = UtilUUID.generarComoTexto();

	}

	private void setMensajes(List<String> mensajes) {

		this.mensajes = UtilObjeto.obtenerValorDefectoSiNulo(mensajes, new ArrayList<String>());

	}

	private void setDatos(List<D> datos) {

		this.datos = UtilObjeto.obtenerValorDefectoSiNulo(datos, new ArrayList<D>());

	}

	private void setEstado(EstadoRespuesta estado) {

		this.estado = UtilObjeto.obtenerValorDefectoSiNulo(estado, EstadoRespuesta.ERROR);

	}

	public LocalDateTime getTimestamp() {

		return timestamp;

	}

	public String getCorrelationId() {

		return correlationId;

	}

	public List<String> getMensajes() {

		return mensajes;

	}

	public List<D> getDatos() {

		return datos;

	}

	public EstadoRespuesta getEstado() {

		return estado;

	}

}
