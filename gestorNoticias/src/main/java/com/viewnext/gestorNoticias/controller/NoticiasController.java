package com.viewnext.gestorNoticias.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestorNoticias.entities.Noticia;
import com.viewnext.gestorNoticias.model.AlmacenDAONoticias;

@RestController()
@RequestMapping("/api/json/noticias")
@CrossOrigin("*")
public class NoticiasController {

	final static String url = "172.16.2.17";
	
	final static String uriApiJson = "http://" + url + ":8083/api/json/noticias";
	
	public static class ListaNoticia extends ArrayList<Noticia> {

		private static final long serialVersionUID = -2471719372400122954L;
		
	}
	
	@Autowired
	private AlmacenDAONoticias daoNoticias;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Noticia getNoticia(@PathVariable Integer id) {
		return daoNoticias.findById(id).orElse(null);
	}
	
	@PostMapping()
	public Noticia crearNoticia(@RequestBody Noticia noticia) {
		return daoNoticias.save(noticia);
	}
	
	@GetMapping
	public List<Noticia> leerTodos(){
		return daoNoticias.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteNoticia(@PathVariable Integer id) {
		daoNoticias.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Noticia modificarUsuario(@PathVariable Integer id, @RequestBody Noticia noticia) {
	
		noticia.setId(id);
		return daoNoticias.save(noticia);
	}

}
