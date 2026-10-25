package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class CEDIDTO {

	private UUID id;

	private String nombre;

	private DireccionDTO direccion;

	public CEDIDTO() {

		this(new Builder());

	}

	private CEDIDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

		this.direccion = builder.direccion;

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

	public DireccionDTO getDireccion() {

		return direccion;

	}

	public void setDireccion(DireccionDTO direccion) {

		this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new DireccionDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private String nombre;

		private DireccionDTO direccion;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			nombre = UtilTexto.VACIO;

			direccion = new DireccionDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public Builder direccion(DireccionDTO direccion) {

			this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new DireccionDTO.Builder().build());

			return this;

		}

		public CEDIDTO build() {

			return new CEDIDTO(this);

		}

	}

}
