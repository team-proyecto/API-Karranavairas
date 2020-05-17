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
	public ReporteEconomico show (@PathVariable Long id){
		return reporteEconomicoService.findById(id);
	}
	
	@PostMapping("/reconomicos")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReporteEconomico create (@RequestBody ReporteEconomico reporteEconomico){
		
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
		
		return reporteEconomicoService.save(reporteEconomico);
	}
	
	@PutMapping("/reconomicos/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReporteEconomico update (@RequestBody ReporteEconomico reporteEconomico, @PathVariable Long id){
		//System.out.println("1"+estadoMedico);
		//estadoMedico.setId((long) 1);	
		//System.out.println("1"+estadoMedico);
		ReporteEconomico reporteEconomicoActualizado = reporteEconomicoService.findById(id);
		//System.out.println("1"+estadoMedico);
		Boolean resultado = reporteEconomico.getBonoAsignado();
		//System.out.println("2"+estadoMedico);
		reporteEconomicoActualizado.setBonoAsignado(resultado);
		//System.out.println("3"+estadoMedico);
		//System.out.println("resultado"+resultado);
		
		//if(resultado == true) {			
			//System.out.println("resultado en condicional"+resultado);
		reporteEconomicoActualizado.setMontoServicio(reporteEconomico.getMontoServicio());	
			//System.out.println("en condicional"+estadoMedico);
		//}
		//System.out.println("fuera de condicional"+estadoMedico);
		//reporteMedicoActualizado.setEstadoMedico(estadoMedico);
		
		//reporteMedicoActualizado.definirEstado(reporteMedico.getResultadoTriaje());
		reporteEconomicoActualizado.setBoletaImagen(reporteEconomico.getBoletaImagen());
			
		reporteEconomicoActualizado.setEstado(reporteEconomico.getEstado());
		
		
		return reporteEconomicoService.save(reporteEconomicoActualizado);
	}
	
	@DeleteMapping("/reconomicos/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id){
		reporteEconomicoService.delete(id);
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
