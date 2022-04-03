package com.pb.prova.config;

import lombok.Getter;

@Getter
public class ErroDeFormularioDto {

    private String nome;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.nome = campo;
        this.erro = erro;
    }
}