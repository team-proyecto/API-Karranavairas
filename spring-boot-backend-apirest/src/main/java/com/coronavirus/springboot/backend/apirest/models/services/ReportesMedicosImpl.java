package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IReportesMedicosDao;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;

@Service
public class ReportesMedicosImpl implements IReportesMedicosService {
	
	@Autowired
	IReportesMedicosDao reportesMedicosDao;
	
	@Override
	public List<ReporteMedico> findAll(){
		
		return reportesMedicosDao.findAll();
	}
	
	@Override
	public Page<ReporteMedico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return reportesMedicosDao.findAll(pageable);
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

	@Override
	@Transactional(readOnly = true)
	public List<ReporteMedico> findByEstadoMedico(Long estadoMedicoId) {		
		return reportesMedicosDao.findByEstadoMedico(estadoMedicoId);
	}

	

}
