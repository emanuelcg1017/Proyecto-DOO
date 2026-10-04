package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.ServicioDominio;
import com.ketra.dominio.UtilidadDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class UtilidadEntidadAssembler
		implements EntidadAssembler<UtilidadDominio, UtilidadEntidad> {

	private static final EntidadAssembler<UtilidadDominio, UtilidadEntidad> instancia = new UtilidadEntidadAssembler();

	private UtilidadEntidadAssembler() {

	}

	public static EntidadAssembler<UtilidadDominio, UtilidadEntidad> getInstance() {

		return instancia;
	}

	@Override
	public UtilidadEntidad convertirAEntidad(UtilidadDominio dominio) {

		var dominioTmp = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new UtilidadDominio.Builder().build());

		var servicioEntidad = new ServicioEntidad.Builder()
						.id(dominioTmp.getServicio().getId())
						.numeroServicio(dominioTmp.getServicio().getNumeroServicio())
						.fechaServicio(dominioTmp.getServicio().getFechaServicio())
						.estado(dominioTmp.getServicio().getEstado())
						.build();

		return new UtilidadEntidad.Builder()
				.id(dominioTmp.getId())
				.servicio(servicioEntidad)
				.valorIngresos(dominioTmp.getValorIngresos())
				.valorCostos(dominioTmp.getValorCostos())
				.valorUtilidad(dominioTmp.getValorUtilidad())
				.build();
	}

	@Override
	public UtilidadDominio convertirADominio(UtilidadEntidad entidad) {

		var entidadTmp = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new UtilidadEntidad.Builder().build());

		var servicioDominio = new ServicioDominio.Builder()
						.id(entidadTmp.getServicio().getId())
						.numeroServicio(entidadTmp.getServicio().getNumeroServicio())
						.fechaServicio(entidadTmp.getServicio().getFechaServicio())
						.estado(entidadTmp.getServicio().getEstado())
						.build();

		return new UtilidadDominio.Builder()
				.id(entidadTmp.getId())
				.servicio(servicioDominio)
				.valorIngresos(entidadTmp.getValorIngresos())
				.valorCostos(entidadTmp.getValorCostos())
				.valorUtilidad(entidadTmp.getValorUtilidad())
				.build();
	}
}