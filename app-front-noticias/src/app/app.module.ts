import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListaNoticiasComponent } from './lista-noticias/lista-noticias.component';
import { AppRoutingModule } from './app-routing.module';
import { RegistroNoticiaComponent } from './registro-noticia/registro-noticia.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaNoticiasComponent,
    RegistroNoticiaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
