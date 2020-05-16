package com.coronavirus.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;

public interface ITiposDocumentosDao extends CrudRepository<TipoDocumento, Long> {

}
