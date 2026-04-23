package jpa_relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa_relacionamentos.entity.Aluno;
import jpa_relacionamentos.entity.Curso;
import jpa_relacionamentos.repository.AlunoRepository;
import jpa_relacionamentos.repository.CursoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;

     @Autowired
    private CursoRepository cursoRepo;

    public Aluno salvar(Aluno a){
        return alunoRepo.save(a);
    }
    public Curso salvarCurso(Curso c){
        return cursoRepo.save(c);
    }
    public Aluno matricular(Long alunoId,Long cursoId){
        Aluno aluno = alunoRepo.findById(alunoId).orElseThrow();
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();

        if(!aluno.getCursos().contains(curso)){
            aluno.getCursos().add(curso);
        }
        return alunoRepo.save(aluno);
    }
}
