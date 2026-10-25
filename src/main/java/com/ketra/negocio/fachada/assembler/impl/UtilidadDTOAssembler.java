package com.ketra.negocio.fachada.assembler.impl;

import com.ketra.dominio.UtilidadDominio;
import com.ketra.dto.UtilidadDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class UtilidadDTOAssembler implements DTOAssembler<UtilidadDominio, UtilidadDTO> {

	private static final DTOAssembler<UtilidadDominio, UtilidadDTO> instancia = new UtilidadDTOAssembler();

	private UtilidadDTOAssembler() {
	}

	public static DTOAssembler<UtilidadDominio, UtilidadDTO> getInstance() {
		return instancia;
	}

	@Override
	public UtilidadDTO convertirADTO(UtilidadDominio dominio) {

		var dominioTmp = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new UtilidadDominio.Builder().build());

		var servicioDTO = ServicioDTOAssembler.getInstance().convertirADTO(dominioTmp.getServicio());

		return new UtilidadDTO.Builder()
				.id(dominioTmp.getId())
				.servicio(servicioDTO)
				.valorIngresos(dominioTmp.getValorIngresos())
				.valorCostos(dominioTmp.getValorCostos())
				.valorUtilidad(dominioTmp.getValorUtilidad())
				.build();
	}

	@Override
	public UtilidadDominio convertirADominio(UtilidadDTO dto) {

		var dtoTmp = UtilObjeto.obtenerValorDefectoSiNulo(dto, new UtilidadDTO.Builder().build());

		var servicioDominio = ServicioDTOAssembler.getInstance().convertirADominio(dtoTmp.getServicio());

		return new UtilidadDominio.Builder()
				.id(dtoTmp.getId())
				.servicio(servicioDominio)
				.valorIngresos(dtoTmp.getValorIngresos())
				.valorCostos(dtoTmp.getValorCostos())
				.valorUtilidad(dtoTmp.getValorUtilidad())
				.build();
	}

}
