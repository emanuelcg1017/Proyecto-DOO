package com.ketra.negocio.negocio.reglas.impl.utilidad;

import java.util.UUID;

import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ValidarDatosGenerarUtilidadRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new ValidarDatosGenerarUtilidadRule();

	private ValidarDatosGenerarUtilidadRule() {
	}

	public static Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {

		final UUID idServicio = datos.length == 0 ? UtilUUID.UUID_DEFECTO : UtilUUID.obtenerValorDefecto(datos[0]);

		if (UtilUUID.UUID_DEFECTO.equals(idServicio)) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.ID_SERVICIO_REQUERIDO;
			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
	
}
