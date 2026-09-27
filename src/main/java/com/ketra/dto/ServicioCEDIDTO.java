package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class ServicioCEDIDTO {

	private UUID id;
	private ServicioDTO servicio;
	private CEDIDTO CEDI;
	private PedidoDTO pedido;

	public ServicioCEDIDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setServicio(new ServicioDTO());
		setCEDI(new CEDIDTO());
		setPedido(new PedidoDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO());
	}

	public CEDIDTO getCEDI() {
		return CEDI;
	}

	public void setCEDI(CEDIDTO CEDI) {
		this.CEDI = UtilObjeto.obtenerValorDefectoSiNulo(CEDI, new CEDIDTO());
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDTO());
	}
	

}
