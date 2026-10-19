package com.ketra.controlador.respuesta;

import java.util.List;

public class RespuestaOk<D> extends Respuesta<D> {

	private RespuestaOk(List<String> mensajes, List<D> datos) {

		super(mensajes, datos, EstadoRespuesta.OK);

	}

	public static <D> RespuestaOk<D> crear(List<String> mensajes, List<D> datos) {

		return new RespuestaOk<>(mensajes, datos);

	}

	public static <D> RespuestaOk<D> crear(List<D> datos) {

		return crear(List.of(), datos);

	}

	public static <D> RespuestaOk<D> crear(D dato) {

		return crear(List.of(dato));

	}

	public static <D> RespuestaOk<D> crear() {

		return crear(List.of(), List.of());

	}

}
