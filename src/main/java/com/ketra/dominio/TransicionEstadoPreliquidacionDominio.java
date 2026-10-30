package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoPreliquidacionDominio {

	private UUID id;

	private EstadoPreliquidacionDominio estadoOrigen;

	private EstadoPreliquidacionDominio estadoDestino;

	private TransicionEstadoPreliquidacionDominio(Builder builder) {

		this.id = builder.id;

		this.estadoOrigen = builder.estadoOrigen;

		this.estadoDestino = builder.estadoDestino;

	}

	public UUID getId() {

		return id;

	}

	public EstadoPreliquidacionDominio getEstadoOrigen() {

		return estadoOrigen;

	}

	public EstadoPreliquidacionDominio getEstadoDestino() {

		return estadoDestino;

	}

	public static class Builder {

		private UUID id;

		private EstadoPreliquidacionDominio estadoOrigen;

		private EstadoPreliquidacionDominio estadoDestino;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			estadoOrigen = new EstadoPreliquidacionDominio.Builder().build();

			estadoDestino = new EstadoPreliquidacionDominio.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder estadoOrigen(EstadoPreliquidacionDominio estadoOrigen) {

			this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoPreliquidacionDominio.Builder().build());

			return this;

		}

		public Builder estadoDestino(EstadoPreliquidacionDominio estadoDestino) {

			this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoPreliquidacionDominio.Builder().build());

			return this;

		}

		public TransicionEstadoPreliquidacionDominio build() {

			return new TransicionEstadoPreliquidacionDominio(this);

		}

	}

}
