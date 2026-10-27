package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TipoDocumentoDTO {

	private UUID id;

	private String nombre;

	public TipoDocumentoDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setNombre(UtilTexto.VACIO);

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

}
