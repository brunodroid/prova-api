import { JogoPlayComponent } from './exam-jogo/jogo-play/jogo-play.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PessoasComponent } from './exam-crud/pessoas/pessoas.component';
import { ContatosComponent } from './exam-crud/contatos/contatos.component';
import { PessoasFormComponent } from './exam-crud/pessoas-form/pessoas-form.component';
import { JogoStartComponent } from './exam-jogo/jogo-start/jogo-start.component';

const routes: Routes = [
  { path: '', component: PessoasComponent },
  { path: 'add', component: PessoasFormComponent },
  { path: 'pessoas/:id', component: PessoasFormComponent },
  { path: 'pessoas/:idPessoa/contatos/add', component: ContatosComponent },
  { path: 'pessoas/:idPessoa/contatos/:id', component: ContatosComponent },
  { path: 'jogos/start', component: JogoStartComponent },
  { path: 'jogos/play/:idJogada', component: JogoPlayComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
