package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IEstadosMedicosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.EstadoMedico;



@Service
public class EstadoMedicoServiceImpl implements IEstadoMedicoService {

	@Autowired
	private IEstadosMedicosDao iEstadosMedicosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EstadoMedico> findAll() {
		
		return (List<EstadoMedico>) iEstadosMedicosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public EstadoMedico findById(Long id) {
		
		return iEstadosMedicosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iEstadosMedicosDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public EstadoMedico save(EstadoMedico estadoMedico) {
		
		return iEstadosMedicosDao.save(estadoMedico);
	}	



}
