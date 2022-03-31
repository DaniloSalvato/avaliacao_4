package com.pb.prova.service;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.dto.PartidoDto;
import com.pb.prova.entities.Partido;
import com.pb.prova.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
            List<Partido> partidos = partidoRepository.findByRegiao(ideologia, sort);
            return PartidoDto.converter(partidos);
        }
    }
}
