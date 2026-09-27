package com.ketra.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioDominio {

	private UUID id;
	private String numeroServicio;
	private LocalDate fechaServicio;
	private String estado;

	ServicioDominio(Builder builder) {
		this.id = builder.id;
		this.numeroServicio = builder.numeroServicio;
		this.fechaServicio = builder.fechaServicio;
		this.estado = builder.estado;
	}

	public UUID getId() {
		return id;
	}

	public String getNumeroServicio() {
		return numeroServicio;
	}

	public LocalDate getFechaServicio() {
		return fechaServicio;
	}

	public String getEstado() {
		return estado;
	}

	public static class Builder {
		private UUID id;
		private String numeroServicio;
		private LocalDate fechaServicio;
		private String estado;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
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

		public ServicioDominio build() {
			return new ServicioDominio(this);
		}
	}
}
