package com.elo.prova.exame2.repository;

import com.elo.prova.exame2.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

}
