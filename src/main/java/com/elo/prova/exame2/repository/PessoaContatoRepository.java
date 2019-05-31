package com.elo.prova.exame2.repository;

import com.elo.prova.exame2.model.PessoaContatoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaContatoRepository extends JpaRepository<PessoaContatoModel, Long> {

    Page<PessoaContatoModel> findByPessoaModelId(Long idPessoa, Pageable pageable);

}
