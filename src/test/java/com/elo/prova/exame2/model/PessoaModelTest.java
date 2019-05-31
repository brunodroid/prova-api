package com.elo.prova.exame2.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PessoaModelTest {

    @Test
    public void jogadaModelTest() {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(1L);
        pessoaModel.setNome("Bruno");
        pessoaModel.setDataNascimento(LocalDate.of(1987,9,25));

        assertEquals(pessoaModel.getId().longValue(), 1L);
        assertEquals(pessoaModel.getNome(), "Bruno");
        assertEquals(pessoaModel.getDataNascimento().toString(), "1987-09-25");
    }
}