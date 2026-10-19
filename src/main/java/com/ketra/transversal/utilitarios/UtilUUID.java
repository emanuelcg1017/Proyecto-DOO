package com.ketra.transversal.utilitarios;

import java.time.Instant;
import java.util.UUID;

public class UtilUUID {

	public static UUID UUID_DEFECTO = new UUID(0L, 0L);

	private UtilUUID() {

	}

	public static UUID generar() {

		return UUID.ofEpochMillis(Instant.now().toEpochMilli());

	}

	public static String generarComoTexto() {

		return generar().toString();

	}

	public static UUID obtenerValorDefecto(UUID id, UUID idDefecto) {

		return UtilObjeto.obtenerValorDefectoSiNulo(id, idDefecto);

	}

	public static UUID obtenerValorDefecto(UUID id) {

		return UtilObjeto.obtenerValorDefectoSiNulo(id, UUID_DEFECTO);

	}

	public static boolean esIgual(UUID uuidUno, UUID uuidDos) {

		return uuidUno.equals(uuidDos);

	}

}
