package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoEntregaEntidad {

	private UUID id;

	private EstadoEntregaEntidad estadoOrigen;

	private EstadoEntregaEntidad estadoDestino;

	private TransicionEstadoEntregaEntidad(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoEntregaEntidad getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoEntregaEntidad getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoEntregaEntidad estadoOrigen;

		private EstadoEntregaEntidad estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoEntregaEntidad.Builder().build();

			estadoDestino = new EstadoEntregaEntidad.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoEntregaEntidad estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoEntregaEntidad.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoEntregaEntidad estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoEntregaEntidad.Builder().build());

			return this;

		}

		public TransicionEstadoEntregaEntidad build() {

			return new TransicionEstadoEntregaEntidad(this);

		}

	}

}
