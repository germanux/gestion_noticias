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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiGestionNoticias.entidades.Tema;
import com.viewnext.apiGestionNoticias.entidades.TemaDeUsuario;
import com.viewnext.apiGestionNoticias.entidades.TemaDeUsuarioPK;
import com.viewnext.apiGestionNoticias.entidades.Usuario;
import com.viewnext.apiGestionNoticias.model.AlmacenDAOTemasDeUsuarios;
import com.viewnext.apiGestionNoticias.model.AlmacenDAOUsuarios;

// cliente REST de API Json y XML,
// a la vez q es un API general
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin()
public class GestionUsuariosController {
	
	// final static String url = "172.16.2.17";
	// final String uriApiJson = "http://" + url + ":8081/api/usuarios";
	// final String uriApiXML = "http://" + url + ":8082/api/xml/usuarios";
	
	@Autowired
	private AlmacenDAOUsuarios dao;
	private AlmacenDAOTemasDeUsuarios temasDeUsuariosDao;
	
	public static class ListaUsuario extends ArrayList<Usuario>{

		private static final long serialVersionUID = 1L;}
	
	@RequestMapping(value="/{id}", method = {RequestMethod.GET /*, RequestMethod.POST */} )
	public Usuario getUsuario(@PathVariable Integer id) {
		System.out.println(">>>> GET - ID RECIBIDO " + id);
		//TODO Optional
		Optional<Usuario> usu = dao.findById(id);
		return usu.orElse(null);
	}
	
	@GetMapping
	public List<Usuario> leerTodos() {
		return dao.findAll();
	}
	
	@PostMapping()
	public Usuario crearUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
	
	/** Captura un formulario
	 * 
	 * @param id
	 * @param name
	 */
	@PostMapping(value="/formulario") // Subruta /formulario porque la raiz con POST ya está cogida
	public Usuario crearUsuarioPorParam(
			//@RequestParam Integer id, 
			@RequestParam (name="nombre") String elNombreDelUsu, 
			@RequestParam String email,
			@RequestParam String password) 
	{
		Usuario usu = new Usuario(null, elNombreDelUsu, email, password);
		System.out.println(">>>> crearUsuarioPorParam ");
		
		return dao.save(usu);
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
	
	@PutMapping()
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT )
	public Usuario modificarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		System.out.println(">>>> MODIFICAR ID RECIBIDO " + id);

		usuario.setId(id);		
		return dao.save(usuario);
	}
	
	@DeleteMapping(value="/{id}") 
	public void eliminarUsuario(@PathVariable Integer id) {
		System.out.println(">>>> ELIMINAR ID RECIBIDO " + id);
		
		temasDeUsuariosDao.deleteByUsuario(id);
		dao.deleteById(id);
	}

	@DeleteMapping() 
	public void eliminarUsuario(@RequestBody Usuario usuario) {
		System.out.println(">>>> DELETE ");
		dao.delete(usuario);
		// Es equivalente a :
		// dao.deleteById(usuario.getId());
	}
	
	@GetMapping(value="/{idUsuario}/temas_usu")
	public List<TemaDeUsuario> getTemasDeUsuario(@PathVariable Integer idUsuario) 
	{
		System.out.println(">>>> getTemasDeUsuario - ID RECIBIDO " + idUsuario);
		
		List<TemaDeUsuario> temasUsu = //  daoTemasUsu.findTemasDeUnUsuario(idUsuario);
				temasDeUsuariosDao.findTemasPorUsuarioHQL(idUsuario);
		return temasUsu;
	}
	
	@PostMapping(value = "/{id}/temas/{idt}")
	public TemaDeUsuario addTemaDeUsuario(@PathVariable Integer idUsuario,
			@PathVariable(name = "idt") Integer idTema) {
		
		TemaDeUsuario nuevoTema = new TemaDeUsuario(idUsuario, idTema);
				
		return temasDeUsuariosDao.save(nuevoTema);
	}
	
	@DeleteMapping(value = "/{id}/temas/{idt}")
	public String deleteTemaDeUsuario(@PathVariable Integer idUsuario,
			@PathVariable(name = "idt") Integer idTema) {
		
		temasDeUsuariosDao.deleteById(new TemaDeUsuarioPK(idUsuario, idTema));
		//daoTemasUsu.delete(id, idTema);
		return "Tema de usuario borrado";
	}
}
