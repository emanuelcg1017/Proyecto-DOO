package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaTerceroDTO {

	private UUID id;

	private EntregaDTO entrega;

	private TerceroDTO tercero;

	public EntregaTerceroDTO() {

		this(new Builder());

	}

	private EntregaTerceroDTO(Builder builder) {

		this.id = builder.id;

		this.entrega = builder.entrega;

		this.tercero = builder.tercero;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public EntregaDTO getEntrega() {

		return entrega;

	}

	public void setEntrega(EntregaDTO entrega) {

		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO.Builder().build());

	}

	public TerceroDTO getTercero() {

		return tercero;

	}

	public void setTercero(TerceroDTO tercero) {

		this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private EntregaDTO entrega;

		private TerceroDTO tercero;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			entrega = new EntregaDTO.Builder().build();

			tercero = new TerceroDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder entrega(EntregaDTO entrega) {

			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO.Builder().build());

			return this;

		}

		public Builder tercero(TerceroDTO tercero) {

			this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDTO.Builder().build());

			return this;

		}

		public EntregaTerceroDTO build() {

			return new EntregaTerceroDTO(this);

		}

	}

}
