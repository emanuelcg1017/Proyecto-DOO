package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntregaEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private EntregaEntidad entrega;

	public ServicioEntregaEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setServicio(new ServicioEntidad());
		setEntrega(new EntregaEntidad());
	}

	public UUID getId() {
		return UtilUUID.obtenerValorDefecto(id);
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntidad servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad());
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaEntidad entrega) {
		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaEntidad());
	}

}
