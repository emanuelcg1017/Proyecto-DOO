package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.CostoRecorridoDominio;
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class CostoRecorridoEntidadAssembler implements EntidadAssembler<CostoRecorridoDominio, CostoRecorridoEntidad> {

	private static final CostoRecorridoEntidadAssembler instancia = new CostoRecorridoEntidadAssembler();

	private CostoRecorridoEntidadAssembler() {

	}

	public static CostoRecorridoEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public CostoRecorridoEntidad convertirAEntidad(CostoRecorridoDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new CostoRecorridoDominio.Builder().build());

		return new CostoRecorridoEntidad.Builder()
				.id(datos.getId())
				.numeroCosto(datos.getNumeroCosto())
				.valorPorKM(datos.getValorPorKM())
				.valorCosto(datos.getValorCosto())
				.detalleEntrega(DetalleEntregaEntidadAssembler.getInstance().convertirAEntidad(datos.getDetalleEntrega()))
				.build();

	}

	@Override
	public CostoRecorridoDominio convertirADominio(CostoRecorridoEntidad entidad) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new CostoRecorridoEntidad.Builder().build());

		return new CostoRecorridoDominio.Builder()
				.id(datos.getId())
				.numeroCosto(datos.getNumeroCosto())
				.valorPorKM(datos.getValorPorKM())
				.valorCosto(datos.getValorCosto())
				.detalleEntrega(DetalleEntregaEntidadAssembler.getInstance().convertirADominio(datos.getDetalleEntrega()))
				.build();

	}

}
