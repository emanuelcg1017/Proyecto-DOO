package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class ServicioFacturaEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private FacturaEntidad factura;

	public ServicioFacturaEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setServicio(new ServicioEntidad());
		setFactura(new FacturaEntidad());
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

	public FacturaEntidad getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntidad factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiNulo(factura, new FacturaEntidad());
	}

}
