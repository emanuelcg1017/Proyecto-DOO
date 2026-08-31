package main.java.com.ketra.transversal;

public class UtilTexto {

	private static UtilTexto INSTANCIA;
	public static String VACIO;
	
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
		var valorSanitizado = quitarEspaciosBlanco ? quitarEspacionEnBlanco(cadena) : cadena;
		
		return obtenerLongitudCadena(valorSanitizado) >= longitudInicial && obtenerLongitudCadena(cadena) <= longitudFinal;
	}
}
