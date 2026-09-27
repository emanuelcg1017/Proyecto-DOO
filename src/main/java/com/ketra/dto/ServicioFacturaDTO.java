package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class ServicioFacturaDTO {

	private UUID id;
	private ServicioDTO servicio;
	private FacturaDTO factura;

	public ServicioFacturaDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setServicio(new ServicioDTO());
		setFactura(new FacturaDTO());
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

	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = UtilObjeto.obtenerValorDefectoSiNulo(factura, new FacturaDTO());
	}

}
