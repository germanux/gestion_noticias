package com.viewnext.gestorNoticias.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiGestionNoticias.entidades.Tema;

@RestController
@RequestMapping("/api/main/temas")
@CrossOrigin
public class TemasController {
	
	final static String url = "http://172.16.2.2:8084/api/temas/";
	
	public static class ListaTemas extends ArrayList<Tema>{

		private static final long serialVersionUID = 1L;}
	
	@GetMapping
	public List<Tema> leerTemas(){
		
		List<Tema> listaTemas = null;
		
		RestTemplate restTemplate = new RestTemplate();
		listaTemas = restTemplate.getForObject(url, ListaTemas.class);
		return listaTemas;
	}
	
	

}
