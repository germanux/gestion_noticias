import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaUsuariosComponent } from './lista-usuarios/lista-usuarios.component';


const routes: Routes = [
  {path: "listarTodos", component: ListaUsuariosComponent}
];

@NgModule({
  declarations: [ListaUsuariosComponent],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
