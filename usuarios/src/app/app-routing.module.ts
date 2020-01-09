import { NgModule } from '@angular/core';
import { Routes, RouterModule, ActivatedRoute } from '@angular/router';
import { ListaUsuariosComponent } from './lista-usuarios/lista-usuarios.component';
import { RegistroUsuariosComponent } from './registro-usuarios/registro-usuarios.component';
import { MenuPrincipalComponent } from './menu-principal/menu-principal.component';
import { UsuarioModComponent } from './usuario-mod/usuario-mod.component';


const routes: Routes = [
  {path: "menuPrincipal", component: MenuPrincipalComponent},
  {path: "registro", component: RegistroUsuariosComponent},
  {path: "modificar/:id", component: UsuarioModComponent},
  {path: "listarTodos", component: ListaUsuariosComponent},
  {path: "", redirectTo:"/menuPrincipal", pathMatch: "full"}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
