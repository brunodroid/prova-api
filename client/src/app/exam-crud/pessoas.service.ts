import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PessoasService {

  private URL_ROOT = environment.baseUrl + 'pessoas';

  constructor(private http: HttpClient) { }

  listarPessoas(): any {
    return this.http.get(this.URL_ROOT);
  }

  getPessoa(idPessoa: any): any {
    return this.http.get(this.URL_ROOT + '/' + idPessoa);
  }

  savePessoa(pessoa: any): any {

    if (pessoa.id == null) {
      return this.http.post(this.URL_ROOT + '/add', pessoa);
    } else {
      return this.http.put(this.URL_ROOT + '/update/' + pessoa.id, pessoa);
    }
  }

  deletePessoa(idPessoa: any): any {
    return this.http.delete(this.URL_ROOT + '/delete/' + idPessoa);
  }

  getPessoaContato(idPessoa: any, idContato: any): any {
    return this.http.get(this.URL_ROOT + '/' + idPessoa + '/contatos/' + idContato);
  }

  savePessoaContato(idPessoa: any, contato: any): any {

    if (contato.id == null) {
      return this.http.post(this.URL_ROOT + '/' + idPessoa + '/contatos/add', contato);
    } else {
      return this.http.put(this.URL_ROOT + '/' + idPessoa + '/contatos/update/' + contato.id, contato);
    }
  }

  deletePessoaContato(idPessoa: any, contato: any): any {
    return this.http.delete(this.URL_ROOT + '/' + idPessoa + '/contatos/delete/' + contato);
  }
}
