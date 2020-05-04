package com.coronavirus.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coronavirus.springboot.backend.apirest.models.entity.Gps;
import com.coronavirus.springboot.backend.apirest.models.services.IGpsService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class GpsRestController {
	
	@Autowired
	IGpsService gpsService;
	
	@GetMapping("/gps")
	public List<Gps> index (){
		return gpsService.findAll();
	}
	
	@GetMapping("/gps/{id}")
	public Gps show (@PathVariable Long id){
		return gpsService.findById(id);
	}
	
	@PostMapping("/gps")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public Gps create (@RequestBody Gps gps){
		return gpsService.save(gps);
	}
	
	@PutMapping("/gps/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public Gps update (@RequestBody Gps gps, @PathVariable Long id){
		Gps gpsActualizado = gpsService.findById(id);
		
		gpsActualizado.setLatitud(gps.getLatitud());
		gpsActualizado.setLongitud(gps.getLongitud());
		gpsActualizado.setDireccionGps(gps.getDireccionGps());
		gpsActualizado.setEstado(gps.getEstado());
		gpsActualizado.setUsuarioCaso(gps.getUsuarioCaso());	
		
		return gpsService.save(gpsActualizado);
	}
	
	@DeleteMapping("/gps/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id){
		gpsService.delete(id);
	}

}
