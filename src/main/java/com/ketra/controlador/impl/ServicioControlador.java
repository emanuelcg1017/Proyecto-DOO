package com.ketra.controlador.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketra.controlador.AbstractRestController;
import com.ketra.controlador.respuesta.RespuestaOk;
import com.ketra.dto.EstadoServicioDTO;
import com.ketra.dto.ServicioDTO;
import com.ketra.dto.TransicionEstadoServicioDTO;
import com.ketra.negocio.fachada.impl.ServicioFachadaImpl;
import com.ketra.negocio.fachada.impl.EstadoServicioFachadaImpl;
import com.ketra.negocio.fachada.impl.TransicionEstadoServicioFachadaImpl;
import com.ketra.transversal.catalogo.CatalogoCodigosEstado;
import com.ketra.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/servicios")
public class ServicioControlador extends AbstractRestController {

    @GetMapping
    public ResponseEntity<RespuestaOk<ServicioDTO>> consultarPorFiltro(ServicioDTO filtro) {

        var fachada = new ServicioFachadaImpl();

        var servicios = fachada.consultarPorFiltro(filtro);

        RespuestaOk<ServicioDTO> respuesta = RespuestaOk.crear(servicios);

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaOk<ServicioDTO>> consultarPorId(@PathVariable UUID id) {

        var fachada = new ServicioFachadaImpl();

        var servicio = fachada.consultarPorId(id);

        RespuestaOk<ServicioDTO> respuesta = RespuestaOk.crear(servicio);

        return ResponseEntity.ok(respuesta);

    }

    @PutMapping("/{id}/finalizacion")
    public ResponseEntity<RespuestaOk<ServicioDTO>> finalizarServicio(@PathVariable UUID id) {

        var fachada = new ServicioFachadaImpl();

        var servicio = fachada.finalizarServicio(id);

        var mensaje = CatalogoMensajes.FinalizacionServicio.SERVICIO_FINALIZADO;

        RespuestaOk<ServicioDTO> respuesta = RespuestaOk.crear(List.of(mensaje), List.of(servicio));

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/estados")
    public ResponseEntity<RespuestaOk<EstadoServicioDTO>> consultarEstados() {

        var fachada = new EstadoServicioFachadaImpl();

        var estados = fachada.consultarPorFiltro(new EstadoServicioDTO());

        RespuestaOk<EstadoServicioDTO> respuesta = RespuestaOk.crear(estados);

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/estado-finalizado")
    public ResponseEntity<RespuestaOk<EstadoServicioDTO>> consultarEstadoFinalizado() {

        var filtro = new EstadoServicioDTO();

        filtro.setCodigo(CatalogoCodigosEstado.Servicio.FINALIZADO);

        var fachada = new EstadoServicioFachadaImpl();

        var estado = fachada.consultarPorFiltro(filtro);

        RespuestaOk<EstadoServicioDTO> respuesta = RespuestaOk.crear(estado);

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/transiciones-finalizacion")
    public ResponseEntity<RespuestaOk<TransicionEstadoServicioDTO>> consultarTransicionesFinalizacion() {

        var estadoDestino = new EstadoServicioDTO();

        estadoDestino.setCodigo(CatalogoCodigosEstado.Servicio.FINALIZADO);

        var filtro = new TransicionEstadoServicioDTO();

        filtro.setEstadoDestino(estadoDestino);

        var fachada = new TransicionEstadoServicioFachadaImpl();

        var transiciones = fachada.consultarPorFiltro(filtro);

        RespuestaOk<TransicionEstadoServicioDTO> respuesta = RespuestaOk.crear(transiciones);

        return ResponseEntity.ok(respuesta);

    }

}
