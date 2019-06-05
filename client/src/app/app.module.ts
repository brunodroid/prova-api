import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PessoasComponent } from './exam-crud/pessoas/pessoas.component';
import { ContatosComponent } from './exam-crud/contatos/contatos.component';
import { PessoasFormComponent } from './exam-crud/pessoas-form/pessoas-form.component';
import { JogoStartComponent } from './exam-jogo/jogo-start/jogo-start.component';
import { JogoPlayComponent } from './exam-jogo/jogo-play/jogo-play.component';
import { PessoasService } from './exam-crud/pessoas.service';
import { JogoService } from './exam-jogo/jogo.service';
import { GlobalErrorHandler } from './app-error-handler';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    PessoasComponent,
    ContatosComponent,
    PessoasFormComponent,
    JogoStartComponent,
    JogoPlayComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [
    { provide: ErrorHandler, useClass: GlobalErrorHandler },
    PessoasService,
    JogoService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
