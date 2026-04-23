package jpa_relacionamentos.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;
    private String nomeString;
    private DocumentoDTO documento;
}
