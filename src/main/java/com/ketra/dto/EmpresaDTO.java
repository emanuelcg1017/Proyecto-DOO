package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaDTO {

	private UUID id;

	private String nombre;

	private String nit;

	private String correoContacto;

	private String telefonoContacto;

	public EmpresaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setNombre(UtilTexto.VACIO);

		setNit(UtilTexto.VACIO);

		setCorreoContacto(UtilTexto.VACIO);

		setTelefonoContacto(UtilTexto.VACIO);

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

	public String getNit() {

		return nit;

	}

	public void setNit(String nit) {

		this.nit = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nit);

	}

	public String getCorreoContacto() {

		return correoContacto;

	}

	public void setCorreoContacto(String correoContacto) {

		this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);

	}

	public String getTelefonoContacto() {

		return telefonoContacto;

	}

	public void setTelefonoContacto(String telefonoContacto) {

		this.telefonoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(telefonoContacto);

	}

}
