package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{
    
}
