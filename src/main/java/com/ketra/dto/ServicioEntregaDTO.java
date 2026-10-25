package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntregaDTO {

	private UUID id;

	private ServicioDTO servicio;

	private EntregaDTO entrega;

	public ServicioEntregaDTO() {

		this(new Builder());

	}

	private ServicioEntregaDTO(Builder builder) {

		this.id = builder.id;

		this.servicio = builder.servicio;

		this.entrega = builder.entrega;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public ServicioDTO getServicio() {

		return servicio;

	}

	public void setServicio(ServicioDTO servicio) {

		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

	}

	public EntregaDTO getEntrega() {

		return entrega;

	}

	public void setEntrega(EntregaDTO entrega) {

		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private ServicioDTO servicio;

		private EntregaDTO entrega;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			servicio = new ServicioDTO.Builder().build();

			entrega = new EntregaDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder servicio(ServicioDTO servicio) {

			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

			return this;

		}

		public Builder entrega(EntregaDTO entrega) {

			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO.Builder().build());

			return this;

		}

		public ServicioEntregaDTO build() {

			return new ServicioEntregaDTO(this);

		}

	}

}
