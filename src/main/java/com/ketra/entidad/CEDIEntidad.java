package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;



public class CEDIEntidad {

	private UUID id;
	private String nombre;
	private DireccionEntidad direccion;

	public CEDIEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setDireccion(new DireccionEntidad());
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

	public DireccionEntidad getDireccion() {
		return direccion;
	}

	private void setDireccion(DireccionEntidad direccion) {
		this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new DireccionEntidad());
	}

}
