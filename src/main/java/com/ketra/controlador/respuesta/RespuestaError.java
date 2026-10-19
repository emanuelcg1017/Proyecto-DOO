package com.ketra.controlador.respuesta;

import java.util.List;

public class RespuestaError<D> extends Respuesta<D> {

	private RespuestaError(List<String> mensajes, List<D> datos) {

		super(mensajes, datos, EstadoRespuesta.ERROR);

	}

	public static RespuestaError<String> crear(String mensaje) {

		return new RespuestaError<>(List.of(mensaje), List.of());

	}

	public static <D> RespuestaError<D> crear(List<String> mensajes, List<D> datos) {

		return new RespuestaError<>(mensajes, datos);

	}

}
