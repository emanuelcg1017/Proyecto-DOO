package com.ketra.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ketra.controlador.respuesta.RespuestaError;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.utilitarios.UtilLogger;
import com.ketra.transversal.utilitarios.UtilTexto;

@RestControllerAdvice
public abstract class AbstractRestController {

	private static final UtilLogger LOGGER = UtilLogger.obtenerLogger(AbstractRestController.class);

	@ExceptionHandler(KETRAExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarKETRAExcepcion(KETRAExcepcion excepcion) {

		LOGGER.printException(excepcion);

		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(Exception excepcion) {

		LOGGER.printException(excepcion);

		if (excepcion instanceof MethodArgumentTypeMismatchException || excepcion instanceof BindException) {

			var respuesta = RespuestaError.crear(CatalogoMensajes.FinalizacionServicio.ENTRADA_INVALIDA);

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);

		}

		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_ERROR_NO_CONTROLADO;

		var respuesta = RespuestaError.crear(mensajeRespuesta);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);

	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarRecursoInexistente(NoResourceFoundException excepcion) {

		LOGGER.printException(excepcion);

		var mensajeRespuesta = UtilTexto.getUtilTexto().concatenar(
				CatalogoMensajes.AbstractRestController.USUARIO_RECURSO_NO_ENCONTRADO,
				excepcion.getResourcePath(),
				CatalogoMensajes.AbstractRestController.USUARIO_METODO_RECURSO_NO_ENCONTRADO,
				String.valueOf(excepcion.getHttpMethod()));

		var respuesta = RespuestaError.crear(mensajeRespuesta);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);

	}

}
