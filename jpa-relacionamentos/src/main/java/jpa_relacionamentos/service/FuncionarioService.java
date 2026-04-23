package jpa_relacionamentos.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jpa_relacionamentos.entity.*;
import jpa_relacionamentos.repository.FuncionarioRepository;
import jpa_relacionamentos.dto.*;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public FuncionarioDTO salvar(FuncionarioDTO dto){
        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());

        Endereco e = new Endereco();
        e.setRua(dto.getEndereco().getRua());
        e.setNumero(dto.getEndereco().getNumero());

        e.setFuncionario(f);
        f.setEndereco(e);

        return toDTO(repo.save(f));
    }

    public FuncionarioDTO buscar(Long id){
        return toDTO(repo.findById(id).orElseThrow());
    }

    private FuncionarioDTO toDTO(Funcionario f){
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(f.getId());
        dto.setNome(f.getNome());

        EnderecoDTO e = new EnderecoDTO();
        e.setRua(f.getEndereco().getRua());
        e.setNumero(f.getEndereco().getNumero());

        dto.setEndereco(e);
        return dto;
    }
}