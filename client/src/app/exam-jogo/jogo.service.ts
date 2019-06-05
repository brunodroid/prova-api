import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JogoService {

  private URL_ROOT = environment.baseUrl + 'jogos';

  constructor(private http: HttpClient) { }

  listarRanking(): any {
    return this.http.get(this.URL_ROOT + '/ranking');
  }

  getJogada(idJogada: any): any {
    return this.http.get(this.URL_ROOT + '/jogada?idJogada=' + idJogada);
  }

  iniciarJogo(qtdVidas: string): any {
    return this.http.post(this.URL_ROOT + '/iniciar?qtdVidas=' + qtdVidas, {});
  }

  tentarLetra(jogada: any, letra: string): any {
    return this.http.post(this.URL_ROOT + '/tentar?idJogada=' + jogada.id + '&letra=' + letra, {});
  }

}
