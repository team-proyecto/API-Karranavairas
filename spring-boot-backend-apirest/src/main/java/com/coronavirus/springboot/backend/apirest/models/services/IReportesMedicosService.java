package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;

public interface IReportesMedicosService {
	
	public List<ReporteMedico> findAll();
	
	public ReporteMedico findById(Long id);
	
	public ReporteMedico save (ReporteMedico reporteMedico);
	
	public void delete ( Long id);
}
