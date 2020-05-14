package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IUsuariosCasosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;
import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;

@Service
public class UsuariosCasosImpl implements IUsuariosCasosService {

	@Autowired
	private IUsuariosCasosDao iUsuariosCasosDao;
	
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

	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAllDocumentos() {
		return (List<TipoDocumento>) iUsuariosCasosDao.findAllDocumento();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nacionalidad> findAllNacionalidad() {		
		return (List<Nacionalidad>) iUsuariosCasosDao.findAllNacionalidad();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findAllDepartamento() {		
		return (List<Departamento>) iUsuariosCasosDao.findAllDepartamento();
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento findByIDDepartamento(Long id) {		
		return iUsuariosCasosDao.findByIDDepartamento(id);
	}	

	@Override
	@Transactional(readOnly = true)
	public Provincia findIDProvincia(Long id) {		
		return iUsuariosCasosDao.findIDProvincia(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Distrito> findAllDistrito() {		
		return (List<Distrito>) iUsuariosCasosDao.findAllDistrito();
	}

}
