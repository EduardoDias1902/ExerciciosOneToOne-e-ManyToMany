package jpa_relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_relacionamentos.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>  {
    
}
