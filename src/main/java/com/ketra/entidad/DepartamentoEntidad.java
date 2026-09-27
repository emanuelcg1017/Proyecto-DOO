package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class DepartamentoEntidad {

	private UUID id;
	private String nombre;
	private PaisEntidad pais;

	public DepartamentoEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setPais(new PaisEntidad());
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

	public PaisEntidad getPais() {
		return pais;
	}

	private void setPais(PaisEntidad pais) {
		this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisEntidad());
	}
}
