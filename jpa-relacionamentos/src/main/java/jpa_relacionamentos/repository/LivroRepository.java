package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>  {
    
}
