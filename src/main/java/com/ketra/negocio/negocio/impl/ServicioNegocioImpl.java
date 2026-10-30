package com.ketra.negocio.negocio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.transversal.catalogo.CatalogoCodigosEstado;
import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.EstadoServicioDominio;
import com.ketra.dominio.ServicioDominio;
import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.negocio.negocio.EstadoServicioNegocio;
import com.ketra.negocio.negocio.ServicioNegocio;
import com.ketra.negocio.negocio.assembler.impl.ServicioEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.servicio.AsegurarEntregaEstaEntregadaRule;
import com.ketra.negocio.negocio.reglas.impl.servicio.AsegurarEstadoServicioDiferenteRule;
import com.ketra.negocio.negocio.reglas.impl.servicio.AsegurarEstadoServicioExisteRule;
import com.ketra.negocio.negocio.reglas.impl.servicio.AsegurarTransicionEstadoServicioPermitidaRule;
import com.ketra.negocio.negocio.reglas.impl.servicio.ValidarDatosServicioRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.AsegurarServicioExisteRule;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioNegocioImpl implements ServicioNegocio {

    private final DAOFactory daoFactory;

    private final EstadoServicioNegocio estadoServicioNegocio;

    public ServicioNegocioImpl(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

        estadoServicioNegocio = new EstadoServicioNegocioImpl(daoFactory);

    }

    @Override
    public ServicioDominio consultarPorId(UUID id) {

        ValidarDatosServicioRule.obtenerInstancia().ejecutar(id);

        var entidad = daoFactory.obtenerServicioDAO().consultarPorId(id);

        var dominio = ServicioEntidadAssembler.getInstance().convertirADominio(entidad);

        AsegurarServicioExisteRule.obtenerInstancia().ejecutar(dominio);

        return dominio;

    }

    @Override
    public List<ServicioDominio> consultarPorFiltro(ServicioDominio filtro) {

        var datos = UtilObjeto.obtenerValorDefectoSiNulo(filtro, new ServicioDominio.Builder().build());

        ValidarDatosServicioRule.obtenerInstancia().ejecutar(datos);

        if (!UtilUUID.UUID_DEFECTO.equals(datos.getEstado().getId()) || !UtilTexto.getUtilTexto().esVacia(datos.getEstado().getNombre())
                || !UtilTexto.getUtilTexto().esVacia(datos.getEstado().getCodigo())) {

            var estados = estadoServicioNegocio.consultarPorFiltro(datos.getEstado());

            var encontrado = estados.isEmpty() ? new EstadoServicioDominio.Builder().build() : estados.get(0);

            AsegurarEstadoServicioExisteRule.obtenerInstancia().ejecutar(encontrado);

        }

        var entidad = ServicioEntidadAssembler.getInstance().convertirAEntidad(datos);

        var entidades = daoFactory.obtenerServicioDAO().consultarPorFiltro(entidad);

        final List<ServicioDominio> resultados = new ArrayList<>();

        for (ServicioEntidad servicio : entidades) {

            resultados.add(ServicioEntidadAssembler.getInstance().convertirADominio(servicio));

        }

        return resultados;

    }

    @Override
    public ServicioDominio finalizarServicio(UUID idServicio) {

        var actual = consultarPorId(idServicio);

        var filtroEstado = new EstadoServicioDominio.Builder()
                .codigo(CatalogoCodigosEstado.Servicio.FINALIZADO)
                .build();

        var estados = estadoServicioNegocio.consultarPorFiltro(filtroEstado);

        var finalizado = estados.isEmpty() ? new EstadoServicioDominio.Builder().build() : estados.get(0);

        AsegurarEstadoServicioExisteRule.obtenerInstancia().ejecutar(actual.getEstado(), finalizado);

        AsegurarEstadoServicioDiferenteRule.obtenerInstancia().ejecutar(actual.getEstado(), finalizado);

        var filtroTransicion = new TransicionEstadoServicioDominio.Builder()
                .estadoOrigen(actual.getEstado())
                .estadoDestino(finalizado)
                .build();

        var transiciones = new TransicionEstadoServicioNegocioImpl(daoFactory).consultarPorFiltro(filtroTransicion);

        AsegurarTransicionEstadoServicioPermitidaRule.obtenerInstancia().ejecutar(transiciones);

        var entregas = new EntregaNegocioImpl(daoFactory).consultarPorServicio(idServicio);

        for (var entrega : entregas) {

            AsegurarEntregaEstaEntregadaRule.obtenerInstancia().ejecutar(entrega);

        }

        var actualizado = new ServicioDominio.Builder()
                .id(actual.getId())
                .numeroServicio(actual.getNumeroServicio())
                .fechaServicio(actual.getFechaServicio())
                .estado(finalizado)
                .build();

        daoFactory.obtenerServicioDAO().actualizar(idServicio, ServicioEntidadAssembler.getInstance().convertirAEntidad(actualizado));

        return actualizado;

    }

}
