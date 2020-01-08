package com.viewnext.apiGestionNoticias.restApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiGestionNoticias.entidades.Tema;
import com.viewnext.apiGestionNoticias.entidades.Usuario;
import com.viewnext.apiGestionNoticias.model.AlmacenDAOUsuarios;



// cliente REST de API Json y XML,
// a la vez q es un API general
@RestController
@RequestMapping("/api/main/usuarios")
@CrossOrigin()
public class GestionNoticiasMainController {
	
	final static String url = "172.16.2.14";
	final String uriApiJson = "http://" + url + ":8081/api/usuarios";
	// final String uriApiXML = "http://" + url + ":8082/api/xml/usuarios";
	
	@Autowired
	private AlmacenDAOUsuarios dao;
	private AlmacenDAOTemasDeUsuarios temasDeUsuariosDao;
	
	public static class ListaUsuario extends ArrayList<Usuario>{

		private static final long serialVersionUID = 1L;}
	
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
		//listaTotal.addAll(resTemplate.getForObject(uriApiXML, ListaUsuario.class));
		
		return listaTotal;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = {MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE
						})
	public Usuario crearUsuario(@RequestBody Usuario usuario, 
								@RequestParam String api) {
		
		RestTemplate restTemplate = new RestTemplate();
		usuario = restTemplate.postForObject(uriApiJson, usuario, Usuario.class);	
		
		return usuario;
	}
	
	@PostMapping(value="form")
	public Usuario crearUsuarioPorParam(@RequestParam String nombre, 
										@RequestParam String email,
										@RequestParam String password) {
		
		Usuario usuario = new Usuario(null, nombre, email, password);
		// HttpEntity<Usuario> peticionHttp = new HttpEntity<Usuario>(usuario);
		
		RestTemplate restTemplate = new RestTemplate();

		usuario = restTemplate.postForObject(uriApiJson, usuario, Usuario.class);	
			
		return usuario;
	}
	
	/*
	@PostMapping(value="form")
	public Usuario modificarUsuarioPorParam(@RequestParam Integer id, 
										@RequestParam String nombre, 
										@RequestParam String email,
										@RequestParam String password) {
		
		System.out.println(">>>> GET Tema - ID RECIBIDO " + id);
		
		Usuario usuarioModificado = new Usuario();

		Optional<Usuario> usuarioAModificar = dao.findById(id);
		usuarioAModificar.ifPresent(user -> {
			user.setNombre(nombre);
			user.setEmail(email);
			user.setPassword(password);
			
			dao.save(user);
		});
			
		Usuario usuario = new Usuario(null, nombre, email, password);
		HttpEntity<Usuario> peticionHttp = new HttpEntity<Usuario>(usuario);
		
		RestTemplate restTemplate = new RestTemplate();

		usuario = restTemplate.postForObject(uriApiJson, usuario, Usuario.class);	
			
		return usuario;
	} */
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT )
	public Usuario modificarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioAModificar) {
		System.out.println(">>>> MODIFICAR ID RECIBIDO " + id);

		usuarioAModificar.setId(id);		
		return dao.save(usuarioAModificar);
	}
	
	@DeleteMapping(value="/{id}") 
	public void eliminarUsuario(@PathVariable Integer id) {
		System.out.println(">>>> ELIMINAR ID RECIBIDO " + id);

		dao.deleteById(id);
	}

	@DeleteMapping() 
	public void eliminarUsuario(@RequestBody Usuario usuario) {
		System.out.println(">>>> DELETE ");
		dao.delete(usuario);
		// Es equivalente a :
		// dao.deleteById(t.getId());
	}
	
	@PostMapping()
	public Usuario anadirTemaPrefAUsuario(@RequestParam Integer usuarioId, 
										@RequestParam Integer temaId) {
		Usuario usuario = new Usuario(null, nombre, email, password);
		// HttpEntity<Usuario> peticionHttp = new HttpEntity<Usuario>(usuario);
		
		RestTemplate restTemplate = new RestTemplate();

		usuario = restTemplate.postForObject(uriApiJson, usuario, Usuario.class);	
			
		return usuario;
	}
}
