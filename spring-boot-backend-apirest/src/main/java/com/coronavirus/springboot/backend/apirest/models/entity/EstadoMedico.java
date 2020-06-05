package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados_medicos")
public class EstadoMedico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_medico")
	private String nombreMedico;

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
	
	public Long definirEstadoMedico(Long id) {
		return id;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	@Override
	public String toString() {
		return "EstadoMedico [id=" + id + ", nombreMedico=" + nombreMedico + "]";
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
