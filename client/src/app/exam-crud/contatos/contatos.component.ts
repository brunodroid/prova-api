import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PessoasService } from '../pessoas.service';

@Component({
  selector: 'app-contatos',
  templateUrl: './contatos.component.html',
  styleUrls: ['./contatos.component.scss']
})
export class ContatosComponent implements OnInit {

  pessoa: any;
  contato: any;
  editMode = false;

  constructor(
    private pessoasService: PessoasService,
    private route: ActivatedRoute,
    private router: Router) {
    this.contato = {};
    this.pessoa = {};
    this.route.params.subscribe((params: any) => {

      this.pessoasService.getPessoa(params.idPessoa)
        .subscribe(response => this.pessoa = response);

      if (params.id != null) {
        this.editMode = true;

        this.pessoasService.getPessoaContato(params.idPessoa, params.id)
          .subscribe(response => this.contato = response);
      }
    });
  }

  ngOnInit() { }

  savePessoaContato(pessoa: any, contato: any) {
    this.pessoasService.savePessoaContato(pessoa.id, contato).subscribe(
      () => this.router.navigate(['pessoas/' + pessoa.id]));
  }

  deletePessoaContato(pessoa: any, contato: any) {
    if (confirm('Excluir contato (' + contato.nome + ')?')) {
      this.pessoasService.deletePessoaContato(pessoa.id, contato.id).subscribe(
        () => this.router.navigate(['pessoas/' + pessoa.id]));
    }
  }
}
