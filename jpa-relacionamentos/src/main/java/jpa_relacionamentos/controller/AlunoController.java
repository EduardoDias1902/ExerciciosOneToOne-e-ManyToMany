package jpa_relacionamentos.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.dto.*;
import jpa_relacionamentos.service.AlunoService;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/alunos")
    public ResponseEntity<AlunoDTO> salvar(@RequestBody AlunoDTO dto){
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PostMapping("/cursos")
    public ResponseEntity<CursoDTO> salvarCurso(@RequestBody CursoDTO dto){
        return ResponseEntity.ok(service.salvarCurso(dto));
    }

    @PutMapping("/matricular/{alunoId}/{cursoId}")
    public ResponseEntity<AlunoDTO> matricular(@PathVariable Long alunoId, @PathVariable Long cursoId){
        return ResponseEntity.ok(service.matricular(alunoId, cursoId));
    }
}