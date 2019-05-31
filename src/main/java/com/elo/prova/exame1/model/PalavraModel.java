package com.elo.prova.exame1.model;

import javax.persistence.*;

@Entity
public class PalavraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String palavra;
    private int tamanho;
    private String dica;

    public PalavraModel() {
        this.palavra = "TESTE";
        this.tamanho = 5;
        this.dica = "Unitário";
    }

    public PalavraModel(String palavra, String dica) {
        this.palavra = palavra.trim();
        this.tamanho = this.palavra.length();
        this.dica = dica.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra.trim().toUpperCase();
        this.tamanho = this.palavra.length();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
}
