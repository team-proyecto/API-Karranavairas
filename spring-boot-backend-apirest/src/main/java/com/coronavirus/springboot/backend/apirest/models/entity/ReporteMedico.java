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
@Table(name = "reportes_medicos")
public class ReporteMedico implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "resultado_triaje")
	private Boolean resultadoTriaje;
	
	@ManyToOne
    @JoinColumn(name="estado_medico_id", nullable=false)
	private EstadoMedico estadoMedicoId;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
