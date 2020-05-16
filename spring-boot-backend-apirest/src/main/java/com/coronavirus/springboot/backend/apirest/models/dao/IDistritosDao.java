package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;

public interface IDistritosDao extends CrudRepository<Distrito, Long> {

}
