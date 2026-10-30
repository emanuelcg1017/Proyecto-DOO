package com.ketra.negocio.fachada.assembler.impl;

import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.dto.TransicionEstadoServicioDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class TransicionEstadoServicioDTOAssembler implements DTOAssembler<TransicionEstadoServicioDominio, TransicionEstadoServicioDTO> {

	private static final TransicionEstadoServicioDTOAssembler instancia = new TransicionEstadoServicioDTOAssembler();

	private TransicionEstadoServicioDTOAssembler() {

	}

	public static TransicionEstadoServicioDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public TransicionEstadoServicioDTO convertirADTO(TransicionEstadoServicioDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new TransicionEstadoServicioDominio.Builder().build());

		var resultado = new TransicionEstadoServicioDTO();

		resultado.setId(datos.getId());

		resultado.setEstadoOrigen(EstadoServicioDTOAssembler.getInstance().convertirADTO(datos.getEstadoOrigen()));

		resultado.setEstadoDestino(EstadoServicioDTOAssembler.getInstance().convertirADTO(datos.getEstadoDestino()));

		return resultado;

	}

	@Override
	public TransicionEstadoServicioDominio convertirADominio(TransicionEstadoServicioDTO original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new TransicionEstadoServicioDTO());

		return new TransicionEstadoServicioDominio.Builder()
				.id(datos.getId())
				.estadoOrigen(EstadoServicioDTOAssembler.getInstance().convertirADominio(datos.getEstadoOrigen()))
				.estadoDestino(EstadoServicioDTOAssembler.getInstance().convertirADominio(datos.getEstadoDestino()))
				.build();

	}

}
