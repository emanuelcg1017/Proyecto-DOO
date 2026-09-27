package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;



public class EmpresaServicioEntidad {

	private UUID id;
	private EmpresaEntidad empresa;
	private ServicioEntidad servicio;

	public EmpresaServicioEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setEmpresa(new EmpresaEntidad());
		setServicio(new ServicioEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EmpresaEntidad getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntidad empresa) {
		this.empresa = UtilObjeto.obtenerValorDefectoSiNulo(empresa, new EmpresaEntidad());
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntidad servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad());
	}

}
