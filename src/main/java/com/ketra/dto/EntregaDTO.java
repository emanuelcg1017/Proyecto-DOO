package com.ketra.dto;

import com.ketra.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaDTO {

	private UUID id;

	private String codigoEntrega;

	private LocalDate fechaEntrega;

	private EstadoEntregaDTO estadoEntrega;

	public EntregaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setCodigoEntrega(UtilTexto.VACIO);

		setFechaEntrega(UtilFecha.FECHA_DEFECTO);

		setEstadoEntrega(new EstadoEntregaDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getCodigoEntrega() {

		return codigoEntrega;

	}

	public void setCodigoEntrega(String codigoEntrega) {

		this.codigoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoEntrega);

	}

	public LocalDate getFechaEntrega() {

		return fechaEntrega;

	}

	public void setFechaEntrega(LocalDate fechaEntrega) {

		this.fechaEntrega = UtilFecha.obtenerFechaDefecto(fechaEntrega);

	}

	public EstadoEntregaDTO getEstadoEntrega() {

		return estadoEntrega;

	}

	public void setEstadoEntrega(EstadoEntregaDTO estadoEntrega) {

		this.estadoEntrega = UtilObjeto.obtenerValorDefectoSiNulo(estadoEntrega, new EstadoEntregaDTO());

	}

}
