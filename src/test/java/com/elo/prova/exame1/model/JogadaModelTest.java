package com.elo.prova.exame1.model;

import com.elo.prova.exame1.enums.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogadaModelTest {

    private PalavraModel palavraModel;
    private JogadaModel jogadaModel;

    @Before
    public void init() {
        palavraModel = new PalavraModel("TESTE", "Unitário");
        jogadaModel = new JogadaModel(palavraModel, 3);
    }

    @Test
    public void jogadaModelTest() {
        assertEquals(jogadaModel.getIdPalavra(), palavraModel.getId());
        assertEquals(jogadaModel.getQtdVidas(), 3);
        assertEquals(jogadaModel.getStatus(), Status.START);
    }

    @Test
    public void atualizarLetrasInformadas() {
        jogadaModel.atualizarLetrasInformadas("E");

        assertEquals("E", jogadaModel.getLetrasInformadas());
    }

    @Test
    public void atualizarStatus() {
        jogadaModel.atualizarStatus(palavraModel);
        assertEquals(Status.RUNNING, jogadaModel.getStatus());

        jogadaModel.setQtdVidas(0);
        jogadaModel.atualizarStatus(palavraModel);
        assertEquals(Status.GAME_OVER, jogadaModel.getStatus());

        jogadaModel.setPalavraMontada(palavraModel.getPalavra());
        jogadaModel.atualizarStatus(palavraModel);
        assertEquals(Status.FINISHED, jogadaModel.getStatus());
    }

    @Test
    public void atualizarFeedBackMessage() {
        jogadaModel.atualizarStatus(palavraModel);
        jogadaModel.atualizarFeedBackMessage(palavraModel, "TESTE");
        assertEquals("TESTE Você ainda possui 3 chance(s).", jogadaModel.getFeedBackMessage());
    }

    @Test
    public void atualizarQtdTentativas() {
        jogadaModel.atualizarQtdTentativas();
        assertEquals(1, jogadaModel.getQtdTentativas());
    }

    @Test
    public void atualizarQtdVidas() {
        jogadaModel.atualizarQtdVidas();
        assertEquals(2, jogadaModel.getQtdVidas());
    }
}