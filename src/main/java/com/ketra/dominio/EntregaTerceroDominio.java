package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaTerceroDominio {

	private UUID id;
	private EntregaDominio entrega;
	private TerceroDominio tercero;

	EntregaTerceroDominio(Builder builder) {
		this.id = builder.id;
		this.entrega = builder.entrega;
		this.tercero = builder.tercero;
	}

	public UUID getId() {
		return id;
	}

	public EntregaDominio getEntrega() {
		return entrega;
	}

	public TerceroDominio getTercero() {
		return tercero;
	}

	public static class Builder {
		private UUID id;
		private EntregaDominio entrega;
		private TerceroDominio tercero;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			entrega = new EntregaDominio.Builder().build();
			tercero = new TerceroDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder entrega(EntregaDominio entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDominio.Builder().build());
			return this;
		}

		public Builder tercero(TerceroDominio tercero) {
			this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDominio.Builder().build());
			return this;
		}

		public EntregaTerceroDominio build() {
			return new EntregaTerceroDominio(this);
		}
	}
}
