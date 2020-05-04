package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;


import com.coronavirus.springboot.backend.apirest.models.entity.Compra;

public interface ICompraService {
	public List<Compra> findAll();
	
	public Compra findById (Long id);
	
	public Compra save(Compra compra);
	
	public void delete (Long id);

}
