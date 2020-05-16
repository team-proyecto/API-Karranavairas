package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IDistritosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;


@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private IDistritosDao iDistritoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Distrito> findAll() {
		
		return (List<Distrito>) iDistritoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Distrito findById(Long id) {
		
		return iDistritoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iDistritoDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Distrito save(Distrito distrito) {
		
		return iDistritoDao.save(distrito);
	}	

}
