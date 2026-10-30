package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EstadoServicioEntidad {

	private UUID id;

	private String codigo;

	private String nombre;

	private EstadoServicioEntidad(Builder builder) {

		this.id = builder.id;

		this.codigo = builder.codigo;

		this.nombre = builder.nombre;

	}

	public UUID getId() {

		return id;

	}

	public String getCodigo() {

		return codigo;

	}

	public String getNombre() {

		return nombre;

	}

	public static class Builder {

		private UUID id;

		private String codigo;

		private String nombre;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			codigo = UtilTexto.VACIO;

			nombre = UtilTexto.VACIO;

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder codigo(String codigo) {

			this.codigo = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigo);

			return this;

		}

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public EstadoServicioEntidad build() {

			return new EstadoServicioEntidad(this);

		}

	}

}
