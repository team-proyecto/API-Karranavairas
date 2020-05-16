package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.TipoUsuario;

public interface ITiposUsuariosDao extends CrudRepository<TipoUsuario, Long> {

}
