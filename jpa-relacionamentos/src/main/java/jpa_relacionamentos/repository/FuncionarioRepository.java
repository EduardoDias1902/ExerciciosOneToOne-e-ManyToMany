package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Funcionario;
public interface  FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    
}
