package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;

public interface IProvinciasDao extends JpaRepository<Provincia, Long> {

}
