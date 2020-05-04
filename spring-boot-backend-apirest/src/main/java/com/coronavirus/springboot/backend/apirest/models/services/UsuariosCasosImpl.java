package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IUsuariosCasosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;

@Service
public class UsuariosCasosImpl implements IUsuariosCasosService {

	@Autowired
	IUsuariosCasosDao iUsuariosCasosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioCaso> findAll() {
		
		return (List<UsuarioCaso>) iUsuariosCasosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioCaso findById(Long id) {
		
		return iUsuariosCasosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iUsuariosCasosDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public UsuarioCaso save(UsuarioCaso usuarioCaso) {
		
		return iUsuariosCasosDao.save(usuarioCaso);
	}

}
