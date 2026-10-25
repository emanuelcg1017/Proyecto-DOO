package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.CostoRecorridoDominio;
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.negocio.negocio.CostoRecorridoNegocio;
import com.ketra.negocio.negocio.assembler.impl.CostoRecorridoEntidadAssembler;

public class CostoRecorridoNegocioImpl implements CostoRecorridoNegocio {

	private final DAOFactory daoFactory;

	public CostoRecorridoNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public List<CostoRecorridoDominio> consultarPorServicio(UUID idServicio) {

		new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

		var entidades = daoFactory.obtenerCostoRecorridoDAO().consultarPorServicio(idServicio);

		final List<CostoRecorridoDominio> resultados = new ArrayList<>();

		for (CostoRecorridoEntidad entidad : entidades) {

			resultados.add(CostoRecorridoEntidadAssembler.getInstance().convertirADominio(entidad));

		}

		return resultados;

	}

}
