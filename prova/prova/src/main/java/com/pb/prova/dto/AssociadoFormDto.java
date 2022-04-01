package com.pb.prova.dto;

import com.pb.prova.constants.Cargo;
import com.pb.prova.constants.Sexo;
import com.pb.prova.entities.Associado;
import com.pb.prova.repository.AssociadoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoFormDto {

    @NotNull(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo sigla não pode ser vazio!")
    private LocalDate dataDeNascimento;

    @NotNull(message = "O campo ideologia não pode ser vazio, e precisa pertencer a Direita, Esquerda ou Centro!")
    private Cargo cargo;

    @NotNull(message = "O campo data de fundação não pode ser vazio!")
    private Sexo sexo;



    public Associado atualizar(Long id, AssociadoRepository associadoRepository) {
        Associado associado = associadoRepository.getById(id);

        associado.setNome(nome);
        associado.setDataDeNascimento(dataDeNascimento);
        associado.setCargo(cargo);
        associado.setSexo(sexo);
        return associado;
    }

    public Associado converter(AssociadoRepository associadoRepository){
        return new Associado(this.nome, this.dataDeNascimento, this.cargo, this.sexo);
    }
}
