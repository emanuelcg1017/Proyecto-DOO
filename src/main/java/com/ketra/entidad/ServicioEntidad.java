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
		this(new Builder());
	}

	private ServicioEntidad(Builder builder) {

		setId(builder.id);
		setNumeroServicio(builder.numeroServicio);
		setFechaServicio(builder.fechaServicio);
		setEstado(builder.estado);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNumeroServicio() {
		return numeroServicio;
	}

	private void setNumeroServicio(String numeroServicio) {

		this.numeroServicio = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroServicio);
	}

	public LocalDate getFechaServicio() {
		return fechaServicio;
	}

	private void setFechaServicio(
			final LocalDate fechaServicio) {

		this.fechaServicio = UtilFecha.obtenerFechaDefecto(fechaServicio);
	}

	public String getEstado() {
		return estado;
	}

	private void setEstado(String estado) {

		this.estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);
	}

	public static class Builder {

		private UUID id;
		private String numeroServicio;
		private LocalDate fechaServicio;
		private String estado;

		public Builder() {

			id =UtilUUID.obtenerValorDefecto(id);
			numeroServicio =UtilTexto.VACIO;
			fechaServicio =UtilFecha.FECHA_DEFECTO;
			estado =UtilTexto.VACIO;
		}

		public Builder id(UUID id) {

			this.id = id;
			return this;
		}

		public Builder numeroServicio(String numeroServicio) {

			this.numeroServicio = numeroServicio;
			return this;
		}

		public Builder fechaServicio(LocalDate fechaServicio) {

			this.fechaServicio = fechaServicio;
			return this;
		}

		public Builder estado(String estado) {

			this.estado = estado;
			return this;
		}

		public ServicioEntidad build() {

			return new ServicioEntidad(this);
		}
	}
}