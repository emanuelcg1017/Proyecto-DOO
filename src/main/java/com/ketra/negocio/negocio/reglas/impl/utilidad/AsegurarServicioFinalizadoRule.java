package com.ketra.negocio.negocio.reglas.impl.utilidad;

import com.ketra.dominio.ServicioDominio;
import com.ketra.transversal.catalogo.CatalogoCodigosEstado;
import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarServicioFinalizadoRule implements Rule<ServicioDominio>{


	private static final Rule<ServicioDominio> instancia = new AsegurarServicioFinalizadoRule();

	private AsegurarServicioFinalizadoRule() {
	}

	public static Rule<ServicioDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(ServicioDominio... datos) {

		var servicio = datos[0];
		

		if (!CatalogoCodigosEstado.Servicio.FINALIZADO.equals(servicio.getEstado().getCodigo())) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.SERVICIO_DEBE_ESTAR_FINALIZADO;
			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
}
