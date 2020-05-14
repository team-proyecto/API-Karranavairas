package com.coronavirus.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name = "direccion_domicilio")
	private String direccionDomicilio;

	@Column(name = "codigo_confirmacion")
	private Integer codigoConfirmacion;

	@Column(name = "condicion_uso")
	private Boolean condicionUso;

	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	@JsonIgnoreProperties(value = {"usuarioCaso","hibernateLazyInitializer", "handler"},allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "distrito_id", nullable = true)
	private Distrito distrito;

	@ManyToOne
	@JoinColumn(name = "tipo_documento_id", nullable = true)
	private TipoDocumento tipoDocumento;

	@ManyToOne
	@JoinColumn(name = "nacionalidad_id", nullable = true)
	private Nacionalidad nacionalidad;

	@JsonIgnoreProperties({"usuarioCaso"})
	@OneToOne
	@JoinColumn(name = "gps_id",referencedColumnName = "id")	
	private Gps gps;

	@ManyToOne
	@JoinColumn(name = "tipo_usuario_id", nullable = true)
	private TipoUsuario tipoUsuario;

	@OneToOne
	@JoinColumn(name = "reporte_economico_id", nullable = true)
	private ReporteEconomico resporteEconomico;

	@OneToOne
	@JoinColumn(name = "reporte_medico_id", nullable = true)
	private ReporteMedico reporteMedico;

	@Column(name = "estado")
	private Boolean estado;

	@PrePersist
	public void prePersist() {
		this.fechaRegistro = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getDireccionDomicilio() {
		return direccionDomicilio;
	}

	public void setDireccionDomicilio(String direccionDomicilio) {
		this.direccionDomicilio = direccionDomicilio;
	}

	public Integer getCodigoConfirmacion() {
		return codigoConfirmacion;
	}

	public void setCodigoConfirmacion(Integer codigoConfirmacion) {
		this.codigoConfirmacion = codigoConfirmacion;
	}

	public Boolean getCondicionUso() {
		return condicionUso;
	}

	public void setCondicionUso(Boolean condicionUso) {
		this.condicionUso = condicionUso;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Gps getGps() {
		return gps;
	}

	public void setGps(Gps gps) {
		this.gps = gps;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public ReporteEconomico getResporteEconomico() {
		return resporteEconomico;
	}

	public void setResporteEconomico(ReporteEconomico resporteEconomico) {
		this.resporteEconomico = resporteEconomico;
	}

	public ReporteMedico getReporteMedico() {
		return reporteMedico;
	}

	public void setReporteMedico(ReporteMedico reporteMedico) {
		this.reporteMedico = reporteMedico;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "UsuarioCaso [id=" + id + ", telefono=" + telefono + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", nacimiento=" + nacimiento + ", numeroDocumento=" + numeroDocumento + ", direccionDomicilio="
				+ direccionDomicilio + ", codigoConfirmacion=" + codigoConfirmacion + ", condicionUso=" + condicionUso
				+ ", fechaRegistro=" + fechaRegistro + ", distrito=" + distrito + ", tipoDocumento="
				+ tipoDocumento + ", nacionalidad=" + nacionalidad + ", gps=" + gps + ", tipoUsuario=" + tipoUsuario
				+ ", resporteEconomico=" + resporteEconomico + ", reporteMedico=" + reporteMedico + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
