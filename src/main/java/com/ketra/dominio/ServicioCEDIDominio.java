package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioCEDIDominio {

	private UUID id;
	private ServicioDominio servicio;
	private CEDIDominio CEDI;
	private PedidoDominio pedido;

	ServicioCEDIDominio(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.CEDI = builder.CEDI;
		this.pedido = builder.pedido;
	}

	public UUID getId() {
		return id;
	}

	public ServicioDominio getServicio() {
		return servicio;
	}

	public CEDIDominio getCEDI() {
		return CEDI;
	}

	public PedidoDominio getPedido() {
		return pedido;
	}

	public static class Builder {
		private UUID id;
		private ServicioDominio servicio;
		private CEDIDominio CEDI;
		private PedidoDominio pedido;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioDominio.Builder().build();
			CEDI = new CEDIDominio.Builder().build();
			pedido = new PedidoDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDominio.Builder().build());
			return this;
		}

		public Builder CEDI(CEDIDominio CEDI) {
			this.CEDI = UtilObjeto.obtenerValorDefectoSiNulo(CEDI, new CEDIDominio.Builder().build());
			return this;
		}

		public Builder pedido(PedidoDominio pedido) {
			this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDominio.Builder().build());
			return this;
		}

		public ServicioCEDIDominio build() {
			return new ServicioCEDIDominio(this);
		}
	}
}
