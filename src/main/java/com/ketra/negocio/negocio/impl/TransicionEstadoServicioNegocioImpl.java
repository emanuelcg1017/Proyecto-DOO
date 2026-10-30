package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.entidad.TransicionEstadoServicioEntidad;
import com.ketra.negocio.negocio.TransicionEstadoServicioNegocio;
import com.ketra.negocio.negocio.assembler.impl.TransicionEstadoServicioEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.transicionestadoservicio.ValidarDatosTransicionEstadoServicioRule;

public class TransicionEstadoServicioNegocioImpl implements TransicionEstadoServicioNegocio {

	private final DAOFactory daoFactory;

	public TransicionEstadoServicioNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public TransicionEstadoServicioDominio consultarPorId(UUID id) {

        ValidarDatosTransicionEstadoServicioRule.obtenerInstancia().validarIdentificador(id);

		var entidad = daoFactory.obtenerTransicionEstadoServicioDAO().consultarPorId(id);

		return TransicionEstadoServicioEntidadAssembler.getInstance().convertirADominio(entidad);

	}

	@Override
	public List<TransicionEstadoServicioDominio> consultarPorFiltro(TransicionEstadoServicioDominio filtro) {

        ValidarDatosTransicionEstadoServicioRule.obtenerInstancia().validarFiltro(filtro);

		var entidad = TransicionEstadoServicioEntidadAssembler.getInstance().convertirAEntidad(filtro);

		var entidades = daoFactory.obtenerTransicionEstadoServicioDAO().consultarPorFiltro(entidad);

		final List<TransicionEstadoServicioDominio> resultados = new ArrayList<>();

		for (TransicionEstadoServicioEntidad resultado : entidades) {

			resultados.add(TransicionEstadoServicioEntidadAssembler.getInstance().convertirADominio(resultado));

		}

		return resultados;

	}

}
