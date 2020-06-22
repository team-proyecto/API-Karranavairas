package com.coronavirus.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;
import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;

public interface IReportesEconomicosDao extends JpaRepository<ReporteEconomico, Long> {
	
	@Query("select re from ReporteEconomico re where re.estadoEconomico.id = ?1")
	public List<ReporteEconomico> findByEstadoEconomico(Long estadoEconomicoId);
	

}
