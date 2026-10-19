package com.ketra.negocio.negocio.reglas.impl.servicio;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.negocio.negocio.reglas.Rule;

public class AsegurarActualizacionEstadoServicioPermitidaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarActualizacionEstadoServicioPermitidaRule();

	private AsegurarActualizacionEstadoServicioPermitidaRule() {

	}

	public static Rule<Object> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(Object... datos) {

		var actual = (ServicioDominio) datos[0];

		var nuevo = (ServicioDominio) datos[1];

		var daoFactory = (DAOFactory) datos[2];

		AsegurarEstadoServicioDiferenteRule.obtenerInstancia().ejecutar(actual.getEstado(), nuevo.getEstado());

		AsegurarTransicionEstadoServicioRule.obtenerInstancia().ejecutar(actual.getEstado(), nuevo.getEstado());

		AsegurarEntregasPermitenCambioEstadoServicioRule.obtenerInstancia().ejecutar(actual.getId(), nuevo.getEstado(), daoFactory);

	}

}
