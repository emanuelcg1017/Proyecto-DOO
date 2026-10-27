package com.ketra.negocio.fachada.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.dto.ServicioDTO;
import com.ketra.negocio.fachada.ServicioFachada;
import com.ketra.negocio.fachada.assembler.impl.ServicioDTOAssembler;
import com.ketra.negocio.negocio.ServicioNegocio;
import com.ketra.negocio.negocio.impl.ServicioNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRAFachadaException;

public class ServicioFachadaImpl implements ServicioFachada {

	private final DAOFactory daoFactory;

	private final ServicioNegocio servicioNegocio;

	public ServicioFachadaImpl() {

		daoFactory = DAOFactory.obtenerFactoria();

		servicioNegocio = new ServicioNegocioImpl(daoFactory);

	}

	public ServicioFachadaImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

		servicioNegocio = new ServicioNegocioImpl(daoFactory);

	}

	@Override
	public ServicioDTO consultarPorId(UUID id) {

		try {

			var servicio = servicioNegocio.consultarPorId(id);

			return ServicioDTOAssembler.getInstance().convertirADTO(servicio);

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			var mensajeUsuario = CatalogoMensajes.ServicioFachadaImpl.ERROR_CONSULTANDO;

			throw KETRAFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

	@Override
	public List<ServicioDTO> consultarPorFiltro(ServicioDTO filtro) {

		try {

			var filtroDominio = ServicioDTOAssembler.getInstance().convertirADominio(filtro);

			var servicios = servicioNegocio.consultarPorFiltro(filtroDominio);

			final List<ServicioDTO> resultados = new ArrayList<>();

			for (ServicioDominio servicio : servicios) {

				resultados.add(ServicioDTOAssembler.getInstance().convertirADTO(servicio));

			}

			return resultados;

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			var mensajeUsuario = CatalogoMensajes.ServicioFachadaImpl.ERROR_CONSULTANDO;

			throw KETRAFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

	@Override
	public List<ServicioDTO> consultarTodos() {

		return consultarPorFiltro(new ServicioDTO());

	}

	@Override
	public ServicioDTO actualizarEstado(UUID id, ServicioDTO servicio) {

		boolean transaccionIniciada = false;

		try {

			daoFactory.iniciarTransaccion();

			transaccionIniciada = true;

			var servicioDominio = ServicioDTOAssembler.getInstance().convertirADominio(servicio);

			var actualizado = servicioNegocio.actualizarEstado(id, servicioDominio);

			var respuesta = ServicioDTOAssembler.getInstance().convertirADTO(actualizado);

			daoFactory.confirmarTransaccion();

			transaccionIniciada = false;

			return respuesta;

		} catch (KETRAExcepcion excepcion) {

			if (transaccionIniciada) {

				daoFactory.cancelarTransaccion();

			}

			throw excepcion;

		} catch (Exception excepcion) {

			if (transaccionIniciada) {

				daoFactory.cancelarTransaccion();

			}

			var mensajeUsuario = CatalogoMensajes.ServicioFachadaImpl.ERROR_ACTUALIZANDO;

			throw KETRAFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

}
