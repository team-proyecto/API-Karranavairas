package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;


import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;

public interface IEstadoEconomicoService {

	public List<EstadoEconomico> findAll();
	
	public EstadoEconomico findById (Long id);
	
	public EstadoEconomico save(EstadoEconomico estadoEconomico);
	
	public void delete (Long id);
}
