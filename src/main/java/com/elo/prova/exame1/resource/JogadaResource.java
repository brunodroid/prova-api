package com.elo.prova.exame1.resource;

import com.elo.prova.exame1.model.JogadaModel;
import com.elo.prova.exame1.service.JogadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jogos")
public class JogadaResource {

    @Autowired
    private JogadaService jogadaService;

    @GetMapping("/jogada")
    public  JogadaModel getJogada(@RequestParam("idJogada") Long idJogada) {
        return jogadaService.findJogadaById(idJogada);
    }

    @GetMapping("/ranking")
    public List<JogadaModel> listarRanking() {

        return jogadaService.listarRanking();
    }

    @PostMapping("/iniciar")
    public JogadaModel iniciar(@RequestParam int qtdVidas) {

        return jogadaService.iniciar(qtdVidas);
    }

    @PostMapping("/tentar")
    public JogadaModel tentarLetra(@RequestParam Long idJogada,
                                   @RequestParam String letra){

        return jogadaService.tentarLetra(idJogada, letra);
    }

    @PostMapping("/cancelar")
    public JogadaModel cancelar(@RequestParam Long idJogada) {

        return jogadaService.cancelar(idJogada);
    }
}
