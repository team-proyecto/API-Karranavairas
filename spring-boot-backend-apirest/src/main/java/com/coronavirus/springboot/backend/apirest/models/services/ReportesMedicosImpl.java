package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coronavirus.springboot.backend.apirest.models.dao.IReportesMedicosDao;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;

@Service
public class ReportesMedicosImpl implements IReportesMedicosService {
	
	@Autowired
	IReportesMedicosDao reportesMedicosDao;
	
	@Override
	public List<ReporteMedico> findAll(){
		
		return (List<ReporteMedico>) reportesMedicosDao.findAll();
	}

	@Override
	public ReporteMedico findById(Long id) {
		
		return reportesMedicosDao.findById(id).orElse(null);
	}

	@Override
	public ReporteMedico save(ReporteMedico reporteMedico) {
		
		return reportesMedicosDao.save(reporteMedico);
	}

	@Override
	public void delete(Long id) {
		reportesMedicosDao.deleteById(id);
		
	}

}
