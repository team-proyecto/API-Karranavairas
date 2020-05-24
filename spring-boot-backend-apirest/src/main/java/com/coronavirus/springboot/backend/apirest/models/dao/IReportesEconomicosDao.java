package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;

public interface IReportesEconomicosDao extends JpaRepository<ReporteEconomico, Long> {

}
