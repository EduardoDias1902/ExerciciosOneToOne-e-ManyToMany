package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{
    
}