package jpa_relacionamentos.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.dto.FuncionarioDTO;
import jpa_relacionamentos.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> salvar(@RequestBody FuncionarioDTO dto){
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }
}