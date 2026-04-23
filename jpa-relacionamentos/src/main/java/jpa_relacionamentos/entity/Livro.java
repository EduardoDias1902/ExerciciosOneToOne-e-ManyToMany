package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Livro {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private String autor;
}
