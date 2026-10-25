package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.FacturaDominio;
import com.ketra.entidad.FacturaEntidad;
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

		var entidades = daoFactory.obtenerFacturaDAO().consultarPorServicio(idServicio);

		final List<FacturaDominio> resultados = new ArrayList<>();

		for (FacturaEntidad entidad : entidades) {

			resultados.add(FacturaEntidadAssembler.getInstance().convertirADominio(entidad));

		}

		return resultados;

	}

}
