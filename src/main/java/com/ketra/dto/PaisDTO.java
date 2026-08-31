package main.java.com.ketra.dto;

import java.util.UUID;

import main.java.com.ketra.transversal.UtilTexto;
import main.java.com.ketra.transversal.UtilUUID;

public class PaisDTO {

	private UUID id;
	private String nombre;

	public PaisDTO() {
		setId(id);
		setNombre(nombre);
		
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
