package com.ketra.negocio.fachada.assembler.impl;

import com.ketra.dominio.EstadoFacturaDominio;
import com.ketra.dto.EstadoFacturaDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoFacturaDTOAssembler implements DTOAssembler<EstadoFacturaDominio, EstadoFacturaDTO> {

	private static final EstadoFacturaDTOAssembler instancia = new EstadoFacturaDTOAssembler();

	private EstadoFacturaDTOAssembler() {

	}

	public static EstadoFacturaDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public EstadoFacturaDTO convertirADTO(EstadoFacturaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EstadoFacturaDominio.Builder().build());

		var resultado = new EstadoFacturaDTO();

		resultado.setId(datos.getId());

		resultado.setCodigo(datos.getCodigo());

		resultado.setNombre(datos.getNombre());

		return resultado;

	}

	@Override
	public EstadoFacturaDominio convertirADominio(EstadoFacturaDTO original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new EstadoFacturaDTO());

		return new EstadoFacturaDominio.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

}
