package com.ketra.dto;

import com.ketra.transversal.utilitarios.UtilTexto;

public class SesionDTO {

	private String nombre;

	private String correo;

	public SesionDTO() {

		setNombre(UtilTexto.VACIO);

		setCorreo(UtilTexto.VACIO);

	}

	public String getNombre() {

		return nombre;

	}

	public void setNombre(String nombre) {

		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

	}

	public String getCorreo() {

		return correo;

	}

	public void setCorreo(String correo) {

		this.correo = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correo);

	}

}
