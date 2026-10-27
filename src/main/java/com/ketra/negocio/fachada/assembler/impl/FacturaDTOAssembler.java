package com.ketra.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import com.ketra.dominio.FacturaDominio;
import com.ketra.dto.FacturaDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class FacturaDTOAssembler implements DTOAssembler<FacturaDominio, FacturaDTO> {

	private static final FacturaDTOAssembler instancia = new FacturaDTOAssembler();

	private FacturaDTOAssembler() {

	}

	public static FacturaDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public FacturaDTO convertirADTO(FacturaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new FacturaDominio.Builder().build());

		var resultado = new FacturaDTO();

		resultado.setId(datos.getId());

		resultado.setNumeroFactura(datos.getNumeroFactura());

		resultado.setFechaFactura(datos.getFechaFactura());

		resultado.setIngresos(datos.getIngresos());

		resultado.setEstadoFactura(datos.getEstadoFactura());

		return resultado;

	}

	@Override
	public FacturaDominio convertirADominio(FacturaDTO dto) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dto, new FacturaDTO());

		return new FacturaDominio.Builder()
				.id(datos.getId())
				.numeroFactura(datos.getNumeroFactura())
				.fechaFactura(datos.getFechaFactura())
				.ingresos(datos.getIngresos())
				.estadoFactura(datos.getEstadoFactura())
				.build();

	}

	public List<FacturaDTO> convertirADTO(List<FacturaDominio> dominios) {

		final List<FacturaDTO> resultados = new ArrayList<>();

		for (FacturaDominio dominio : dominios) {

			resultados.add(convertirADTO(dominio));

		}

		return resultados;

	}

}
