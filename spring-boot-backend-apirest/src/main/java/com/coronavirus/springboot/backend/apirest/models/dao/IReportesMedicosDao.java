package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;

public interface IReportesMedicosDao extends CrudRepository<ReporteMedico, Long>{

}
