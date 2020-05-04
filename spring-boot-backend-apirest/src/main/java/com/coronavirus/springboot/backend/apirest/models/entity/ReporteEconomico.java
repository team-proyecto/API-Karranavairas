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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reportes_economicos")
public class ReporteEconomico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "bono_asignado")
	private Boolean bonoAsignado;

	@Column(name = "monto_servicio")
	private Double montoServicio;

	@Column(name = "boleta_imagen")
	private String boletaImagen;

	@ManyToOne
	@JoinColumn(name = "estado_economico_id", nullable = false)
	private EstadoEconomico estadoEconomico;
	
	private Boolean estado;
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@PrePersist
	public void prePersist() {
		this.fechaRegistro = new Date();
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

	public Boolean getBonoAsignado() {
		return bonoAsignado;
	}

	public void setBonoAsignado(Boolean bonoAsignado) {
		this.bonoAsignado = bonoAsignado;
	}

	public Double getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(Double montoServicio) {
		this.montoServicio = montoServicio;
	}

	public String getBoletaImagen() {
		return boletaImagen;
	}

	public void setBoletaImagen(String boletaImagen) {
		this.boletaImagen = boletaImagen;
	}

	public EstadoEconomico getEstadoEconomicoId() {
		return estadoEconomico;
	}

	public void setEstadoEconomicoId(EstadoEconomico estadoEconomicoId) {
		this.estadoEconomico = estadoEconomicoId;
	}

	@Override
	public String toString() {
		return "ReporteEconomico [id=" + id + ", bonoAsignado=" + bonoAsignado + ", montoServicio=" + montoServicio
				+ ", boletaImagen=" + boletaImagen + ", estadoEconomico=" + estadoEconomico + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
