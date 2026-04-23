package jpa_relacionamentos.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    @ManyToMany
    private List<Livro> livrosEmprestados = new ArrayList<>();
}
