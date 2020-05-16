package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;

public interface INacionalidadesDao extends CrudRepository<Nacionalidad, Long> {

}
