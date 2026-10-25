package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PersonaDTO {

	private UUID id;

	private TipoDocumentoDTO tipoDocumento;

	private String numeroIdentificacion;

	private String primerNombre;

	private String segundoNombre;

	private String primerApellido;

	private String segundoApellido;

	private String numeroTelefonico;

	private String correoElectronico;

	public PersonaDTO() {

		this(new Builder());

	}

	private PersonaDTO(Builder builder) {

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

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public TipoDocumentoDTO getTipoDocumento() {

		return tipoDocumento;

	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {

		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiNulo(tipoDocumento, new TipoDocumentoDTO.Builder().build());

	}

	public String getNumeroIdentificacion() {

		return numeroIdentificacion;

	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {

		this.numeroIdentificacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroIdentificacion);

	}

	public String getPrimerNombre() {

		return primerNombre;

	}

	public void setPrimerNombre(String primerNombre) {

		this.primerNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerNombre);

	}

	public String getSegundoNombre() {

		return segundoNombre;

	}

	public void setSegundoNombre(String segundoNombre) {

		this.segundoNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoNombre);

	}

	public String getPrimerApellido() {

		return primerApellido;

	}

	public void setPrimerApellido(String primerApellido) {

		this.primerApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerApellido);

	}

	public String getSegundoApellido() {

		return segundoApellido;

	}

	public void setSegundoApellido(String segundoApellido) {

		this.segundoApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoApellido);

	}

	public String getNumeroTelefonico() {

		return numeroTelefonico;

	}

	public void setNumeroTelefonico(String numeroTelefonico) {

		this.numeroTelefonico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroTelefonico);

	}

	public String getCorreoElectronico() {

		return correoElectronico;

	}

	public void setCorreoElectronico(String correoElectronico) {

		this.correoElectronico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoElectronico);

	}

	public static class Builder {

		private UUID id;

		private TipoDocumentoDTO tipoDocumento;

		private String numeroIdentificacion;

		private String primerNombre;

		private String segundoNombre;

		private String primerApellido;

		private String segundoApellido;

		private String numeroTelefonico;

		private String correoElectronico;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			tipoDocumento = new TipoDocumentoDTO.Builder().build();

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

		public Builder tipoDocumento(TipoDocumentoDTO tipoDocumento) {

			this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiNulo(tipoDocumento, new TipoDocumentoDTO.Builder().build());

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

		public PersonaDTO build() {

			return new PersonaDTO(this);

		}

	}

}
