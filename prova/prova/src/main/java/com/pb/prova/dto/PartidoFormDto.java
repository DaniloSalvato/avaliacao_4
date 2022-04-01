package com.pb.prova.dto;

import com.pb.prova.constants.Ideologia;

import com.pb.prova.entities.Partido;
import com.pb.prova.repository.PartidoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


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
    private LocalDate dataDeFundacao;


    public Partido converter(PartidoRepository partidoRepository){
        return new Partido(this.nomeDoPartido, this.sigla, this.ideologia, this.dataDeFundacao);
    }

    public Partido atualizar(Long id, PartidoRepository partidoRepository){
        Partido partido = partidoRepository.getOne(id);

        partido.setNomeDoPartido(nomeDoPartido);
        partido.setSigla(sigla);
        partido.setIdeologia(ideologia);
        partido.setDataDeFundacao(dataDeFundacao);
        return partido;
    }
}