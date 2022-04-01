package com.pb.prova.service;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.dto.PartidoDto;
import com.pb.prova.dto.PartidoFormDto;
import com.pb.prova.entities.Partido;
import com.pb.prova.repository.PartidoRepository;
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
public class PartidoService {

    @Autowired
    PartidoRepository partidoRepository;

    public Page<PartidoDto> listarTodos(Ideologia ideologia, Pageable ordenacao) {

        if (ideologia == null) {
            List<Partido> partidos = partidoRepository.findAll();
            return PartidoDto.converter(new PageImpl<>(partidos));
        } else {
            List<Partido> partidos = partidoRepository.findByIdeologia(ideologia, ordenacao);
            return PartidoDto.converter(new PageImpl<>(partidos));
        }
    }

    public ResponseEntity<PartidoDto> listarPorId(Long id) {
        Optional<Partido> partido = partidoRepository.findById(id);
        if(partido.isPresent()){
            return ResponseEntity.ok(new PartidoDto(partido.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PartidoDto> cadastrar(PartidoFormDto partidoFormDto, UriComponentsBuilder uriBuilder) {
        Partido partido = partidoFormDto.converter(partidoRepository);
        partidoRepository.save(partido);
        URI uri = uriBuilder.path("/partidos").buildAndExpand(partido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PartidoDto(partido));
    }

    public ResponseEntity<PartidoDto> atualizarPorId(Long id, PartidoFormDto partidoFormDto) {
        Optional<Partido> optional = partidoRepository.findById(id);
        if(optional.isPresent()){
            Partido partido = partidoFormDto.atualizar(id, partidoRepository);
            return ResponseEntity.ok(new PartidoDto(partido));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> excluirPorId(Long id) {
        Optional<Partido> optional = partidoRepository.findById(id);
        if(optional.isPresent()){
            partidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
