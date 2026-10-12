package com.ketra.negocio.fachada.assembler.impl;

import com.ketra.dominio.ServicioDominio;
import com.ketra.dto.ServicioDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class ServicioDTOAssembler implements DTOAssembler<ServicioDominio, ServicioDTO> {

	private static final DTOAssembler<ServicioDominio, ServicioDTO> instancia = new ServicioDTOAssembler();

	private ServicioDTOAssembler() {
	}

	public static DTOAssembler<ServicioDominio, ServicioDTO> getInstance() {
		return instancia;
	}

	@Override
	public ServicioDTO convertirADTO(ServicioDominio dominio) {

		var dominioTmp = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new ServicioDominio.Builder().build());

		return new ServicioDTO.Builder()
				.id(dominioTmp.getId())
				.numeroServicio(dominioTmp.getNumeroServicio())
				.fechaServicio(dominioTmp.getFechaServicio())
				.estado(dominioTmp.getEstado())
				.build();
	}

	@Override
	public ServicioDominio convertirADominio(ServicioDTO dto) {

		var dtoTmp = UtilObjeto.obtenerValorDefectoSiNulo(dto, new ServicioDTO.Builder().build());

		return new ServicioDominio.Builder()
				.id(dtoTmp.getId())
				.numeroServicio(dtoTmp.getNumeroServicio())
				.fechaServicio(dtoTmp.getFechaServicio())
				.estado(dtoTmp.getEstado())
				.build();
	}
}