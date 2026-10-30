package com.ketra.negocio.negocio.reglas.impl.utilidad;

import com.ketra.dominio.FacturaDominio;
import com.ketra.transversal.catalogo.CatalogoCodigosEstado;

public final class ConsiderarFacturaEnIngresosRule {

    private static final ConsiderarFacturaEnIngresosRule instancia = new ConsiderarFacturaEnIngresosRule();

    private ConsiderarFacturaEnIngresosRule() {

    }

    public static ConsiderarFacturaEnIngresosRule obtenerInstancia() {

        return instancia;

    }

    public boolean cumple(FacturaDominio datos) {

        return !CatalogoCodigosEstado.Factura.ANULADA.equals(datos.getEstadoFactura().getCodigo());

    }

}
