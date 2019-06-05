import { Component, OnInit } from '@angular/core';
import { PessoasService } from '../pessoas.service';

@Component({
  selector: 'app-pessoas',
  templateUrl: './pessoas.component.html',
  styleUrls: ['./pessoas.component.scss']
})
export class PessoasComponent implements OnInit {

  pessoas: any;

  constructor(private pessoasService: PessoasService) {
    this.pessoasService.listarPessoas().subscribe(
      response => this.pessoas = response.content
    );
  }

  ngOnInit() { }

  deletePessoa(pessoa: any) {
    if (confirm('Excluir pessoa (' + pessoa.nome + ')?')) {
      this.pessoasService.deletePessoa(pessoa.id).subscribe(
        () => this.pessoasService.listarPessoas().subscribe(
          response => this.pessoas = response.content
        )
      );
    }
  }
}
