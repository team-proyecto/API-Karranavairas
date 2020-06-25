package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;



public interface IDistritoService {

	public List<Distrito> findAll();
	
	public Page<Distrito> findAll(Pageable pageable);
	
	public Distrito findById (Long id);
	
	public Distrito save(Distrito distrito);
	
	public void delete (Long id);
	
	public Distrito findbyNombreDistrito(String nombreDistrito);
	
}
