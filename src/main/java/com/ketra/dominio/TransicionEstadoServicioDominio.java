package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoServicioDominio {

	private UUID id;

	private EstadoServicioDominio estadoOrigen;

	private EstadoServicioDominio estadoDestino;

	private TransicionEstadoServicioDominio(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoServicioDominio getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoServicioDominio getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoServicioDominio estadoOrigen;

		private EstadoServicioDominio estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoServicioDominio.Builder().build();

			estadoDestino = new EstadoServicioDominio.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoServicioDominio estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoServicioDominio.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoServicioDominio estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoServicioDominio.Builder().build());

			return this;

		}

		public TransicionEstadoServicioDominio build() {

			return new TransicionEstadoServicioDominio(this);

		}

	}

}
