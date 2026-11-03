package com.ketra.transversal.catalogo.catalogocodigosdeestado.enums;

public enum EstadoPreliquidacionEnum {

    PENDIENTE("PRE-01"),
    PAGADA("PRE-02"),
    ANULADA("PRE-03");

    private final String codigo;

    private EstadoPreliquidacionEnum(String codigo) {

        this.codigo = codigo;

    }

    public String getCodigo() {

        return codigo;

    }

}
