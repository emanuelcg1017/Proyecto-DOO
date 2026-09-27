package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class CEDIDominio {
	private UUID id;
	private String nombre;
	private DireccionDominio direccion;

	CEDIDominio(Builder builder) {
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

	public DireccionDominio getDireccion() {
		return direccion;
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		private DireccionDominio direccion;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			direccion = new DireccionDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder direccion(DireccionDominio direccion) {
			this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new DireccionDominio.Builder().build());
			return this;
		}

		public CEDIDominio build() {
			return new CEDIDominio(this);
		}
	}
}
