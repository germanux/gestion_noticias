import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';
// import { timingSafeEqual } from 'crypto';

@Component({
  selector: 'app-registro-usuarios',
  templateUrl: './registro-usuarios.component.html',
  styleUrls: ['./registro-usuarios.component.css']
})
export class RegistroUsuariosComponent implements OnInit {

  usuario: Usuario;
  nombre = null;
  email = null;
  password = null;
  idTemaPreferido = null;

  constructor(public usuSrv: UsuariosRestService) { }

  ngOnInit() {
    this.nombre = null ;
    this.email = null;
    this.password = null;
    this.idTemaPreferido = null;
  }

  registrar(){
    //Creación del objeto Usuario
    this.usuario = new Usuario();
    this.usuario.nombre = this.nombre ;
    this.usuario.email = this.email;
    this.usuario.password = this.password;
    this.usuario.idTemaPreferido = this.idTemaPreferido;

    //Llama al servicio Rest
    this.usuSrv.registro(this.usuario).subscribe(usuRegistrado =>{ 
      this.usuario = usuRegistrado; 
    alert(`Usuario registrado con ID: ${usuRegistrado.id}`);
    this.ngOnInit()});

    
  }

}
