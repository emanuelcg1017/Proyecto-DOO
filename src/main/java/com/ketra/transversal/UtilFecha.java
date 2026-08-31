package main.java.com.ketra.transversal;
import java.time.LocalDate;

public class UtilFecha {
	
	public static LocalDate FECHA_DEFECTO = LocalDate.of(1000, 1, 1);
	
	private UtilFecha() {
	}
    
	public static LocalDate  obtenerFechaDefecto(LocalDate fecha, LocalDate FechaDefecto){
		return UtilObjeto.obtenerValorDefectoSiNulo(fecha, FechaDefecto);
	}
	
	public static LocalDate  obtenerFechaDefecto(LocalDate fecha){
		return UtilObjeto.obtenerValorDefectoSiNulo(fecha, FECHA_DEFECTO);
	}
	
	public static LocalDate obtenerFechaActual() {
		return LocalDate.now();
	}
	
	public static boolean esIgualA(LocalDate fechaUno ,LocalDate fechaDos) {
		return obtenerFechaDefecto(fechaUno).isEqual(obtenerFechaDefecto(fechaDos));
	}
	
	public static boolean esPosteriorA(LocalDate fechaUno ,LocalDate fechaDos) {
		return obtenerFechaDefecto(fechaUno).isAfter(obtenerFechaDefecto(fechaDos));
	}

	public static boolean esAnteriorA(LocalDate fechaUno ,LocalDate fechaDos) {
		return obtenerFechaDefecto(fechaUno).isBefore(obtenerFechaDefecto(fechaDos));
	}
	
	public static boolean esPosteriorIgualA(LocalDate fechaUno ,LocalDate fechaDos) {
		return esIgualA(fechaUno, fechaDos) || esPosteriorA(fechaUno, fechaDos);
	}
	
	public static boolean esAnteriorIgualA(LocalDate fechaUno ,LocalDate fechaDos) {
		return esIgualA(fechaUno, fechaDos) || esAnteriorA(fechaUno, fechaDos);
	}
	
	public static boolean estaEntre(LocalDate fecha, LocalDate fechaInicial, LocalDate fechaFinal, boolean incluirLimites) {
		return incluirLimites ? esPosteriorIgualA(fecha, fechaInicial) && esAnteriorIgualA(fecha, fechaFinal):
			esPosteriorA(fecha, fechaInicial) && esAnteriorA(fecha, fechaFinal);
	}
}
