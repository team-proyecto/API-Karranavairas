package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;

public interface IUsuariosCasosDao extends CrudRepository<UsuarioCaso, Long>{
	
	@Query("from TipoDocumento")
	public List<TipoDocumento> findAllDocumento();
	
	@Query("from Departamento")
	public List<Departamento> findAllDepartamento();
	
	@Query("from Nacionalidad")
	public List<Nacionalidad> findAllNacionalidad();

}
