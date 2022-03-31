package com.pb.prova.dto;

import com.pb.prova.constants.Ideologia;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoFormDto {

    @NotNull(message = "O campo nome não pode ser vazio!")
    private String nomeDoPartido;

    @NotNull(message = "O campo sigla não pode ser vazio!")
    private String sigla;

    @NotNull(message = "O campo ideologia não pode ser vazio, e precisa pertencer a Direita, Esquerda ou Centro!")
    private Ideologia ideologia;

    @NotNull(message = "O campo data de fundação não pode ser vazio!")
    private Date dataDeFuncadacao;


}