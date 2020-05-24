package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;

public interface IReportesMedicosService {
	
	public List<ReporteMedico> findAll();
	
	public Page<ReporteMedico> findAll(Pageable pageable);
	
	public ReporteMedico findById(Long id);
	
	public ReporteMedico save (ReporteMedico reporteMedico);
	
	public void delete ( Long id);
}
