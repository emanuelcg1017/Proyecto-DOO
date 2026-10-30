package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetalleEntregaDTO {

	private UUID id;

	private String numeroDetalleEntrega;

	private PedidoDTO pedido;

	private EntregaDTO entrega;

	private CEDIDTO cediOrigen;

	private DireccionDTO direccionDestino;

	private Double distanciaKM;

	public DetalleEntregaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setNumeroDetalleEntrega(UtilTexto.VACIO);

		setPedido(new PedidoDTO());

		setEntrega(new EntregaDTO());

		setCediOrigen(new CEDIDTO());

		setDireccionDestino(new DireccionDTO());

		setDistanciaKM(UtilNumero.CERO_DECIMAL);

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroDetalleEntrega() {

		return numeroDetalleEntrega;

	}

	public void setNumeroDetalleEntrega(String numeroDetalleEntrega) {

		this.numeroDetalleEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroDetalleEntrega);

	}

	public PedidoDTO getPedido() {

		return pedido;

	}

	public void setPedido(PedidoDTO pedido) {

		this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDTO());

	}

	public EntregaDTO getEntrega() {

		return entrega;

	}

	public void setEntrega(EntregaDTO entrega) {

		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO());

	}

	public CEDIDTO getCediOrigen() {

		return cediOrigen;

	}

	public void setCediOrigen(CEDIDTO cediOrigen) {

		this.cediOrigen = UtilObjeto.obtenerValorDefectoSiNulo(cediOrigen, new CEDIDTO());

	}

	public DireccionDTO getDireccionDestino() {

		return direccionDestino;

	}

	public void setDireccionDestino(DireccionDTO direccionDestino) {

		this.direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionDTO());

	}

	public Double getDistanciaKM() {

		return distanciaKM;

	}

	public void setDistanciaKM(Double distanciaKM) {

		this.distanciaKM = UtilNumero.obtenerValorDefecto(distanciaKM, UtilNumero.CERO_DECIMAL);

	}

}
