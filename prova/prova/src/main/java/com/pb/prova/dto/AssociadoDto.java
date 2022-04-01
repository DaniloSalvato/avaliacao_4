package com.pb.prova.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pb.prova.constants.Cargo;
import com.pb.prova.constants.Sexo;
import com.pb.prova.entities.Associado;
import com.pb.prova.serializer.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDto {

    private Long id;
    private String nome;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeNascimento;
    private Cargo cargo;
    private Sexo sexo;

    public AssociadoDto(Associado associado){
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.dataDeNascimento = associado.getDataDeNascimento();
        this.cargo = associado.getCargo();
        this.sexo = associado.getSexo();
    }

    public static Page<AssociadoDto> converter(Page<Associado> associados) {
        return associados.map(AssociadoDto::new);
    }
}
