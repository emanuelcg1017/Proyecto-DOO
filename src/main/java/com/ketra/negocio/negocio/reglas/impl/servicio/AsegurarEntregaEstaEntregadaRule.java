package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.dominio.EntregaDominio;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarEntregaEstaEntregadaRule implements Rule<EntregaDominio> {

	private static final Rule<EntregaDominio> instancia = new AsegurarEntregaEstaEntregadaRule();

	private AsegurarEntregaEstaEntregadaRule() {

	}

	public static Rule<EntregaDominio> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(EntregaDominio... datos) {

		for (EntregaDominio entrega : datos) {

			if (!"Entregada".equals(entrega.getEstadoEntrega())) {

				throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ENTREGAS_SIN_COMPLETAR);

			}

		}

	}

}
