package com.ketra.negocio.negocio.reglas.impl.servicio;

import java.util.List;

import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;

public final class AsegurarTransicionEstadoServicioPermitidaRule {

    private static final AsegurarTransicionEstadoServicioPermitidaRule instancia = new AsegurarTransicionEstadoServicioPermitidaRule();

    private AsegurarTransicionEstadoServicioPermitidaRule() {

    }

    public static AsegurarTransicionEstadoServicioPermitidaRule obtenerInstancia() {

        return instancia;

    }

    public void ejecutar(List<TransicionEstadoServicioDominio> coincidencias) {

        if (UtilObjeto.esNulo(coincidencias) || coincidencias.isEmpty()) {

            throw KETRANegocioException.crear(CatalogoMensajes.FinalizacionServicio.TRANSICION_NO_PERMITIDA);

        }

    }

}
