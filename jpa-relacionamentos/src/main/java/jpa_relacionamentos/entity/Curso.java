package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

public class Curso {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos = new ArrayList<>();
}
