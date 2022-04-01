package com.pb.prova.repository;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.entities.Partido;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    List<Partido> findByIdeologia(Ideologia ideologia, Pageable ordenacao);
}
