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

		var resultado = new ServicioDTO();

		resultado.setId(dominioTmp.getId());

		resultado.setNumeroServicio(dominioTmp.getNumeroServicio());

		resultado.setFechaServicio(dominioTmp.getFechaServicio());

		resultado.setEstado(EstadoServicioDTOAssembler.getInstance().convertirADTO(dominioTmp.getEstado()));

		return resultado;
	}

	@Override
	public ServicioDominio convertirADominio(ServicioDTO dto) {

		var dtoTmp = UtilObjeto.obtenerValorDefectoSiNulo(dto, new ServicioDTO());

		return new ServicioDominio.Builder()
				.id(dtoTmp.getId())
				.numeroServicio(dtoTmp.getNumeroServicio())
				.fechaServicio(dtoTmp.getFechaServicio())
				.estado(EstadoServicioDTOAssembler.getInstance().convertirADominio(dtoTmp.getEstado()))
				.build();
	}
}