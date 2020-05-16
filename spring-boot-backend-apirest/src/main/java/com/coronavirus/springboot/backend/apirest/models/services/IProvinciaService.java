package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;



public interface IProvinciaService {

	public List<Provincia> findAll();
	
	public Provincia findById (Long id);
	
	public Provincia save(Provincia provincia);
	
	public void delete (Long id);
	
}
