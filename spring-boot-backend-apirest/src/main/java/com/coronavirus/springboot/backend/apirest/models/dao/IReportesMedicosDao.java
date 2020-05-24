package com.coronavirus.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;


public interface IReportesMedicosDao extends JpaRepository<ReporteMedico, Long>{
	
	

}
