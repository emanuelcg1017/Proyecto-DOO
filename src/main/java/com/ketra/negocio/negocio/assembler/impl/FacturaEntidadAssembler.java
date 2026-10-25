package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.FacturaDominio;
import com.ketra.entidad.FacturaEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class FacturaEntidadAssembler implements EntidadAssembler<FacturaDominio, FacturaEntidad> {

	private static final FacturaEntidadAssembler instancia = new FacturaEntidadAssembler();

	private FacturaEntidadAssembler() {

	}

	public static FacturaEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public FacturaEntidad convertirAEntidad(FacturaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new FacturaDominio.Builder().build());

		return new FacturaEntidad.Builder()
				.id(datos.getId())
				.numeroFactura(datos.getNumeroFactura())
				.fechaFactura(datos.getFechaFactura())
				.ingresos(datos.getIngresos())
				.EstadoFactura(datos.getEstadoFactura())
				.build();

	}

	@Override
	public FacturaDominio convertirADominio(FacturaEntidad entidad) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new FacturaEntidad.Builder().build());

		return new FacturaDominio.Builder()
				.id(datos.getId())
				.numeroFactura(datos.getNumeroFactura())
				.fechaFactura(datos.getFechaFactura())
				.ingresos(datos.getIngresos())
				.estadoFactura(datos.getEstadoFactura())
				.build();

	}

}
