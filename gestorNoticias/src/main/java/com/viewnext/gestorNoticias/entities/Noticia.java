package com.viewnext.gestorNoticias.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@NotNull
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Integer idTema;
	
	public Noticia(Integer id, @NotNull @Size(min = 1, max = 100) String titular,
			@NotNull @Size(min = 1, max = 500) String cabecera, Date fecha) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
