package com.pb.prova.service;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.dto.PartidoDto;
import com.pb.prova.entities.Partido;
import com.pb.prova.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    PartidoRepository partidoRepository;

    public List<PartidoDto> listarTodos(Ideologia ideologia, String ordenacao) {

        Sort sort = Sort.by("id").ascending();

        if (ideologia == null) {
            List<Partido> partidos = partidoRepository.findAll(sort);
            return PartidoDto.converter(partidos);
        } else {
            List<Partido> partidos = partidoRepository.findByIdeologia(ideologia, sort);
            return PartidoDto.converter(partidos);
        }
    }

    public ResponseEntity<PartidoDto> listarPorId(Long id) {
        Optional<Partido> partido = partidoRepository.findById(id);
        if(partido.isPresent()){
            return ResponseEntity.ok(new PartidoDto(partido.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
