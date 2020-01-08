package com.viewnext.apiGestionNoticias.restApi;

import java.util.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiusuarios.entidades.Usuario;

// cliente REST de API Json y XML,
// a la vez q es un API general
@RestController
@RequestMapping("/api/main/usuarios")
@CrossOrigin()
public class GestionNoticiasMainController {
	
	final static String url = "172.16.2.14";
	final String uriApiJson = "http://" + url + ":8081/api/usuarios";
	final String uriApiXML = "http://" + url + ":8082/api/xml/usuarios";
	
	public static class ListaUsuario extends ArrayList<Usuario>{}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> leerTodosTodos() {
		
		List<Usuario> listaTotal;
		RestTemplate resTemplate = new RestTemplate();
		
		// invocamos metodo GET http sobre API json 0.0.1
		// y se encarga de des-serializar JSON en un ArrList
		listaTotal = resTemplate.getForObject(uriApiJson, ListaUsuario.class);
		
		// TODO : pedir todos del API XML + añadir a listaTotal
		
		// invocamos metodo GET http sobre API json 0.0.2
		// y se encarga de des-serializar JSON en un ArrList
		// + AÑADIMOS A listaTotal;
		listaTotal.addAll(resTemplate.getForObject(uriApiXML, ListaUsuario.class));
		
		return listaTotal;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = {MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE
						})
	public Usuario crearUsuario(@RequestBody Usuario usuario, 
								@RequestParam String api) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		if("json".contentEquals(api.toLowerCase())) {
			
			usuario = restTemplate.postForObject(uriApiJson, usuario, Usuario.class);	
		}	
		
		else { // deberia ser xml
			usuario = restTemplate.postForObject(uriApiXML, usuario, Usuario.class);
		}
		
		return usuario;
	}
	
	@PostMapping(value="form")
	public Usuario crearUsuarioPorParam(@RequestParam String nombre, 
										@RequestParam String email,
										@RequestParam String password,
										@RequestParam String api) {
		
		Usuario usuario = new Usuario(null, nombre, email, password);
		HttpEntity<Usuario> peticionHttp = new HttpEntity<Usuario>(usuario);
		
		RestTemplate restTemplate = new RestTemplate();
			
		if("json".contentEquals(api.toLowerCase())) {
			// HttpHeaders headers = new HttpHeaders();
			// peticionHttp.getHeaders().setContentType(MediaType.APPLICATION_JSON);

			usuario = restTemplate.postForObject(uriApiJson, usuario, Usuario.class);	
		}	
		
		else { // deberia ser xml
		
			// peticionHttp.getHeaders().setContentType(MediaType.APPLICATION_XML);
			usuario = restTemplate.postForObject(uriApiXML, usuario, Usuario.class);
		}
		
		return usuario;
	}
}
