package com.elo.prova.exame1.service;

import com.elo.prova.exame1.model.PalavraModel;
import com.elo.prova.exame1.model.JogadaModel;
import com.elo.prova.exame1.repository.JogadaRepository;
import com.elo.prova.exame1.repository.PalavraRepository;
import com.elo.prova.exame1.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.text.Normalizer;

@Service
public class JogadaService {

    @Autowired
    private JogadaRepository jogadaRepository;
    @Autowired
    private PalavraRepository palavraRepository;

    private void validarStatus(JogadaModel jogadaModel) {

        if (jogadaModel.getStatus().equals(Status.CANCELLED)) {
            throw new InvalidParameterException("Essa jogada está cancelada");
        }

        if ((jogadaModel.getStatus().equals(Status.FINISHED) ||
                (jogadaModel.getStatus().equals(Status.GAME_OVER)))) {
            throw new InvalidParameterException("Essa jogada está encerrada");
        }
    }

    private JogadaModel findJogadaById(Long idJogada) {

        return jogadaRepository.findById(idJogada)
                .orElseThrow(() -> new InvalidParameterException("Jogada não localizada"));
    }

    public JogadaModel iniciar(int qtdVidas) {

        //TODO = geração de palavras
        PalavraModel palavraModel = new PalavraModel("TESTE","Unitário");

        palavraRepository.save(palavraModel);

        JogadaModel jogadaModel = new JogadaModel(palavraModel, qtdVidas);

        jogadaRepository.save(jogadaModel);

        return jogadaModel;
    }

    public JogadaModel tentarLetra(Long idJogada, String letraInformada) {

        String letraNormalizada = Normalizer.normalize(letraInformada, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toUpperCase();

        if (idJogada == null) {
            throw new InvalidParameterException("ID Jogada inválido");
        }

        if (!letraNormalizada.matches("[A-Z]+")) {
            throw new InvalidParameterException("Somente letras de A a Z são aceitas");
        }

        if (letraNormalizada.length() != 1) {
            throw new InvalidParameterException("Informe apenas uma letra");
        }

        JogadaModel jogadaModel = findJogadaById(idJogada);

        validarStatus(jogadaModel);

        if (jogadaModel.getLetrasInformadas().contains(letraNormalizada)) {
            throw new InvalidParameterException(String.format("A letra %s já foi informada", letraNormalizada));
        }

        jogadaModel.setLetrasInformadas(jogadaModel.getLetrasInformadas()
                .concat(String.format(" %s", letraNormalizada)).trim()
                .replace(" ", ","));

        PalavraModel palavraModel = palavraRepository.findById(jogadaModel.getIdPalavra())
                .orElseThrow(() -> new InvalidParameterException("Palavra não localizada"));

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
            jogadaModel.setQtdVidas(jogadaModel.getQtdVidas() - 1);

            mensagemComplementar = mensagemComplementar.concat("não faz parte da palavra.");
        }

        jogadaModel.setQtdTentativas(jogadaModel.getQtdTentativas() + 1);

        if (palavraModel.getPalavra().equals(jogadaModel.getPalavraMontada())) {
            jogadaModel.setStatus(Status.FINISHED);
            jogadaModel.setFeedBackMessage(String.format("Parabéns! :D Você acertou a palavra %s com %d tentativa(s).",
                    palavraModel.getPalavra(),
                    jogadaModel.getQtdTentativas()));

        } else if (jogadaModel.getQtdVidas() == 0) {
            jogadaModel.setStatus(Status.GAME_OVER);
            jogadaModel.setFeedBackMessage(String.format("Você perdeu! :( A palavra era: %s",
                    palavraModel.getPalavra()));

        } else {
            jogadaModel.setStatus(Status.RUNNING);
            jogadaModel.setFeedBackMessage(String.format("%s Você ainda possui %d chance(s).",
                    mensagemComplementar,
                    jogadaModel.getQtdVidas()));
        }

        jogadaRepository.save(jogadaModel);

        return jogadaModel;
    }

    public JogadaModel cancelar(Long idJogada) {

        JogadaModel jogadaModel = findJogadaById(idJogada);

        validarStatus(jogadaModel);

        jogadaModel.setStatus(Status.CANCELLED);
        jogadaModel.setFeedBackMessage("Jogo cancelado.");

        jogadaRepository.save(jogadaModel);

        return jogadaModel;
    }
}
