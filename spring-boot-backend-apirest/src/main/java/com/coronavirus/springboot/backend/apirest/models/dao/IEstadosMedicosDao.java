package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.coronavirus.springboot.backend.apirest.models.entity.EstadoMedico;

public interface IEstadosMedicosDao extends CrudRepository<EstadoMedico, Long> {

}
