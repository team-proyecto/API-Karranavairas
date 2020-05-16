package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;



public interface INacionalidadService {

	public List<Nacionalidad> findAll();
	
	public Nacionalidad findById (Long id);
	
	public Nacionalidad save(Nacionalidad nacionalidad);
	
	public void delete (Long id);
	
}
