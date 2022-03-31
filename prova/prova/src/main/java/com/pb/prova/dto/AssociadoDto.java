package com.pb.prova.dto;

import com.pb.prova.constants.Cargo;
import com.pb.prova.constants.Sexo;
import lombok.Data;


@Data
public class AssociadoDto {

    private Long id;
    private String nome;
    private String dataDeNascimento;
    private Cargo cargo;
    private Sexo sexo;
}
