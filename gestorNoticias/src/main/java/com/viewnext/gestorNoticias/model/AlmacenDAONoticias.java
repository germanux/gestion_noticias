package com.viewnext.gestorNoticias.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.viewnext.gestorNoticias.entities.Noticia;

public interface AlmacenDAONoticias {

	@Query(value="SELECT noticia.* FROM noticia_de_tema AS tu INNER JOIN noticia ON noticia.id = tu.id_noticia WHERE tu.id_tema = ?1", nativeQuery = true)
	public List<Noticia> findNoticiasPorTema(Integer idTema);
}
