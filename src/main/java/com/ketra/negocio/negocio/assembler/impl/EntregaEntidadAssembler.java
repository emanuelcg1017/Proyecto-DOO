package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.EntregaDominio;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EntregaEntidadAssembler implements EntidadAssembler<EntregaDominio, EntregaEntidad> {

	private static final EntregaEntidadAssembler instancia = new EntregaEntidadAssembler();

	private EntregaEntidadAssembler() {

	}

	public static EntregaEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public EntregaEntidad convertirAEntidad(EntregaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EntregaDominio.Builder().build());

		return new EntregaEntidad.Builder()
				.id(datos.getId())
				.codigoEntrega(datos.getCodigoEntrega())
				.fechaEntrega(datos.getFechaEntrega())
				.estadoEntrega(datos.getEstadoEntrega())
				.build();

	}

	@Override
	public EntregaDominio convertirADominio(EntregaEntidad entidad) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new EntregaEntidad.Builder().build());

		return new EntregaDominio.Builder()
				.id(datos.getId())
				.codigoEntrega(datos.getCodigoEntrega())
				.fechaEntrega(datos.getFechaEntrega())
				.estadoEntrega(datos.getEstadoEntrega())
				.build();

	}

}
