package com.elo.prova.exame1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalavraModelTest {

    @Test
    public void palavraModelTest() {
        PalavraModel palavraModel = new PalavraModel("TESTE", "Unitário");

        assertEquals(palavraModel.getPalavra(), "TESTE");
        assertEquals(palavraModel.getDica(), "Unitário");
        assertEquals(palavraModel.getTamanho(), 5);
    }

}