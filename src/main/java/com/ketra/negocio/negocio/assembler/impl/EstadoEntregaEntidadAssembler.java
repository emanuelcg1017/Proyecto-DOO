package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.EstadoEntregaDominio;
import com.ketra.entidad.EstadoEntregaEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoEntregaEntidadAssembler implements EntidadAssembler<EstadoEntregaDominio, EstadoEntregaEntidad> {

	private static final EstadoEntregaEntidadAssembler instancia = new EstadoEntregaEntidadAssembler();

	private EstadoEntregaEntidadAssembler() {

	}

	public static EstadoEntregaEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public EstadoEntregaEntidad convertirAEntidad(EstadoEntregaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EstadoEntregaDominio.Builder().build());

		return new EstadoEntregaEntidad.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

	@Override
	public EstadoEntregaDominio convertirADominio(EstadoEntregaEntidad original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new EstadoEntregaEntidad.Builder().build());

		return new EstadoEntregaDominio.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

}
