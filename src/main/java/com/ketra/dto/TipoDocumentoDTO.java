package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TipoDocumentoDTO {

	private UUID id;
	private String nombre;

	public TipoDocumentoDTO() {
		setId(id);
		setNombre(nombre);
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
}
