package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gps")
public class Gps implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long latitud;
	private Long longitud;
	
	@Column(name = "direccion_gps")
	private String direccionGps;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getLatitud() {
		return latitud;
	}



	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}



	public Long getLongitud() {
		return longitud;
	}



	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}



	public String getDireccionGps() {
		return direccionGps;
	}



	public void setDireccionGps(String direccionGps) {
		this.direccionGps = direccionGps;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
