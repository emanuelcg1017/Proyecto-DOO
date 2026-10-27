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

		setId(UtilUUID.UUID_DEFECTO);

		setNombre(UtilTexto.VACIO);

		setNIT(UtilTexto.VACIO);

		setNumeroContacto(UtilTexto.VACIO);

		setCorreoContacto(UtilTexto.VACIO);

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

	public String getNIT() {

		return NIT;

	}

	public void setNIT(String NIT) {

		this.NIT = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(NIT);

	}

	public String getNumeroContacto() {

		return numeroContacto;

	}

	public void setNumeroContacto(String numeroContacto) {

		this.numeroContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroContacto);

	}

	public String getCorreoContacto() {

		return correoContacto;

	}

	public void setCorreoContacto(String correoContacto) {

		this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);

	}

}
