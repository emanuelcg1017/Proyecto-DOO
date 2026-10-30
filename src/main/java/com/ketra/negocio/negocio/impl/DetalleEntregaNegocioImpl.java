package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.DetalleEntregaDominio;
import com.ketra.dominio.EntregaDominio;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.negocio.negocio.DetalleEntregaNegocio;
import com.ketra.negocio.negocio.assembler.impl.DetalleEntregaEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.detalleentrega.ValidarDatosConsultarDetallesEntregaRule;

public class DetalleEntregaNegocioImpl implements DetalleEntregaNegocio {

	private final DAOFactory daoFactory;

	public DetalleEntregaNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

	}

	@Override
	public List<DetalleEntregaDominio> consultarDetallesEntrega(List<EntregaDominio> entregas) {

		ValidarDatosConsultarDetallesEntregaRule.obtenerInstancia().ejecutar(entregas);

		final List<DetalleEntregaDominio> resultados = new ArrayList<>();

		final Set<UUID> identificadores = new HashSet<>();

		for (EntregaDominio entrega : entregas) {

			var referencia = new EntregaEntidad.Builder().id(entrega.getId()).build();

			var filtro = new DetalleEntregaEntidad.Builder().entrega(referencia).build();

			var entidades = daoFactory.obtenerDetalleEntregaDAO().consultarPorFiltro(filtro);

			for (DetalleEntregaEntidad entidad : entidades) {

				if (identificadores.add(entidad.getId())) {

					resultados.add(DetalleEntregaEntidadAssembler.getInstance().convertirADominio(entidad));

				}

			}

		}

		return resultados;

	}

}
