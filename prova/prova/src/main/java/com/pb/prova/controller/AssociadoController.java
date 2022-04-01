package com.pb.prova.controller;

import com.pb.prova.constants.Cargo;
import com.pb.prova.dto.AssociadoDto;
import com.pb.prova.dto.AssociadoFormDto;
import com.pb.prova.service.AssociadoService;
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

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    AssociadoService associadoService;

    @GetMapping
    public Page<AssociadoDto> listar(@RequestParam(required = false) Cargo cargo,@PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable ordenacao){
        return associadoService.listarTodos(cargo, ordenacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoDto> listarPorId(@PathVariable Long id){
        return associadoService.listarPorId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoFormDto associadoFormDto, UriComponentsBuilder uriBuilder){
        return associadoService.cadastrar(associadoFormDto, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociadoDto> atualizarPorId(@PathVariable Long id, @RequestBody @Valid AssociadoFormDto associadoFormDto){
        return associadoService.atualizarPorId(id, associadoFormDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluirPorId(@PathVariable Long id){
        return associadoService.excluirPorId(id);
    }
}
