package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoEntregaDominio {

	private UUID id;

	private EstadoEntregaDominio estadoOrigen;

	private EstadoEntregaDominio estadoDestino;

	private TransicionEstadoEntregaDominio(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoEntregaDominio getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoEntregaDominio getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoEntregaDominio estadoOrigen;

		private EstadoEntregaDominio estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoEntregaDominio.Builder().build();

			estadoDestino = new EstadoEntregaDominio.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoEntregaDominio estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoEntregaDominio.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoEntregaDominio estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoEntregaDominio.Builder().build());

			return this;

		}

		public TransicionEstadoEntregaDominio build() {

			return new TransicionEstadoEntregaDominio(this);

		}

	}

}
