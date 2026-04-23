package jpa_relacionamentos.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import jpa_relacionamentos.entity.Pessoa;
import jpa_relacionamentos.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity <Pessoa> salvar(@RequestBody Pessoa p){
        return ResponseEntity.ok(service.salvar(p));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscar (@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));

    }
}