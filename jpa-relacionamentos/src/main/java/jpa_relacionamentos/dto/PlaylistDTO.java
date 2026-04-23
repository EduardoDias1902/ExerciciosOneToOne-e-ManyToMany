package jpa_relacionamentos.dto;

import java.util.List;

import lombok.Data;

@Data
public class PlaylistDTO {
    private Long id;
    private String nome;
    private List<MusicaDTO> musicas;
}
