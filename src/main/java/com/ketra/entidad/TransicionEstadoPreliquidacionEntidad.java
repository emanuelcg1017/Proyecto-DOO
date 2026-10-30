package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoPreliquidacionEntidad {

	private UUID id;

	private EstadoPreliquidacionEntidad estadoOrigen;

	private EstadoPreliquidacionEntidad estadoDestino;

	private TransicionEstadoPreliquidacionEntidad(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoPreliquidacionEntidad getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoPreliquidacionEntidad getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoPreliquidacionEntidad estadoOrigen;

		private EstadoPreliquidacionEntidad estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoPreliquidacionEntidad.Builder().build();

			estadoDestino = new EstadoPreliquidacionEntidad.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoPreliquidacionEntidad estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoPreliquidacionEntidad.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoPreliquidacionEntidad estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoPreliquidacionEntidad.Builder().build());

			return this;

		}

		public TransicionEstadoPreliquidacionEntidad build() {

			return new TransicionEstadoPreliquidacionEntidad(this);

		}

	}

}
