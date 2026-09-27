package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class DepartamentoDTO {

	private UUID id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setPais(new PaisDTO());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
	}

	public PaisDTO getPais() {
		return pais;
	}

	private void setPais(PaisDTO pais) {
		this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisDTO());
	}
}
