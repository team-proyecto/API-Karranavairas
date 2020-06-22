package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reportes_medicos")
public class ReporteMedico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "resultado_triaje")
	private Boolean resultadoTriaje;

	@ManyToOne
	@JoinColumn(name = "estado_medico_id", nullable = true)
	private EstadoMedico estadoMedico;

	private Boolean estado;

	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	
	@JsonIgnoreProperties(value={"reporteMedico"}, allowSetters = true)
	@OneToOne(mappedBy = "reporteMedico")	
	private UsuarioCaso usuarioCaso;

	@PrePersist
	public void prePersist() {
		this.fechaRegistro = new Date();
	}
	
	
	

	public UsuarioCaso getUsuarioCaso() {
		return usuarioCaso;
	}




	public void setUsuarioCaso(UsuarioCaso usuarioCaso) {
		this.usuarioCaso = usuarioCaso;
	}




	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getResultadoTriaje() {
		return resultadoTriaje;
	}

	public void setResultadoTriaje(Boolean resultadoTriaje) {
		this.resultadoTriaje = resultadoTriaje;
	}

	public EstadoMedico getEstadoMedico() {
		return estadoMedico;
	}

	public void setEstadoMedico(EstadoMedico estadoMedico) {
		this.estadoMedico = estadoMedico;
	}

	public void definirEstado(Boolean triaje) {
		this.resultadoTriaje = triaje;
//		List<EstadoMedico> listaEstadoMedicos = new ArrayList<EstadoMedico>();

		if (triaje = true) {
			this.estadoMedico.setId((long) 2);

//			setEstadoMedico(listaEstadoMedicos.get(2));
		}
	}

	@Override
	public String toString() {
		return "ReporteMedico [id=" + id + ", resultadoTriaje=" + resultadoTriaje + ", estadoMedico=" + estadoMedico
				+ "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
