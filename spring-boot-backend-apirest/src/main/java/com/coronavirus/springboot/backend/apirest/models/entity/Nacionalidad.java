package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nacionalidad")
public class Nacionalidad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_nacionalidad")
	private String nombreNacionalidad;

	private Boolean estado;
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreNacionalidad() {
		return nombreNacionalidad;
	}

	public void setNombreNacionalidad(String nombreNacionalidad) {
		this.nombreNacionalidad = nombreNacionalidad;
	}

	@Override
	public String toString() {
		return "Nacionalidad [id=" + id + ", nombreNacionalidad=" + nombreNacionalidad + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
