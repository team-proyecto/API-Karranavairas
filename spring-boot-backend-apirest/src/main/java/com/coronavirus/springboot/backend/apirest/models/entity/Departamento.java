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
import javax.persistence.OneToMany; 
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_departamento")
	private String nombreDepartamento;
	
	@JsonIgnoreProperties(value={"departamento","hibernateLazyInitializer","handler"},allowSetters = true)  // Para que no se Genere un Loop Infinito
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "departamento")	
	private List<Provincia> provincia;	
	
	private Boolean estado;
	
	public Departamento() {
		this.provincia = new ArrayList<>();
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

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
		
	public List<Provincia> getProvincia() {
		return provincia;
	}

	public void setProvincia(List<Provincia> provincia) {
		this.provincia = provincia;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
