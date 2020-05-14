package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "provincias")
public class Provincia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_provincia")
	private String nombreProvincia;

	@JsonIgnoreProperties(value = { "provincia", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@JsonIgnoreProperties(value={"provincia","hibernateLazyInitializer", "handler"},allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia")
	private List<Distrito> distrito;	

	private Boolean estado;
	
	public Provincia() {
		this.distrito= new ArrayList<>();
	}
	
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

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	
	public List<Distrito> getDistrito() {
		return distrito;
	}

	public void setDistrito(List<Distrito> distrito) {
		this.distrito = distrito;
	}
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
