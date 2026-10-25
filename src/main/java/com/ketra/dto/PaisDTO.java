package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PaisDTO {

	private UUID id;

	private String nombre;

	public PaisDTO() {

		this(new Builder());

	}

	private PaisDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

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

	public static class Builder {

		private UUID id;

		private String nombre;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

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

		public PaisDTO build() {

			return new PaisDTO(this);

		}

	}

}
