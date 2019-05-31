package com.elo.prova.exame2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rg;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoaModel", cascade = CascadeType.ALL)
    private Set<PessoaContatoModel> pessoaContatos;

    public PessoaModel() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<PessoaContatoModel> getPessoaContatos() {
        return pessoaContatos;
    }

    public void setPessoaContatos(Set<PessoaContatoModel> pessoaContatos) {
        this.pessoaContatos = pessoaContatos;
    }
}
