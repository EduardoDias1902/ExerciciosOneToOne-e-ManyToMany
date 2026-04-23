package jpa_relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpa_relacionamentos.entity.Funcionario;
import jpa_relacionamentos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public Funcionario salvar(Funcionario f){
        f.getEndereco().setFuncionario(f);
        return repo.save(f);
    }
    public Funcionario buscar(Long id){
        return repo.findById(id).orElseThrow();
    }
}
