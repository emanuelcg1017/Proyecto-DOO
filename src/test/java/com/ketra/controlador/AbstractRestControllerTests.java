package com.ketra.controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.excepciones.KETRANegocioException;

class AbstractRestControllerTests {

	private final AbstractRestController controlador = new AbstractRestController() {

	};

	@Test
	void errorDeNegocioDevuelve400ConElMensajeDeUsuario() {

		var mensaje = CatalogoMensajes.ServicioNegocioImpl.ESTADO_IGUAL;

		var respuesta = controlador.controlarKETRAExcepcion(KETRANegocioException.crear(mensaje));

		assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());

		assertEquals(List.of(mensaje), respuesta.getBody().getMensajes());

	}

	@Test
	void errorDeDatosSigueElManejoComunDeKETRAExcepcionSinExponerElDetalleTecnico() {

		var mensaje = CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR;

		var excepcion = KETRADatosException.crear(mensaje, "Detalle reservado de la conexión");

		var respuesta = controlador.controlarKETRAExcepcion(excepcion);

		assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());

		assertEquals(List.of(mensaje), respuesta.getBody().getMensajes());

	}

	@Test
	void recursoInexistenteDevuelve404ConLaRutaYElMetodoSolicitados() {

		var excepcion = new NoResourceFoundException(HttpMethod.GET, "/inexistente", "/inexistente");

		var recurso = controlador.controlarRecursoInexistente(excepcion);

		assertEquals(HttpStatus.NOT_FOUND, recurso.getStatusCode());

		assertEquals(List.of("El recurso solicitado no existe: /inexistente. Método HTTP: GET"), recurso.getBody().getMensajes());

	}

	@Test
	void errorInesperadoDevuelve500ConMensajeGeneralDelCatalogo() {

		var respuesta = controlador.controlarException(new IllegalStateException("Detalle reservado"));

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, respuesta.getStatusCode());

		assertEquals(List.of(CatalogoMensajes.AbstractRestController.USUARIO_ERROR_NO_CONTROLADO), respuesta.getBody().getMensajes());

	}

}
