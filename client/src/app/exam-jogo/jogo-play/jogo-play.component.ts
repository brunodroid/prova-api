import { ActivatedRoute } from '@angular/router';
import { JogoService } from './../jogo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-jogo-play',
  templateUrl: './jogo-play.component.html',
  styleUrls: ['./jogo-play.component.scss']
})
export class JogoPlayComponent implements OnInit {

  jogada: any;
  jogadaAberta: boolean;
  letraInformada: any;
  imagePath: string;

  constructor(
    private jogoService: JogoService,
    private route: ActivatedRoute) {
    this.jogada = this.route.params.subscribe(params => {
      this.jogoService.getJogada(params.idJogada).subscribe(
        (response: any) => {
          this.jogada = response;
          this.atualizarImage();
        });
    });
  }

  ngOnInit() { }

  atualizarImage() {
    if (this.jogada.status === 'FINISHED') {
      this.imagePath = '../../../assets/personagens/' + this.jogada.idPalavra + '.png';
    } else if (this.jogada.status === 'GAME_OVER') {
      this.imagePath = '../../../assets/personagens/game-over.png';
    }
  }

  isJogadaAberta(): boolean {
    return (this.jogada.status === 'START' || this.jogada.status === 'RUNNING');
  }

  tentarLetra(letra: string) {
    this.jogoService.tentarLetra(this.jogada, letra).subscribe(
      (response: any) => {
        this.jogada = response;
        this.atualizarImage();
      });

    this.letraInformada = null;
  }
}
