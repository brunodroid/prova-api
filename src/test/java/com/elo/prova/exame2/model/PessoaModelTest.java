package com.elo.prova.exame2.model;

import com.elo.prova.exame1.utils.Status;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class PessoaModelTest {

    @Test
    public void jogadaModelTest() {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(1L);
        pessoaModel.setNome("Bruno");
        pessoaModel.setDataNascimento(Date.valueOf("1987-09-25"));

        assertEquals(pessoaModel.getId().longValue(), 1L);
        assertEquals(pessoaModel.getNome(), "Bruno");
        assertEquals(pessoaModel.getDataNascimento().toString(), "1987-09-25");
    }
}