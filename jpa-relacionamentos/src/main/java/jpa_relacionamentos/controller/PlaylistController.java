package jpa_relacionamentos.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.dto.*;
import jpa_relacionamentos.service.PlaylistService;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @PostMapping("/musicas")
    public ResponseEntity<MusicaDTO> salvar(@RequestBody MusicaDTO dto){
        return ResponseEntity.ok(service.salvarMusica(dto));
    }

    @PostMapping("/playlists")
    public ResponseEntity<PlaylistDTO> salvar(@RequestBody PlaylistDTO dto){
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PutMapping("/playlist/{playlistId}/musica/{musicaId}")
    public ResponseEntity<PlaylistDTO> addMusica(@PathVariable Long playlistId, @PathVariable Long musicaId){
        return ResponseEntity.ok(service.addMusica(playlistId, musicaId));
    }
}