package com.ketra.transversal.catalogo.catalogocodigosdeestado.enums;

public enum EstadoFacturaEnum {

    PENDIENTE("FAC-01"),
    PAGADA("FAC-02"),
    ANULADA("FAC-03");

    private final String codigo;

    private EstadoFacturaEnum(String codigo) {

        this.codigo = codigo;

    }

    public String getCodigo() {

        return codigo;

    }

}
