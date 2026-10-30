package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.entidad.EstadoServicioEntidad;
import com.ketra.negocio.negocio.EstadoServicioNegocio;
import com.ketra.negocio.negocio.assembler.impl.EstadoServicioEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.estadoservicio.ValidarDatosEstadoServicioRule;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoServicioNegocioImpl implements EstadoServicioNegocio {

	private final DAOFactory daoFactory;

	public EstadoServicioNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public EstadoServicioDominio consultarPorId(UUID id) {

		ValidarDatosEstadoServicioRule.obtenerInstancia().ejecutar(id);

		var entidad = daoFactory.obtenerEstadoServicioDAO().consultarPorId(id);

		return EstadoServicioEntidadAssembler.getInstance().convertirADominio(entidad);

	}

	@Override
	public List<EstadoServicioDominio> consultarPorFiltro(EstadoServicioDominio filtro) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(filtro, new EstadoServicioDominio.Builder().build());

		ValidarDatosEstadoServicioRule.obtenerInstancia().ejecutar(datos);

		var entidad = EstadoServicioEntidadAssembler.getInstance().convertirAEntidad(datos);

		var entidades = daoFactory.obtenerEstadoServicioDAO().consultarPorFiltro(entidad);

		final List<EstadoServicioDominio> resultados = new ArrayList<>();

		for (EstadoServicioEntidad estado : entidades) {

			resultados.add(EstadoServicioEntidadAssembler.getInstance().convertirADominio(estado));

		}

		return resultados;

	}

}
