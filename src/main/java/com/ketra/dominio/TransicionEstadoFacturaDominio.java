package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoFacturaDominio {

	private UUID id;

	private EstadoFacturaDominio estadoOrigen;

	private EstadoFacturaDominio estadoDestino;

	private TransicionEstadoFacturaDominio(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoFacturaDominio getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoFacturaDominio getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoFacturaDominio estadoOrigen;

		private EstadoFacturaDominio estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoFacturaDominio.Builder().build();

			estadoDestino = new EstadoFacturaDominio.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoFacturaDominio estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoFacturaDominio.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoFacturaDominio estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoFacturaDominio.Builder().build());

			return this;

		}

		public TransicionEstadoFacturaDominio build() {

			return new TransicionEstadoFacturaDominio(this);

		}

	}

}
