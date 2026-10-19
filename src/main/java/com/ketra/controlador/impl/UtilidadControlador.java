package com.ketra.controlador.impl;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketra.controlador.AbstractRestController;
import com.ketra.dto.UtilidadDTO;
import com.ketra.negocio.fachada.impl.UtilidadFachadaImpl;

@RestController
@RequestMapping("/api/v1/utilidades")
public class UtilidadControlador extends AbstractRestController{

	@GetMapping("/servicio/{idServicio}")
	public UtilidadDTO consultarUtilidad(@PathVariable UUID idServicio) {
		
		var fachada = new UtilidadFachadaImpl();
		
		return fachada.consultarUtilidadPorServicio(idServicio);
	}
}
