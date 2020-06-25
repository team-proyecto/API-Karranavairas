package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;


public interface IDistritosDao extends JpaRepository<Distrito, Long> {

	@Query("select di from Distrito di where di.nombreDistrito = ?1")
	public Distrito findByNombreDistrito(String nombreDistrito);
	
}
