package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}