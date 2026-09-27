package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PersonaDominio {
	
	private UUID id;
	private TipoDocumentoDominio tipoDocumento;
	private String numeroIdentificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String numeroTelefonico;
	private String correoElectronico;

	PersonaDominio(Builder builder) {
		this.id = builder.id;
		this.tipoDocumento = builder.tipoDocumento;
		this.numeroIdentificacion = builder.numeroIdentificacion;
		this.primerNombre = builder.primerNombre;
		this.segundoNombre = builder.segundoNombre;
		this.primerApellido = builder.primerApellido;
		this.segundoApellido = builder.segundoApellido;
		this.numeroTelefonico = builder.numeroTelefonico;
		this.correoElectronico = builder.correoElectronico;
	}

	public UUID getId() {
		return id;
	}

	public TipoDocumentoDominio getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public static class Builder {
		private UUID id;
		private TipoDocumentoDominio tipoDocumento;
		private String numeroIdentificacion;
		private String primerNombre;
		private String segundoNombre;
		private String primerApellido;
		private String segundoApellido;
		private String numeroTelefonico;
		private String correoElectronico;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			tipoDocumento = new TipoDocumentoDominio.Builder().build();
			numeroIdentificacion = UtilTexto.VACIO;
			primerNombre = UtilTexto.VACIO;
			segundoNombre = UtilTexto.VACIO;
			primerApellido = UtilTexto.VACIO;
			segundoApellido = UtilTexto.VACIO;
			numeroTelefonico = UtilTexto.VACIO;
			correoElectronico = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder tipoDocumento(TipoDocumentoDominio tipoDocumento) {
			this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiNulo(tipoDocumento, new TipoDocumentoDominio.Builder().build());
			return this;
		}

		public Builder numeroIdentificacion(String numeroIdentificacion) {
			this.numeroIdentificacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroIdentificacion);
			return this;
		}

		public Builder primerNombre(String primerNombre) {
			this.primerNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerNombre);
			return this;
		}

		public Builder segundoNombre(String segundoNombre) {
			this.segundoNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoNombre);
			return this;
		}

		public Builder primerApellido(String primerApellido) {
			this.primerApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerApellido);
			return this;
		}

		public Builder segundoApellido(String segundoApellido) {
			this.segundoApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoApellido);
			return this;
		}

		public Builder numeroTelefonico(String numeroTelefonico) {
			this.numeroTelefonico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroTelefonico);
			return this;
		}

		public Builder correoElectronico(String correoElectronico) {
			this.correoElectronico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoElectronico);
			return this;
		}

		public PersonaDominio build() {
			return new PersonaDominio(this);
		}
	}
}