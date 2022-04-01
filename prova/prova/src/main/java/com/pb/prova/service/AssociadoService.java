package com.pb.prova.service;

import com.pb.prova.constants.Cargo;
import com.pb.prova.dto.AssociadoDto;
import com.pb.prova.dto.AssociadoFormDto;
import com.pb.prova.entities.Associado;
import com.pb.prova.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class AssociadoService {

    @Autowired
    AssociadoRepository associadoRepository;

    public Page<AssociadoDto> listarTodos(Cargo cargo, Pageable ordenacao) {

        if (cargo == null) {
            List<Associado> associados = associadoRepository.findAll();
            return AssociadoDto.converter(new PageImpl<>(associados));
        } else {
            List<Associado> associados = associadoRepository.findByCargo(cargo, ordenacao);
            return AssociadoDto.converter(new PageImpl<>(associados));
        }
    }

    public ResponseEntity<AssociadoDto> listarPorId(Long id) {
        Optional<Associado> associado = associadoRepository.findById(id);
        if(associado.isPresent()){
            return ResponseEntity.ok(new AssociadoDto(associado.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AssociadoDto> cadastrar(AssociadoFormDto associadoFormDto, UriComponentsBuilder uriBuilder) {
        Associado associado = associadoFormDto.converter(associadoRepository);
        associadoRepository.save(associado);
        URI uri = uriBuilder.path("/associados").buildAndExpand(associado.getId()).toUri();
        return ResponseEntity.created(uri).body(new AssociadoDto(associado));
    }

    public ResponseEntity<AssociadoDto> atualizarPorId(Long id, AssociadoFormDto associadoFormDto) {
        Optional<Associado> optional = associadoRepository.findById(id);
        if(optional.isPresent()){
            Associado associado = associadoFormDto.atualizar(id, associadoRepository);
            return ResponseEntity.ok(new AssociadoDto(associado));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> excluirPorId(Long id) {
        Optional<Associado> optional = associadoRepository.findById(id);
        if(optional.isPresent()){
            associadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}

