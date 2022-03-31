package com.pb.prova.entities;

import com.pb.prova.constants.Ideologia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Date dataDeFundacao;

}
