package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PersonaEntidad {

	private UUID id;
	private TipoDocumentoEntidad tipoDocumento;
	private String numeroIdentificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String numeroTelefonico;
	private String correoElectronico;

	public PersonaEntidad() {
		this(new Builder());
	}

	private PersonaEntidad(final Builder builder) {
		setId(builder.id);
		setTipoDocumento(builder.tipoDocumento);
		setNumeroIdentificacion(builder.numeroIdentificacion);
		setPrimerNombre(builder.primerNombre);
		setSegundoNombre(builder.segundoNombre);
		setPrimerApellido(builder.primerApellido);
		setSegundoApellido(builder.segundoApellido);
		setNumeroTelefonico(builder.numeroTelefonico);
		setCorreoElectronico(builder.correoElectronico);
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoEntidad getTipoDocumento() {
		return tipoDocumento;
	}

	private void setTipoDocumento(final TipoDocumentoEntidad tipoDocumento) {
		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiNulo(tipoDocumento, new TipoDocumentoEntidad.Builder().build());
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	private void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroIdentificacion);
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	private void setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerNombre);
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	private void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoNombre);
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	private void setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerApellido);
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	private void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoApellido);
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	private void setNumeroTelefonico(final String numeroTelefonico) {
		this.numeroTelefonico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroTelefonico);
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	private void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoElectronico);
	}

	public static class Builder {

		private UUID id;
		private TipoDocumentoEntidad tipoDocumento;
		private String numeroIdentificacion;
		private String primerNombre;
		private String segundoNombre;
		private String primerApellido;
		private String segundoApellido;
		private String numeroTelefonico;
		private String correoElectronico;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			tipoDocumento = new TipoDocumentoEntidad.Builder().build();
			numeroIdentificacion = UtilTexto.VACIO;
			primerNombre = UtilTexto.VACIO;
			segundoNombre = UtilTexto.VACIO;
			primerApellido = UtilTexto.VACIO;
			segundoApellido = UtilTexto.VACIO;
			numeroTelefonico = UtilTexto.VACIO;
			correoElectronico = UtilTexto.VACIO;
		}

		public Builder id(final UUID id) {
			this.id = id;return this;
		}

		public Builder tipoDocumento(final TipoDocumentoEntidad tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

		public Builder numeroIdentificacion(final String numeroIdentificacion) {
			this.numeroIdentificacion = numeroIdentificacion;
			return this;
		}

		public Builder primerNombre(final String primerNombre) {
			this.primerNombre = primerNombre;
			return this;
		}

		public Builder segundoNombre(final String segundoNombre) {
			this.segundoNombre = segundoNombre;
			return this;
		}

		public Builder primerApellido(final String primerApellido) {
			this.primerApellido = primerApellido;
			return this;
		}

		public Builder segundoApellido(final String segundoApellido) {
			this.segundoApellido = segundoApellido;
			return this;
		}

		public Builder numeroTelefonico(final String numeroTelefonico) {
			this.numeroTelefonico = numeroTelefonico;
			return this;
		}

		public Builder correoElectronico(final String correoElectronico) {
			this.correoElectronico = correoElectronico;
			return this;
		}

		public PersonaEntidad build() {
			return new PersonaEntidad(this);
		}
	}
}