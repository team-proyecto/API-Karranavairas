package com.coronavirus.springboot.backend.apirest.controllers;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.multipart.MultipartFile;

import com.coronavirus.springboot.backend.apirest.models.entity.EstadoEconomico;
import com.coronavirus.springboot.backend.apirest.models.entity.ReporteEconomico;

import com.coronavirus.springboot.backend.apirest.models.services.IEstadoEconomicoService;

import com.coronavirus.springboot.backend.apirest.models.services.IReporteEconomicoService;


@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class ReportesEconomicosRestController {
	
	@Autowired
	private IReporteEconomicoService reporteEconomicoService;
	
	@Autowired
	private IEstadoEconomicoService estadoEconomicoService;
	

	
	@GetMapping("/reconomicos")
	public List<ReporteEconomico> index (){
		return reporteEconomicoService.findAll();
	}
	
	@GetMapping("/reconomicos/page/{page}")
	public Page<ReporteEconomico> index (@PathVariable Integer page){
		return reporteEconomicoService.findAll(PageRequest.of(page, 2));
	}
	
	@GetMapping("/reconomicos/reporte")
	public List<ReporteEconomico> reportePorEstadoMedico (@RequestParam Long estadoEconomicoId){
		return reporteEconomicoService.findByEstadoEconomico(estadoEconomicoId);
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
		reporteEconomicoActualizado.setEstadoEconomico(reporteEconomico.getEstadoEconomico());
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
			ReporteEconomico reporteEconomico = reporteEconomicoService.findById(id);
			String nombreFotoAnterior = reporteEconomico.getBoletaImagen();
			
			if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists()&& archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
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
	public List<EstadoEconomico> listEstadosEconomicos( ){
		return estadoEconomicoService.findAll();
	}
	
	@GetMapping("/reconomicos/estadoseconomicos/{id}")
	public EstadoEconomico showEstado(@PathVariable Long id){
		return estadoEconomicoService.findById(id);
	}
	
	@PostMapping("/reconomicos/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response =  new HashMap<>();
		
		ReporteEconomico reporteEconomico = reporteEconomicoService.findById(id);
		if(!archivo.isEmpty()) {
			String  nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen" + nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = reporteEconomico.getBoletaImagen();
			
			if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists()&& archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
			reporteEconomico.setBoletaImagen(nombreArchivo);
			
			reporteEconomicoService.save(reporteEconomico);
			
			response.put("reporteEconomico", reporteEconomico);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/reconomicos/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto (@PathVariable String nombreFoto){
		
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new  RuntimeException("Error no se pudo cargar la imagen: " + nombreFoto);
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		
		return new ResponseEntity<Resource>(recurso,cabecera, HttpStatus.OK);
	}
	
	


}
