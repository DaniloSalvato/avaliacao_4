package com.pb.prova.repository;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.entities.Partido;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByIdeologia(Ideologia ideologia, Sort sort);

    List<Partido> findAll(Sort sort);
}
