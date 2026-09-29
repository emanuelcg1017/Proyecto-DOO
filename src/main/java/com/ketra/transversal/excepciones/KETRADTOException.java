package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;

public class KETRADTOException extends KETRAExcepcion{

	private static final long serialVersionUID = -1332207713066290062L;

	private KETRADTOException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		}
	
	
	public static KETRAExcepcion crear(String mensajeUsuario) {
		return new KETRADTOException(mensajeUsuario, mensajeUsuario , new Exception(mensajeUsuario));
	}

	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new KETRADTOException(mensajeUsuario, mensajeTecnico , new Exception(mensajeTecnico));
	}
	
	public static KETRAExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new KETRADTOException(mensajeUsuario, mensajeTecnico , excepcionRaiz);
	}
}
