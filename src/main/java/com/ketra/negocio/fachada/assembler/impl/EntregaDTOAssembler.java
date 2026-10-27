package com.ketra.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import com.ketra.dominio.EntregaDominio;
import com.ketra.dto.EntregaDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class EntregaDTOAssembler implements DTOAssembler<EntregaDominio, EntregaDTO> {

	private static final EntregaDTOAssembler instancia = new EntregaDTOAssembler();

	private EntregaDTOAssembler() {

	}

	public static EntregaDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public EntregaDTO convertirADTO(EntregaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new EntregaDominio.Builder().build());

		var resultado = new EntregaDTO();

		resultado.setId(datos.getId());

		resultado.setCodigoEntrega(datos.getCodigoEntrega());

		resultado.setFechaEntrega(datos.getFechaEntrega());

		resultado.setEstadoEntrega(datos.getEstadoEntrega());

		return resultado;

	}

	@Override
	public EntregaDominio convertirADominio(EntregaDTO dto) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dto, new EntregaDTO());

		return new EntregaDominio.Builder()
				.id(datos.getId())
				.codigoEntrega(datos.getCodigoEntrega())
				.fechaEntrega(datos.getFechaEntrega())
				.estadoEntrega(datos.getEstadoEntrega())
				.build();

	}

	public List<EntregaDTO> convertirADTO(List<EntregaDominio> dominios) {

		final List<EntregaDTO> resultados = new ArrayList<>();

		for (EntregaDominio dominio : dominios) {

			resultados.add(convertirADTO(dominio));

		}

		return resultados;

	}

}
