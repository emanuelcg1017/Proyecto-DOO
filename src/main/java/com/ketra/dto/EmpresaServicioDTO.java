package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;



public class EmpresaServicioDTO {

	private UUID id;
	private EmpresaDTO empresa;
	private ServicioDTO servicio;

	public EmpresaServicioDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setEmpresa(new EmpresaDTO());
		setServicio(new ServicioDTO());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = UtilObjeto.obtenerValorDefectoSiNulo(empresa, new EmpresaDTO());
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO());
	}

}
