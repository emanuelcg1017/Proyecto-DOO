package com.ketra.transversal.catalogo.catalogocodigosdeestado.enums;

public enum EstadoServicioEnum {

    REGISTRADO("SER-01"),
    EN_EJECUCION("SER-02"),
    FINALIZADO("SER-03"),
    CANCELADO("SER-04");

    private final String codigo;

    private EstadoServicioEnum(String codigo) {

        this.codigo = codigo;

    }

    public String getCodigo() {

        return codigo;

    }

}
