package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class MunicipioDTO {

	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;

	public MunicipioDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setDepartamento(new DepartamentoDTO());
		
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

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(departamento , new DepartamentoDTO());
	}

}
