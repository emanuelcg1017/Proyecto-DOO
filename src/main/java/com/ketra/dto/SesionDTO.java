package com.ketra.dto;

import com.ketra.transversal.utilitarios.UtilTexto;

public class SesionDTO {

	private final String nombre;

	private final String correo;

	private SesionDTO(Builder builder) {

		nombre = builder.nombre;

		correo = builder.correo;

	}

	public String getNombre() {

		return nombre;

	}

	public String getCorreo() {

		return correo;

	}

	public static class Builder {

		private String nombre = UtilTexto.VACIO;

		private String correo = UtilTexto.VACIO;

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public Builder correo(String correo) {

			this.correo = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correo);

			return this;

		}

		public SesionDTO build() {

			return new SesionDTO(this);

		}

	}

}
