package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DireccionDTO {

	private UUID id;
	private String nombre;
	private BarrioDTO barrio;
	private TipoDireccionDTO direccion;

	public DireccionDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setBarrio(new BarrioDTO());
		setDireccion(new TipoDireccionDTO());
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

	public BarrioDTO getBarrio() {
		return barrio;
	}

	private void setBarrio(BarrioDTO barrio) {
		this.barrio = UtilObjeto.obtenerValorDefectoSiNulo(barrio, new BarrioDTO());
	}
	
	public TipoDireccionDTO getDireccion() {
		return direccion;
	}

	private void setDireccion(TipoDireccionDTO direccion) {
		this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new TipoDireccionDTO());
	}

}
