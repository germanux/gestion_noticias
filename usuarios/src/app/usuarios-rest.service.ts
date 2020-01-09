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

  getTodos():Observable<Usuario[]>{
    let observableHttp = this.clienteHttp.get<Usuario[]>(this.url);

    return observableHttp;
  }

  getUsuario(id: number):Observable<Usuario>{
    let observableHttp = this.clienteHttp.get<Usuario>(`${this.url}/${id}`);

    return observableHttp;
  }

  
  delete(id: number): Observable<any>{

    let observableHttp = this.clienteHttp.delete<any>(`${this.url}/${id}`);

    return observableHttp;
  }

  modify(usuario: Usuario): Observable<Usuario>{

    let observableHttp = this.clienteHttp.put<Usuario>(`${this.url}/${usuario.id}`, usuario);

    return observableHttp;
  }
}
