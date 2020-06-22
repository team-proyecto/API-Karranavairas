package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gps")
public class Gps implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long latitud;
	private Long longitud;

	@Column(name = "direccion_gps")
	private String direccionGps;

	private Boolean estado;

	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	//@JsonIgnoreProperties({"hibernateLazyInitializaer","handler","gps"})
	@JsonIgnoreProperties(value = {"gps"}, allowSetters = true)
	@OneToOne(mappedBy = "gps")	
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	public Long getLatitud() {
		return latitud;
	}

	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}

	public Long getLongitud() {
		return longitud;
	}

	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}

	public String getDireccionGps() {
		return direccionGps;
	}

	public void setDireccionGps(String direccionGps) {
		this.direccionGps = direccionGps;
	}

	@Override
	public String toString() {
		return "Gps [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + ", direccionGps=" + direccionGps
				+ "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
