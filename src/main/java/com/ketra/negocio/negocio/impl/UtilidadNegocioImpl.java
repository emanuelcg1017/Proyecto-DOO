package com.ketra.negocio.negocio.impl;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.UtilidadDominio;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.negocio.negocio.UtilidadNegocio;
import com.ketra.negocio.negocio.assembler.impl.UtilidadEntidadAssembler;
import com.ketra.negocio.negocio.reglas.impl.utilidad.AsegurarServicioFinalizadoRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.AsegurarUtilidadNoGeneradaRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.ConsiderarCostoDeEntregaRealizadaRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.ConsiderarFacturaEnIngresosRule;
import com.ketra.negocio.negocio.reglas.impl.utilidad.ValidarDatosGenerarUtilidadRule;
import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadNegocioImpl implements UtilidadNegocio {

    private final DAOFactory daoFactory;

    public UtilidadNegocioImpl(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    @Override
    public UtilidadDominio generarUtilidad(UUID idServicio) {

        ValidarDatosGenerarUtilidadRule.obtenerInstancia().ejecutar(idServicio);

        var servicio = new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

        AsegurarServicioFinalizadoRule.obtenerInstancia().ejecutar(servicio);

        AsegurarUtilidadNoGeneradaRule.obtenerInstancia().ejecutar(idServicio, daoFactory);

        var ingresos = calcularValorIngresos(idServicio);

        var costos = calcularValorCostos(idServicio);

        var resultado = UtilNumero.restar(ingresos, costos);

        var idUtilidad = UtilUUID.generar();

        var utilidad = new UtilidadDominio.Builder()
                .id(idUtilidad)
                .servicio(servicio)
                .valorIngresos(ingresos)
                .valorCostos(costos)
                .valorUtilidad(resultado)
                .build();

        daoFactory.obtenerUtilidadDAO().crear(UtilidadEntidadAssembler.getInstance().convertirAEntidad(utilidad));

        return utilidad;

    }

    @Override
    public Double calcularValorIngresos(UUID idServicio) {

        ValidarDatosGenerarUtilidadRule.obtenerInstancia().ejecutar(idServicio);

        var servicio = new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

        AsegurarServicioFinalizadoRule.obtenerInstancia().ejecutar(servicio);

        var facturas = new FacturaNegocioImpl(daoFactory).consultarPorServicio(idServicio);

        Double total = UtilNumero.CERO_DECIMAL;

        for (var factura : facturas) {

            if (ConsiderarFacturaEnIngresosRule.obtenerInstancia().cumple(factura)) {

                total = UtilNumero.sumar(total, factura.getIngresos());

            }

        }

        return total;

    }

    @Override
    public Double calcularValorCostos(UUID idServicio) {

        ValidarDatosGenerarUtilidadRule.obtenerInstancia().ejecutar(idServicio);

        var servicio = new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

        AsegurarServicioFinalizadoRule.obtenerInstancia().ejecutar(servicio);

        var entregas = new EntregaNegocioImpl(daoFactory).consultarPorServicio(idServicio);

        var detalles = new DetalleEntregaNegocioImpl(daoFactory).consultarDetallesEntrega(entregas);

        var costos = new CostoRecorridoNegocioImpl(daoFactory).consultarCostosRecorrido(detalles);

        Double total = UtilNumero.CERO_DECIMAL;

        for (var costo : costos) {

            if (ConsiderarCostoDeEntregaRealizadaRule.obtenerInstancia().cumple(costo)) {

                total = UtilNumero.sumar(total, costo.getValorCosto());

            }

        }

        return total;

    }

    @Override
    public UtilidadDominio consultarUtilidadPorServicio(UUID idServicio) {

        ValidarDatosGenerarUtilidadRule.obtenerInstancia().ejecutar(idServicio);

        new ServicioNegocioImpl(daoFactory).consultarPorId(idServicio);

        var servicio = new ServicioEntidad.Builder().id(idServicio).build();

        var filtro = new UtilidadEntidad.Builder().servicio(servicio).build();

        var resultados = daoFactory.obtenerUtilidadDAO().consultarPorFiltro(filtro);

        return resultados.isEmpty() ? new UtilidadDominio.Builder().build() : UtilidadEntidadAssembler.getInstance().convertirADominio(resultados.get(0));

    }

}
