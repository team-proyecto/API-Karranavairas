package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.Compra;

public interface IComprasDao extends CrudRepository<Compra, Long>{

}
