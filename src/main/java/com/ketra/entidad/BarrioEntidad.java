package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class BarrioEntidad {

	private UUID id;
	private String nombre;
	private MunicipioEntidad municipio;

	public BarrioEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setMunicipio(new MunicipioEntidad());
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

	public MunicipioEntidad getMunicipio() {
		return municipio;
	}

	private void setMunicipio(MunicipioEntidad municipio) {
		this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioEntidad());
	}

}
