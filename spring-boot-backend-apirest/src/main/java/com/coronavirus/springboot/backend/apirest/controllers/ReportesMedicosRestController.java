package com.coronavirus.springboot.backend.apirest.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoMedico;
import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;
import com.coronavirus.springboot.backend.apirest.models.services.IEstadoMedicoService;
import com.coronavirus.springboot.backend.apirest.models.services.IReportesMedicosService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class ReportesMedicosRestController {
	@Autowired
	IReportesMedicosService reportesMedicosService;
	
	@Autowired
	IEstadoMedicoService estadoMedicoService;
	
	@GetMapping("/rmedicos")
	public List<ReporteMedico> index (){
		return reportesMedicosService.findAll();
	}
	
	@GetMapping("/rmedicos/page/{page}")
	public Page<ReporteMedico> index (@PathVariable Integer page){
		return reportesMedicosService.findAll(PageRequest.of(page, 2));
	}
	
	@GetMapping("/rmedicos/reporte")
	public List<ReporteMedico> reportePorReporteEconomico (@RequestParam Long estadoMedicoId){
		return reportesMedicosService.findByEstadoMedico(estadoMedicoId);
	}
	
	@GetMapping("/rmedicos/{id}")
	public ResponseEntity<?> show (@PathVariable Long id){
		ReporteMedico reporteMedico = null;
		Map<String, Object> response =  new HashMap<>();
		try {
			reporteMedico  = reportesMedicosService.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(reporteMedico == null)
		{
			response.put("mensaje", "El reporteMedico ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ReporteMedico>(reporteMedico,HttpStatus.OK);
	}
	
	@PostMapping("/rmedicos")
	@Transactional	
	public ResponseEntity<?> create (@Valid @RequestBody ReporteMedico reporteMedico, BindingResult result){
		ReporteMedico reporteMedicoNew =  null;
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
			reporteMedicoNew  = reportesMedicosService.save(reporteMedico);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		response.put("mensaje", "El reporteMedico ha sido creado con éxito!");
		response.put("reporteMedico",  reporteMedicoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/rmedicos/{id}")
	@Transactional	
	public ResponseEntity<?> update (@Valid @RequestBody ReporteMedico reporteMedico,BindingResult result , @PathVariable Long id){
		
		ReporteMedico reporteMedicoActualizado = reportesMedicosService.findById(id);
		
		ReporteMedico reporteMedicoUpdated = null;
		Map<String, Object> response =  new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(reporteMedicoActualizado == null)
		{
			response.put("mensaje", "Error: no se pudo editar, el reporteMedico ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
	
		reporteMedicoActualizado.setResultadoTriaje(reporteMedico.getResultadoTriaje());
		reporteMedicoActualizado.setEstadoMedico(reporteMedico.getEstadoMedico());	
		reporteMedicoActualizado.setEstado(reporteMedico.getEstado());
		
		reporteMedicoUpdated = reportesMedicosService.save(reporteMedicoActualizado);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el reporteMedico en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El reporteMedico ha sido actualizado con éxito!");
		response.put("reporteMedico",  reporteMedicoUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/rmedicos/{id}")
	@Transactional	
	public ResponseEntity<?> delete (@PathVariable Long id){
			
		Map<String, Object> response =  new HashMap<>();
		
		try {			
			
			reportesMedicosService.delete(id);
		
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al eliminar el reporteMedico en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El reporteMedico ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/rmedicos/estadosmedicos")
	public List<EstadoMedico> listAll ( ){
		return estadoMedicoService.findAll();
	}
	
	@GetMapping("/rmedicos/estadosmedicos/{id}")
	public EstadoMedico showEstado (@PathVariable Long id){
		return estadoMedicoService.findById(id);
	}


}
