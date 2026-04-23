package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>  {
    
}
