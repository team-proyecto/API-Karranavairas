package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "niveles_accesos")
public class NivelAcceso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_acceso")
	private String nombreAcceso;

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

	public String getNombreAcceso() {
		return nombreAcceso;
	}

	public void setNombreAcceso(String nombreAcceso) {
		this.nombreAcceso = nombreAcceso;
	}

	@Override
	public String toString() {
		return "NivelAcceso [id=" + id + ", nombreAcceso=" + nombreAcceso + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
