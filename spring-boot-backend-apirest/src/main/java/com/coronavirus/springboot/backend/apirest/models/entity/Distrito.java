package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "distritos")
public class Distrito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_distrito")
	private String nombreDistrito;

	@ManyToOne
	@JoinColumn(name = "provincia_id", nullable = false)
	private Provincia provincia;

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

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public Provincia getProvinciaId() {
		return provincia;
	}

	public void setProvinciaId(Provincia provinciaId) {
		this.provincia = provinciaId;
	}

	
	@Override
	public String toString() {
		return "Distrito [id=" + id + ", nombreDistrito=" + nombreDistrito + ", provincia=" + provincia + "]";
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
