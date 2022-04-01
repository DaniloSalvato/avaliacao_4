package com.pb.prova.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pb.prova.constants.Ideologia;
import com.pb.prova.entities.Partido;
import com.pb.prova.serializer.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDto {

    private Long id;
    private String nomeDoPartido;
    private String sigla;
    private Ideologia ideologia;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeFuncadacao;

    public PartidoDto(Partido partido){
        this.id = partido.getId();
        this.nomeDoPartido = partido.getNomeDoPartido();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataDeFuncadacao = partido.getDataDeFundacao();
    }

    public static Page<PartidoDto> converter(PageImpl<Partido> partidos) {
        return partidos.map(PartidoDto::new);
    }
}
