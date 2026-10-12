package com.ketra.negocio.negocio.reglas.impl.utilidad;

import com.ketra.dominio.ServicioDominio;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class AsegurarServicioExisteRule implements Rule<ServicioDominio> {


	private static final Rule<ServicioDominio> instancia = new AsegurarServicioExisteRule();

	private AsegurarServicioExisteRule() {
	}

	public static Rule<ServicioDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(ServicioDominio... datos) {

		var servicio = UtilObjeto.obtenerValorDefectoSiNulo(datos[0], new ServicioDominio.Builder().build());

		if (UtilUUID.UUID_DEFECTO.equals(UtilUUID.obtenerValorDefecto(servicio.getId()))) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.SERVICIO_NO_EXISTE;
			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
	
}
