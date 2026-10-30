package com.ketra.transversal.utilitarios;

public class UtilTexto {
	
	private static UtilTexto INSTANCIA;
	public static final String SOLO_LETRAS_ESPACIOS = "^[a-zA-Z ñÑáÁéÉíÍóÓúÚ]*$";
	public static final String VACIO = "" ;
	
	private UtilTexto() {
		
	}
	public static UtilTexto getUtilTexto() {
		
		synchronized (UtilTexto.class) {
			if(UtilObjeto.esNulo(INSTANCIA)) {
				INSTANCIA = new UtilTexto();
			}
		}
		
		return INSTANCIA;
	}
	
	public boolean esNulla(String cadena) {
		return UtilObjeto.esNulo(cadena);
	}
	
	public boolean esVacia(String cadena) {
		return VACIO.equals(obtenerValorDefecto(cadena));
	}
	
	public String obtenerValorDefecto(String valor, String valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiNulo(valor, valorDefecto);
	}
	
	public String obtenerValorDefecto(String valor) {
		return obtenerValorDefecto(valor,VACIO);
	}

	public String concatenar(String... textos) {

		final StringBuilder resultado = new StringBuilder();

		if (!UtilObjeto.esNulo(textos)) {

			for (String texto : textos) {

				resultado.append(obtenerValorDefecto(texto));

			}

		}

		return resultado.toString();

	}

	public String quitarEspacionEnBlanco(String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	public int obtenerLongitudCadena(String cadena) {
		return obtenerValorDefecto(cadena).length();
	}
	
	public int obtenerLongitudCadena(String cadena, boolean quitarEspacionBlanco) {
		return quitarEspacionBlanco ? obtenerLongitudCadena(quitarEspacionEnBlanco(cadena)) : obtenerLongitudCadena(cadena);
	}
	
	public boolean longitudCadenaEsValida(String cadena, int longitudInicial, int longitudFinal, boolean quitarEspaciosBlanco) {
		var longitud = obtenerLongitudCadena(cadena, quitarEspaciosBlanco);

		return longitud >= longitudInicial && longitud <= longitudFinal;
	}
	
	public boolean formatoEsValido(String valor, String patron) {
		
		return (obtenerValorDefecto(valor)).matches(obtenerValorDefecto(patron));
	}
}
	
