package com.ketra.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaDTO {

	private UUID id;
	private String codigoEntrega;
	private LocalDate fechaEntrega;
	private String estadoEntrega;

	
	public EntregaDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setCodigoEntrega(UtilTexto.VACIO);
		setFechaEntrega(UtilFecha.FECHA_DEFECTO);
		setEstadoEntrega(UtilTexto.VACIO);
	}


	public UUID getId() {
		return id;
	}


	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}


	public String getCodigoEntrega() {
		return codigoEntrega;
	}


	private void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoEntrega);
	}


	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}


	private void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = UtilFecha.obtenerFechaDefecto(fechaEntrega);
	}


	public String getEstadoEntrega() {
		return estadoEntrega;
	}


	private void setEstadoEntrega(String estadoEntrega) {
		this.estadoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estadoEntrega);
	}

	
}
