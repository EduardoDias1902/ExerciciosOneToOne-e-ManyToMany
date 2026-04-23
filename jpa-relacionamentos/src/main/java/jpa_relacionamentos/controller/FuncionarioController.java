package jpa_relacionamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jpa_relacionamentos.entity.Funcionario;
import jpa_relacionamentos.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> salvar (@RequestBody Funcionario f){
        return ResponseEntity.ok(service.salvar(f));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }
}
