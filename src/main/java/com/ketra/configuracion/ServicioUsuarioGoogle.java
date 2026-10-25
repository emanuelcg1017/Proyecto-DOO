package com.ketra.configuracion;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.utilitarios.UtilTexto;

public class ServicioUsuarioGoogle implements OAuth2UserService<OidcUserRequest, OidcUser> {

	private final OidcUserService servicioGoogle = new OidcUserService();

	private final String[] correosPermitidos;

	public ServicioUsuarioGoogle(String correos) {

		correosPermitidos = UtilTexto.getUtilTexto().obtenerValorDefecto(correos).split(",");

	}

	@Override
	public OidcUser loadUser(OidcUserRequest solicitud) throws OAuth2AuthenticationException {

		var usuario = servicioGoogle.loadUser(solicitud);

		if (Boolean.TRUE.equals(usuario.getEmailVerified())) {

			for (String correo : correosPermitidos) {

				if (correo.trim().equalsIgnoreCase(usuario.getEmail())) {

					return usuario;

				}

			}

		}

		throw new OAuth2AuthenticationException(new OAuth2Error("cuenta_no_autorizada"),
				CatalogoMensajes.Seguridad.CUENTA_NO_AUTORIZADA);

	}

}
