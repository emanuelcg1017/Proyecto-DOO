package com.ketra.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import com.ketra.transversal.utilitarios.UtilTexto;

@Configuration
public class ConfiguracionAcceso {

	private static final String RUTA_LOGIN = "/login.html";

	@Bean
	public SecurityFilterChain configurarAcceso(HttpSecurity http) {

		http.authorizeHttpRequests(permisos -> {

			permisos.requestMatchers(RUTA_LOGIN, "/css/**", "/js/**", "/favicon.ico",
						"/oauth2/**", "/login/**", "/error", "/api/v1/sesion/csrf").permitAll()
					.anyRequest().authenticated();

		});

		http.oauth2Login(ingreso -> {

			ingreso.loginPage(RUTA_LOGIN);
			ingreso.defaultSuccessUrl("/servicios.html", true);
			ingreso.failureUrl(UtilTexto.getUtilTexto().concatenar(RUTA_LOGIN, "?error"));

		});

		http.exceptionHandling(errores -> {

			errores.defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
					PathPatternRequestMatcher.withDefaults().matcher("/api/**"));

			errores.defaultAuthenticationEntryPointFor(new LoginUrlAuthenticationEntryPoint(RUTA_LOGIN),
					AnyRequestMatcher.INSTANCE);

		});

		http.logout(salida -> {

			salida.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.NO_CONTENT));
			salida.invalidateHttpSession(true);
			salida.deleteCookies("JSESSIONID");

		});

		return http.build();

	}

	@Bean
	public OAuth2UserService<OidcUserRequest, OidcUser> usuarioGoogle(
			@Value("${ketra.seguridad.correos-permitidos}") String correosPermitidos) {

		return new ServicioUsuarioGoogle(correosPermitidos);

	}

}
