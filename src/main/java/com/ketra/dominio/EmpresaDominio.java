package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaDominio {


	private UUID id;
	private String nombre;
	private String nit;
	private String correoContacto;
	private String telefonoContacto;

	EmpresaDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.nit = builder.nit;
		this.correoContacto = builder.correoContacto;
		this.telefonoContacto = builder.telefonoContacto;
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

	public String getCorreoContacto() {
		return correoContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private String nit;
		private String correoContacto;
		private String telefonoContacto;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			nit = UtilTexto.VACIO;
			correoContacto = UtilTexto.VACIO;
			telefonoContacto = UtilTexto.VACIO;
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

		public Builder correoContacto(String correoContacto) {
			this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);
			return this;
		}

		public Builder telefonoContacto(String telefonoContacto) {
			this.telefonoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(telefonoContacto);
			return this;
		}

		public EmpresaDominio build() {
			return new EmpresaDominio(this);
		}
	}
}
