package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRADominioException extends KETRAExcepcion {
	
	private static final long serialVersionUID = -295888984189460242L;

	private KETRADominioException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRADominioException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRADominioException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRADominioException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
