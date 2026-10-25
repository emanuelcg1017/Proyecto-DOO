package com.ketra.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
public class ConfiguracionAcceso {

	@Bean
	public SecurityFilterChain configurarAcceso(HttpSecurity http, ApplicationContext contexto) throws Exception {

		var permisos = new AuthorizeHttpRequestsConfigurer<HttpSecurity>(contexto);

		permisos.getRegistry()
				.requestMatchers("/login.html", "/css/**", "/js/**", "/favicon.ico",
						"/oauth2/**", "/login/**", "/error", "/api/v1/sesion/csrf").permitAll()
				.anyRequest().authenticated();

		http.with(permisos, Customizer.withDefaults());

		var ingreso = new OAuth2LoginConfigurer<HttpSecurity>();

		ingreso.loginPage("/login.html");
		ingreso.defaultSuccessUrl("/servicios.html", true);
		ingreso.failureUrl("/login.html?error");

		http.with(ingreso, Customizer.withDefaults());

		var errores = new ExceptionHandlingConfigurer<HttpSecurity>();

		errores.defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
				PathPatternRequestMatcher.withDefaults().matcher("/api/**"));

		errores.defaultAuthenticationEntryPointFor(new LoginUrlAuthenticationEntryPoint("/login.html"),
				AnyRequestMatcher.INSTANCE);

		http.with(errores, Customizer.withDefaults());

		var salida = new LogoutConfigurer<HttpSecurity>();

		salida.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.NO_CONTENT));
		salida.invalidateHttpSession(true);
		salida.deleteCookies("JSESSIONID");

		http.with(salida, Customizer.withDefaults());

		return http.build();

	}

	@Bean
	public OAuth2UserService<OidcUserRequest, OidcUser> usuarioGoogle(
			@Value("${ketra.seguridad.correos-permitidos}") String correosPermitidos) {

		return new ServicioUsuarioGoogle(correosPermitidos);

	}

}
