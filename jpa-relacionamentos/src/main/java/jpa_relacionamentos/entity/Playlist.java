package jpa_relacionamentos.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @ManyToMany
    private List<Musica> musicas = new ArrayList<>();
}
