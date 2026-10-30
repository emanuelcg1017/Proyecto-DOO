package com.ketra.negocio.negocio.reglas.impl.utilidad;

import java.util.UUID;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;

public class AsegurarUtilidadNoGeneradaRule {


	private static final AsegurarUtilidadNoGeneradaRule instancia = new AsegurarUtilidadNoGeneradaRule();

	private AsegurarUtilidadNoGeneradaRule() {
	}

	public static AsegurarUtilidadNoGeneradaRule obtenerInstancia() {
		return instancia;
	}

    public void ejecutar(UUID idServicio, DAOFactory daoFactory) {

		var servicioEntidad = new ServicioEntidad.Builder().id(idServicio).build();
		var utilidadFiltro = new UtilidadEntidad.Builder().servicio(servicioEntidad).build();

		var resultados = daoFactory.obtenerUtilidadDAO().consultarPorFiltro(utilidadFiltro);

		if (!resultados.isEmpty()) {

			var mensajeUsuario = CatalogoMensajes.UtilidadNegocioImpl.UTILIDAD_YA_GENERADA;
			throw KETRANegocioException.crear(mensajeUsuario);
		}
	}
}
