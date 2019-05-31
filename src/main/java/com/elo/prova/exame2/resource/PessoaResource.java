package com.elo.prova.exame2.resource;

import com.elo.prova.exame2.model.PessoaModel;
import com.elo.prova.exame2.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public Page<PessoaModel> listarPessoas(Pageable pageable) {
        return pessoaService.listarPessoas(pageable);
    }

    @GetMapping("/{id}")
    public PessoaModel getPessoa(@PathVariable Long id) {
        return pessoaService.getPessoa(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel addPessoa(@RequestBody PessoaModel pessoaModel) {
        return pessoaService.addPessoa(pessoaModel);
    }

    @PutMapping("/update/{id}")
    public PessoaModel updatePessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {
        return pessoaService.updatePessoa(id, pessoaModel);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }
}
