package jpa_relacionamentos.dto;

import lombok.Data;

@Data
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private EnderecoDTO endereco;
}
