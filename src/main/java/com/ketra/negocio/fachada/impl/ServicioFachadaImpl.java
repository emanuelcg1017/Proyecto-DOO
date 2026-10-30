package com.ketra.negocio.fachada.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.dto.ServicioDTO;
import com.ketra.negocio.fachada.ServicioFachada;
import com.ketra.negocio.fachada.assembler.impl.ServicioDTOAssembler;
import com.ketra.negocio.negocio.impl.ServicioNegocioImpl;
import com.ketra.negocio.negocio.impl.UtilidadNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRAFachadaException;

public class ServicioFachadaImpl implements ServicioFachada {

    @Override
    public ServicioDTO consultarPorId(UUID id) {

        var daoFactory = DAOFactory.obtenerFactoria();

        var servicioNegocio = new ServicioNegocioImpl(daoFactory);

        try {

            var datos = servicioNegocio.consultarPorId(id);

            return ServicioDTOAssembler.getInstance().convertirADTO(datos);

        } catch (KETRAExcepcion excepcion) {

            throw excepcion;

        } catch (Exception excepcion) {

            throw KETRAFachadaException.crear(
                    CatalogoMensajes.ServicioFachadaImpl.ERROR_CONSULTANDO, excepcion.getMessage(), excepcion);

        } finally {

            daoFactory.cerrarConexion();

        }

    }

    @Override
    public List<ServicioDTO> consultarPorFiltro(ServicioDTO filtro) {

        var daoFactory = DAOFactory.obtenerFactoria();

        var servicioNegocio = new ServicioNegocioImpl(daoFactory);

        try {

            var filtroDominio = ServicioDTOAssembler.getInstance().convertirADominio(filtro);

            var datos = servicioNegocio.consultarPorFiltro(filtroDominio);

            final List<ServicioDTO> resultados = new ArrayList<>();

            for (ServicioDominio dato : datos) {

                resultados.add(ServicioDTOAssembler.getInstance().convertirADTO(dato));

            }

            return resultados;

        } catch (KETRAExcepcion excepcion) {

            throw excepcion;

        } catch (Exception excepcion) {

            throw KETRAFachadaException.crear(
                    CatalogoMensajes.ServicioFachadaImpl.ERROR_CONSULTANDO, excepcion.getMessage(), excepcion);

        } finally {

            daoFactory.cerrarConexion();

        }

    }

    @Override
    public ServicioDTO finalizarServicio(UUID idServicio) {

        var daoFactory = DAOFactory.obtenerFactoria();

        var servicioNegocio = new ServicioNegocioImpl(daoFactory);

        var utilidadNegocio = new UtilidadNegocioImpl(daoFactory);

        boolean transaccionIniciada = false;

        try {

            daoFactory.iniciarTransaccion();

            transaccionIniciada = true;

            var servicio = servicioNegocio.finalizarServicio(idServicio);

            utilidadNegocio.generarUtilidad(idServicio);

            var respuesta = ServicioDTOAssembler.getInstance().convertirADTO(servicio);

            daoFactory.confirmarTransaccion();

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

            throw KETRAFachadaException.crear(
                    CatalogoMensajes.FinalizacionServicio.ERROR_FINALIZANDO, excepcion.getMessage(), excepcion);

        } finally {

            daoFactory.cerrarConexion();

        }

    }

}
