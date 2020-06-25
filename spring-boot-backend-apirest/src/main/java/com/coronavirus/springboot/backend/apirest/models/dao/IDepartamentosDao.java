package com.coronavirus.springboot.backend.apirest.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;


public interface IDepartamentosDao extends JpaRepository<Departamento, Long> {
	
	@Query("select de from Departamento de where de.nombreDepartamento = ?1")
	public Departamento findByNombreDepartamento(String nombreDepartamento);

}
