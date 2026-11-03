package com.ketra.transversal.catalogo.catalogocodigosdeestado.enums;

public enum EstadoEntregaEnum {

    PENDIENTE("ENT-01"),
    EN_TRANSITO("ENT-02"),
    ENTREGADA("ENT-03"),
    CANCELADA("ENT-04");

    private final String codigo;

    private EstadoEntregaEnum(String codigo) {

        this.codigo = codigo;

    }

    public String getCodigo() {

        return codigo;

    }

}
