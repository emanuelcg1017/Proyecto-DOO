package com.ketra.transversal.utilitarios;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

public class UtilFecha {
	
	public static final LocalDate FECHA_DEFECTO = LocalDate.of(1000, Month.JANUARY, 1);

	private static final ZoneId ZONA_HORARIA = ZoneId.of("America/Bogota");
	
	private UtilFecha() {
	}
    
	public static LocalDate  obtenerFechaDefecto(LocalDate fecha, LocalDate fechaDefecto){
		return UtilObjeto.obtenerValorDefectoSiNulo(fecha, fechaDefecto);
	}
	
	public static LocalDate  obtenerFechaDefecto(LocalDate fecha){
		return UtilObjeto.obtenerValorDefectoSiNulo(fecha, FECHA_DEFECTO);
	}
	
	public static LocalDate obtenerFechaActual() {
		return LocalDate.now(ZONA_HORARIA);
	}

	public static LocalDateTime generarFechaHoraActual() {

		return LocalDateTime.now(ZONA_HORARIA);

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
