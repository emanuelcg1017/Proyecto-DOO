package com.ketra.negocio.negocio.reglas.impl.detalleentrega;

import java.util.List;

import com.ketra.dominio.EntregaDominio;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public final class ValidarDatosConsultarDetallesEntregaRule {

	private static final ValidarDatosConsultarDetallesEntregaRule instancia = new ValidarDatosConsultarDetallesEntregaRule();

	private ValidarDatosConsultarDetallesEntregaRule() {

	}

	public static ValidarDatosConsultarDetallesEntregaRule obtenerInstancia() {

		return instancia;

	}

	public void ejecutar(List<EntregaDominio> entregas) {

		if (UtilObjeto.esNulo(entregas)) {

			throw KETRANegocioException.crear(CatalogoMensajes.DetalleEntregaNegocioImpl.LISTA_ENTREGAS_REQUERIDA);

		}

		for (EntregaDominio entrega : entregas) {

			if (UtilObjeto.esNulo(entrega) || UtilUUID.UUID_DEFECTO.equals(entrega.getId())) {

				throw KETRANegocioException.crear(CatalogoMensajes.DetalleEntregaNegocioImpl.ENTREGA_INVALIDA);

			}

		}

	}

}
