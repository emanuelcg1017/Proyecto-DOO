package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRAEntidadException extends KETRAExcepcion{

	private static final long serialVersionUID = -7178544903036679326L;

	private KETRAEntidadException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRAEntidadException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRAEntidadException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRAEntidadException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
