package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.springboot.backend.apirest.models.dao.IGpsDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Gps;

@Service
public class GpsServiceImpl implements IGpsService {

	@Autowired
	IGpsDao gpsDao;
	
	@Override
	public List<Gps> findAll(){
		
		return (List<Gps>) gpsDao.findAll();
	}

	@Override
	public Gps findById(Long id) {
		
		return gpsDao.findById(id).orElse(null);
	}

	@Override
	public Gps save(Gps gps) {
		
		return gpsDao.save(gps);
	}

	@Override
	public void delete(Long id) {
		gpsDao.deleteById(id);
		
	}

}
