package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class BarrioDTO {

	private UUID id;
	private String nombre;
	private MunicipioDTO municipio;

	public BarrioDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setMunicipio(new MunicipioDTO());
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

	public MunicipioDTO getMunicipio() {
		return municipio;
	}

	private void setMunicipio(MunicipioDTO municipio) {
		this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioDTO());
	}

}
