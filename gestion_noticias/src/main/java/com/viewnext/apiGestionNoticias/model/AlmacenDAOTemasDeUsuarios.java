package com.viewnext.apiGestionNoticias.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.apiGestionNoticias.entidades.TemaDeUsuario;
import com.viewnext.apiGestionNoticias.entidades.TemaDeUsuarioPK;



public interface AlmacenDAOTemasDeUsuarios 
	extends JpaRepository<TemaDeUsuario, TemaDeUsuarioPK> {
	
	@Query(value = "SELECT tu.* FROM tema_de_usuario AS tu\r\n" + 
			" INNER JOIN usuario AS u ON u.id = tu.id_usuario\r\n" + 
			" WHERE tu.id_usuario = ?1", 
			nativeQuery = true)
	public List<TemaDeUsuario> findTemasDeUnUsuario(Integer idUsuario);

	public List<TemaDeUsuario> findTemasPorUsuarioHQL(Integer idUsuario);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM tema_de_usuario WHERE id_usuario = ?1",
			nativeQuery=true)
	public void deleteByUsuario(Integer id);
	
// Sólo versión 11 de Java
	/*
	public void delete(Integer idU, Integer idT) {
		deleteById(new TemaDeUsuarioPK(idU, idT));
	}; */
	
	// UPDATE table_name
	// SET column1 = value1, column2 = value2, ...
	// WHERE condition;
	@Transactional
	@Modifying
	@Query(value="UPDATE tema_de_usuario SET usuario=?1, tema=?1 "
			+ "WHERE id_usuario = ?1",
			nativeQuery=true)
	public void anadirTemaPrefAUsuario(Integer idUsuario, Integer tema);
}
