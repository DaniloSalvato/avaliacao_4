package com.pb.prova.repository;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.entities.Partido;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PartidoRepository {
    List<Partido> findByRegiao(Ideologia ideologia, Sort sort);

    List<Partido> findAll(Sort sort);
}
