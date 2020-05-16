package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "distritos")
public class Distrito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_distrito")
	private String nombreDistrito;

	@JsonIgnoreProperties(value = {"distrito","hibernateLazyInitializer", "handler"},allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;
	
	@JsonIgnoreProperties(value={"distrito","hibernateLazyInitializer", "handler"},allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distrito")
	private List<UsuarioCaso> usuarioCaso;
	
	
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
	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
		

	public List<UsuarioCaso> getUsuarioCaso() {
		return usuarioCaso;
	}

	public void setUsuarioCaso(List<UsuarioCaso> usuarioCaso) {
		this.usuarioCaso = usuarioCaso;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
