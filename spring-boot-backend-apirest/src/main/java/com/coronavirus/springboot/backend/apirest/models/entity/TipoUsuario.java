package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_usuarios")
public class TipoUsuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="nivel_acceso_id", nullable=false)
	private NivelAcceso nivelAccesoId;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
