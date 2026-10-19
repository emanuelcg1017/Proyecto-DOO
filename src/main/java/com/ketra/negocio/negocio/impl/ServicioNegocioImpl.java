package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.negocio.negocio.ServicioNegocio;
import com.ketra.negocio.negocio.assembler.impl.ServicioEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.servicio.AsegurarActualizacionEstadoServicioPermitidaRule;
import com.ketra.negocio.negocio.reglas.impl.servicio.ValidarDatosServicioRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.AsegurarServicioExisteRule;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class ServicioNegocioImpl implements ServicioNegocio {

	private DAOFactory daoFactory;

	public ServicioNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public ServicioDominio consultarPorId(UUID id) {

		ValidarDatosServicioRule.obtenerInstancia().ejecutar(id);

		var servicioEntidad = daoFactory.obtenerServicioDAO().consultarPorId(id);

		var servicioDominio = ServicioEntidadAssembler.getInstance().convertirADominio(servicioEntidad);

		AsegurarServicioExisteRule.obtenerInstancia().ejecutar(servicioDominio);

		return servicioDominio;

	}

	@Override
	public List<ServicioDominio> consultarPorFiltro(ServicioDominio filtro) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(filtro, new ServicioDominio.Builder().build());

		ValidarDatosServicioRule.obtenerInstancia().ejecutar(datos);

		var entidad = ServicioEntidadAssembler.getInstance().convertirAEntidad(datos);

		var entidades = daoFactory.obtenerServicioDAO().consultarPorFiltro(entidad);

		final List<ServicioDominio> resultados = new ArrayList<>();

		for (ServicioEntidad servicio : entidades) {

			resultados.add(ServicioEntidadAssembler.getInstance().convertirADominio(servicio));

		}

		return resultados;

	}

	@Override
	public List<ServicioDominio> consultarTodos() {

		return consultarPorFiltro(new ServicioDominio.Builder().build());

	}

	@Override
	public ServicioDominio actualizarEstado(UUID id, ServicioDominio servicio) {

		ValidarDatosServicioRule.obtenerInstancia().ejecutar(id, servicio);

		var actual = consultarPorId(id);

		AsegurarActualizacionEstadoServicioPermitidaRule.obtenerInstancia().ejecutar(actual, servicio, daoFactory);

		var actualizado = new ServicioDominio.Builder()
			.id(id)
			.numeroServicio(actual.getNumeroServicio())
			.fechaServicio(actual.getFechaServicio())
			.estado(servicio.getEstado())
			.build();

		daoFactory.obtenerServicioDAO().actualizar(id, ServicioEntidadAssembler.getInstance().convertirAEntidad(actualizado));

		if ("Finalizado".equals(actualizado.getEstado())) {

			new UtilidadNegocioImpl(daoFactory).generarUtilidad(id);

		}

		return actualizado;

	}

}
