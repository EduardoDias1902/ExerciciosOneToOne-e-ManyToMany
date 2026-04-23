package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
    
}