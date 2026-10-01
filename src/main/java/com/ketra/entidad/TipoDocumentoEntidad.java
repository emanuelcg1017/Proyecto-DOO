package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TipoDocumentoEntidad {

	private UUID id;
	private String nombre;

	private TipoDocumentoEntidad(final Builder builder) {
		setId(builder.id);
		setNombre(builder.nombre);
	}

	public UUID getId() {
		return id;
	}
	
	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);;
	}

	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
	}
	
	public static class Builder {

		private UUID id;
		private String nombre;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public TipoDocumentoEntidad build() {
			return new TipoDocumentoEntidad(this);
		}
	}
}
