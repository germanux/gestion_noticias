package com.viewnext.apiGestionNoticias.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.apiGestionNoticias.entidades.Usuario;


public interface AlmacenDAOUsuarios 
	extends JpaRepository<Usuario, Integer> {

}
