package com.pb.prova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelacionamentoFormDto {

    private Long idAssociado;
    private Long idPartido;
}
