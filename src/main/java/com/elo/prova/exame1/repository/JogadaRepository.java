package com.elo.prova.exame1.repository;

import com.elo.prova.exame1.enums.Status;
import com.elo.prova.exame1.model.JogadaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadaRepository extends JpaRepository<JogadaModel, Long> {

    List<JogadaModel> findByStatus(Status status);

}
