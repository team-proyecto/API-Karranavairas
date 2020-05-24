package com.coronavirus.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coronavirus.springboot.backend.apirest.models.entity.Cliente;
import com.coronavirus.springboot.backend.apirest.models.entity.Gps;
import com.coronavirus.springboot.backend.apirest.models.services.IGpsService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
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
	public ResponseEntity<?> show (@PathVariable Long id){
		Gps gps = null;
		Map<String, Object> response =  new HashMap<>();
		
		try {
			gps  = gpsService.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(gps == null)
		{
			response.put("mensaje", "El gps ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Gps>(gps,HttpStatus.OK);
	}
	
	@PostMapping("/gps")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> create (@Valid @RequestBody Gps gps, BindingResult result){
		Gps gpsNew = null;
		Map<String, Object> response =  new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			gpsNew  = gpsService.save(gps);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El gps ha sido creado con éxito!");
		response.put("gps",  gpsNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/gps/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> update (@Valid @RequestBody Gps gps,BindingResult result, @PathVariable Long id){
				
		Gps gpsActualizado = gpsService.findById(id);
		
		Gps gpsUpdated = null;
		Map<String, Object> response =  new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if(gpsActualizado == null)
		{
			response.put("mensaje", "Error: no se pudo editar, el gps ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
		gpsActualizado.setLatitud(gps.getLatitud());
		gpsActualizado.setLongitud(gps.getLongitud());
		gpsActualizado.setDireccionGps(gps.getDireccionGps());
		gpsActualizado.setEstado(gps.getEstado());
		gpsActualizado.setUsuarioCaso(gps.getUsuarioCaso());
		
		gpsUpdated = gpsService.save(gpsActualizado);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el gps en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El gps ha sido actualizado con éxito!");
		response.put("gps",  gpsUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/gps/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete (@PathVariable Long id){
		Map<String, Object> response =  new HashMap<>();
		try {				
			gpsService.delete(id);		
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al eliminar el gps en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El gps ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}

}
