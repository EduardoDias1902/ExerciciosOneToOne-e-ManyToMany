package jpa_relacionamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpa_relacionamentos.entity.Aluno;
import jpa_relacionamentos.entity.Curso;
import jpa_relacionamentos.service.AlunoService;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno a){
        return ResponseEntity.ok(service.salvar(a));
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> salvarCurso(@RequestBody Curso c){
        return ResponseEntity.ok(service.salvarCurso(c));
    }

    @PutMapping("/matricular/{alunoId}/{cursoId}")
    public ResponseEntity<Aluno> matricular(@PathVariable Long alunoId, @PathVariable Long cursoId){
        return ResponseEntity.ok(service.matricular(alunoId, cursoId));
    }
}