package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioCEDIDTO {

	private UUID id;

	private ServicioDTO servicio;

	private CEDIDTO CEDI;

	private PedidoDTO pedido;

	public ServicioCEDIDTO() {

		this(new Builder());

	}

	private ServicioCEDIDTO(Builder builder) {

		this.id = builder.id;

		this.servicio = builder.servicio;

		this.CEDI = builder.CEDI;

		this.pedido = builder.pedido;

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

	public CEDIDTO getCEDI() {

		return CEDI;

	}

	public void setCEDI(CEDIDTO CEDI) {

		this.CEDI = UtilObjeto.obtenerValorDefectoSiNulo(CEDI, new CEDIDTO.Builder().build());

	}

	public PedidoDTO getPedido() {

		return pedido;

	}

	public void setPedido(PedidoDTO pedido) {

		this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private ServicioDTO servicio;

		private CEDIDTO CEDI;

		private PedidoDTO pedido;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			servicio = new ServicioDTO.Builder().build();

			CEDI = new CEDIDTO.Builder().build();

			pedido = new PedidoDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder servicio(ServicioDTO servicio) {

			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

			return this;

		}

		public Builder CEDI(CEDIDTO CEDI) {

			this.CEDI = UtilObjeto.obtenerValorDefectoSiNulo(CEDI, new CEDIDTO.Builder().build());

			return this;

		}

		public Builder pedido(PedidoDTO pedido) {

			this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDTO.Builder().build());

			return this;

		}

		public ServicioCEDIDTO build() {

			return new ServicioCEDIDTO(this);

		}

	}

}
