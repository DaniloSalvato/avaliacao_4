package com.pb.prova.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.pb.prova.constants.Ideologia;

import com.pb.prova.serializer.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoPartido;
    private String sigla;
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeFundacao;

    public Partido(String nomeDoPartido, String sigla, Ideologia ideologia, LocalDate dataDeFundacao) {
        this.nomeDoPartido = nomeDoPartido;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.dataDeFundacao = dataDeFundacao;
    }
}
