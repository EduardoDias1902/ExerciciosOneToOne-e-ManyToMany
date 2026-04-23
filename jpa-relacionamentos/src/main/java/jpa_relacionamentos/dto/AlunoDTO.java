package jpa_relacionamentos.dto;

import java.util.List;

import lombok.Data;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private List<String> cursos;
}
