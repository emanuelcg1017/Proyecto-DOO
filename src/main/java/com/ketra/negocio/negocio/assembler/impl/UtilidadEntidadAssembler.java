package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.UtilidadDominio;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class UtilidadEntidadAssembler
		implements EntidadAssembler<UtilidadDominio, UtilidadEntidad> {

	private static final UtilidadEntidadAssembler instancia = new UtilidadEntidadAssembler();

	private UtilidadEntidadAssembler() {

	}

	public static UtilidadEntidadAssembler getInstance() {

		return instancia;
	}

	@Override
	public UtilidadEntidad convertirAEntidad(UtilidadDominio dominio) {

		var dominioTmp = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new UtilidadDominio.Builder().build());

		var servicioEntidad = ServicioEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getServicio());

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

		var servicioDominio = ServicioEntidadAssembler.getInstance().convertirADominio(entidadTmp.getServicio());

		return new UtilidadDominio.Builder()
				.id(entidadTmp.getId())
				.servicio(servicioDominio)
				.valorIngresos(entidadTmp.getValorIngresos())
				.valorCostos(entidadTmp.getValorCostos())
				.valorUtilidad(entidadTmp.getValorUtilidad())
				.build();
	}

}
