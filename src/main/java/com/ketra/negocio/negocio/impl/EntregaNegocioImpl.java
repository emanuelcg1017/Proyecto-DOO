package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.EntregaDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioEntregaEntidad;
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

		var servicio = new ServicioEntidad.Builder().id(idServicio).build();

		var filtro = new ServicioEntregaEntidad.Builder().servicio(servicio).build();

		var asociaciones = daoFactory.obtenerServicioEntregaDAO().consultarPorFiltro(filtro);

		final List<EntregaDominio> resultados = new ArrayList<>();

		final Set<UUID> identificadores = new HashSet<>();

		for (ServicioEntregaEntidad relacion : asociaciones) {

			var entidad = relacion.getEntrega();

			if (identificadores.add(entidad.getId())) {

				resultados.add(EntregaEntidadAssembler.getInstance().convertirADominio(entidad));

			}

		}

		return resultados;

	}

}
