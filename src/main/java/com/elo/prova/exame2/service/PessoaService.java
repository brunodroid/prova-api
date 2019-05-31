package com.elo.prova.exame2.service;

import com.elo.prova.exame2.model.PessoaModel;
import com.elo.prova.exame2.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<PessoaModel> listarPessoas(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public PessoaModel getPessoa(Long id) {
        return pessoaRepository.getOne(id);
    }

    public PessoaModel addPessoa(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    public PessoaModel updatePessoa(Long id, PessoaModel pessoaModel) {
        PessoaModel pessoaModelDB = pessoaRepository.getOne(id);

        BeanUtils.copyProperties(pessoaModel, pessoaModelDB, "id", "pessoaContatos");

        pessoaRepository.save(pessoaModelDB);

        return pessoaModelDB;
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
