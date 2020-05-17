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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoMedico;
import com.coronavirus.springboot.backend.apirest.models.entity.ReporteMedico;
import com.coronavirus.springboot.backend.apirest.models.services.IEstadoMedicoService;
import com.coronavirus.springboot.backend.apirest.models.services.IReportesMedicosService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReportesMedicosRestController {
	@Autowired
	IReportesMedicosService reportesMedicosService;
	IEstadoMedicoService estadoMedicoService;
	
	@GetMapping("/rmedicos")
	public List<ReporteMedico> index (){
		return reportesMedicosService.findAll();
	}
	
	@GetMapping("/rmedicos/{id}")
	public ReporteMedico show (@PathVariable Long id){
		return reportesMedicosService.findById(id);
	}
	
	@PostMapping("/rmedicos")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReporteMedico create (@RequestBody ReporteMedico reporteMedico){
		
		/*System.out.println(reporteMedico);
		
		ReporteMedico nuevoReporteMedico = reportesMedicosService.save(reporteMedico);
		
		//ReporteMedico nuevoReporteMedico = new ReporteMedico();
		
		Boolean triaje = nuevoReporteMedico.getResultadoTriaje();
		
		nuevoReporteMedico.setResultadoTriaje(triaje);
				
		
		EstadoMedico estadoMedicoEnRiesgo = estadoMedicoService.findById((long)2) ;
		EstadoMedico estadoMedicoNormal = estadoMedicoService.findById((long)1) ;
		
		
		if(reporteMedico.getResultadoTriaje() == true) {
			nuevoReporteMedico.setEstadoMedico(estadoMedicoEnRiesgo);
		}else {
			nuevoReporteMedico.setEstadoMedico(estadoMedicoNormal);
		}
			
		nuevoReporteMedico.setEstado(true);
			
			System.out.println(nuevoReporteMedico);*/
		
		return reportesMedicosService.save(reporteMedico);
	}
	
	@PutMapping("/rmedicos/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReporteMedico update (@RequestBody ReporteMedico reporteMedico, @PathVariable Long id){
		//System.out.println("1"+estadoMedico);
		//estadoMedico.setId((long) 1);	
		//System.out.println("1"+estadoMedico);
		ReporteMedico reporteMedicoActualizado = reportesMedicosService.findById(id);
		//System.out.println("1"+estadoMedico);
		Boolean resultado = reporteMedico.getResultadoTriaje();
		//System.out.println("2"+estadoMedico);
		reporteMedicoActualizado.setResultadoTriaje(resultado);
		//System.out.println("3"+estadoMedico);
		//System.out.println("resultado"+resultado);
		
		//if(resultado == true) {			
			//System.out.println("resultado en condicional"+resultado);
			reporteMedicoActualizado.setEstadoMedico(reporteMedico.getEstadoMedico());	
			//System.out.println("en condicional"+estadoMedico);
		//}
		//System.out.println("fuera de condicional"+estadoMedico);
		//reporteMedicoActualizado.setEstadoMedico(estadoMedico);
		
		//reporteMedicoActualizado.definirEstado(reporteMedico.getResultadoTriaje());
			
		reporteMedicoActualizado.setEstado(reporteMedico.getEstado());
		
		
		return reportesMedicosService.save(reporteMedicoActualizado);
	}
	
	@DeleteMapping("/rmedicos/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id){
		reportesMedicosService.delete(id);
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
