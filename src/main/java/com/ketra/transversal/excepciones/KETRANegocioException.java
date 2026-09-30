package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;


public class KETRANegocioException extends KETRAExcepcion {

	private static final long serialVersionUID = -3944080165692344227L;

	private KETRANegocioException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRANegocioException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRANegocioException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRANegocioException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
