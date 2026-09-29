package com.ketra.transversal.excepciones;

import com.ketra.transversal.excepciones.enums.Capa;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;

public class KETRAExcepcion extends RuntimeException {

	private static final long serialVersionUID = 8082942784000168578L;
	
	private Capa capa;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private Exception excepcionRaiz;
	
	

	protected KETRAExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super();
		setCapa(capa);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		setExcepcionRaiz(excepcionRaiz);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Capa getCapa() {
		return capa;
	}

	private void setCapa(Capa capa) {
		this.capa = UtilObjeto.obtenerValorDefectoSiNulo(capa, Capa.GENERAL);
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeUsuario);
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	private void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeTecnico, getMensajeUsuario());
	}

	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}

	private void setExcepcionRaiz(Exception excepcionRaiz) {
		this.excepcionRaiz = UtilObjeto.obtenerValorDefectoSiNulo(excepcionRaiz, new Exception(getMensajeTecnico()));
	}

}
