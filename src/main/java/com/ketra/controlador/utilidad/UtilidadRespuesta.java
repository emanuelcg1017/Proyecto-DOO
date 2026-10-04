package com.ketra.controlador.utilidad;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Contrato de esta consulta REST, independiente de los DTO y del dominio existentes. */
public record UtilidadRespuesta(String numeroServicio, LocalDate fechaServicio,
        String estadoServicio, BigDecimal valorIngresos, BigDecimal valorCostos,
        BigDecimal valorUtilidad, List<Factura> facturas, List<Entrega> entregas,
        List<DetalleEntrega> detallesEntrega, List<CostoRecorrido> costosRecorrido) {
    public record Factura(String numeroFactura, LocalDate fechaFactura,
            BigDecimal ingresos, String estadoFactura) {}
    public record Entrega(String codigoEntrega, LocalDate fechaEntrega, String estadoEntrega) {}
    public record DetalleEntrega(String numeroDetalleEntrega, String codigoEntrega,
            String numeroPedido, BigDecimal distanciaKM) {}
    public record CostoRecorrido(String numeroCosto, String numeroDetalleEntrega,
            BigDecimal valorPorKM, BigDecimal distanciaKM, BigDecimal valorCosto) {}
}
