package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRADatosException extends KETRAExcepcion {

	private static final long serialVersionUID = 1202221204184197914L;

	private KETRADatosException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRADatosException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRADatosException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRADatosException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
}
