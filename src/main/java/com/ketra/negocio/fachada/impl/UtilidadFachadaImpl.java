package com.ketra.negocio.fachada.impl;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dto.UtilidadDTO;
import com.ketra.negocio.fachada.UtilidadFachada;
import com.ketra.negocio.fachada.assembler.impl.CostoRecorridoDTOAssembler;
import com.ketra.negocio.fachada.assembler.impl.DetalleEntregaDTOAssembler;
import com.ketra.negocio.fachada.assembler.impl.EntregaDTOAssembler;
import com.ketra.negocio.fachada.assembler.impl.FacturaDTOAssembler;
import com.ketra.negocio.fachada.assembler.impl.UtilidadDTOAssembler;
import com.ketra.negocio.negocio.impl.CostoRecorridoNegocioImpl;
import com.ketra.negocio.negocio.impl.DetalleEntregaNegocioImpl;
import com.ketra.negocio.negocio.impl.EntregaNegocioImpl;
import com.ketra.negocio.negocio.impl.FacturaNegocioImpl;
import com.ketra.negocio.negocio.impl.UtilidadNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRAFachadaException;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadFachadaImpl implements UtilidadFachada {

	@Override
	public UtilidadDTO consultarUtilidadPorServicio(UUID idServicio) {

		var daoFactory = DAOFactory.obtenerFactoria();

		var utilidadNegocio = new UtilidadNegocioImpl(daoFactory);

		try {

			var utilidadDominio = utilidadNegocio.consultarUtilidadPorServicio(idServicio);

			var utilidad = UtilidadDTOAssembler.getInstance().convertirADTO(utilidadDominio);

			if (UtilUUID.UUID_DEFECTO.equals(utilidad.getId())) {

				return utilidad;

			}

			var facturas = new FacturaNegocioImpl(daoFactory).consultarPorServicio(idServicio);

			var entregas = new EntregaNegocioImpl(daoFactory).consultarPorServicio(idServicio);

			var detalles = new DetalleEntregaNegocioImpl(daoFactory).consultarDetallesEntrega(entregas);

			var costos = new CostoRecorridoNegocioImpl(daoFactory).consultarCostosRecorrido(detalles);

			utilidad.setFacturas(FacturaDTOAssembler.getInstance().convertirADTO(facturas));

			utilidad.setEntregas(EntregaDTOAssembler.getInstance().convertirADTO(entregas));

			utilidad.setDetallesEntrega(DetalleEntregaDTOAssembler.getInstance().convertirADTO(detalles));

			utilidad.setCostosRecorrido(CostoRecorridoDTOAssembler.getInstance().convertirADTO(costos));

			return utilidad;

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
