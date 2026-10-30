package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.CostoRecorridoDominio;
import com.ketra.dominio.DetalleEntregaDominio;
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.negocio.negocio.CostoRecorridoNegocio;
import com.ketra.negocio.negocio.assembler.impl.CostoRecorridoEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.costorecorrido.ValidarDatosConsultarCostosRecorridoRule;

public class CostoRecorridoNegocioImpl implements CostoRecorridoNegocio {

	private final DAOFactory daoFactory;

	public CostoRecorridoNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public List<CostoRecorridoDominio> consultarCostosRecorrido(List<DetalleEntregaDominio> detallesEntrega) {

		ValidarDatosConsultarCostosRecorridoRule.obtenerInstancia().ejecutar(detallesEntrega);

		final List<CostoRecorridoDominio> resultados = new ArrayList<>();

		final Set<UUID> identificadores = new HashSet<>();

		for (DetalleEntregaDominio detalleEntrega : detallesEntrega) {

			var referencia = new DetalleEntregaEntidad.Builder().id(detalleEntrega.getId()).build();

			var filtro = new CostoRecorridoEntidad.Builder().detalleEntrega(referencia).build();

			var entidades = daoFactory.obtenerCostoRecorridoDAO().consultarPorFiltro(filtro);

			for (CostoRecorridoEntidad entidad : entidades) {

				if (identificadores.add(entidad.getId())) {

					var costo = CostoRecorridoEntidadAssembler.getInstance().convertirADominio(entidad);

					resultados.add(new CostoRecorridoDominio.Builder()
							.id(costo.getId())
							.numeroCosto(costo.getNumeroCosto())
							.detalleEntrega(detalleEntrega)
							.valorPorKM(costo.getValorPorKM())
							.valorCosto(costo.getValorCosto())
							.build());

				}

			}

		}

		return resultados;

	}

}
