package com.elo.prova.exame1.model;

import javax.persistence.*;

@Entity
public class PalavraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String palavra;
    private String dica;

    public PalavraModel() { }

    public PalavraModel(String palavra, String dica) {
        this.palavra = palavra.trim();
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
        this.palavra = palavra;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
}
