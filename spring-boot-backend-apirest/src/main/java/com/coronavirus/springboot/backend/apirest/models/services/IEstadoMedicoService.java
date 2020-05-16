package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoMedico;



public interface IEstadoMedicoService {

	public List<EstadoMedico> findAll();
	
	public EstadoMedico findById (Long id);
	
	public EstadoMedico save(EstadoMedico estadoMedico);
	
	public void delete (Long id);
	
}
