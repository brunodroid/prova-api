package com.elo.prova.exame2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rg;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dataNascimento;

    @OneToMany(mappedBy = "pessoaModel", cascade = CascadeType.ALL)
    private Set<PessoaContatoModel> pessoaContatos;

    public PessoaModel() {
    }

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<PessoaContatoModel> getPessoaContatos() {
        return pessoaContatos;
    }

    public void setPessoaContatos(Set<PessoaContatoModel> pessoaContatos) {
        this.pessoaContatos = pessoaContatos;
    }
}
