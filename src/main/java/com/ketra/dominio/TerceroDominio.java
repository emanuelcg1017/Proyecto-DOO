package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TerceroDominio {
	private UUID id;
	private String nombre;
	private String NIT;
	private String numeroContacto;
	private String correoContacto;

	TerceroDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.NIT = builder.NIT;
		this.numeroContacto = builder.numeroContacto;
		this.correoContacto = builder.correoContacto;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNIT() {
		return NIT;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		private String NIT;
		private String numeroContacto;
		private String correoContacto;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			NIT = UtilTexto.VACIO;
			numeroContacto = UtilTexto.VACIO;
			correoContacto = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder NIT(String NIT) {
			this.NIT = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(NIT);
			return this;
		}

		public Builder numeroContacto(String numeroContacto) {
			this.numeroContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroContacto);
			return this;
		}

		public Builder correoContacto(String correoContacto) {
			this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);
			return this;
		}

		public TerceroDominio build() {
			return new TerceroDominio(this);
		}
	}
}
