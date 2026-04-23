package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String tipo;
}