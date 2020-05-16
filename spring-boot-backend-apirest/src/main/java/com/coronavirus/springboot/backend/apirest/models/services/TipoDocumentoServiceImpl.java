package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.ITiposDocumentosDao;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;



@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Autowired
	private ITiposDocumentosDao iTiposDocumentosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAll() {
		
		return (List<TipoDocumento>) iTiposDocumentosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDocumento findById(Long id) {
		
		return iTiposDocumentosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iTiposDocumentosDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public TipoDocumento save(TipoDocumento usuarioCaso) {
		
		return iTiposDocumentosDao.save(usuarioCaso);
	}	


}
