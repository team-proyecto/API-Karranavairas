package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;



public interface ITipoDocumentoService {

	public List<TipoDocumento> findAll();
	
	public TipoDocumento findById (Long id);
	
	public TipoDocumento save(TipoDocumento tipoDocumento);
	
	public void delete (Long id);
	
}
