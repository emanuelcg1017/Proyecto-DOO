package com.ketra.negocio.fachada.impl;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dto.UtilidadDTO;
import com.ketra.negocio.fachada.UtilidadFachada;
import com.ketra.negocio.fachada.assembler.impl.UtilidadDTOAssembler;
import com.ketra.negocio.negocio.UtilidadNegocio;
import com.ketra.negocio.negocio.impl.UtilidadNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRAFachadaException;

public class UtilidadFachadaImpl implements UtilidadFachada {

	private final DAOFactory daoFactory;

	private final UtilidadNegocio utilidadNegocio;

	public UtilidadFachadaImpl() {

		daoFactory = DAOFactory.obtenerFactoria();

		utilidadNegocio = new UtilidadNegocioImpl(daoFactory);

	}

	public UtilidadFachadaImpl(DAOFactory daoFactory) {

		this.daoFactory = daoFactory;

		utilidadNegocio = new UtilidadNegocioImpl(daoFactory);

	}

	@Override
	public UtilidadDTO generarUtilidad(UUID idServicio) {

		boolean transaccionIniciada = false;

		try {

			daoFactory.iniciarTransaccion();

			transaccionIniciada = true;

			var utilidadDominio = utilidadNegocio.generarUtilidad(idServicio);

			var utilidadDTO = UtilidadDTOAssembler.getInstance().convertirADTO(utilidadDominio);

			daoFactory.confirmarTransaccion();

			transaccionIniciada = false;

			return utilidadDTO;

		} catch (KETRAExcepcion excepcion) {

			if (transaccionIniciada) {

				daoFactory.cancelarTransaccion();

			}

			throw excepcion;

		} catch (Exception excepcion) {

			if (transaccionIniciada) {

				daoFactory.cancelarTransaccion();

			}

			var mensajeUsuario = CatalogoMensajes.UtilidadFachadaImpl.ERROR_GENERANDO_UTILIDAD;

			throw KETRAFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

	@Override
	public UtilidadDTO consultarUtilidadPorServicio(UUID idServicio) {

		try {

			var utilidadDominio = utilidadNegocio.consultarUtilidadPorServicio(idServicio);

			return UtilidadDTOAssembler.getInstance().convertirADTO(utilidadDominio);

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			var mensajeUsuario = CatalogoMensajes.UtilidadFachadaImpl.ERROR_CONSULTANDO_UTILIDAD;

			throw KETRAFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

}
