package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaDTO {

	private UUID id;

	private String nombre;

	private String NIT;

	private String correoContacto;

	private String telefonoContacto;

	public EmpresaDTO() {

		this(new Builder());

	}

	private EmpresaDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

		this.NIT = builder.NIT;

		this.correoContacto = builder.correoContacto;

		this.telefonoContacto = builder.telefonoContacto;

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

	public String getNIT() {

		return NIT;

	}

	public void setNIT(String NIT) {

		this.NIT = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(NIT);

	}

	public String getCorreoContacto() {

		return correoContacto;

	}

	public void setCorreoContacto(String correoContacto) {

		this.correoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoContacto);

	}

	public String getTelefonoContacto() {

		return telefonoContacto;

	}

	public void setTelefonoContacto(String telefonoContacto) {

		this.telefonoContacto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(telefonoContacto);

	}

	public static class Builder {

		private UUID id;

		private String nombre;

		private String NIT;

		private String correoContacto;

		private String telefonoContacto;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			nombre = UtilTexto.VACIO;

			NIT = UtilTexto.VACIO;

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

		public Builder NIT(String NIT) {

			this.NIT = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(NIT);

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

		public EmpresaDTO build() {

			return new EmpresaDTO(this);

		}

	}

}
