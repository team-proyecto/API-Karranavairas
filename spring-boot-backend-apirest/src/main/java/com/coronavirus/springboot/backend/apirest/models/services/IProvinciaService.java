package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;



public interface IProvinciaService {

	public List<Provincia> findAll();
	
	public Page<Provincia> findAll(Pageable pageable);
	
	public Provincia findById (Long id);
	
	public Provincia save(Provincia provincia);
	
	public void delete (Long id);
	
	public Provincia findbyNombreProvincia(String nombreProvincia);
}
