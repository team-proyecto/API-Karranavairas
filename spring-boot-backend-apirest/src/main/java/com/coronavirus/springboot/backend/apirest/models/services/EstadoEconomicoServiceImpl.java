package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IEstadosEconomicosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;



@Service
public class EstadoEconomicoServiceImpl implements IEstadoEconomicoService {

	@Autowired
	private IEstadosEconomicosDao iEstadosEconomicosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EstadoEconomico> findAll() {
		
		return (List<EstadoEconomico>) iEstadosEconomicosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public EstadoEconomico findById(Long id) {
		
		return iEstadosEconomicosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iEstadosEconomicosDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public EstadoEconomico save(EstadoEconomico estadoEconomico) {
		
		return iEstadosEconomicosDao.save(estadoEconomico);
	}	


}
