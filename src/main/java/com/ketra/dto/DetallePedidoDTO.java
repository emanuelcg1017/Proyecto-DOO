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

		setId(UtilUUID.UUID_DEFECTO);

		setNumeroPedido(new PedidoDTO());

		setCodigoBarras(UtilTexto.VACIO);

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

		this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoDTO());

	}

	public String getCodigoBarras() {

		return codigoBarras;

	}

	public void setCodigoBarras(String codigoBarras) {

		this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);

	}

}
