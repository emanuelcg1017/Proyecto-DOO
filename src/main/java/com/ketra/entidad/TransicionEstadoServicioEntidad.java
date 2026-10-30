package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoServicioEntidad {

	private UUID id;

	private EstadoServicioEntidad estadoOrigen;

	private EstadoServicioEntidad estadoDestino;

	private TransicionEstadoServicioEntidad(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoServicioEntidad getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoServicioEntidad getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoServicioEntidad estadoOrigen;

		private EstadoServicioEntidad estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoServicioEntidad.Builder().build();

			estadoDestino = new EstadoServicioEntidad.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoServicioEntidad estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoServicioEntidad.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoServicioEntidad estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoServicioEntidad.Builder().build());

			return this;

		}

		public TransicionEstadoServicioEntidad build() {

			return new TransicionEstadoServicioEntidad(this);

		}

	}

}
