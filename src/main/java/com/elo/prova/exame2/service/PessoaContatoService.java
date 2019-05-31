package com.elo.prova.exame2.service;

import com.elo.prova.exame2.model.PessoaContatoModel;
import com.elo.prova.exame2.model.PessoaModel;
import com.elo.prova.exame2.repository.PessoaContatoRepository;
import com.elo.prova.exame2.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaContatoService {

    @Autowired
    private PessoaContatoRepository pessoaContatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<PessoaContatoModel> listarPessoaContatos(Long idPessoa, Pageable pageable) {
        return pessoaContatoRepository.findByPessoaModelId(idPessoa, pageable);
    }

    public PessoaContatoModel getPessoaContato(Long id) {
        return pessoaContatoRepository.getOne(id);
    }

    public PessoaContatoModel addPessoaContato(Long idPessoa, PessoaContatoModel pessoaContatoModel) {
        PessoaModel pessoaModel = pessoaRepository.getOne(idPessoa);

        pessoaContatoModel.setPessoaModel(pessoaModel);

        pessoaContatoRepository.save(pessoaContatoModel);

        return pessoaContatoModel;
    }

    public PessoaContatoModel updatePessoaContato(Long id, PessoaContatoModel pessoaContatoModel) {
        PessoaContatoModel pessoaContatoModelDB = pessoaContatoRepository.getOne(id);

        BeanUtils.copyProperties(pessoaContatoModel, pessoaContatoModelDB, "id");

        pessoaContatoRepository.save(pessoaContatoModelDB);

        return pessoaContatoModelDB;
    }

    public void deletePessoaContato(Long id) {
        pessoaContatoRepository.deleteById(id);
    }
}
