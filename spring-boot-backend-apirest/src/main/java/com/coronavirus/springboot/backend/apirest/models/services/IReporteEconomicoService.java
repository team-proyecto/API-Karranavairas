package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;



public interface IReporteEconomicoService {

	public List<ReporteEconomico> findAll();
	
	public Page<ReporteEconomico> findAll(Pageable pageable);
	
	public ReporteEconomico findById (Long id);
	
	public ReporteEconomico save(ReporteEconomico reporteEconomico);
	
	public void delete (Long id);
	
}
