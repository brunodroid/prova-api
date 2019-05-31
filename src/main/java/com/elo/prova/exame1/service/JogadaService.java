package com.elo.prova.exame1.service;

import com.elo.prova.exame1.model.PalavraModel;
import com.elo.prova.exame1.model.JogadaModel;
import com.elo.prova.exame1.repository.JogadaRepository;
import com.elo.prova.exame1.repository.PalavraRepository;
import com.elo.prova.exame1.enums.Status;
import com.elo.prova.utils.ObjHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class JogadaService {

    @Autowired
    private JogadaRepository jogadaRepository;
    @Autowired
    private PalavraRepository palavraRepository;

    private void validarAtributos(Long idJogada, String letraNormalizada) {

        if (idJogada == null) {
            throw new InvalidParameterException("ID Jogada inválido");
        }

        if (!letraNormalizada.matches("[A-Z]+")) {
            throw new InvalidParameterException("Somente letras de A a Z são aceitas");
        }

        if (letraNormalizada.length() != 1) {
            throw new InvalidParameterException("Informe apenas uma letra");
        }
    }

    private void validarStatus(JogadaModel jogadaModel) {

        if (jogadaModel.getStatus().equals(Status.CANCELLED)) {
            throw new InvalidParameterException("Essa jogada está cancelada");
        }

        if (jogadaModel.getStatus().equals(Status.FINISHED) ||
                jogadaModel.getStatus().equals(Status.GAME_OVER)) {
            throw new InvalidParameterException("Essa jogada está encerrada");
        }
    }

    private void validarTentativa(JogadaModel jogadaModel, String letraNormalizada) {

        if (jogadaModel.getLetrasInformadas().contains(letraNormalizada)) {
            throw new InvalidParameterException(String.format("A letra %s já foi informada", letraNormalizada));
        }
    }

    private JogadaModel findJogadaById(Long idJogada) {

        return jogadaRepository.findById(idJogada)
                .orElseThrow(() -> new InvalidParameterException("Jogada não localizada"));
    }

    private PalavraModel findPalavraById(Long idPalavra) {

        return palavraRepository.findById(idPalavra)
                .orElseThrow(() -> new InvalidParameterException("Palavra não localizada"));
    }

    public JogadaModel iniciar(int qtdVidas) {

        PalavraModel palavraModel = new PalavraModel("TESTE","Unitário");

        palavraRepository.save(palavraModel);

        JogadaModel jogadaModel = new JogadaModel(palavraModel, qtdVidas);

        return jogadaRepository.save(jogadaModel);
    }

    public JogadaModel tentarLetra(Long idJogada, String letraInformada) {

        String letraNormalizada = ObjHelper.normalizarString(letraInformada);

        validarAtributos(idJogada, letraNormalizada);

        JogadaModel jogadaModel = findJogadaById(idJogada);

        validarStatus(jogadaModel);

        validarTentativa(jogadaModel, letraNormalizada);

        jogadaModel.atualizarLetrasInformadas(letraNormalizada);

        PalavraModel palavraModel = findPalavraById(jogadaModel.getIdPalavra());

        String mensagemComplementar = String.format("A letra %s ", letraNormalizada);

        if (palavraModel.getPalavra().contains(letraNormalizada)) {

            String palavra = palavraModel.getPalavra();

            char letra = letraNormalizada.charAt(0);

            char[] letrasMontadas = jogadaModel.getPalavraMontada().toCharArray();

            for (int i = 0; i < palavra.length(); i++) {

                if (palavra.charAt(i) == letra) {
                    letrasMontadas[i] = letra;
                }
            }

            jogadaModel.setPalavraMontada(String.valueOf(letrasMontadas));

            mensagemComplementar = mensagemComplementar.concat("está correta!");

        } else {
            jogadaModel.atualizarQtdVidas();

            mensagemComplementar = mensagemComplementar.concat("não faz parte da palavra.");
        }

        jogadaModel.atualizarQtdTentativas();

        jogadaModel.atualizarStatus(palavraModel);

        jogadaModel.atualizarFeedBackMessage(palavraModel, mensagemComplementar);

        return jogadaRepository.save(jogadaModel);
    }

    public JogadaModel cancelar(Long idJogada) {

        JogadaModel jogadaModel = findJogadaById(idJogada);

        validarStatus(jogadaModel);

        jogadaModel.setStatus(Status.CANCELLED);
        jogadaModel.setFeedBackMessage("Jogo cancelado.");

        return jogadaRepository.save(jogadaModel);
    }
}
