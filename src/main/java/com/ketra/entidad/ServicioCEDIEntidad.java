package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioCEDIEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private CEDIEntidad cedi;
	private PedidoEntidad pedido;

	private ServicioCEDIEntidad(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.cedi = builder.cedi;
		this.pedido = builder.pedido;
	}

	public UUID getId() {
		return id;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public CEDIEntidad getCedi() {
		return cedi;
	}

	public PedidoEntidad getPedido() {
		return pedido;
	}

	public static class Builder {

		private UUID id;
		private ServicioEntidad servicio;
		private CEDIEntidad cedi;
		private PedidoEntidad pedido;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioEntidad.Builder().build();
			cedi = new CEDIEntidad.Builder().build();
			pedido = new PedidoEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioEntidad servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad.Builder().build());
			return this;
		}

		public Builder cedi(CEDIEntidad cedi) {
			this.cedi = UtilObjeto.obtenerValorDefectoSiNulo(cedi, new CEDIEntidad.Builder().build());
			return this;
		}

		public Builder pedido(PedidoEntidad pedido) {
			this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoEntidad.Builder().build());
			return this;
		}

		public ServicioCEDIEntidad build() {
			return new ServicioCEDIEntidad(this);
		}
	}
}
