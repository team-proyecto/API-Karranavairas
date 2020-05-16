package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;

public interface IDepartamentosDao extends CrudRepository<Departamento, Long> {

}
