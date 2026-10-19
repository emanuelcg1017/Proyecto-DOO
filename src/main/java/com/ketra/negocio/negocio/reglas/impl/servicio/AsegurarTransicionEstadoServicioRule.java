package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarTransicionEstadoServicioRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarTransicionEstadoServicioRule();

	private AsegurarTransicionEstadoServicioRule() {

	}

	public static Rule<String> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(String... datos) {

		var actual = datos[0];

		var nuevo = datos[1];

		if ("Cancelado".equals(nuevo) && ("En ejecución".equals(actual) || "Finalizado".equals(actual))) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.NO_CANCELABLE);

		}

		if ("Finalizado".equals(actual) || "Cancelado".equals(actual)) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ESTADO_TERMINAL);

		}


		if (!("Registrado".equals(actual) && ("En ejecución".equals(nuevo) || "Cancelado".equals(nuevo)) || "En ejecución".equals(actual) && "Finalizado".equals(nuevo))) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.TRANSICION_INVALIDA);

		}

	}

}
