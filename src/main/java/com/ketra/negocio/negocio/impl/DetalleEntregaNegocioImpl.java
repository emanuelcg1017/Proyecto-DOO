package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.DetalleEntregaDominio;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.negocio.negocio.DetalleEntregaNegocio;
import com.ketra.negocio.negocio.assembler.impl.DetalleEntregaEntidadAssembler;

public class DetalleEntregaNegocioImpl implements DetalleEntregaNegocio {

	private final DAOFactory daoFactory;

	public DetalleEntregaNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public List<DetalleEntregaDominio> consultarPorServicio(UUID idServicio) {

		new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

		var entidades = daoFactory.obtenerDetalleEntregaDAO().consultarPorServicio(idServicio);

		final List<DetalleEntregaDominio> resultados = new ArrayList<>();

		for (DetalleEntregaEntidad entidad : entidades) {

			resultados.add(DetalleEntregaEntidadAssembler.getInstance().convertirADominio(entidad));

		}

		return resultados;

	}

}
