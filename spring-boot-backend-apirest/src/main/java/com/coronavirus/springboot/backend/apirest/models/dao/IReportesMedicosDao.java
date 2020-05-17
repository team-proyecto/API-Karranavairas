package com.coronavirus.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;

public interface IReportesMedicosDao extends CrudRepository<ReporteMedico, Long>{
	
	

}
