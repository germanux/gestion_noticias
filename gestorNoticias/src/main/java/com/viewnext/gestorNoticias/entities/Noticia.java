package com.viewnext.gestorNoticias.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Noticia {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String titular;
	
	@NotNull
	@Size(min = 1, max = 500)
	private String cabecera;
	
	@NotNull
	@Size(min = 1, max = 500)
	private String fecha;
	
	@Column(name="id_noticia_tema", insertable = true, updatable = true)
	private Integer idTema;
	
	public Noticia(Integer id, @NotNull @Size(min = 1, max = 100) String titular,
			@NotNull @Size(min = 1, max = 500) String cabecera, String fecha) {
		super();
		this.id = id;
		this.titular = titular;
		this.cabecera = cabecera;
		this.fecha = fecha;
	}

	public Noticia() {
		super();
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
