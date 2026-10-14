package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class CEDIEntidad {

	private UUID id;
	private String nombre;
	private DireccionEntidad direccion;

	private CEDIEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.direccion = builder.direccion;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DireccionEntidad getDireccion() {
		return direccion;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private DireccionEntidad direccion;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			direccion = new DireccionEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder direccion(DireccionEntidad direccion) {
			this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new DireccionEntidad.Builder().build());
			return this;
		}

		public CEDIEntidad build() {
			return new CEDIEntidad(this);
		}
	}
}
