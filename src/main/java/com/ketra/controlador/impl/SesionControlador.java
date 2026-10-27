package com.ketra.controlador.impl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketra.controlador.AbstractRestController;
import com.ketra.controlador.respuesta.RespuestaOk;
import com.ketra.dto.SesionDTO;
import com.ketra.transversal.utilitarios.UtilTexto;

@RestController
@RequestMapping("/api/v1/sesion")
public class SesionControlador extends AbstractRestController {

    @GetMapping
    public ResponseEntity<RespuestaOk<SesionDTO>> consultarSesion(@AuthenticationPrincipal OidcUser usuario) {

        var sesion = new SesionDTO();

        sesion.setNombre(UtilTexto.getUtilTexto().obtenerValorDefecto(usuario.getFullName(), usuario.getEmail()));

        sesion.setCorreo(usuario.getEmail());

        RespuestaOk<SesionDTO> respuesta = RespuestaOk.crear(sesion);

        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/csrf")
    public ResponseEntity<RespuestaOk<Map<String, String>>> consultarTokenCsrf(CsrfToken token) {

        var datos = Map.of("headerName", token.getHeaderName(), "token", token.getToken());

        RespuestaOk<Map<String, String>> respuesta = RespuestaOk.crear(datos);

        return ResponseEntity.ok(respuesta);

    }

}
