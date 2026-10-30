package com.ketra.negocio.negocio.reglas.impl.utilidad;

import com.ketra.dominio.CostoRecorridoDominio;
import com.ketra.transversal.catalogo.CatalogoCodigosEstado;

public final class ConsiderarCostoDeEntregaRealizadaRule {

    private static final ConsiderarCostoDeEntregaRealizadaRule instancia = new ConsiderarCostoDeEntregaRealizadaRule();

    private ConsiderarCostoDeEntregaRealizadaRule() {

    }

    public static ConsiderarCostoDeEntregaRealizadaRule obtenerInstancia() {

        return instancia;

    }

    public boolean cumple(CostoRecorridoDominio datos) {

        return CatalogoCodigosEstado.Entrega.ENTREGADA.equals(datos.getDetalleEntrega().getEntrega().getEstadoEntrega().getCodigo());

    }

}
