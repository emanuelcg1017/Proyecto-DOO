package com.ketra.controlador.utilidad.simulado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.ketra.controlador.utilidad.UtilidadRespuesta;
import com.ketra.controlador.utilidad.UtilidadRespuesta.*;

/** Fuente temporal. Sustituir por una consulta a negocio cuando esa capa esté disponible. */
@Component
public class UtilidadSimulada {
    private final UtilidadRespuesta utilidad = new UtilidadRespuesta(
        "SRV-001", LocalDate.of(2026, 8, 1), "Finalizado",
        new BigDecimal("1425000"), new BigDecimal("140100"), new BigDecimal("1284900"),
        List.of(
            new Factura("FAC-001", LocalDate.of(2026, 8, 15), new BigDecimal("950000"), "Pagada"),
            new Factura("FAC-002", LocalDate.of(2026, 8, 15), new BigDecimal("475000"), "Pagada")),
        List.of(
            new Entrega("ENT-001", LocalDate.of(2026, 8, 10), "Entregada"),
            new Entrega("ENT-002", LocalDate.of(2026, 8, 11), "Entregada")),
        List.of(
            new DetalleEntrega("DET-001", "ENT-001", "PED-000001", new BigDecimal("28.4")),
            new DetalleEntrega("DET-002", "ENT-001", "PED-000001", new BigDecimal("9.6")),
            new DetalleEntrega("DET-003", "ENT-002", "PED-000001", new BigDecimal("8.7"))),
        List.of(
            new CostoRecorrido("COS-0001", "DET-001", new BigDecimal("3000"), new BigDecimal("28.4"), new BigDecimal("85200")),
            new CostoRecorrido("COS-0002", "DET-002", new BigDecimal("3000"), new BigDecimal("9.6"), new BigDecimal("28800")),
            new CostoRecorrido("COS-0003", "DET-003", new BigDecimal("3000"), new BigDecimal("8.7"), new BigDecimal("26100"))));

    public Optional<UtilidadRespuesta> consultar(String numeroServicio) {
        return utilidad.numeroServicio().equals(numeroServicio) ? Optional.of(utilidad) : Optional.empty();
    }
}
