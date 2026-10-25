package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.EntregaDominio;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.negocio.negocio.EntregaNegocio;
import com.ketra.negocio.negocio.assembler.impl.EntregaEntidadAssembler;

public class EntregaNegocioImpl implements EntregaNegocio {

	private final DAOFactory daoFactory;

	public EntregaNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public List<EntregaDominio> consultarPorServicio(UUID idServicio) {

		new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

		var entidades = daoFactory.obtenerEntregaDAO().consultarPorServicio(idServicio);

		final List<EntregaDominio> resultados = new ArrayList<>();

		for (EntregaEntidad entidad : entidades) {

			resultados.add(EntregaEntidadAssembler.getInstance().convertirADominio(entidad));

		}

		return resultados;

	}

}
