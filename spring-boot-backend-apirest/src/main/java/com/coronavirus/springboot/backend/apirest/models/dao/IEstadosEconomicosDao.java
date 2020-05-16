package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;

public interface IEstadosEconomicosDao extends CrudRepository<EstadoEconomico, Long> {

}
