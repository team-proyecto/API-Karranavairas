package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;

public interface IProvinciasDao extends JpaRepository<Provincia, Long> {

	@Query("select pr from Provincia pr where pr.nombreProvincia = ?1")
	public Provincia findByNombreProvincia(String nombreProvincia);
}
