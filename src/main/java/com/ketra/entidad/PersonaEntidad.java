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
		setId(UtilUUID.obtenerValorDefecto(id));
		setTipoDocumento(new TipoDocumentoEntidad());
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

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public TipoDocumentoEntidad getTipoDocumento() {
		return tipoDocumento;
	}

	private void setTipoDocumento(TipoDocumentoEntidad tipoDocumento) {
		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiNulo(tipoDocumento, new TipoDocumentoEntidad());
	}
	
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	private void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroIdentificacion);
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	private void setPrimerNombre(String primerNombre) {
		this.primerNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerNombre);
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	private void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoNombre);
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	private void setPrimerApellido(String primerApellido) {
		this.primerApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(primerApellido);
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	private void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(segundoApellido);
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	private void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroTelefonico);
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	private void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(correoElectronico);
	}

}
