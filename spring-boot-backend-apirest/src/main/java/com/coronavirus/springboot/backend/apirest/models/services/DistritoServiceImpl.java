package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		
		return iDistritoDao.findAll();
	}
	
	@Override
	public Page<Distrito> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iDistritoDao.findAll(pageable);
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
