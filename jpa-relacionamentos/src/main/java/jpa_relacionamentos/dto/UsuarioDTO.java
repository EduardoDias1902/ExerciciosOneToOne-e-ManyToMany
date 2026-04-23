package jpa_relacionamentos.dto;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private ContatoDTO contato;
    private List<String> livros;
}
