package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;
import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;

public interface IUsuariosCasosService {
	
	public List<UsuarioCaso> findAll();
	
	public UsuarioCaso findById (Long id);
	
	public void delete (Long id);
	
	public UsuarioCaso save(UsuarioCaso usuarioCaso);	
   
	public List<TipoDocumento> findAllDocumentos();
	
	public List<Nacionalidad> findAllNacionalidad();
	
	public List<Departamento> findAllDepartamento();
	
	public Departamento findByIDDepartamento(Long id);	
	
	public Provincia findIDProvincia(Long id);

	public List<Distrito> findAllDistrito();
	
}
