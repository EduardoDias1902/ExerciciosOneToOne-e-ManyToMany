package jpa_relacionamentos.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Musica {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String artista;
}
