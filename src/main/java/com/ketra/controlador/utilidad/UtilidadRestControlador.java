package com.ketra.controlador.utilidad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.ketra.controlador.utilidad.simulado.UtilidadSimulada;

@RestController
@RequestMapping("/api/utilidades")
public class UtilidadRestControlador {
    private final UtilidadSimulada datos;

    public UtilidadRestControlador(UtilidadSimulada datos) {
        this.datos = datos;
    }

    @GetMapping("/{numeroServicio}")
    public UtilidadRespuesta consultar(@PathVariable String numeroServicio) {
        return datos.consultar(numeroServicio).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la utilidad del servicio"));
    }
}
