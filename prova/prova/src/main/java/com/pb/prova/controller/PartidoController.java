package com.pb.prova.controller;

import com.pb.prova.constants.Ideologia;
import com.pb.prova.dto.PartidoDto;
import com.pb.prova.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    PartidoService partidoService;

    @GetMapping
    public List<PartidoDto> listar(@RequestParam(required = false) Ideologia ideologia, @RequestParam(required = false) String sort){
        return partidoService.listarTodos(ideologia, sort);
    }
}
