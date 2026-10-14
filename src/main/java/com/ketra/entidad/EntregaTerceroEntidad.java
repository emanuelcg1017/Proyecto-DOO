package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaTerceroEntidad {

	private UUID id;
	private EntregaEntidad entrega;
	private TerceroEntidad tercero;

	private EntregaTerceroEntidad(Builder builder) {
		this.id = builder.id;
		this.entrega = builder.entrega;
		this.tercero = builder.tercero;
	}

	public UUID getId() {
		return id;
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	public TerceroEntidad getTercero() {
		return tercero;
	}

	public static class Builder {

		private UUID id;
		private EntregaEntidad entrega;
		private TerceroEntidad tercero;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			entrega = new EntregaEntidad.Builder().build();
			tercero = new TerceroEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder entrega(EntregaEntidad entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaEntidad.Builder().build());
			return this;
		}

		public Builder tercero(TerceroEntidad tercero) {
			this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroEntidad.Builder().build());
			return this;
		}

		public EntregaTerceroEntidad build() {
			return new EntregaTerceroEntidad(this);
		}
	}
}
