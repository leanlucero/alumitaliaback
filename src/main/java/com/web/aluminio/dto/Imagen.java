package com.web.aluminio.dto;

public class Imagen {
	private String imagenUrl;
    private String imagenId;
    
	public Imagen(String imagenUrl, String imagenId) {
		super();
		this.imagenUrl = imagenUrl;
		this.imagenId = imagenId;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	public String getImagenId() {
		return imagenId;
	}
	public void setImagenId(String imagenId) {
		this.imagenId = imagenId;
	}
    
    
}
