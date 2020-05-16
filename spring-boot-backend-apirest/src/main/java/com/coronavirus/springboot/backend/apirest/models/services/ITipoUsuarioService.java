package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import com.coronavirus.springboot.backend.apirest.models.entity.TipoUsuario;



public interface ITipoUsuarioService {

	public List<TipoUsuario> findAll();
	
	public TipoUsuario findById (Long id);
	
	public TipoUsuario save(TipoUsuario tipoUsuario);
	
	public void delete (Long id);
	
}
