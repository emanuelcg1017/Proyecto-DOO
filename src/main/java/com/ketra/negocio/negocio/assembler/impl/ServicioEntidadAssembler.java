package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.ServicioDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class ServicioEntidadAssembler
		implements EntidadAssembler<ServicioDominio, ServicioEntidad> {

	private static final EntidadAssembler<ServicioDominio, ServicioEntidad> instancia = new ServicioEntidadAssembler();

	private ServicioEntidadAssembler() {

	}

	public static EntidadAssembler<ServicioDominio, ServicioEntidad> getInstance() {

		return instancia;
	}

	@Override
	public ServicioEntidad convertirAEntidad(ServicioDominio dominio) {

		var dominioTmp = UtilObjeto.obtenerValorDefectoSiNulo(dominio,new ServicioDominio.Builder().build());

		return new ServicioEntidad.Builder()
				.id(dominioTmp.getId())
				.numeroServicio(dominioTmp.getNumeroServicio())
				.fechaServicio(dominioTmp.getFechaServicio())
				.estado(dominioTmp.getEstado())
				.build();
	}

	@Override
	public ServicioDominio convertirADominio(ServicioEntidad entidad) {

		var entidadTmp = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new ServicioEntidad.Builder().build());

		return new ServicioDominio.Builder()
				.id(entidadTmp.getId())
				.numeroServicio(entidadTmp.getNumeroServicio())
				.fechaServicio(entidadTmp.getFechaServicio())
				.estado(entidadTmp.getEstado())
				.build();
	}
}