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

		setId(UtilUUID.UUID_DEFECTO);

		setTipoDocumento(new TipoDocumentoDTO());

		setNumeroIdentificacion(UtilTexto.VACIO);

		setPrimerNombre(UtilTexto.VACIO);

		setSegundoNombre(UtilTexto.VACIO);

		setPrimerApellido(UtilTexto.VACIO);

		setSegundoApellido(UtilTexto.VACIO);

		setNumeroTelefonico(UtilTexto.VACIO);

		setCorreoElectronico(UtilTexto.VACIO);

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

		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiNulo(tipoDocumento, new TipoDocumentoDTO());

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

}
