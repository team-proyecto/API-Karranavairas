package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IDepartamentosDao;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;


@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	private IDepartamentosDao iDepartamentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findAll() {
		
		return (List<Departamento>) iDepartamentoDao.findAll();
	}
	
	@Override
	public Page<Departamento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iDepartamentoDao.findAll(pageable);
	}	

	@Override
	@Transactional(readOnly = true)
	public Departamento findById(Long id) {
		
		return iDepartamentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iDepartamentoDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Departamento save(Departamento departamento) {
		
		return iDepartamentoDao.save(departamento);
	}

	

	

}
