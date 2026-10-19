package com.ketra.servicio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.ketra.transversal.utilitarios.UtilUUID;

class UtilUUIDTests {

	@Test
	void generarIncorporaElTiempoActualYLaVersionSiete() {

		long antes = Instant.now().toEpochMilli();

		UUID id = UtilUUID.generar();

		long despues = Instant.now().toEpochMilli();

		long instanteDelUUID = id.getMostSignificantBits() >>> 16;

		assertEquals(7, id.version());

		assertEquals(2, id.variant());

		assertTrue(instanteDelUUID >= antes && instanteDelUUID <= despues);

	}

	@Test
	void generarComoTextoDevuelveUnUUIDVersionSieteValido() {

		String texto = UtilUUID.generarComoTexto();

		UUID id = UUID.fromString(texto);

		assertEquals(36, texto.length());

		assertEquals(7, id.version());

		assertNotEquals(UtilUUID.UUID_DEFECTO, id);

	}

	@Test
	void llamadasConsecutivasProducenIdentificadoresDistintos() {

		Set<UUID> identificadores = new HashSet<>();

		for (int indice = 0; indice < 1000; indice++) {

			assertTrue(identificadores.add(UtilUUID.generar()));

		}

	}

}
