package com.coronavirus.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;


public interface IReportesMedicosDao extends JpaRepository<ReporteMedico, Long>{
	
	@Query("select rm from ReporteMedico rm where rm.estadoMedico.id = ?1")
	public List<ReporteMedico> findByEstadoMedico(Long estadoMedicoId);
	

}
