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

		this(new Builder());

	}

	private EntregaDTO(Builder builder) {

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

	public String getEstadoEntrega() {

		return estadoEntrega;

	}

	public static class Builder {

		private UUID id;

		private String codigoEntrega;

		private LocalDate fechaEntrega;

		private String estadoEntrega;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			codigoEntrega = UtilTexto.VACIO;

			fechaEntrega = UtilFecha.FECHA_DEFECTO;

			estadoEntrega = UtilTexto.VACIO;

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

		public Builder estadoEntrega(String estadoEntrega) {

			this.estadoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estadoEntrega);

			return this;

		}

		public EntregaDTO build() {

			return new EntregaDTO(this);

		}

	}

}
