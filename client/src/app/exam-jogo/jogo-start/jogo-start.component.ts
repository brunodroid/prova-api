import { Router } from '@angular/router';
import { JogoService } from './../jogo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-jogo-start',
  templateUrl: './jogo-start.component.html',
  styleUrls: ['./jogo-start.component.scss']
})
export class JogoStartComponent implements OnInit {

  rankingJogadas: any;
  qtdVidas: any;

  constructor(
    private jogoService: JogoService,
    private router: Router) {
  }

  ngOnInit() {
    this.jogoService.listarRanking().subscribe(
      response => this.rankingJogadas = response
    );
  }

  jogoStart(qtdVidas: string) {
    this.jogoService.iniciarJogo(qtdVidas).subscribe(
      (jogadaGerada => this.router.navigate(['jogos/play', jogadaGerada.id]))
    );
  }
}
