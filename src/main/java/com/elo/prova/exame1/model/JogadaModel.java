package com.elo.prova.exame1.model;

import com.elo.prova.exame1.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class JogadaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String palavraMontada = "";
    private String letrasInformadas = "";
    private int qtdVidas = 0;
    private int qtdTentativas = 0;
    private Status status = Status.START;
    private String feedBackMessage = "";

    @JsonIgnore
    private Long idPalavra;

    public JogadaModel() {}

    public JogadaModel(PalavraModel palavraModel, int qtdVidas) {
        this.idPalavra = palavraModel.getId();
        this.qtdVidas = qtdVidas;
        this.feedBackMessage = String.format("Jogo iniciado. A dica é: %s. Boa Sorte!", palavraModel.getDica());

        while (palavraModel.getTamanho() > this.palavraMontada.length()) {
            this.palavraMontada = this.palavraMontada.concat("_");
        }
    }

    public void atualizarLetrasInformadas(String letraInformada) {
        setLetrasInformadas(getLetrasInformadas()
                .concat(String.format(" %s", letraInformada)).trim()
                .replace(" ", ","));
    }

    public void atualizarStatus(PalavraModel palavraModel) {

        if (palavraModel.getPalavra().equals(getPalavraMontada())) {
            setStatus(Status.FINISHED);

        } else if (getQtdVidas() == 0) {
            setStatus(Status.GAME_OVER);

        } else {
            setStatus(Status.RUNNING);
        }
    }

    public void atualizarFeedBackMessage(PalavraModel palavraModel, String mensagemComplementar) {

        switch (getStatus()) {
            case FINISHED:
                setFeedBackMessage(String.format("Parabéns! :D Você acertou a palavra %s com %d tentativa(s).",
                    palavraModel.getPalavra(),
                    getQtdTentativas()));
                break;
            case GAME_OVER:
                setFeedBackMessage(String.format("Você perdeu! :( A palavra era: %s",
                    palavraModel.getPalavra()));
                break;
            case RUNNING:
                setFeedBackMessage(String.format("%s Você ainda possui %d chance(s).",
                    mensagemComplementar,
                    getQtdVidas()));
                break;
            default:
                setFeedBackMessage(String.format("Jogada %d", getId()));
                break;
        }
    }

    public void atualizarQtdTentativas() {
        setQtdTentativas(getQtdTentativas() + 1);
    }

    public void atualizarQtdVidas() {
        setQtdVidas(getQtdVidas() - 1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPalavra() {
        return idPalavra;
    }

    public void setIdPalavra(Long idPalavra) {
        this.idPalavra = idPalavra;
    }

    public String getPalavraMontada() {
        return palavraMontada;
    }

    public void setPalavraMontada(String palavraMontada) {
        this.palavraMontada = palavraMontada;
    }

    public String getLetrasInformadas() {
        return letrasInformadas;
    }

    public void setLetrasInformadas(String letrasInformadas) {
        this.letrasInformadas = letrasInformadas;
    }

    public int getQtdVidas() {
        return qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }

    public int getQtdTentativas() {
        return qtdTentativas;
    }

    public void setQtdTentativas(int qtdTentativas) {
        this.qtdTentativas = qtdTentativas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFeedBackMessage() {
        return feedBackMessage;
    }

    public void setFeedBackMessage(String feedBackMessage) {
        this.feedBackMessage = feedBackMessage;
    }
}
