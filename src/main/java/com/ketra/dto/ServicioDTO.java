package com.ketra.dto;

import com.ketra.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioDTO {

	private UUID id;

	private String numeroServicio;

	private LocalDate fechaServicio;

	private EstadoServicioDTO estado;

	public ServicioDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setNumeroServicio(UtilTexto.VACIO);

		setFechaServicio(UtilFecha.FECHA_DEFECTO);

		setEstado(new EstadoServicioDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroServicio() {

		return numeroServicio;

	}

	public void setNumeroServicio(String numeroServicio) {

		this.numeroServicio = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroServicio);

	}

	public LocalDate getFechaServicio() {

		return fechaServicio;

	}

	public void setFechaServicio(LocalDate fechaServicio) {

		this.fechaServicio = UtilFecha.obtenerFechaDefecto(fechaServicio);

	}

	public EstadoServicioDTO getEstado() {

		return estado;

	}

	public void setEstado(EstadoServicioDTO estado) {

		this.estado = UtilObjeto.obtenerValorDefectoSiNulo(estado, new EstadoServicioDTO());

	}

}
