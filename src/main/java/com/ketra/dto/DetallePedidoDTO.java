package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetallePedidoDTO {

	private UUID id;

	private PedidoDTO numeroPedido;

	private String codigoBarras;

	public DetallePedidoDTO() {

		this(new Builder());

	}

	private DetallePedidoDTO(Builder builder) {

		this.id = builder.id;

		this.numeroPedido = builder.numeroPedido;

		this.codigoBarras = builder.codigoBarras;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public PedidoDTO getNumeroPedido() {

		return numeroPedido;

	}

	public void setNumeroPedido(PedidoDTO numeroPedido) {

		this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoDTO.Builder().build());

	}

	public String getCodigoBarras() {

		return codigoBarras;

	}

	public void setCodigoBarras(String codigoBarras) {

		this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);

	}

	public static class Builder {

		private UUID id;

		private PedidoDTO numeroPedido;

		private String codigoBarras;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			numeroPedido = new PedidoDTO.Builder().build();

			codigoBarras = UtilTexto.VACIO;

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder numeroPedido(PedidoDTO numeroPedido) {

			this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoDTO.Builder().build());

			return this;

		}

		public Builder codigoBarras(String codigoBarras) {

			this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);

			return this;

		}

		public DetallePedidoDTO build() {

			return new DetallePedidoDTO(this);

		}

	}

}
