package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;

public interface IProvinciasDao extends CrudRepository<Provincia, Long> {

}
