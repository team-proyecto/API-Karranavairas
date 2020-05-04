package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;

public interface IUsuariosCasosDao extends CrudRepository<UsuarioCaso, Long>{
	
	

}
