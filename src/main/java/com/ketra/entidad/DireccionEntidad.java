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

	private DireccionEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.barrio = builder.barrio;
		this.direccion = builder.direccion;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public BarrioEntidad getBarrio() {
		return barrio;
	}

	public TipoDireccionEntidad getDireccion() {
		return direccion;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private BarrioEntidad barrio;
		private TipoDireccionEntidad direccion;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			barrio = new BarrioEntidad.Builder().build();
			direccion = new TipoDireccionEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder barrio(BarrioEntidad barrio) {
			this.barrio = UtilObjeto.obtenerValorDefectoSiNulo(barrio, new BarrioEntidad.Builder().build());
			return this;
		}

		public Builder direccion(TipoDireccionEntidad direccion) {
			this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new TipoDireccionEntidad.Builder().build());
			return this;
		}

		public DireccionEntidad build() {
			return new DireccionEntidad(this);
		}
	}
}
