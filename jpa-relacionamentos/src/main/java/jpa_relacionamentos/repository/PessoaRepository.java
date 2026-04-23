package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
