package com.ketra.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.ketra.controlador.respuesta.RespuestaError;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;

@RestControllerAdvice
public abstract class AbstractRestController {

	@ExceptionHandler(KETRAExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarKETRAExcepcion(KETRAExcepcion excepcion) {

		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(Exception excepcion) {

		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_ERROR_NO_CONTROLADO;

		var respuesta = RespuestaError.crear(mensajeRespuesta);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);

	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarRecursoInexistente(NoResourceFoundException excepcion) {

		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_RECURSO_NO_ENCONTRADO
				+ excepcion.getResourcePath()
				+ CatalogoMensajes.AbstractRestController.USUARIO_METODO_RECURSO_NO_ENCONTRADO
				+ excepcion.getHttpMethod();

		var respuesta = RespuestaError.crear(mensajeRespuesta);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);

	}

}
