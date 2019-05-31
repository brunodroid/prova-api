package com.elo.prova.exame1.model;

import com.elo.prova.exame1.utils.Status;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class JogadaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPalavra;
    private String palavraMontada;
    private String letrasInformadas;
    private int qtdVidas;
    private int qtdTentativas;
    private Status status;
    private String feedBackMessage;

    public JogadaModel() {}

    public JogadaModel(PalavraModel palavraModel, int qtdVidas) {
        this.idPalavra = palavraModel.getId();
        this.palavraMontada = "";
        this.letrasInformadas = "";
        this.qtdVidas = qtdVidas;
        this.qtdTentativas = 0;
        this.status = Status.START;
        this.feedBackMessage = String.format("Jogo iniciado. A dica é: %s. Boa Sorte!", palavraModel.getDica());

        while (palavraModel.getTamanho() > this.palavraMontada.length()) {
            this.palavraMontada = this.palavraMontada.concat("_");
        }
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
