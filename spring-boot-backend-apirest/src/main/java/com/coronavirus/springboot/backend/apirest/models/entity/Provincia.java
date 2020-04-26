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
    @JoinColumn(name="departamento_id", nullable=false)
	private Departamento departamentoId;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
