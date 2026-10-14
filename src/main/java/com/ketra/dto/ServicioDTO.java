
package com.ketra.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioDTO {

	private UUID id;
	private String numeroServicio;
	private LocalDate fechaServicio;
	private String estado;

	public ServicioDTO() {
		this(new Builder());
	}

	private ServicioDTO(Builder builder) {

		setId(builder.id);
		setNumeroServicio(builder.numeroServicio);
		setFechaServicio(builder.fechaServicio);
		setEstado(builder.estado);
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

	public static class Builder {

		private UUID id;
		private String numeroServicio;
		private LocalDate fechaServicio;
		private String estado;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;
			numeroServicio = UtilTexto.VACIO;
			fechaServicio = UtilFecha.FECHA_DEFECTO;
			estado = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroServicio(String numeroServicio) {
			this.numeroServicio = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroServicio);
			return this;
		}

		public Builder fechaServicio(LocalDate fechaServicio) {
			this.fechaServicio = UtilFecha.obtenerFechaDefecto(fechaServicio);
			return this;
		}

		public Builder estado(String estado) {
			this.estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);
			return this;
		}

		public ServicioDTO build() {
			return new ServicioDTO(this);
		}
	}
}
