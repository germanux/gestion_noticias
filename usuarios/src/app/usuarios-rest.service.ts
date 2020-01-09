import { Injectable } from '@angular/core';
import { Usuario } from './entidades/Usuario';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosRestService {

  url = "http://localhost:8081/api/json/usuarios"
  // url = "http://localhost:8081/api/main/usuarios"
  

  constructor(public clienteHttp: HttpClient) { }

  // Registro del usuario en BBDD
  registro(usuario: Usuario): Observable<Usuario>{
    
    let observableHttp = this.clienteHttp.post<Usuario>(this.url,usuario);

    return observableHttp;
  }
}
