package com.elo.prova.exame1.model;

import com.elo.prova.exame1.utils.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogadaModelTest {

    @Test
    public void jogadaModelTest() {
        PalavraModel palavraModel = new PalavraModel("TESTE", "Unitário");
        JogadaModel jogadaModel = new JogadaModel(palavraModel, 3);

        assertEquals(jogadaModel.getIdPalavra(), palavraModel.getId());
        assertEquals(jogadaModel.getQtdVidas(), 3);
        assertEquals(jogadaModel.getStatus(), Status.START);
    }
}