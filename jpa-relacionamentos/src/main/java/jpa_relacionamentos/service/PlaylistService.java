package jpa_relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa_relacionamentos.entity.Musica;
import jpa_relacionamentos.entity.Playlist;
import jpa_relacionamentos.repository.MusicaRepository;
import jpa_relacionamentos.repository.PlaylistRepository;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepo;

    @Autowired
    private MusicaRepository musicaRepo;

    public Playlist salvar(Playlist p){
        return playlistRepo.save(p);
    }
    public Musica salvarMusica(Musica m){
        return musicaRepo.save(m);
    }
    public Playlist adicionarMusica(Long playlistId,Long musicaId){
        Playlist p = playlistRepo.findById(playlistId).orElseThrow();
        Musica m = musicaRepo.findById(musicaId).orElseThrow();

        p.getMusicas().add(m);
        return playlistRepo.save(p);
    }
}
