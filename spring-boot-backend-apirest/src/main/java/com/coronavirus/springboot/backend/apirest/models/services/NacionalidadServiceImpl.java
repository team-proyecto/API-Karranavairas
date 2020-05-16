package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.INacionalidadesDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;


@Service
public class NacionalidadServiceImpl implements INacionalidadService {

	@Autowired
	private INacionalidadesDao iNacionalidadesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Nacionalidad> findAll() {
		
		return (List<Nacionalidad>) iNacionalidadesDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Nacionalidad findById(Long id) {
		
		return iNacionalidadesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iNacionalidadesDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Nacionalidad save(Nacionalidad nacionalidad) {
		
		return iNacionalidadesDao.save(nacionalidad);
	}	


}
