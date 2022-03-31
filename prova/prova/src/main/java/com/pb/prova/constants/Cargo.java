package com.pb.prova.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cargo {
    VEREADOR("vereador"),
    PREFEITO("prefeito"),
    DEPUTADO_ESTADUAL("deputado_estadual"),
    DEPUTADO_FEDERAL("deputado_federal"),
    SENADOR("senador"),
    GOVERNADOR("governador"),
    PRESIDENTE("presidente"),
    NENHUM("nenhum");

    Cargo(String value) {
        this.value = value;
    }

    private String value;

    @JsonCreator
    public static Cargo fromValue(String value) {
        for (Cargo cargoPolitico : Cargo.values()) {
            if (cargoPolitico.value.equalsIgnoreCase(value)) {
                return cargoPolitico;
            }
        }
        return null;
    }
}
