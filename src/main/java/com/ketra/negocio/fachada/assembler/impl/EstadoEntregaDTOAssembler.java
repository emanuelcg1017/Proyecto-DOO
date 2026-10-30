package com.ketra.negocio.fachada.assembler.impl;

import com.ketra.dominio.EstadoEntregaDominio;
import com.ketra.dto.EstadoEntregaDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoEntregaDTOAssembler implements DTOAssembler<EstadoEntregaDominio, EstadoEntregaDTO> {

	private static final EstadoEntregaDTOAssembler instancia = new EstadoEntregaDTOAssembler();

	private EstadoEntregaDTOAssembler() {

	}

	public static EstadoEntregaDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public EstadoEntregaDTO convertirADTO(EstadoEntregaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EstadoEntregaDominio.Builder().build());

		var resultado = new EstadoEntregaDTO();

		resultado.setId(datos.getId());

		resultado.setCodigo(datos.getCodigo());

		resultado.setNombre(datos.getNombre());

		return resultado;

	}

	@Override
	public EstadoEntregaDominio convertirADominio(EstadoEntregaDTO original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new EstadoEntregaDTO());

		return new EstadoEntregaDominio.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

}
