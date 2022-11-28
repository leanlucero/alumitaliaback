package com.web.aluminio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="categoria") 
public class Categoria implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,name = "nombre")
	private String nombre;
	@Column(nullable = false,name = "detalle")
	private String detalle;
	

	  public List<Trabajo> getTrabajos() { return trabajos; }
	  
	  public void setTrabajos(List<Trabajo> trabajos) { this.trabajos = trabajos; }
	  
	  @JsonIgnore
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria") 
	  private List<Trabajo> trabajos = new ArrayList<Trabajo>();
	  
	  public void addTrabajo(Trabajo trabajo) { this.trabajos.add(trabajo); }
	 

	public Categoria() {
		super();
	}

	public Categoria(String nombre, String detalle) {
		super();
		this.nombre = nombre;
		this.detalle = detalle;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
}
