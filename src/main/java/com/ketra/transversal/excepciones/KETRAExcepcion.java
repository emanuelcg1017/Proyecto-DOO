package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;

public class KETRAExcepcion extends RuntimeException {

	private static final long serialVersionUID = 8082942784000168578L;
	
	private final Capa capa;
	private final String mensajeUsuario;
	private final String mensajeTecnico;
	private final Exception excepcionRaiz;
	
	

	protected  KETRAExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super();
		this.capa = UtilObjeto.obtenerValorDefectoSiNulo(capa, Capa.GENERAL);
		this.mensajeUsuario = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeUsuario);
		this.mensajeTecnico = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeTecnico, this.mensajeUsuario);
		this.excepcionRaiz = UtilObjeto.obtenerValorDefectoSiNulo(excepcionRaiz, new Exception(this.mensajeTecnico));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Capa getCapa() {
		return capa;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}

}
