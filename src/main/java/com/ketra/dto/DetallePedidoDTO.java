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
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroPedido(new PedidoDTO());
		setCodigoBarras(UtilTexto.VACIO);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public PedidoDTO getNumeroPedido() {
		return numeroPedido;
	}

	private void setNumeroPedido(PedidoDTO numeroPedido) {
		this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoDTO());
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	private void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);
	}

}
