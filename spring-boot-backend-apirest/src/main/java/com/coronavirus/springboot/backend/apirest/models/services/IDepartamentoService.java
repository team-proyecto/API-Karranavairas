package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;


import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;

public interface IDepartamentoService {
	
	
	public List<Departamento> findAll();
	
	public Departamento findById (Long id);
	
	public Departamento save(Departamento departamento);
	
	public void delete (Long id);
	

}
