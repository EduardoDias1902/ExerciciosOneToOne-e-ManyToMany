package jpa_relacionamentos.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.dto.*;
import jpa_relacionamentos.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PostMapping("/livros")
    public ResponseEntity<LivroDTO> salvarLivro(@RequestBody LivroDTO dto){
        return ResponseEntity.ok(service.salvarLivro(dto));
    }

    @PutMapping("/emprestar/{usuarioId}/{livroId}")
    public ResponseEntity<UsuarioDTO> emprestar(@PathVariable Long usuarioId, @PathVariable Long livroId){
        return ResponseEntity.ok(service.emprestar(usuarioId, livroId));
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }
}