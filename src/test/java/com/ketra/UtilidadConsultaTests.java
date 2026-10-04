package com.ketra;

import static org.junit.jupiter.api.Assertions.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.ketra.controlador.utilidad.simulado.UtilidadSimulada;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UtilidadConsultaTests {
    @Value("${local.server.port}")
    private int port;
    @Autowired
    private UtilidadSimulada datos;

    private HttpResponse<String> get(String path) throws Exception {
        return HttpClient.newHttpClient().send(
            HttpRequest.newBuilder(URI.create("http://localhost:" + port + path)).GET().build(),
            HttpResponse.BodyHandlers.ofString());
    }

    @Test
    void consultaPublicaJsonYRechazaServiciosDesconocidos() throws Exception {
        var respuesta = get("/api/utilidades/SRV-001");
        assertEquals(200, respuesta.statusCode());
        assertTrue(respuesta.headers().firstValue("content-type").orElse("").contains("application/json"));
        assertTrue(respuesta.body().contains("\"numeroServicio\":\"SRV-001\""));
        assertTrue(respuesta.body().contains("\"valorUtilidad\":1284900"));
        assertTrue(respuesta.body().contains("2026-08-01"));
        assertTrue(respuesta.body().contains("COS-0003"));
        assertEquals(404, get("/api/utilidades/SRV-999").statusCode());
    }

    @Test
    void valoresRegistradosConcuerdanConFacturasYCostos() {
        var utilidad = datos.consultar("SRV-001").orElseThrow();
        var ingresos = utilidad.facturas().stream().map(f -> f.ingresos())
            .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
        var costos = utilidad.costosRecorrido().stream().map(c -> c.valorCosto())
            .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
        assertEquals(0, ingresos.compareTo(utilidad.valorIngresos()));
        assertEquals(0, costos.compareTo(utilidad.valorCostos()));
        assertEquals(0, ingresos.subtract(costos).compareTo(utilidad.valorUtilidad()));
        utilidad.costosRecorrido().forEach(c -> assertEquals(0,
            c.valorPorKM().multiply(c.distanciaKM()).compareTo(c.valorCosto())));
    }

    @Test
    void vistaYRecursosDisponibles() throws Exception {
        var vista = get("/utilidad");
        assertEquals(200, vista.statusCode());
        assertTrue(vista.body().contains("Consultar utilidad por servicio"));
        assertFalse(vista.body().contains("Generar Utilidad"));
        assertFalse(vista.body().contains("Trazabilidad"));
        assertFalse(vista.body().contains("FAC-001"));
        assertEquals(200, get("/css/consultar-utilidad.css").statusCode());
        assertEquals(200, get("/js/consultar-utilidad.js").statusCode());
    }
}
