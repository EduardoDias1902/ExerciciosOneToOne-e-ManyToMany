package jpa_relacionamentos.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jpa_relacionamentos.entity.Pessoa;
import jpa_relacionamentos.repository.PessoaRepository;

@Service
public class PessoaService {
  @Autowired
  private PessoaRepository repo;
  
  public Pessoa salvar(Pessoa p){
    return repo.save(p);
  }
  public Pessoa buscar(Long id){
    return repo.findById(id).orElseThrow();
  }
}
