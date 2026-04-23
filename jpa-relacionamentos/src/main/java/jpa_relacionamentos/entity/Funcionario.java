package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
public class Funcionario {
 
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(mappedBy = "funcionario",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private Endereco endereco;
}
