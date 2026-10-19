package com.ketra.controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.ketra.controlador.respuesta.EstadoRespuesta;
import com.ketra.controlador.respuesta.RespuestaError;
import com.ketra.controlador.respuesta.RespuestaOk;
import com.ketra.transversal.utilitarios.UtilFecha;

import tools.jackson.databind.json.JsonMapper;

class RespuestaTests {

	@Test
	void respuestaSeSerializaConFechaIdentificadorMensajesDatosYEstado() {

		LocalDateTime antes = UtilFecha.generarFechaHoraActual();

		var respuesta = RespuestaOk.crear(List.of("Consulta realizada"), List.of("SRV-001"));

		LocalDateTime despues = UtilFecha.generarFechaHoraActual();

		assertFalse(respuesta.getTimestamp().isBefore(antes));

		assertFalse(respuesta.getTimestamp().isAfter(despues));

		assertNotNull(UUID.fromString(respuesta.getCorrelationId()));

		var json = JsonMapper.builder().build().valueToTree(respuesta);

		assertEquals(5, json.size());

		assertTrue(json.hasNonNull("timestamp"));

		assertEquals(respuesta.getCorrelationId(), json.get("correlationId").asString());

		assertEquals("Consulta realizada", json.get("mensajes").get(0).asString());

		assertEquals("SRV-001", json.get("datos").get(0).asString());

		assertEquals("OK", json.get("estado").asString());

	}

	@Test
	void respuestasConListasNulasOfrecenListasVaciasYConservanSuEstado() {

		var correcta = RespuestaOk.crear(null, null);

		var error = RespuestaError.crear(null, null);

		assertTrue(correcta.getMensajes().isEmpty());

		assertTrue(correcta.getDatos().isEmpty());

		assertEquals(EstadoRespuesta.OK, correcta.getEstado());

		assertTrue(error.getMensajes().isEmpty());

		assertTrue(error.getDatos().isEmpty());

		assertEquals(EstadoRespuesta.ERROR, error.getEstado());

	}

}
