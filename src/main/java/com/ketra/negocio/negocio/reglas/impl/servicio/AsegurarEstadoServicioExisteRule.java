package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class AsegurarEstadoServicioExisteRule implements Rule<EstadoServicioDominio> {

	private static final Rule<EstadoServicioDominio> instancia = new AsegurarEstadoServicioExisteRule();

	private AsegurarEstadoServicioExisteRule() {

	}

	public static Rule<EstadoServicioDominio> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(EstadoServicioDominio... datos) {

		if (UtilObjeto.esNulo(datos) || datos.length == 0) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ESTADO_NO_EXISTE);

		}

		for (EstadoServicioDominio estado : datos) {

			if (UtilObjeto.esNulo(estado) || UtilUUID.UUID_DEFECTO.equals(estado.getId())) {

				throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ESTADO_NO_EXISTE);

			}

		}

	}

}
