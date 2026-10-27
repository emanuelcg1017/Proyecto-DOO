package com.ketra.controlador.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketra.controlador.AbstractRestController;
import com.ketra.controlador.respuesta.RespuestaOk;
import com.ketra.dto.ServicioDTO;
import com.ketra.negocio.fachada.impl.ServicioFachadaImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/servicios")
public class ServicioControlador extends AbstractRestController {


	@GetMapping
	public ResponseEntity<RespuestaOk<ServicioDTO>> consultarPorFiltro(ServicioDTO filtro) {
		
		var fachada = new ServicioFachadaImpl();
		
		var servicio = fachada.consultarPorFiltro(filtro);
		RespuestaOk<ServicioDTO> respuesta = RespuestaOk.crear(servicio);
		
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<ServicioDTO>> consultarPorId(@PathVariable UUID id) {
		
		var fachada = new ServicioFachadaImpl();
		var servicio = fachada.consultarPorId(id);

		RespuestaOk<ServicioDTO> respuesta = RespuestaOk.crear(servicio);

		return ResponseEntity.ok(respuesta);
	}
	

	
	@PutMapping("/{id}")
	public ResponseEntity<RespuestaOk<ServicioDTO>> actualizarEstado(@PathVariable UUID id, @RequestBody ServicioDTO estado) {
		
		var fachada = new ServicioFachadaImpl();
		var servicio = fachada.actualizarEstado(id, estado);
		
        var mensaje = CatalogoMensajes.ServicioControlador.ESTADO_ACTUALIZADO;

		RespuestaOk<ServicioDTO> respuesta = RespuestaOk.crear(List.of(mensaje), List.of(servicio));
		
		
		return ResponseEntity.ok(respuesta);
	}

}
