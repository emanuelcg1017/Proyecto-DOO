package com.ketra.negocio.negocio.reglas.impl.servicio;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.dominio.ServicioDominio;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ValidarDatosServicioRule implements Rule<ServicioDominio> {

	private static final ValidarDatosServicioRule instancia = new ValidarDatosServicioRule();

	private ValidarDatosServicioRule() {

	}

	public static ValidarDatosServicioRule obtenerInstancia() {

		return instancia;

	}

	public void ejecutar(UUID id) {

		if (UtilUUID.UUID_DEFECTO.equals(UtilUUID.obtenerValorDefecto(id))) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ID_REQUERIDO);

		}

	}

	@Override
	public void ejecutar(ServicioDominio... datos) {

		if (UtilObjeto.esNulo(datos) || datos.length == 0) {

			return;

		}

		var filtro = UtilObjeto.obtenerValorDefectoSiNulo(datos[0], new ServicioDominio.Builder().build());

		validarNumeroServicio(filtro.getNumeroServicio());

		validarFechaServicio(filtro.getFechaServicio());

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstado())) {

			AsegurarEstadoServicioValidoRule.obtenerInstancia().ejecutar(filtro.getEstado());

		}

	}

	public void ejecutar(UUID id, ServicioDominio servicio) {

		ejecutar(id);

		if (UtilObjeto.esNulo(servicio)) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.DATOS_ESTADO_INVALIDOS);

		}

		validarEstadoObligatorio(servicio.getEstado());

		validarIdentificadorSolicitud(id, servicio.getId());

		AsegurarEstadoServicioValidoRule.obtenerInstancia().ejecutar(servicio.getEstado());

	}

	private void validarNumeroServicio(String numeroServicio) {

		if (!UtilTexto.getUtilTexto().longitudCadenaEsValida(numeroServicio, 0, 30, true)) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.FILTRO_INVALIDO);

		}

	}

	private void validarFechaServicio(LocalDate fechaServicio) {

		if (UtilFecha.FECHA_DEFECTO.equals(fechaServicio)) {

			return;

		}

		if (fechaServicio.getYear() < 1 || fechaServicio.getYear() > 9999) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.FECHA_FILTRO_INVALIDA);

		}

	}

	private void validarIdentificadorSolicitud(UUID id, UUID idSolicitud) {

		if (!UtilUUID.UUID_DEFECTO.equals(idSolicitud) && !id.equals(idSolicitud)) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ID_NO_COINCIDE);

		}

	}

	private void validarEstadoObligatorio(String estado) {

		if (estado.isBlank() || !UtilTexto.getUtilTexto().longitudCadenaEsValida(estado, 1, 15, true)) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.DATOS_ESTADO_INVALIDOS);

		}

	}

}
