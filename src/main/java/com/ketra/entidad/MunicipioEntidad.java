package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class MunicipioEntidad {

	private UUID id;
	private String nombre;
	private DepartamentoEntidad departamento;

	public MunicipioEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setDepartamento(new DepartamentoEntidad());
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
	}

	public DepartamentoEntidad getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoEntidad departamento) {
		this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(departamento , new DepartamentoEntidad());
	}

}
