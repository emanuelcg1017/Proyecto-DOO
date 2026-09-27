package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetallePedidoDominio {

	private UUID id;
	private PedidoDominio numeroPedido;
	private String codigoBarras;

	DetallePedidoDominio(Builder builder) {
		this.id = builder.id;
		this.numeroPedido = builder.numeroPedido;
		this.codigoBarras = builder.codigoBarras;
	}

	public UUID getId() {
		return id;
	}

	public PedidoDominio getNumeroPedido() {
		return numeroPedido;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public static class Builder {
		private UUID id;
		private PedidoDominio numeroPedido;
		private String codigoBarras;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroPedido = new PedidoDominio.Builder().build();
			codigoBarras = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroPedido(PedidoDominio numeroPedido) {
			this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoDominio.Builder().build());
			return this;
		}

		public Builder codigoBarras(String codigoBarras) {
			this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);
			return this;
		}

		public DetallePedidoDominio build() {
			return new DetallePedidoDominio(this);
		}
	}
}
