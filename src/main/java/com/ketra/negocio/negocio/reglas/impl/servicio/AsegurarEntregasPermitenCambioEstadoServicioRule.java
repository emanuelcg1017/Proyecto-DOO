package com.ketra.negocio.negocio.reglas.impl.servicio;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.EntregaDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioEntregaEntidad;
import com.ketra.negocio.negocio.reglas.Rule;

public class AsegurarEntregasPermitenCambioEstadoServicioRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarEntregasPermitenCambioEstadoServicioRule();

	private AsegurarEntregasPermitenCambioEstadoServicioRule() {

	}

	public static Rule<Object> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(Object... datos) {

		var idServicio = (UUID) datos[0];

		var nuevoEstado = (String) datos[1];

		var daoFactory = (DAOFactory) datos[2];

		if (!"Cancelado".equals(nuevoEstado) && !"Finalizado".equals(nuevoEstado)) {

			return;

		}

		var servicioFiltro = new ServicioEntidad.Builder()
				.id(idServicio)
				.build();

		var filtro = new ServicioEntregaEntidad.Builder()
				.servicio(servicioFiltro)
				.build();

		var asociaciones = daoFactory.obtenerServicioEntregaDAO().consultarPorFiltro(filtro);

		for (ServicioEntregaEntidad asociacion : asociaciones) {

			var entidad = asociacion.getEntrega();

			var entrega = new EntregaDominio.Builder()
					.id(entidad.getId())
					.codigoEntrega(entidad.getCodigoEntrega())
					.fechaEntrega(entidad.getFechaEntrega())
					.estadoEntrega(entidad.getEstadoEntrega())
					.build();

			if ("Cancelado".equals(nuevoEstado)) {

				AsegurarEntregaNoEstaEnTransitoRule.obtenerInstancia().ejecutar(entrega);

			} else {

				AsegurarEntregaEstaEntregadaRule.obtenerInstancia().ejecutar(entrega);

			}

		}

	}

}
