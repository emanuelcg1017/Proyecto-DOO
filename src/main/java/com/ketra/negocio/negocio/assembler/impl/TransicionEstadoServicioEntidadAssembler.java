package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.entidad.TransicionEstadoServicioEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class TransicionEstadoServicioEntidadAssembler implements EntidadAssembler<TransicionEstadoServicioDominio, TransicionEstadoServicioEntidad> {

	private static final TransicionEstadoServicioEntidadAssembler instancia = new TransicionEstadoServicioEntidadAssembler();

	private TransicionEstadoServicioEntidadAssembler() {

	}

	public static TransicionEstadoServicioEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public TransicionEstadoServicioEntidad convertirAEntidad(TransicionEstadoServicioDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new TransicionEstadoServicioDominio.Builder().build());

		return new TransicionEstadoServicioEntidad.Builder()
				.id(datos.getId())
				.estadoOrigen(EstadoServicioEntidadAssembler.getInstance().convertirAEntidad(datos.getEstadoOrigen()))
				.estadoDestino(EstadoServicioEntidadAssembler.getInstance().convertirAEntidad(datos.getEstadoDestino()))
				.build();

	}

	@Override
	public TransicionEstadoServicioDominio convertirADominio(TransicionEstadoServicioEntidad original) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(original, new TransicionEstadoServicioEntidad.Builder().build());

		return new TransicionEstadoServicioDominio.Builder()
				.id(datos.getId())
				.estadoOrigen(EstadoServicioEntidadAssembler.getInstance().convertirADominio(datos.getEstadoOrigen()))
				.estadoDestino(EstadoServicioEntidadAssembler.getInstance().convertirADominio(datos.getEstadoDestino()))
				.build();

	}

}
