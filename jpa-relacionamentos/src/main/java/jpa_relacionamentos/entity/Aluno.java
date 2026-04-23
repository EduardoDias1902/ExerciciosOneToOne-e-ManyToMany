package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Entity
@Data
public class Aluno {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @ManyToMany
    @JoinTable(
        name = "aluno_curso",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos = new ArrayList<>();
}
