import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  listaUsu: Usuario[];
  usuario: Usuario;
  usuarioModif: Usuario;
  id: number;

  constructor(public srvUsu: UsuariosRestService) { }

  ngOnInit() {

    let obserConDatos: Observable<Usuario[]>= this.srvUsu.getTodos();
    //Le decimos al objeto observable que cuando reciba datos, 
    //invoque a esta función callback
    obserConDatos.subscribe(datos => this.listaUsu = datos);

  }

  eliminar(id: number){

    this.srvUsu.delete(id).subscribe(() => {alert(`Usuario con id ${id} eliminado`);
    this.ngOnInit();});

  }



}
