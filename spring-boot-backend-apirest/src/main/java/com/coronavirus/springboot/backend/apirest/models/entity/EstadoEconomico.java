package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados_economicos")
public class EstadoEconomico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_economico")
	private String nombreEconomico;

	private Boolean estado;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEconomico() {
		return nombreEconomico;
	}

	public void setNombreEconomico(String nombreEconomico) {
		this.nombreEconomico = nombreEconomico;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EstadoEconomico [id=" + id + ", nombreEconomico=" + nombreEconomico + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
