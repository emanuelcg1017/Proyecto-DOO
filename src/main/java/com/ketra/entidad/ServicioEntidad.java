package com.ketra.entidad;

import java.time.LocalDate;
import java.util.UUID;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntidad {

	private UUID id;
	private String numeroServicio;
	private LocalDate fechaServicio;
	private String estado;

	public ServicioEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroServicio(UtilTexto.VACIO);
		setFechaServicio(UtilFecha.FECHA_DEFECTO);
		setEstado(UtilTexto.VACIO);
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);
	}

}
