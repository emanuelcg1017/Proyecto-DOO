package com.ketra.controlador.utilidad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilidadVistaControlador {
    @GetMapping("/utilidad")
    public String consultar() {
        return "utilidad/consultar-utilidad";
    }
}
