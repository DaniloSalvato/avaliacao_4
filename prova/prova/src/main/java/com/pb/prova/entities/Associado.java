package com.pb.prova.entities;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import com.pb.prova.constants.Cargo;
import com.pb.prova.constants.Sexo;

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
@Table(name = "associados")
public class Associado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeNascimento;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name="partido_id")
    private Partido partido;

    public Associado(String nome, LocalDate dataDeNascimento, Cargo cargo, Sexo sexo) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cargo = cargo;
        this.sexo = sexo;
    }
}
