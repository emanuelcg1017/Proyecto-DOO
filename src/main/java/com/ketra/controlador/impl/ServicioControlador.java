package com.ketra.controlador.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ketra.controlador.AbstractRestController;
import com.ketra.dto.ServicioDTO;
import com.ketra.negocio.fachada.impl.ServicioFachadaImpl;

@RestController
@RequestMapping("/api/v1/servicios")
public class ServicioControlador extends AbstractRestController {

	@GetMapping
	public List<ServicioDTO> consultarTodos() {
		
		var fachada = new ServicioFachadaImpl();
		
		return fachada.consultarTodos();
	}
	
	@GetMapping("/{id}")
	public ServicioDTO consultarPorId(@PathVariable UUID id) {
		
		var fachada = new ServicioFachadaImpl();
		
		return fachada.consultarPorId(id);
	}
	
	@GetMapping("/filtro")
	public List<ServicioDTO> consultarPorFiltro(
			@RequestParam(required = false) String numeroServicio,
	        @RequestParam(required = false) String estado) {
		
	    var filtro = new ServicioDTO.Builder()
	            .numeroServicio(numeroServicio)
	            .estado(estado)
	            .build();
	    
		var fachada = new ServicioFachadaImpl();
		
		return fachada.consultarPorFiltro(filtro);
	}
	
	@PutMapping("/{id}")
	public ServicioDTO actualizarEstado(@PathVariable UUID id, @RequestBody ServicioDTO estado) {
		
		var fachada = new ServicioFachadaImpl();
		
		return fachada.actualizarEstado(id, estado);
	}

}
