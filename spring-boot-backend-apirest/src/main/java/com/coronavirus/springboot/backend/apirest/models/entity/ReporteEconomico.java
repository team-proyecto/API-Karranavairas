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
	private Byte boletaImagen[];
	
	@ManyToOne
    @JoinColumn(name="estado_economico_id", nullable=false)
	private EstadoEconomico estadoEconomicoId;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
