package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.dominio.EstadoServicioDominio;

import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarEstadoServicioDiferenteRule implements Rule<EstadoServicioDominio> {

	private static final Rule<EstadoServicioDominio> instancia = new AsegurarEstadoServicioDiferenteRule();

	private AsegurarEstadoServicioDiferenteRule() {

	}

	public static Rule<EstadoServicioDominio> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(EstadoServicioDominio... datos) {

		if (datos[0].getId().equals(datos[1].getId())) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ESTADO_IGUAL);

		}

	}

}
