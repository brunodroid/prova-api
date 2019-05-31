package com.elo.prova.exame1.resource;

import com.elo.prova.exame1.model.JogadaModel;
import com.elo.prova.exame1.service.JogadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogo")
public class JogadaResource {

    @Autowired
    private JogadaService jogadaService;

    @GetMapping("/iniciar/{qtdVidas}")
    public JogadaModel iniciar(@PathVariable int qtdVidas) {

        return jogadaService.iniciar(qtdVidas);
    }

    @PutMapping("/tentar")
    public JogadaModel tentarLetra(@RequestParam Long idJogada,
                                   @RequestParam String letra){

        return jogadaService.tentarLetra(idJogada, letra);
    }

    @PostMapping("/cancelar")
    public JogadaModel cancelar(@RequestParam Long idJogada) {

        return jogadaService.cancelar(idJogada);
    }
}
