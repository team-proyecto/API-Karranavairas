package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;

public interface IDepartamentoService {
	
	
	public List<Departamento> findAll();
	
	public Page<Departamento> findAll(Pageable pageable);
	
	public Departamento findById (Long id);
	
	public Departamento save(Departamento departamento);
	
	public void delete (Long id);
	
	public Departamento findbyNombreDepartamento(String nombreDepartamento);

}
