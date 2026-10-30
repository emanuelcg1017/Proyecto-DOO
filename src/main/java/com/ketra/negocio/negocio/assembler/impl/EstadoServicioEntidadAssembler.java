package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.entidad.EstadoServicioEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoServicioEntidadAssembler implements EntidadAssembler<EstadoServicioDominio, EstadoServicioEntidad> {

	private static final EstadoServicioEntidadAssembler instancia = new EstadoServicioEntidadAssembler();

	private EstadoServicioEntidadAssembler() {

	}

	public static EstadoServicioEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public EstadoServicioEntidad convertirAEntidad(EstadoServicioDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EstadoServicioDominio.Builder().build());

		return new EstadoServicioEntidad.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

	@Override
	public EstadoServicioDominio convertirADominio(EstadoServicioEntidad original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new EstadoServicioEntidad.Builder().build());

		return new EstadoServicioDominio.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

}
