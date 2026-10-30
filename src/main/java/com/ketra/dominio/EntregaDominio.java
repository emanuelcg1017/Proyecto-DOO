package com.ketra.dominio;

import com.ketra.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;
import java.util.UUID;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaDominio {

	private UUID id;
	private String codigoEntrega;
	private LocalDate fechaEntrega;
	private EstadoEntregaDominio estadoEntrega;

	EntregaDominio(Builder builder) {
		this.id = builder.id;
		this.codigoEntrega = builder.codigoEntrega;
		this.fechaEntrega = builder.fechaEntrega;
		this.estadoEntrega = builder.estadoEntrega;
	}

	public UUID getId() {
		return id;
	}

	public String getCodigoEntrega() {
		return codigoEntrega;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public EstadoEntregaDominio getEstadoEntrega() {
		return estadoEntrega;
	}

	public static class Builder {
		private UUID id;
		private String codigoEntrega;
		private LocalDate fechaEntrega;
		private EstadoEntregaDominio estadoEntrega;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			codigoEntrega = UtilTexto.VACIO;
			fechaEntrega = UtilFecha.FECHA_DEFECTO;
			estadoEntrega = new EstadoEntregaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder codigoEntrega(String codigoEntrega) {
			this.codigoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoEntrega);
			return this;
		}

		public Builder fechaEntrega(LocalDate fechaEntrega) {
			this.fechaEntrega = UtilFecha.obtenerFechaDefecto(fechaEntrega);
			return this;
		}

		public Builder estadoEntrega(EstadoEntregaDominio estadoEntrega) {
			this.estadoEntrega = UtilObjeto.obtenerValorDefectoSiNulo(estadoEntrega, new EstadoEntregaDominio.Builder().build());
			return this;
		}

		public EntregaDominio build() {
			return new EntregaDominio(this);
		}
	}
}
