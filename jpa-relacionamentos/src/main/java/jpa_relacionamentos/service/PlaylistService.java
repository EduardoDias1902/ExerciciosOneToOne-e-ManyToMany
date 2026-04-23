package jpa_relacionamentos.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.entity.*;
import jpa_relacionamentos.repository.*;
import jpa_relacionamentos.dto.*;

import java.util.stream.Collectors;

@Service
public class PlaylistService {

    @Autowired private PlaylistRepository playlistRepo;
    @Autowired private MusicaRepository musicaRepo;

    public MusicaDTO salvarMusica(MusicaDTO dto){
        Musica m = new Musica();
        m.setNome(dto.getNome());
        m.setArtista(dto.getArtista());

        return toMusicaDTO(musicaRepo.save(m));
    }

    public PlaylistDTO salvar(PlaylistDTO dto){
        Playlist p = new Playlist();
        p.setNome(dto.getNome());
        return toDTO(playlistRepo.save(p));
    }

    public PlaylistDTO addMusica(Long playlistId, Long musicaId){
        Playlist p = playlistRepo.findById(playlistId).orElseThrow();
        Musica m = musicaRepo.findById(musicaId).orElseThrow();

        p.getMusicas().add(m);
        return toDTO(playlistRepo.save(p));
    }

    private PlaylistDTO toDTO(Playlist p){
        PlaylistDTO dto = new PlaylistDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());

        dto.setMusicas(
            p.getMusicas().stream()
                .map(this::toMusicaDTO)
                .collect(Collectors.toList())
        );

        return dto;
    }

    private MusicaDTO toMusicaDTO(Musica m){
        MusicaDTO dto = new MusicaDTO();
        dto.setId(m.getId());
        dto.setNome(m.getNome());
        dto.setArtista(m.getArtista());
        return dto;
    }
}