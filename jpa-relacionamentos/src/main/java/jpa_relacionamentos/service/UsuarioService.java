package jpa_relacionamentos.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.entity.*;
import jpa_relacionamentos.repository.*;
import jpa_relacionamentos.dto.*;

import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private LivroRepository livroRepo;

    public UsuarioDTO salvar(UsuarioDTO dto){
        Usuario u = new Usuario();
        u.setNome(dto.getNome());

        Contato c = new Contato();
        c.setEmail(dto.getContato().getEmail());
        c.setTelefone(dto.getContato().getTelefone());

        u.setContato(c);

        return toDTO(usuarioRepo.save(u));
    }

    public LivroDTO salvarLivro(LivroDTO dto){
        Livro l = new Livro();
        l.setTitulo(dto.getTitulo());
        l.setAutor(dto.getAutor());

        Livro saved = livroRepo.save(l);

        LivroDTO resp = new LivroDTO();
        resp.setId(saved.getId());
        resp.setTitulo(saved.getTitulo());
        resp.setAutor(saved.getAutor());
        return resp;
    }

    public UsuarioDTO emprestar(Long usuarioId, Long livroId){
        Usuario u = usuarioRepo.findById(usuarioId).orElseThrow();
        Livro l = livroRepo.findById(livroId).orElseThrow();

        u.getLivrosEmprestados().add(l);
        return toDTO(usuarioRepo.save(u));
    }

    public UsuarioDTO buscar(Long id){
        return toDTO(usuarioRepo.findById(id).orElseThrow());
    }

    private UsuarioDTO toDTO(Usuario u){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());

        ContatoDTO c = new ContatoDTO();
        c.setEmail(u.getContato().getEmail());
        c.setTelefone(u.getContato().getTelefone());

        dto.setContato(c);

        dto.setLivros(
            u.getLivrosEmprestados().stream()
                .map(Livro::getTitulo)
                .collect(Collectors.toList())
        );

        return dto;
    }
}