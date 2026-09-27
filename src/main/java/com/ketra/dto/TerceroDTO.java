package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TerceroDTO {

	private UUID id;
	private String nombre;
	private String NIT;
	private String numeroContacto;
	private String correoContacto;

	public TerceroDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setNIT(UtilTexto.VACIO);
		setNumeroContacto(UtilTexto.VACIO);
		setCorreoContacto(UtilTexto.VACIO);
		
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

	public String getNIT() {
		return NIT;
	}

	private void setNIT(String nIT) {
		NIT = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nIT);
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	private void setNumeroContacto(String numeroContacto) {
		numeroContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroContacto);
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	private void setCorreoContacto(String correoContacto) {
		this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);
	}

}
