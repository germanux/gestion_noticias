import { Component, OnInit } from '@angular/core';
import { Noticia } from '../entidades/Noticia';
import { NoticiasRestService } from '../noticias-rest.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registro-noticia',
  templateUrl: './registro-noticia.component.html',
  styleUrls: ['./registro-noticia.component.css']
})
export class RegistroNoticiaComponent implements OnInit {

  fecha = '20/20/2020';
  titular = 'Javi Terro';
  cabecera = 'Vamos Atleti Campeon';
  idTemaRef = 1;

  estaRegistrada = false;

  noticia: Noticia = new Noticia();

  constructor(private notRest: NoticiasRestService) {
    this.noticia = new Noticia();
  }

  ngOnInit() {
  }

  enviarDatos() {

    this.notRest.registro(this.noticia).subscribe( (notRecibida) => {
      this.noticia = notRecibida;
      this.estaRegistrada = (typeof this.noticia.id !== undefined);
      });
  }

  pulsar() {
    this.noticia.titular = this.titular;
  }

}
