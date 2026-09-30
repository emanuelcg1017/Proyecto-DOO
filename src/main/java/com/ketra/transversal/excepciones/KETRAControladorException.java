package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRAControladorException extends KETRAExcepcion{

	private static final long serialVersionUID = -4366900195755863997L;

	private KETRAControladorException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);

	}

	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRAControladorException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRAControladorException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRAControladorException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
