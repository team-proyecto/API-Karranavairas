package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios_casos")
public class UsuarioCaso implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String telefono;
	private String nombre;
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	private Date nacimiento;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
	private String departamento;
	
	@Column(name = "direccion_domicilio")
	private String direccionDomicilio;
	
	@Column(name = "codigo_confirmacion")
	private Integer codigoConfirmacion;
	
	@Column(name = "condicion_uso")
	private Boolean condicionUso;
	
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@ManyToOne
    @JoinColumn(name="departamento_id", nullable=false)
	private Departamento departamentoId;
	
	@ManyToOne
    @JoinColumn(name="tipo_documento_id", nullable=false)
	private TipoDocumento tipoDocumentoId;	
	
	@ManyToOne
    @JoinColumn(name="nacionalidad_id", nullable=false)
	private Nacionalidad nacionalidadId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="gps_id", nullable=false)
	private Gps gpsId;
	
	@ManyToOne
    @JoinColumn(name="tipo_usuario_id", nullable=false)
	private TipoUsuario tipoUsuarioId;
	
	@OneToOne
    @JoinColumn(name="reporte_economico_id", nullable=false)
	private ReporteEconomico resporteEconomicoId;
	
	@OneToOne
    @JoinColumn(name="reporte_medico_id", nullable=false)
	private ReporteMedico reporteMedicoId;
	
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
