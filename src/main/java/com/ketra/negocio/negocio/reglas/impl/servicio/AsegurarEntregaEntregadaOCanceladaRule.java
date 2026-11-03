package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.dominio.EntregaDominio;
import com.ketra.transversal.catalogo.catalogocodigosdeestado.enums.EstadoEntregaEnum;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarEntregaEntregadaOCanceladaRule implements Rule<EntregaDominio> {

	private static final Rule<EntregaDominio> instancia = new AsegurarEntregaEntregadaOCanceladaRule();

	private AsegurarEntregaEntregadaOCanceladaRule() {

	}

	public static Rule<EntregaDominio> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(EntregaDominio... datos) {

		for (EntregaDominio entrega : datos) {

			var codigoEstado = entrega.getEstadoEntrega().getCodigo();

			if (!EstadoEntregaEnum.ENTREGADA.getCodigo().equals(codigoEstado)
					&& !EstadoEntregaEnum.CANCELADA.getCodigo().equals(codigoEstado)) {

				throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ENTREGAS_SIN_COMPLETAR);

			}

		}

	}

}
