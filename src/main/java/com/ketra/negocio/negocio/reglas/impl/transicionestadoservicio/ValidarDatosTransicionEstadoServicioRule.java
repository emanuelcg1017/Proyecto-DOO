package com.ketra.negocio.negocio.reglas.impl.transicionestadoservicio;

import java.util.UUID;

import com.ketra.dominio.TransicionEstadoServicioDominio;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRANegocioException;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.negocio.negocio.reglas.impl.estadoservicio.ValidarDatosEstadoServicioRule;
import com.ketra.transversal.utilitarios.UtilUUID;

public final class ValidarDatosTransicionEstadoServicioRule {

    private static final ValidarDatosTransicionEstadoServicioRule instancia = new ValidarDatosTransicionEstadoServicioRule();

    private ValidarDatosTransicionEstadoServicioRule() {

    }

    public static ValidarDatosTransicionEstadoServicioRule obtenerInstancia() {

        return instancia;

    }

    public void validarIdentificador(UUID id) {

        if (UtilUUID.UUID_DEFECTO.equals(UtilUUID.obtenerValorDefecto(id))) {

            throw KETRANegocioException.crear(CatalogoMensajes.FinalizacionServicio.TRANSICION_ID_INVALIDO);

        }

    }

    public void validarFiltro(TransicionEstadoServicioDominio filtro) {

        var datos = UtilObjeto.obtenerValorDefectoSiNulo(filtro, new TransicionEstadoServicioDominio.Builder().build());

        ValidarDatosEstadoServicioRule.obtenerInstancia().ejecutar(datos.getEstadoOrigen(), datos.getEstadoDestino());

    }

}
