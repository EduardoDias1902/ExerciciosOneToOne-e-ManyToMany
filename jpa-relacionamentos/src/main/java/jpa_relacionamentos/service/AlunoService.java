package jpa_relacionamentos.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.entity.*;
import jpa_relacionamentos.repository.*;
import jpa_relacionamentos.dto.*;

import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired private AlunoRepository alunoRepo;
    @Autowired private CursoRepository cursoRepo;

    public AlunoDTO salvar(AlunoDTO dto){
        Aluno a = new Aluno();
        a.setNome(dto.getNome());
        return toDTO(alunoRepo.save(a));
    }

    public CursoDTO salvarCurso(CursoDTO dto){
        Curso c = new Curso();
        c.setNome(dto.getNome());
        return toCursoDTO(cursoRepo.save(c));
    }

    public AlunoDTO matricular(Long alunoId, Long cursoId){
        Aluno a = alunoRepo.findById(alunoId).orElseThrow();
        Curso c = cursoRepo.findById(cursoId).orElseThrow();

        a.getCursos().add(c);
        return toDTO(alunoRepo.save(a));
    }

    private AlunoDTO toDTO(Aluno a){
        AlunoDTO dto = new AlunoDTO();
        dto.setId(a.getId());
        dto.setNome(a.getNome());

        dto.setCursos(
            a.getCursos().stream()
                .map(Curso::getNome)
                .collect(Collectors.toList())
        );

        return dto;
    }

    private CursoDTO toCursoDTO(Curso c){
        CursoDTO dto = new CursoDTO();
        dto.setId(c.getId());
        dto.setNome(c.getNome());

        dto.setAlunos(
            c.getAlunos().stream()
                .map(Aluno::getNome)
                .collect(Collectors.toList())
        );

        return dto;
    }
}