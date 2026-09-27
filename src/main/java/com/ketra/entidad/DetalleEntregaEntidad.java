package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetalleEntregaEntidad {

	private UUID id;
	private String numeroDetalleEntrega;
	private PedidoEntidad pedido;
	private EntregaEntidad entrega;
	private CEDIEntidad CEDIOrigen;
	private DireccionEntidad direccionDestino;
	private Double distanciaKM;

	public DetalleEntregaEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroDetalleEntrega(UtilTexto.VACIO);
		setPedido(new PedidoEntidad());
		setEntrega(new EntregaEntidad());
		setCEDIOrigen(new CEDIEntidad());
		setDireccionDestino(new DireccionEntidad());
		setDistanciaKM(UtilNumero.CERO_DECIMAL);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNumeroDetalleEntrega() {
		return numeroDetalleEntrega;
	}

	private void setNumeroDetalleEntrega(String numeroDetalleEntrega) {
		this.numeroDetalleEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroDetalleEntrega);
	}

	public PedidoEntidad getPedido() {
		return pedido;
	}

	private void setPedido(PedidoEntidad pedido) {
		this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoEntidad());
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	private void setEntrega(EntregaEntidad entrega) {
		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaEntidad());
	}

	public CEDIEntidad getCEDIOrigen() {
		return CEDIOrigen;
	}

	private void setCEDIOrigen(CEDIEntidad cEDIOrigen) {
		CEDIOrigen = UtilObjeto.obtenerValorDefectoSiNulo(cEDIOrigen, new CEDIEntidad());
	}

	public DireccionEntidad getDireccionDestino() {
		return direccionDestino;
	}

	private void setDireccionDestino(DireccionEntidad direccionDestino) {
		this.direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionEntidad());
	}

	public Double getDistanciaKM() {
		return distanciaKM;
	}

	private void setDistanciaKM(Double distanciaKM) {
		this.distanciaKM = UtilNumero.obtenerValorDefecto(distanciaKM, UtilNumero.CERO_DECIMAL);
	}

}
