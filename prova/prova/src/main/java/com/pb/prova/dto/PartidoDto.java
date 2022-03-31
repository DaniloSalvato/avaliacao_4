package com.pb.prova.dto;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.entities.Partido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDto {

    private Long id;
    private String nomeDoPartido;
    private String sigla;
    private Ideologia ideologia;
    private Date dataDeFuncadacao;

    public PartidoDto(Partido partido){
        this.id = partido.getId();
        this.nomeDoPartido = partido.getNomeDoPartido();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataDeFuncadacao = partido.getDataDeFundacao();
    }

    public static List<PartidoDto> converter(List<Partido> partidos) {
        return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());
    }
}
