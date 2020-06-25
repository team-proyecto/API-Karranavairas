package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id")
	private Long id;

	@Column(name = "nombres_apellidos", nullable =  false)	
	private String nombresApellidos;
	
	private Boolean provincia;

	@Max(value = 5)
	@NotEmpty
	@DecimalMax(value = "5", inclusive = true)
	private Long departamento;
	@Email
	@NotEmpty
	@Size(min=8, max=20)
	@Column(unique = true, nullable =  false)	
	private String distrito;
	@NotEmpty
	private String estado;

	@Column(name = "create_at")
	//@Temporal(TemporalType.DATE)
	private String createAt;

	/*@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}*/

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getProvincia() {
		return provincia;
	}

	public void setProvincia(Boolean provincia) {
		this.provincia = provincia;
	}

	public Long getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Long departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
