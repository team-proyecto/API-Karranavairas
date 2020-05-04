package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.springboot.backend.apirest.models.dao.IComprasDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Compra;

@Service
public class CompraServiceimpl implements ICompraService{
	
	@Autowired
	IComprasDao comprasDao;

	@Override
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return (List<Compra>) comprasDao.findAll();
	}

	@Override
	public Compra findById(Long id) {
		// TODO Auto-generated method stub
		return comprasDao.findById(id).orElse(null);
	}

	@Override
	public Compra save(Compra compra) {
		// TODO Auto-generated method stub
		return comprasDao.save(compra);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		comprasDao.deleteById(id);
	}
	
	
	
}
