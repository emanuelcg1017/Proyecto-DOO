package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class ServicioCEDIEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private CEDIEntidad CEDI;
	private PedidoEntidad pedido;

	public ServicioCEDIEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setServicio(new ServicioEntidad());
		setCEDI(new CEDIEntidad());
		setPedido(new PedidoEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntidad servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad());
	}

	public CEDIEntidad getCEDI() {
		return CEDI;
	}

	public void setCEDI(CEDIEntidad CEDI) {
		CEDI = UtilObjeto.obtenerValorDefectoSiNulo(CEDI, new CEDIEntidad());
	}

	public PedidoEntidad getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntidad pedido) {
		this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoEntidad());
	}
	

}
