package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetallePedidoEntidad {

	private UUID id;
	private PedidoEntidad numeroPedido;
	private String codigoBarras;

	private DetallePedidoEntidad(Builder builder) {
		this.id = builder.id;
		this.numeroPedido = builder.numeroPedido;
		this.codigoBarras = builder.codigoBarras;
	}

	public UUID getId() {
		return id;
	}

	public PedidoEntidad getNumeroPedido() {
		return numeroPedido;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public static class Builder {

		private UUID id;
		private PedidoEntidad numeroPedido;
		private String codigoBarras;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroPedido = new PedidoEntidad.Builder().build();
			codigoBarras = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroPedido(PedidoEntidad numeroPedido) {
			this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoEntidad.Builder().build());
			return this;
		}

		public Builder codigoBarras(String codigoBarras) {
			this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);
			return this;
		}

		public DetallePedidoEntidad build() {
			return new DetallePedidoEntidad(this);
		}
	}
}
