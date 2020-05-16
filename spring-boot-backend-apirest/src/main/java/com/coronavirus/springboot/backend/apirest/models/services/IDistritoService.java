package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;



public interface IDistritoService {

	public List<Distrito> findAll();
	
	public Distrito findById (Long id);
	
	public Distrito save(Distrito distrito);
	
	public void delete (Long id);
	
}
