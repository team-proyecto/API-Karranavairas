package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;



import com.coronavirus.springboot.backend.apirest.models.entity.Gps;

public interface IGpsService {

	public List<Gps> findAll();
	
	public Gps findById(Long id);
	
	public Gps save (Gps gps);
	
	public void delete ( Long id);
	
}
