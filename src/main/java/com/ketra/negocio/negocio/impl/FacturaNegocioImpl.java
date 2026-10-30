package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.FacturaDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioFacturaEntidad;
import com.ketra.negocio.negocio.FacturaNegocio;
import com.ketra.negocio.negocio.assembler.impl.FacturaEntidadAssembler;

public class FacturaNegocioImpl implements FacturaNegocio {

	private final DAOFactory daoFactory;

	public FacturaNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public List<FacturaDominio> consultarPorServicio(UUID idServicio) {

		new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

		var servicio = new ServicioEntidad.Builder().id(idServicio).build();

		var filtro = new ServicioFacturaEntidad.Builder().servicio(servicio).build();

		var asociaciones = daoFactory.obtenerServicioFacturaDAO().consultarPorFiltro(filtro);

		final List<FacturaDominio> resultados = new ArrayList<>();

		final Set<UUID> identificadores = new HashSet<>();

		for (ServicioFacturaEntidad relacion : asociaciones) {

			var entidad = relacion.getFactura();

			if (identificadores.add(entidad.getId())) {

				resultados.add(FacturaEntidadAssembler.getInstance().convertirADominio(entidad));

			}

		}

		return resultados;

	}

}
