import { Injectable } from '@angular/core';
import { AlmacenLocalService } from './almacen-local.service';
import { Noticia } from './entidades/Noticia';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NoticiasRestService {

  url = 'http://localhost:8081/api/json/noticias';

  listaNoticia: Noticia[];

  noticia: Noticia = new Noticia();

  constructor(public almSrv: AlmacenLocalService, public clienteHttp: HttpClient) { }

  getTodos(): Observable<Noticia[]> {
    const observableHttp = this.clienteHttp.get<Noticia[]>(this.url);
    return observableHttp;
  }

  registro(noticia: Noticia): Observable<Noticia> {
    return this.clienteHttp.post<Noticia>(this.url, noticia);
  }

  eliminar(id: number): Observable<any> {
    return this.clienteHttp.delete<any>(`${this.url}/${id}`);
  }

  modificar(id: number, noticia: Noticia): Observable<any> {
    return this.clienteHttp.put(`${this.url}/${id}`, noticia);
  }
}
