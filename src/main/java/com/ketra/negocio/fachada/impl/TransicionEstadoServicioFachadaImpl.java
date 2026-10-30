package com.ketra.negocio.fachada.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.dto.TransicionEstadoServicioDTO;
import com.ketra.negocio.fachada.TransicionEstadoServicioFachada;
import com.ketra.negocio.fachada.assembler.impl.TransicionEstadoServicioDTOAssembler;
import com.ketra.negocio.negocio.impl.TransicionEstadoServicioNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRAFachadaException;

public class TransicionEstadoServicioFachadaImpl implements TransicionEstadoServicioFachada {

	@Override
	public TransicionEstadoServicioDTO consultarPorId(UUID id) {

		var daoFactory = DAOFactory.obtenerFactoria();

		var negocio = new TransicionEstadoServicioNegocioImpl(daoFactory);

		try {

			var dominio = negocio.consultarPorId(id);

			return TransicionEstadoServicioDTOAssembler.getInstance().convertirADTO(dominio);

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			throw KETRAFachadaException.crear(
					CatalogoMensajes.TransicionEstadoServicioFachadaImpl.ERROR_CONSULTANDO, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

	@Override
	public List<TransicionEstadoServicioDTO> consultarPorFiltro(TransicionEstadoServicioDTO filtro) {

		var daoFactory = DAOFactory.obtenerFactoria();

		var negocio = new TransicionEstadoServicioNegocioImpl(daoFactory);

		try {

			var dominio = TransicionEstadoServicioDTOAssembler.getInstance().convertirADominio(filtro);

			var datos = negocio.consultarPorFiltro(dominio);

			final List<TransicionEstadoServicioDTO> resultados = new ArrayList<>();

			for (TransicionEstadoServicioDominio dato : datos) {

				resultados.add(TransicionEstadoServicioDTOAssembler.getInstance().convertirADTO(dato));

			}

			return resultados;

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			throw KETRAFachadaException.crear(
					CatalogoMensajes.TransicionEstadoServicioFachadaImpl.ERROR_CONSULTANDO, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

}
