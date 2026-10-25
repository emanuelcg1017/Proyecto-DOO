package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRAFachadaException extends KETRAExcepcion {

	private static final long serialVersionUID = 1L;

	private KETRAFachadaException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.FACHADA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRAFachadaException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRAFachadaException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRAFachadaException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
