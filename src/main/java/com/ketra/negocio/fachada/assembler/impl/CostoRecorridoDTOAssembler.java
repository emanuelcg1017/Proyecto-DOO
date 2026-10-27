package com.ketra.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import com.ketra.dominio.CostoRecorridoDominio;
import com.ketra.dto.CostoRecorridoDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class CostoRecorridoDTOAssembler implements DTOAssembler<CostoRecorridoDominio, CostoRecorridoDTO> {

	private static final CostoRecorridoDTOAssembler instancia = new CostoRecorridoDTOAssembler();

	private CostoRecorridoDTOAssembler() {

	}

	public static CostoRecorridoDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public CostoRecorridoDTO convertirADTO(CostoRecorridoDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new CostoRecorridoDominio.Builder().build());

		var resultado = new CostoRecorridoDTO();

		resultado.setId(datos.getId());

		resultado.setNumeroCosto(datos.getNumeroCosto());

		resultado.setDetalleEntrega(DetalleEntregaDTOAssembler.getInstance().convertirADTO(datos.getDetalleEntrega()));

		resultado.setValorPorKM(datos.getValorPorKM());

		resultado.setValorCosto(datos.getValorCosto());

		return resultado;

	}

	@Override
	public CostoRecorridoDominio convertirADominio(CostoRecorridoDTO dto) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dto, new CostoRecorridoDTO());

		return new CostoRecorridoDominio.Builder()
				.id(datos.getId())
				.numeroCosto(datos.getNumeroCosto())
				.valorPorKM(datos.getValorPorKM())
				.valorCosto(datos.getValorCosto())
				.detalleEntrega(DetalleEntregaDTOAssembler.getInstance().convertirADominio(datos.getDetalleEntrega()))
				.build();

	}

	public List<CostoRecorridoDTO> convertirADTO(List<CostoRecorridoDominio> dominios) {

		final List<CostoRecorridoDTO> resultados = new ArrayList<>();

		for (CostoRecorridoDominio dominio : dominios) {

			resultados.add(convertirADTO(dominio));

		}

		return resultados;

	}

}
