import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlmacenLocalService {

  constructor() { }

  public guardar(nombre: string, objDatos: any): void {

    // tslint:disable-next-line: prefer-const
    let textoJsonNot = JSON.stringify(objDatos);
    window.localStorage.setItem(nombre, textoJsonNot);

  }

  public leer(nombre: string): any {

    const notGuardadas = window.localStorage.getItem(nombre);
    if (notGuardadas != null) {
      const objDatos = JSON.parse(notGuardadas);
      return objDatos;
    }
  }
}
