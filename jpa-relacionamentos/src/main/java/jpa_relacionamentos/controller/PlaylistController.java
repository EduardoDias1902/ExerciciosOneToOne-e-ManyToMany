package jpa_relacionamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpa_relacionamentos.entity.Musica;
import jpa_relacionamentos.entity.Playlist;
import jpa_relacionamentos.service.PlaylistService;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService service;

    @PostMapping("/musicas")
    public ResponseEntity<Musica> salvar(@RequestBody Musica m){
        return ResponseEntity.ok(service.salvarMusica(m));
    }
    @PostMapping("/playlists")
    public ResponseEntity<Playlist> salvarPlaylist(@RequestBody Playlist p){
        return ResponseEntity.ok(service.salvar(p));
    }
    @PutMapping("/playlist/{playlistId}/musica/{musicaId}")
    public ResponseEntity<Playlist> add(@PathVariable Long playlistId,@PathVariable Long musicaId){
        return ResponseEntity.ok(service.adicionarMusica(playlistId, musicaId));
    }
}
