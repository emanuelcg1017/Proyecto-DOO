package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarEstadoServicioDiferenteRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarEstadoServicioDiferenteRule();

	private AsegurarEstadoServicioDiferenteRule() {

	}

	public static Rule<String> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(String... datos) {

		if (datos[0].equals(datos[1])) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ESTADO_IGUAL);

		}

	}

}
