package com.ketra.negocio.negocio.reglas.impl.utilidad;

import com.ketra.dominio.EntregaDominio;
import com.ketra.transversal.catalogo.catalogocodigosdeestado.enums.EstadoEntregaEnum;

public final class VerificarEntregaRealizadaRule {

    private static final VerificarEntregaRealizadaRule instancia = new VerificarEntregaRealizadaRule();

    private VerificarEntregaRealizadaRule() {

    }

    public static VerificarEntregaRealizadaRule obtenerInstancia() {

        return instancia;

    }

    public boolean cumple(EntregaDominio entrega) {

        return EstadoEntregaEnum.ENTREGADA.getCodigo().equals(entrega.getEstadoEntrega().getCodigo());

    }

}
