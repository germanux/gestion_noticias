import { Component, OnInit } from '@angular/core';
import { Noticia } from '../entidades/Noticia';
import { NoticiasRestService } from '../noticias-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-noticias',
  templateUrl: './lista-noticias.component.html',
  styleUrls: ['./lista-noticias.component.css']
})
export class ListaNoticiasComponent implements OnInit {

  listaNot: Noticia[];

  noticia: Noticia = new Noticia();

  constructor(private srvNot: NoticiasRestService) {
    this.srvNot = srvNot;
  }

  ngOnInit() {
    const obserConDatos: Observable<Noticia[]> = this.srvNot.getTodos();

    obserConDatos.subscribe( datos => this.listaNot = datos );
  }

  eliminarNoticia(id: number) {
    this.srvNot.eliminar(id).subscribe(() => {
      alert(`Noticia con id ${id} eliminado`);
      this.ngOnInit();
    });
  }

  modificarNoticia(id: number, noticia: Noticia) {
    this.srvNot.modificar(id, noticia).subscribe((u) => {
      alert(`**Noticia** -> ${noticia.titular}, con **ID** -> ${noticia.id} y **MAIL** -> ha sido modificado`);
      this.ngOnInit();
    });
  }
}
