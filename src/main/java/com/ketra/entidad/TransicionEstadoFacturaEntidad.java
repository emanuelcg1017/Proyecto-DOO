package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoFacturaEntidad {

	private UUID id;

	private EstadoFacturaEntidad estadoOrigen;

	private EstadoFacturaEntidad estadoDestino;

	private TransicionEstadoFacturaEntidad(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoFacturaEntidad getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoFacturaEntidad getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoFacturaEntidad estadoOrigen;

		private EstadoFacturaEntidad estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoFacturaEntidad.Builder().build();

			estadoDestino = new EstadoFacturaEntidad.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoFacturaEntidad estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoFacturaEntidad.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoFacturaEntidad estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoFacturaEntidad.Builder().build());

			return this;

		}

		public TransicionEstadoFacturaEntidad build() {

			return new TransicionEstadoFacturaEntidad(this);

		}

	}

}
