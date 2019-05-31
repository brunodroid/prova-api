package com.elo.prova.exame2.resource;

import com.elo.prova.exame2.model.PessoaContatoModel;
import com.elo.prova.exame2.service.PessoaContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas/{idPessoa}/contatos")
public class PessoaContatoResource {

    @Autowired
    private PessoaContatoService pessoaContatoService;

    @GetMapping
    public Page<PessoaContatoModel> listarPessoaContatos(@PathVariable(value = "idPessoa") Long idPessoa,
                                                         Pageable pageable) {
        return pessoaContatoService.listarPessoaContatos(idPessoa, pageable);
    }

    @GetMapping("/{id}")
    public PessoaContatoModel getPessoaContato(@PathVariable(value = "id") Long id) {
        return pessoaContatoService.getPessoaContato(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaContatoModel addPessoaContato(@PathVariable(value = "idPessoa") Long idPessoa,
                                 @RequestBody PessoaContatoModel pessoaContatoModel) {
        return pessoaContatoService.addPessoaContato(idPessoa, pessoaContatoModel);
    }

    @PutMapping("/update/{id}")
    public PessoaContatoModel updatePessoaContato(@PathVariable Long id, @RequestBody PessoaContatoModel pessoaContatoModel) {
        return pessoaContatoService.updatePessoaContato(id, pessoaContatoModel);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoaContato(@PathVariable Long id) {
        pessoaContatoService.deletePessoaContato(id);
    }

}
