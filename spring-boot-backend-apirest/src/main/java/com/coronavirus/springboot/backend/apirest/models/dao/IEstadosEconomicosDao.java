package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;

public interface IEstadosEconomicosDao extends JpaRepository<EstadoEconomico, Long> {

}
