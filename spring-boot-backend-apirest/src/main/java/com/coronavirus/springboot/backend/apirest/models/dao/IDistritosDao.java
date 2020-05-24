package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;

public interface IDistritosDao extends JpaRepository<Distrito, Long> {

}
