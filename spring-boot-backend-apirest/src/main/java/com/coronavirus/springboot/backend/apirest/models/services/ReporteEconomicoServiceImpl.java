package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IReportesEconomicosDao;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;


@Service
public class ReporteEconomicoServiceImpl implements IReporteEconomicoService {

	@Autowired
	private IReportesEconomicosDao iReportesEconomicosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ReporteEconomico> findAll() {
		
		return iReportesEconomicosDao.findAll();
	}
	
	@Override
	public Page<ReporteEconomico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iReportesEconomicosDao.findAll(pageable);
	}	

	@Override
	@Transactional(readOnly = true)
	public ReporteEconomico findById(Long id) {
		
		return iReportesEconomicosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iReportesEconomicosDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public ReporteEconomico save(ReporteEconomico reporteEconomico) {
		
		return iReportesEconomicosDao.save(reporteEconomico);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReporteEconomico> findByEstadoEconomico(Long estadoEconomicoId) {
		return iReportesEconomicosDao.findByEstadoEconomico(estadoEconomicoId);
	}



	

}
