package com.ketra.transversal.utilitarios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;

public final class UtilLogger {

	private final Logger logger;

	private UtilLogger(Class<?> clase) {

		logger = LoggerFactory.getLogger(clase);

	}

	public static UtilLogger obtenerLogger(Class<?> clase) {

		return new UtilLogger(clase);

	}

	public void printException(Exception excepcion) {

		if (excepcion instanceof KETRAExcepcion excepcionKetra) {

			logger.error(CatalogoMensajes.UtilLogger.FORMATO_EXCEPCION_KETRA,
					excepcionKetra.getCapa(),
					excepcionKetra.getMensajeTecnico(),
					excepcionKetra.getExcepcionRaiz());

		} else {

			logger.error(CatalogoMensajes.UtilLogger.ERROR_NO_CONTROLADO, excepcion);

		}

	}

}
