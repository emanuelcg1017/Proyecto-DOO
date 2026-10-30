package com.ketra.negocio.negocio.reglas.impl.costorecorrido;

import java.util.List;

import com.ketra.dominio.DetalleEntregaDominio;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public final class ValidarDatosConsultarCostosRecorridoRule {

	private static final ValidarDatosConsultarCostosRecorridoRule instancia = new ValidarDatosConsultarCostosRecorridoRule();

	private ValidarDatosConsultarCostosRecorridoRule() {

	}

	public static ValidarDatosConsultarCostosRecorridoRule obtenerInstancia() {

		return instancia;

	}

	public void ejecutar(List<DetalleEntregaDominio> detallesEntrega) {

		if (UtilObjeto.esNulo(detallesEntrega)) {

			throw KETRANegocioException.crear(CatalogoMensajes.CostoRecorridoNegocioImpl.LISTA_DETALLES_REQUERIDA);

		}

		for (DetalleEntregaDominio detalleEntrega : detallesEntrega) {

			if (UtilObjeto.esNulo(detalleEntrega) || UtilUUID.UUID_DEFECTO.equals(detalleEntrega.getId())) {

				throw KETRANegocioException.crear(CatalogoMensajes.CostoRecorridoNegocioImpl.DETALLE_INVALIDO);

			}

		}

	}

}
