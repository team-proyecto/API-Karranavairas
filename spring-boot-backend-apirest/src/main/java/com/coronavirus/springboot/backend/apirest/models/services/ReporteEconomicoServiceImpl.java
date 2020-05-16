package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IReportesEconomicosDao;
import com.coronavirus.springboot.backend.apirest.models.dao.IReportesMedicosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;


@Service
public class ReporteEconomicoServiceImpl implements IReporteEconomicoService {

	@Autowired
	private IReportesEconomicosDao iReportesEconomicosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ReporteEconomico> findAll() {
		
		return (List<ReporteEconomico>) iReportesEconomicosDao.findAll();
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

	

}
