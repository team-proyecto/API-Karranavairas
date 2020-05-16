package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.ITiposUsuariosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoUsuario;



@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {

	@Autowired
	private ITiposUsuariosDao iTiposUsuariosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuario> findAll() {
		
		return (List<TipoUsuario>) iTiposUsuariosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoUsuario findById(Long id) {
		
		return iTiposUsuariosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iTiposUsuariosDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public TipoUsuario save(TipoUsuario tipoUsuario) {
		
		return iTiposUsuariosDao.save(tipoUsuario);
	}	



}
