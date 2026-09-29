package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRATransversalException extends KETRAExcepcion {

	private static final long serialVersionUID = 7101581336734117497L;

	private KETRATransversalException(String mensajeUsuario, String mensajeTecnico,Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRATransversalException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRATransversalException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRATransversalException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
