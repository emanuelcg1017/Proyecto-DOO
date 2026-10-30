package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.EstadoFacturaDominio;
import com.ketra.entidad.EstadoFacturaEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoFacturaEntidadAssembler implements EntidadAssembler<EstadoFacturaDominio, EstadoFacturaEntidad> {

	private static final EstadoFacturaEntidadAssembler instancia = new EstadoFacturaEntidadAssembler();

	private EstadoFacturaEntidadAssembler() {

	}

	public static EstadoFacturaEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public EstadoFacturaEntidad convertirAEntidad(EstadoFacturaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EstadoFacturaDominio.Builder().build());

		return new EstadoFacturaEntidad.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

	@Override
	public EstadoFacturaDominio convertirADominio(EstadoFacturaEntidad original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new EstadoFacturaEntidad.Builder().build());

		return new EstadoFacturaDominio.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

}
