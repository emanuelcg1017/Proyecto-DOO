package main.java.com.ketra.transversal;

public class UtilObjeto {

	private UtilObjeto() {	
	}
	
	public static <O> boolean esNulo(O objeto) {
		return objeto == null;
	}
	
	public static <O> O obtenerValorDefectoSiNulo(O valor, O valorDefecto) {
		return esNulo(valor) ? valorDefecto:valor;
	}
}
