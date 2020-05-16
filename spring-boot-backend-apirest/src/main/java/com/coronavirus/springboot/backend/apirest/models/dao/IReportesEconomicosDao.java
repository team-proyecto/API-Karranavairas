package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;

public interface IReportesEconomicosDao extends CrudRepository<ReporteEconomico, Long> {

}
