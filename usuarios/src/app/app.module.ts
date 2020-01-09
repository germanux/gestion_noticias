import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule} from './app-routing.module';
import {RouterModule, Routes, ActivatedRoute} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { RegistroUsuariosComponent } from './registro-usuarios/registro-usuarios.component';
import { ListaUsuariosComponent } from './lista-usuarios/lista-usuarios.component';
import { MenuPrincipalComponent } from './menu-principal/menu-principal.component';
import { UsuarioModComponent } from './usuario-mod/usuario-mod.component';



@NgModule({
  declarations: [
    AppComponent,
    RegistroUsuariosComponent,
    MenuPrincipalComponent,
    UsuarioModComponent,
    ListaUsuariosComponent,
    UsuarioModComponent,
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
