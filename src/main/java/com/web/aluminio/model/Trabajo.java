package com.web.aluminio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="trabajo")
public class Trabajo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@Column(nullable = false, name = "nombre")
	private String nombre;
	@Column(name = "detalle")
	private String detalle;
	@Column (name = "fecha")
	private Date fecha;
	@Column (name = "imagenurl")
	private String ImagenUrl;
	@Column (name = "imagenid")
	private String ImagenId;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getImagenUrl() {
		return ImagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		ImagenUrl = imagenUrl;
	}
	public String getImagenId() {
		return ImagenId;
	}
	public void setImagenId(String imagenId) {
		ImagenId = imagenId;
	}
	
	public Trabajo(Long id, String nombre, String detalle, Date fecha, String imagenUrl, String imagenId,
			Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.fecha = fecha;
		ImagenUrl = imagenUrl;
		ImagenId = imagenId;
		this.categoria = categoria;
	}
	public Trabajo() {
		super();
	}
	
	
	
	
}
