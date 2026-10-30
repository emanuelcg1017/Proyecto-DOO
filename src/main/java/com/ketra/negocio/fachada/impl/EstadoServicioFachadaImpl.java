package com.ketra.negocio.fachada.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.dto.EstadoServicioDTO;
import com.ketra.negocio.fachada.EstadoServicioFachada;
import com.ketra.negocio.fachada.assembler.impl.EstadoServicioDTOAssembler;
import com.ketra.negocio.negocio.impl.EstadoServicioNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRAFachadaException;

public class EstadoServicioFachadaImpl implements EstadoServicioFachada {

	@Override
	public EstadoServicioDTO consultarPorId(UUID id) {

		var daoFactory = DAOFactory.obtenerFactoria();

		var negocio = new EstadoServicioNegocioImpl(daoFactory);

		try {

			var dominio = negocio.consultarPorId(id);

			return EstadoServicioDTOAssembler.getInstance().convertirADTO(dominio);

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			throw KETRAFachadaException.crear(
					CatalogoMensajes.EstadoServicioFachadaImpl.ERROR_CONSULTANDO, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

	@Override
	public List<EstadoServicioDTO> consultarPorFiltro(EstadoServicioDTO filtro) {

		var daoFactory = DAOFactory.obtenerFactoria();

		var negocio = new EstadoServicioNegocioImpl(daoFactory);

		try {

			var dominio = EstadoServicioDTOAssembler.getInstance().convertirADominio(filtro);

			var datos = negocio.consultarPorFiltro(dominio);

			final List<EstadoServicioDTO> resultados = new ArrayList<>();

			for (EstadoServicioDominio dato : datos) {

				resultados.add(EstadoServicioDTOAssembler.getInstance().convertirADTO(dato));

			}

			return resultados;

		} catch (KETRAExcepcion excepcion) {

			throw excepcion;

		} catch (Exception excepcion) {

			throw KETRAFachadaException.crear(
					CatalogoMensajes.EstadoServicioFachadaImpl.ERROR_CONSULTANDO, excepcion.getMessage(), excepcion);

		} finally {

			daoFactory.cerrarConexion();

		}

	}

}
