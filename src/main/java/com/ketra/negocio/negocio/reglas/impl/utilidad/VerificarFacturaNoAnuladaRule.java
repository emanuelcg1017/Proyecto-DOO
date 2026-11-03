package com.ketra.negocio.negocio.reglas.impl.utilidad;

import com.ketra.dominio.FacturaDominio;
import com.ketra.transversal.catalogo.catalogocodigosdeestado.enums.EstadoFacturaEnum;

public final class VerificarFacturaNoAnuladaRule {

    private static final VerificarFacturaNoAnuladaRule instancia = new VerificarFacturaNoAnuladaRule();

    private VerificarFacturaNoAnuladaRule() {

    }

    public static VerificarFacturaNoAnuladaRule obtenerInstancia() {

        return instancia;

    }

    public boolean cumple(FacturaDominio factura) {

        return !EstadoFacturaEnum.ANULADA.getCodigo().equals(factura.getEstadoFactura().getCodigo());

    }

}
