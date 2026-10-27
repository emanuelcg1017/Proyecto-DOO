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

		setId(UtilUUID.UUID_DEFECTO);

		setNombre(UtilTexto.VACIO);

		setMunicipio(new MunicipioDTO());

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

	public MunicipioDTO getMunicipio() {

		return municipio;

	}

	public void setMunicipio(MunicipioDTO municipio) {

		this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioDTO());

	}

}
