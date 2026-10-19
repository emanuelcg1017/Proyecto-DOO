package com.ketra.negocio.negocio.reglas.impl.servicio;

import java.util.List;

import com.ketra.negocio.negocio.reglas.Rule;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

// P-SER-0004.
public class AsegurarEstadoServicioValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarEstadoServicioValidoRule();

	private static final List<String> estados = List.of("Registrado", "En ejecución", "Finalizado", "Cancelado");

	private AsegurarEstadoServicioValidoRule() {

	}

	public static Rule<String> obtenerInstancia() {

		return instancia;

	}

	@Override
	public void ejecutar(String... datos) {

		if (datos == null || datos.length == 0 || datos[0] == null || !estados.contains(datos[0])) {

			throw KETRANegocioException.crear(CatalogoMensajes.ServicioNegocioImpl.ESTADO_INVALIDO);

		}

	}

}
