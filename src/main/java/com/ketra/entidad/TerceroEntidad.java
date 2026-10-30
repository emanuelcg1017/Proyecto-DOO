package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TerceroEntidad {

	private UUID id;
	private String nombre;
	private String nit;
	private String numeroContacto;
	private String correoContacto;

	private TerceroEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.nit = builder.nit;
		this.numeroContacto = builder.numeroContacto;
		this.correoContacto = builder.correoContacto;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNit() {
		return nit;
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
		private String nit;
		private String numeroContacto;
		private String correoContacto;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			nit = UtilTexto.VACIO;
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

		public Builder nit(String nit) {
			this.nit = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nit);
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

		public TerceroEntidad build() {
			return new TerceroEntidad(this);
		}
	}
}
