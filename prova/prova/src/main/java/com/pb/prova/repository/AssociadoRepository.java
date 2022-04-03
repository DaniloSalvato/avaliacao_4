package com.pb.prova.repository;

import com.pb.prova.constants.Cargo;
import com.pb.prova.dto.AssociadoDto;
import com.pb.prova.entities.Associado;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    List<Associado> findByCargo(Cargo cargo, Pageable ordenacao);

    List<Associado> findByPartidoId(Long id);
}
