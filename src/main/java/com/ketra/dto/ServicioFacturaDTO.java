package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioFacturaDTO {

	private UUID id;

	private ServicioDTO servicio;

	private FacturaDTO factura;

	public ServicioFacturaDTO() {

		this(new Builder());

	}

	private ServicioFacturaDTO(Builder builder) {

		this.id = builder.id;

		this.servicio = builder.servicio;

		this.factura = builder.factura;

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

	public FacturaDTO getFactura() {

		return factura;

	}

	public void setFactura(FacturaDTO factura) {

		this.factura = UtilObjeto.obtenerValorDefectoSiNulo(factura, new FacturaDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private ServicioDTO servicio;

		private FacturaDTO factura;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			servicio = new ServicioDTO.Builder().build();

			factura = new FacturaDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder servicio(ServicioDTO servicio) {

			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

			return this;

		}

		public Builder factura(FacturaDTO factura) {

			this.factura = UtilObjeto.obtenerValorDefectoSiNulo(factura, new FacturaDTO.Builder().build());

			return this;

		}

		public ServicioFacturaDTO build() {

			return new ServicioFacturaDTO(this);

		}

	}

}
