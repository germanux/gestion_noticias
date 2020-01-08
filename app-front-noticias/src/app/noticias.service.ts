import { Injectable } from '@angular/core';
import { Noticia } from './entidades/Noticia';
import { AlmacenLocalService } from './almacen-local.service';

@Injectable({
  providedIn: 'root'
})
export class NoticiasService {
  listaNoticia: Noticia[];

  constructor(public almSrv: AlmacenLocalService) {
    this.listaNoticia = [{
      id: 1,
      titular: 'Javi Terrorista',
      fecha: '10/10/2020',
      cabecera: 'Choni mostoles',
      idTemaRef: 1
    }, {
      id: 2,
      titular: 'Javi Terrorista del Git',
      fecha: '10/Sept/2020',
      cabecera: 'Javi Terro',
      idTemaRef: 2
    }];

    this.listaNoticia = almSrv.leer('noticias');
  }

  public getTodasNoticias(): Noticia[] {
    this.listaNoticia.push({
      id: this.listaNoticia.length,
      titular: 'Javi Terrorista',
      fecha: '10/10/2020',
      cabecera: 'chupa microfono',
      idTemaRef: 1
    });

    this.almSrv.guardar('noticias', this.listaNoticia);

    return this.listaNoticia;
  }
}
