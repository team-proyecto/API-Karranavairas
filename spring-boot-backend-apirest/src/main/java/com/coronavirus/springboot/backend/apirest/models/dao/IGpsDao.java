package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.Gps;

public interface IGpsDao extends CrudRepository<Gps, Long> {

}
