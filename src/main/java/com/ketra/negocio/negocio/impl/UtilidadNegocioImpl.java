package com.ketra.negocio.negocio.impl;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.dominio.UtilidadDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.negocio.negocio.UtilidadNegocio;
import com.ketra.negocio.negocio.assembler.impl.ServicioEntidadAssembler;
import com.ketra.negocio.negocio.assembler.impl.UtilidadEntidadAssembler;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadNegocioImpl implements UtilidadNegocio {

	private DAOFactory daoFactory;

	protected UtilidadNegocioImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;
	}
	

	@Override
	public UtilidadDominio generarUtilidad(UUID idServicio) {

		asegurarDatosGeneracionUtilidadValidos(idServicio);
		
		var servicio = consultarServicio(idServicio);

		asegurarServicioExista(servicio);

		asegurarServicioEsteFinalizado(servicio);

		asegurarUtilidadNoHayaSidoGenerada(idServicio);

		var valorIngresos = calcularValorIngresos(idServicio);

		var valorCostos = calcularValorCostos(idServicio);

		var valorUtilidad = valorIngresos - valorCostos;

		var utilidad = construirUtilidad(servicio,valorIngresos,valorCostos,valorUtilidad);

		registrarUtilidad(utilidad);

		return utilidad;
	}
	


	private ServicioDominio consultarServicio(UUID idServicio) {

		var servicioEntidad = daoFactory.obtenerServicioDAO().consultarPorId(idServicio);

		return ServicioEntidadAssembler.getInstance().convertirADominio(servicioEntidad);
	}
	
	private void asegurarDatosGeneracionUtilidadValidos(UUID idServicio) {

		final UUID idDefecto =UtilUUID.obtenerValorDefecto(null);

		if (idDefecto.equals(UtilUUID.obtenerValorDefecto(idServicio))) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.ID_SERVICIO_REQUERIDO;

			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
	
	private void asegurarServicioExista(ServicioDominio servicio) {

		final UUID idDefecto =UtilUUID.obtenerValorDefecto(null);

		if (servicio == null || idDefecto.equals(servicio.getId())) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.SERVICIO_NO_EXISTE;

			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
	
	private void asegurarServicioEsteFinalizado(ServicioDominio servicio) {

		if (!"Finalizado".equalsIgnoreCase(servicio.getEstado())) {

			var mensajeUsuario =CatalogoMensajes.UtilidadNegocioImpl.SERVICIO_DEBE_ESTAR_FINALIZADO;

			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
	
	private void asegurarUtilidadNoHayaSidoGenerada(
			final UUID idServicio) {

		var servicioEntidad = new ServicioEntidad.Builder().id(idServicio).build();

		var utilidadFiltro = new UtilidadEntidad.Builder().servicio(servicioEntidad).build();

		var resultados = daoFactory.obtenerUtilidadDAO().consultarPorFiltro(utilidadFiltro);

		if (!resultados.isEmpty()) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.UTILIDAD_YA_GENERADA;

			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
	
	private Double calcularValorCostos(UUID idServicio) {
		
		return UtilNumero.CERO_DECIMAL;
	}


	private Double calcularValorIngresos(UUID idServicio) {
		
		return UtilNumero.CERO_DECIMAL;
	}
	
	private UtilidadDominio construirUtilidad(ServicioDominio servicio, Double valorIngresos, Double valorCostos, Double valorUtilidad) {

		return new UtilidadDominio.Builder()
				.id(UUID.randomUUID())
				.servicio(servicio)
				.valorIngresos(valorIngresos)
				.valorCostos(valorCostos)
				.valorUtilidad(valorUtilidad)
				.build();
	}
	
	private void registrarUtilidad(UtilidadDominio utilidad) {

		var utilidadEntidad =UtilidadEntidadAssembler.getInstance().convertirAEntidad(utilidad);

		daoFactory.obtenerUtilidadDAO().crear(utilidadEntidad);
	}
	
	@Override
	public UtilidadDominio consultarUtilidadPorServicio(UUID idServicio) {

		asegurarDatosGeneracionUtilidadValidos(idServicio);

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
