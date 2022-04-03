package com.pb.prova.controller;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.dto.AssociadoDto;
import com.pb.prova.dto.PartidoDto;
import com.pb.prova.dto.PartidoFormDto;
import com.pb.prova.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    PartidoService partidoService;

    @GetMapping
    public ResponseEntity<Page<PartidoDto>> listarTodos(@RequestParam(required = false) Ideologia ideologia,@PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable ordenacao){
        return ResponseEntity.ok().body(partidoService.listarTodos(ideologia, ordenacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoDto> listarPorId(@PathVariable Long id){
        return partidoService.listarPorId(id);
    }

    @GetMapping("/{id}/associados")
    public ResponseEntity<List<AssociadoDto>> listarAssociadosPorPartido(@PathVariable Long id){
        return ResponseEntity.ok().body(partidoService.listarAssociadosPorPartido(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoFormDto partidoFormDto, UriComponentsBuilder uriBuilder){
        return partidoService.cadastrar(partidoFormDto, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PartidoFormDto partidoFormDto){
        return partidoService.atualizarPorId(id, partidoFormDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluirPorId(@PathVariable Long id){
        return partidoService.excluirPorId(id);
    }

}
