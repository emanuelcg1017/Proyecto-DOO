package com.ketra.controlador.impl;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketra.controlador.AbstractRestController;
import com.ketra.dto.SesionDTO;
import com.ketra.transversal.utilitarios.UtilTexto;

@RestController
@RequestMapping("/api/v1/sesion")
public class SesionControlador extends AbstractRestController {

	@GetMapping
	public SesionDTO consultarSesion(@AuthenticationPrincipal OidcUser usuario) {

		return new SesionDTO.Builder()
				.nombre(UtilTexto.getUtilTexto().obtenerValorDefecto(usuario.getFullName(), usuario.getEmail()))
				.correo(usuario.getEmail())
				.build();

	}

	@GetMapping("/csrf")
	public Map<String, String> consultarTokenCsrf(CsrfToken token) {

		return Map.of("headerName", token.getHeaderName(), "token", token.getToken());

	}

}
