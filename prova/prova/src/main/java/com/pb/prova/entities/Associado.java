package com.pb.prova.entities;

import com.pb.prova.constants.Cargo;
import com.pb.prova.constants.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "associado")
public class Associado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataDeNascimento;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
