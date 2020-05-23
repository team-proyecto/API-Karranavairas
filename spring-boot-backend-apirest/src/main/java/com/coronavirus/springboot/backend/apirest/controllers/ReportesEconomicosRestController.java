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
import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;
import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;

import com.coronavirus.springboot.backend.apirest.models.services.IEstadoEconomicoService;

import com.coronavirus.springboot.backend.apirest.models.services.IReporteEconomicoService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReportesEconomicosRestController {
	@Autowired
	IReporteEconomicoService reporteEconomicoService;
	IEstadoEconomicoService estadoEconomicoService;
	
	@GetMapping("/reconomicos")
	public List<ReporteEconomico> index (){
		return reporteEconomicoService.findAll();
	}
	
	@GetMapping("/reconomicos/{id}")
	public ResponseEntity<?> show (@PathVariable Long id){
		ReporteEconomico reporteEconomico = null;
		Map<String, Object> response =  new HashMap<>();
		
		try {
			reporteEconomico  = reporteEconomicoService.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(reporteEconomico == null)
		{
			response.put("mensaje", "El reporteEconomico ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
				
		return new ResponseEntity<ReporteEconomico>(reporteEconomico,HttpStatus.OK);
	}
	
	@PostMapping("/reconomicos")
	@Transactional
	public ResponseEntity<?> create (@Valid @RequestBody ReporteEconomico reporteEconomico, BindingResult result ){
				ReporteEconomico reporteEconomicoNew = null;
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
					reporteEconomicoNew  = reporteEconomicoService.save(reporteEconomico);
				} catch (DataAccessException e) {
					// TODO: handle exception
					response.put("mensaje", "Error al realizar el insert en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		
				response.put("mensaje", "El reporteEconomico ha sido creado con éxito!");
				response.put("reporteEconomico",  reporteEconomicoNew);
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/reconomicos/{id}")
	@Transactional
	public ResponseEntity<?> update (@Valid @RequestBody ReporteEconomico reporteEconomico,BindingResult result, @PathVariable Long id){

		ReporteEconomico reporteEconomicoActualizado = reporteEconomicoService.findById(id);
		
		ReporteEconomico reporteEconomicoUpdated= null;
		
		Map<String, Object> response =  new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if(reporteEconomicoActualizado == null)
		{
			response.put("mensaje", "Error: no se pudo editar, el reporteEconomico ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

		reporteEconomicoActualizado.setBonoAsignado(reporteEconomico.getBonoAsignado());	
		reporteEconomicoActualizado.setMontoServicio(reporteEconomico.getMontoServicio());			
		reporteEconomicoActualizado.setBoletaImagen(reporteEconomico.getBoletaImagen());			
		reporteEconomicoActualizado.setEstado(reporteEconomico.getEstado());
		
		reporteEconomicoUpdated = reporteEconomicoService.save(reporteEconomicoActualizado);
		
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el reporteEconomico en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El reporteEconomico ha sido actualizado con éxito!");
		response.put("reporteEconomico",  reporteEconomicoUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/reconomicos/{id}")
	@Transactional
	public ResponseEntity<?> delete (@PathVariable Long id){
		Map<String, Object> response =  new HashMap<>();
		
		try {
		reporteEconomicoService.delete(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el reporteEconomico en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El reporteEconomico ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);	
	}
	
	@GetMapping("/reconomicos/estadoseconomicos")
	public List<EstadoEconomico> listAll ( ){
		return estadoEconomicoService.findAll();
	}
	
	@GetMapping("/reconomicos/estadoseconomicos/{id}")
	public EstadoEconomico showEstado (@PathVariable Long id){
		return estadoEconomicoService.findById(id);
	}


}
