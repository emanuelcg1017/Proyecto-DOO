package main.java.com.ketra.transversal;

public class UtilNumero {
	
	public static int CERO = 0;
	
	private UtilNumero() {
	}
	
	public static <N extends Number> N obtenerValorDefecto(N valor, N valorDefecto){
		return UtilObjeto.obtenerValorDefectoSiNulo(valor, valorDefecto);
	}
	
	public static <N extends Number> Number obtenerValorDefecto(N valor){
		return UtilObjeto.obtenerValorDefectoSiNulo(valor, CERO);
	}
	
	public static <N extends Number> boolean mayorQue(N numeroUno, N numeroDos){
		return obtenerValorDefecto(numeroUno).doubleValue() > obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean menorQue(N numeroUno, N numeroDos){
		return obtenerValorDefecto(numeroUno).doubleValue() < obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean mayorIgualQue(N numeroUno, N numeroDos){
		return obtenerValorDefecto(numeroUno).doubleValue() >= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean menorIgualQue(N numeroUno, N numeroDos){
		return obtenerValorDefecto(numeroUno).doubleValue() <= obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean diferenteQue(N numeroUno, N numeroDos){
		return obtenerValorDefecto(numeroUno).doubleValue() != obtenerValorDefecto(numeroDos).doubleValue();
	}
	
	public static <N extends Number> boolean estaEntre(N numeroUno, int longitudInicial, int longitudFinal, boolean incluirLimites){
		return incluirLimites ? mayorIgualQue(numeroUno, longitudInicial) && menorIgualQue(numeroUno, longitudFinal) :
			mayorQue(numeroUno, longitudInicial) && menorQue(numeroUno, longitudFinal);
	}
}
