package jpa_relacionamentos.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpa_relacionamentos.entity.Livro;
import jpa_relacionamentos.entity.Usuario;
import jpa_relacionamentos.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario u){
        return ResponseEntity.ok(service.salvar(u));
    }
    @PostMapping("/livros")
    public ResponseEntity<Livro>salvarLivro(@RequestBody Livro l){
        return ResponseEntity.ok(service.salvarLivro(l));
    }
    @PutMapping("/emprestar/{usuarioId}/{livroId}")
    public ResponseEntity<Usuario> emprestar(@PathVariable Long usuarioId,@PathVariable Long livroId){
        return ResponseEntity.ok(service.emprestar(usuarioId, livroId));
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }
}
