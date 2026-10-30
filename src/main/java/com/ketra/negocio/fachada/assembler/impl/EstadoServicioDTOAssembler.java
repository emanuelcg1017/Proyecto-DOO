package com.ketra.negocio.fachada.assembler.impl;

import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.dto.EstadoServicioDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EstadoServicioDTOAssembler implements DTOAssembler<EstadoServicioDominio, EstadoServicioDTO> {

	private static final EstadoServicioDTOAssembler instancia = new EstadoServicioDTOAssembler();

	private EstadoServicioDTOAssembler() {

	}

	public static EstadoServicioDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public EstadoServicioDTO convertirADTO(EstadoServicioDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EstadoServicioDominio.Builder().build());

		var resultado = new EstadoServicioDTO();

		resultado.setId(datos.getId());

		resultado.setCodigo(datos.getCodigo());

		resultado.setNombre(datos.getNombre());

		return resultado;

	}

	@Override
	public EstadoServicioDominio convertirADominio(EstadoServicioDTO original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new EstadoServicioDTO());

		return new EstadoServicioDominio.Builder()
				.id(datos.getId())
				.codigo(datos.getCodigo())
				.nombre(datos.getNombre())
				.build();

	}

}
