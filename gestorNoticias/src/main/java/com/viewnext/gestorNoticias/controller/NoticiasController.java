package com.viewnext.gestorNoticias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestorNoticias.entities.Noticia;
import com.viewnext.gestorNoticias.model.AlmacenDAONoticias;

@RestController()
@RequestMapping("/api/json/noticias")
@CrossOrigin("*")
public class NoticiasController {

	@Autowired
	private AlmacenDAONoticias daoNoticias;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Noticia getNoticia(@PathVariable Integer id) {
		return daoNoticias.findById(id).orElse(null);
	}
	
	@PostMapping()
	public Noticia crearNoticia(@RequestBody Noticia noticia) {
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un objeto Usuario
		return daoNoticias.save(noticia); // Devuelve con ID
	}
	
	@GetMapping
	public List<Noticia> leerTodos(){
		return daoNoticias.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteNoticia(@PathVariable Integer id) {
		//daoNoticiasTemasUsu.deleteByNoticia(id);
		daoNoticias.deleteById(id);
	}
	
	@PutMapping()
	public Noticia modificarNoticia(@RequestBody Noticia noticia) {
		return daoNoticias.save(noticia);
	}

}
