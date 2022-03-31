package com.pb.prova.dto;

import com.pb.prova.constants.Cargo;
import com.pb.prova.constants.Sexo;
import com.sun.istack.NotNull;

import java.util.Date;

public class AssociadoFormDto {

    @NotNull(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo sigla não pode ser vazio!")
    private Date dataDeNascimento;

    @NotNull(message = "O campo ideologia não pode ser vazio, e precisa pertencer a Direita, Esquerda ou Centro!")
    private Cargo cargo;

    @NotNull(message = "O campo data de fundação não pode ser vazio!")
    private Sexo sexo;
}
