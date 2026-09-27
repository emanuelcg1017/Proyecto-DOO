package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class EmpresaEntidad {

	private UUID id;
	private String nombre;
	private String NIT;
	private String correoContacto;
	private String telefonoContacto;

	public EmpresaEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setNIT(UtilTexto.VACIO);
		setCorreoContacto(UtilTexto.VACIO);
		setTelefonoContacto(UtilTexto.VACIO);
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

	private void setNIT(String NIT) {
		NIT = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(NIT);
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	private void setCorreoContacto(String correoContacto) {
		this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	private void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(telefonoContacto);
	}

}
