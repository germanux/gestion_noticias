package com.viewnext.gestorNoticias.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiGestionNoticias.entidades.Tema;
import com.viewnext.gestorNoticias.entities.Noticia;

@RestController
@RequestMapping("/api/main/noticias")
@CrossOrigin
public class NoticiasMainController {

	final static String url = "172.16.2.17";
	
	final static String uriApiJson = "http://" + url + ":8081/api/json/noticias";
	
	public static class ListaUsuario extends ArrayList<Noticia> {

		private static final long serialVersionUID = -2471719372400122954L;
		
	}
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Noticia> leerTodosTodos() {
		
		List<Noticia> listaTotal;

		RestTemplate restTemplate = new RestTemplate();

		listaTotal = restTemplate.getForObject(uriApiJson, ListaUsuario.class);

		return listaTotal;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Noticia crearUsuario(@RequestBody Noticia noticia, @RequestParam String api) {
		
		RestTemplate restTemplate = new RestTemplate();

		noticia = restTemplate.postForObject(uriApiJson, noticia, Noticia.class);

		return noticia;
	}
	
	@PostMapping(value="/form")
	public Noticia crearUsuarioPorParam(@RequestParam String titular, @RequestParam String cabecera, @RequestParam Date fecha, @RequestParam String api) {
		
		Noticia noticia = new Noticia(null, titular, cabecera, fecha);

		RestTemplate restTemplate = new RestTemplate();
	
		noticia = restTemplate.postForObject(uriApiJson, noticia, Noticia.class);

		return noticia;
	}
}
