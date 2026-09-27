package com.ketra.dominio;

import java.util.UUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TipoDireccionDominio {

	private UUID id;
	private String nombre;

	TipoDireccionDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public static class Builder {
		private UUID id;
		private String nombre;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public TipoDireccionDominio build() {
			return new TipoDireccionDominio(this);
		}
	}
}
