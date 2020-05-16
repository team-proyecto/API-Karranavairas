package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;



public interface IReporteEconomicoService {

	public List<ReporteEconomico> findAll();
	
	public ReporteEconomico findById (Long id);
	
	public ReporteEconomico save(ReporteEconomico reporteEconomico);
	
	public void delete (Long id);
	
}
