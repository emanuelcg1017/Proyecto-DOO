package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EstadoServicioDTO {

	private UUID id;

	private String codigo;

	private String nombre;

	public EstadoServicioDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setCodigo(UtilTexto.VACIO);

		setNombre(UtilTexto.VACIO);

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getCodigo() {

		return codigo;

	}

	public void setCodigo(String codigo) {

		this.codigo = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigo);

	}

	public String getNombre() {

		return nombre;

	}

	public void setNombre(String nombre) {

		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

	}

}
