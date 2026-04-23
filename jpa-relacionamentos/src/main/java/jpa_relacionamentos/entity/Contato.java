package jpa_relacionamentos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String telefone;
}
