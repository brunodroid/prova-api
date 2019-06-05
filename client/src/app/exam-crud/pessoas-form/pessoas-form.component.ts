import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PessoasService } from '../pessoas.service';

@Component({
  selector: 'app-pessoas-form',
  templateUrl: './pessoas-form.component.html',
  styleUrls: ['./pessoas-form.component.scss']
})
export class PessoasFormComponent implements OnInit {

  pessoa: any;
  idPessoa: any;
  displayContatos = false;

  constructor(
    private pessoasService: PessoasService,
    private route: ActivatedRoute,
    private router: Router) {
    this.pessoa = {};
    this.route.params.subscribe(params => {
      if (params.id != null) {
        this.idPessoa = params.id;
        this.displayContatos = true;

        this.pessoasService.getPessoa(this.idPessoa).subscribe(
          response => this.pessoa = response
        );
      }
    });
  }

  ngOnInit() { }

  navegarAdd() {
    this.router.navigate(['pessoas/' + this.pessoa.id + '/contatos/add']);
  }

  savePessoa(pessoa: any): any {
    this.pessoasService.savePessoa(pessoa).subscribe((response: any) => {
      this.pessoa = response;
      const rotaDestino = (pessoa.id === '') ? 'pessoas/' + this.pessoa.id : '';
      this.router.navigate([rotaDestino]);
    });
  }
}
