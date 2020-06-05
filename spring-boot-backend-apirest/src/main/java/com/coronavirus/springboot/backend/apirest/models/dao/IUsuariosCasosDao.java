package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;
import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;

public interface IUsuariosCasosDao extends JpaRepository<UsuarioCaso, Long>{
	
	@Query("from TipoDocumento")
	public List<TipoDocumento> findAllDocumento();
	
	@Query("from Nacionalidad")
	public List<Nacionalidad> findAllNacionalidad();
	
	@Query("from Departamento")
	public List<Departamento> findAllDepartamento();	
	
	@Query("Select d from Departamento d where d.id=?1")
	public Departamento findByIDDepartamento(Long id);
	
	@Query("Select p from Provincia p where p.id=?1")
	public Provincia findIDProvincia(Long id);
	
	@Query("from Distrito")
	public List<Distrito> findAllDistrito();	
	
	//para reporte por busqueda en rango de fecha
	@Query("select uc from UsuarioCaso uc where uc.fechaRegistro>=?1 and uc.fechaRegistro>=?2")
	public List<UsuarioCaso> findByFechaRegistro(Date fechaInicio, Date fechaFinal);
	
	
	
}
