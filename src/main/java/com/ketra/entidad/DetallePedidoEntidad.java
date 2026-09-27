package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetallePedidoEntidad {

	private UUID id;
	private PedidoEntidad numeroPedido;
	private String codigoBarras;

	public DetallePedidoEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroPedido(new PedidoEntidad());
		setCodigoBarras(UtilTexto.VACIO);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public PedidoEntidad getNumeroPedido() {
		return numeroPedido;
	}

	private void setNumeroPedido(PedidoEntidad numeroPedido) {
		this.numeroPedido = UtilObjeto.obtenerValorDefectoSiNulo(numeroPedido, new PedidoEntidad());
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	private void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoBarras);
	}

}
