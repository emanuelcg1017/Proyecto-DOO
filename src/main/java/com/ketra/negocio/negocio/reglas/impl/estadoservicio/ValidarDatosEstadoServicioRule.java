package com.ketra.negocio.negocio.reglas.impl.estadoservicio;

import java.util.UUID;

import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public final class ValidarDatosEstadoServicioRule implements Rule<EstadoServicioDominio> {

	private static final ValidarDatosEstadoServicioRule instancia = new ValidarDatosEstadoServicioRule();

	private ValidarDatosEstadoServicioRule() {

	}

	public static ValidarDatosEstadoServicioRule obtenerInstancia() {

		return instancia;

	}

	public void ejecutar(UUID id) {

		if (UtilUUID.UUID_DEFECTO.equals(UtilUUID.obtenerValorDefecto(id))) {

			throw KETRANegocioException.crear(CatalogoMensajes.EstadoServicioNegocioImpl.ID_REQUERIDO);

		}

	}

	@Override
	public void ejecutar(EstadoServicioDominio... filtros) {

		if (UtilObjeto.esNulo(filtros) || filtros.length == 0) {

			return;

		}

		for (EstadoServicioDominio estado : filtros) {

			var filtro = UtilObjeto.obtenerValorDefectoSiNulo(estado, new EstadoServicioDominio.Builder().build());

			if (!UtilTexto.getUtilTexto().longitudCadenaEsValida(filtro.getNombre(), 0, 50, true)) {

				throw KETRANegocioException.crear(CatalogoMensajes.EstadoServicioNegocioImpl.NOMBRE_INVALIDO);

			}

			if (!UtilTexto.getUtilTexto().esVacia(filtro.getCodigo()) && !UtilTexto.getUtilTexto().formatoEsValido(filtro.getCodigo(), "^[A-Z]{3}-[0-9]{2}$")) {

				throw KETRANegocioException.crear(CatalogoMensajes.EstadoServicioNegocioImpl.CODIGO_INVALIDO);

			}

		}

	}

}
