import { Component, OnInit } from '@angular/core';
import { UsuariosRestService } from '../usuarios-rest.service';
import { Usuario } from '../entidades/Usuario';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-usuario-mod',
  templateUrl: './usuario-mod.component.html',
  styleUrls: ['./usuario-mod.component.css']
})
export class UsuarioModComponent implements OnInit {

  usuario: Usuario = new Usuario();
  usuModif: Usuario = new Usuario();
  sId: string = null;
  id: number;

  constructor(public srvUsu: UsuariosRestService,private rutaActiva: ActivatedRoute) { }

  ngOnInit() {
    this.sId =this.rutaActiva.snapshot.paramMap.get('id');
    this.id = Number(this.sId);
    let obserConDatos: Observable<Usuario>= this.srvUsu.getUsuario(this.id);
    obserConDatos.subscribe(datos => this.usuModif = datos);
  }

  modificar(usuario: Usuario){

    this.srvUsu.modify(usuario).subscribe(usuRecibido => {
    this.usuario = usuRecibido;
    alert(`Usuario con id ${usuRecibido.id} modificado`);
    this.ngOnInit();
  });

  }

}
