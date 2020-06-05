package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IProvinciasDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;



@Service
public class ProvinciaServiceImpl implements IProvinciaService {

	@Autowired
	private IProvinciasDao iProvinciasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Provincia> findAll() {
		
		return iProvinciasDao.findAll();
	}
	
	@Override
	public Page<Provincia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iProvinciasDao.findAll(pageable);
	}	

	@Override
	@Transactional(readOnly = true)
	public Provincia findById(Long id) {
		
		return iProvinciasDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iProvinciasDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Provincia save(Provincia provincia) {
		
		return iProvinciasDao.save(provincia);
	}

	




}
