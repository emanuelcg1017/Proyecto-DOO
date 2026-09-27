package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DireccionEntidad {

	private UUID id;
	private String nombre;
	private BarrioEntidad barrio;
	private TipoDireccionEntidad direccion;

	public DireccionEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setBarrio(new BarrioEntidad());
		setDireccion(new TipoDireccionEntidad());
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

	public BarrioEntidad getBarrio() {
		return barrio;
	}

	private void setBarrio(BarrioEntidad barrio) {
		this.barrio = UtilObjeto.obtenerValorDefectoSiNulo(barrio, new BarrioEntidad());
	}
	
	public TipoDireccionEntidad getDireccion() {
		return direccion;
	}

	private void setDireccion(TipoDireccionEntidad direccion) {
		this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new TipoDireccionEntidad());
	}

}
