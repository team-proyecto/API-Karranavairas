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
@Table(name = "provincias")
public class Provincia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_provincia")
	private String nombreProvincia;

	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;

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

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Departamento getDepartamentoId() {
		return departamento;
	}

	public void setDepartamentoId(Departamento departamentoId) {
		this.departamento = departamentoId;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombreProvincia=" + nombreProvincia + ", departamento=" + departamento + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
