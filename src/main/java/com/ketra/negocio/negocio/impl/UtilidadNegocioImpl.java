package com.ketra.negocio.negocio.impl;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.dominio.UtilidadDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.negocio.negocio.ServicioNegocio;
import com.ketra.negocio.negocio.UtilidadNegocio;
import com.ketra.negocio.negocio.assembler.impl.UtilidadEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.utilidad.AsegurarServicioFinalizadoRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.AsegurarUtilidadNoGeneradaRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.ValidarDatosGenerarUtilidadRule;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadNegocioImpl implements UtilidadNegocio {

	private DAOFactory daoFactory;

	public UtilidadNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;
	}
	

	@Override
	public UtilidadDominio generarUtilidad(final UUID idServicio) {

		ValidarDatosGenerarUtilidadRule.obtenerInstancia().ejecutar(idServicio);

		ServicioNegocio servicioNegocio = new ServicioNegocioImpl(daoFactory);

		var servicio = servicioNegocio.consultarPorId(idServicio);

		AsegurarServicioFinalizadoRule.obtenerInstancia().ejecutar(servicio);

		AsegurarUtilidadNoGeneradaRule.obtenerInstancia().ejecutar(idServicio, daoFactory);

		var valorIngresos = calcularValorIngresos(idServicio);

		var valorCostos = calcularValorCostos(idServicio);

		var valorUtilidad = valorIngresos - valorCostos;

		var idUtilidad = UtilUUID.generar();

		var utilidad = construirUtilidad(idUtilidad, servicio, valorIngresos, valorCostos, valorUtilidad);

		registrarUtilidad(utilidad);

		return utilidad;
	}
	
	
	private Double calcularValorCostos(UUID idServicio) {

		return daoFactory.obtenerCostoRecorridoDAO().consultarTotalCostosPorServicio(idServicio);
	}


	private Double calcularValorIngresos(UUID idServicio) {

		return daoFactory.obtenerFacturaDAO().consultarTotalIngresosPorServicio(idServicio);
	}
	
	private UtilidadDominio construirUtilidad(final UUID idUtilidad, final ServicioDominio servicio, final Double valorIngresos, final Double valorCostos, final Double valorUtilidad) {

		return new UtilidadDominio.Builder()
				.id(idUtilidad)
				.servicio(servicio)
				.valorIngresos(valorIngresos)
				.valorCostos(valorCostos)
				.valorUtilidad(valorUtilidad)
				.build();
	}
	
	private void registrarUtilidad(final UtilidadDominio utilidad) {

		var utilidadEntidad = UtilidadEntidadAssembler.getInstance().convertirAEntidad(utilidad);

		daoFactory.obtenerUtilidadDAO().crear(utilidadEntidad);
	}
	
	@Override
	public UtilidadDominio consultarUtilidadPorServicio(UUID idServicio) {

		ValidarDatosGenerarUtilidadRule.obtenerInstancia().ejecutar(idServicio);
		
		var servicioEntidad = new ServicioEntidad.Builder()
						.id(idServicio)
						.build();

		var utilidadFiltro = new UtilidadEntidad.Builder()
						.servicio(servicioEntidad)
						.build();

		var resultados = daoFactory.obtenerUtilidadDAO().consultarPorFiltro(utilidadFiltro);

		if (resultados.isEmpty()) {

			return new UtilidadDominio.Builder().build();
		}

		return UtilidadEntidadAssembler.getInstance().convertirADominio(resultados.get(0));
	}

}
