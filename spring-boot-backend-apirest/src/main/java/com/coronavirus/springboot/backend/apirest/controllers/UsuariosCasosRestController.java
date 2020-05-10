package com.coronavirus.springboot.backend.apirest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;
import com.coronavirus.springboot.backend.apirest.models.services.IGpsService;
import com.coronavirus.springboot.backend.apirest.models.services.IUsuariosCasosService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuariosCasosRestController {
	
	@Autowired
	private IUsuariosCasosService usuariosCasosService;
	
	@Autowired
	private IGpsService gpsService;
	
	@GetMapping("/usuarioscasos")
	public List<UsuarioCaso> index(){
		return usuariosCasosService.findAll();
	}
	
	@GetMapping("/usuarioscasos/{id}")
	public UsuarioCaso show(@PathVariable Long id) {
		return usuariosCasosService.findById(id);
	}
	
	@PostMapping("/usuarioscasos")
	@ResponseStatus(value = HttpStatus.CREATED)
	public UsuarioCaso save(@RequestBody UsuarioCaso usuarioCaso) {
		
		//Gps gpsNuevo = gpsService.save(gps);
		
		//gpsNuevo.getId();
		
		//UsuarioCaso usuarioCasoNuevo = 
		
		//usuarioCasoNuevo.setGps(gpsNuevo);
		
		return usuariosCasosService.save(usuarioCaso);
	}
	
	@PutMapping("/usuarioscasos/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public UsuarioCaso update(@RequestBody UsuarioCaso usuarioCasoNuevo, @PathVariable Long id) {
		UsuarioCaso usuarioCasoActualizado;
		usuarioCasoActualizado = usuariosCasosService.findById(id);
		
		usuarioCasoActualizado.setTelefono(usuarioCasoNuevo.getTelefono());
		usuarioCasoActualizado.setNombre(usuarioCasoNuevo.getNombre());
		usuarioCasoActualizado.setApellido(usuarioCasoNuevo.getApellido());
		usuarioCasoActualizado.setDireccionDomicilio(usuarioCasoNuevo.getDireccionDomicilio());
		usuarioCasoActualizado.setTipoDocumento(usuarioCasoNuevo.getTipoDocumento());
		usuarioCasoActualizado.setNumeroDocumento(usuarioCasoNuevo.getNumeroDocumento());
		usuarioCasoActualizado.setCodigoConfirmacion(usuarioCasoNuevo.getCodigoConfirmacion());
		usuarioCasoActualizado.setCondicionUso(usuarioCasoNuevo.getCondicionUso());
		usuarioCasoActualizado.setDepartamento(usuarioCasoNuevo.getDepartamento());
		usuarioCasoActualizado.setEstado(usuarioCasoNuevo.getEstado());
		usuarioCasoActualizado.setFechaRegistro(usuarioCasoNuevo.getFechaRegistro());
		usuarioCasoActualizado.setGps(usuarioCasoNuevo.getGps());
		usuarioCasoActualizado.setNacimiento(usuarioCasoNuevo.getNacimiento());
		usuarioCasoActualizado.setNacionalidad(usuarioCasoNuevo.getNacionalidad());
		usuarioCasoActualizado.setReporteMedico(usuarioCasoNuevo.getReporteMedico());
		usuarioCasoActualizado.setResporteEconomico(usuarioCasoNuevo.getResporteEconomico());
		usuarioCasoActualizado.setTipoUsuario(usuarioCasoNuevo.getTipoUsuario());		
		
		return usuariosCasosService.save(usuarioCasoActualizado);
	}
	
	@DeleteMapping("/usuarioscasos/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {				
		usuariosCasosService.delete(id);
	}
	
	
	@GetMapping("/usuarioscasos/documentos")
	public List<TipoDocumento> listDocumentos(){
		return usuariosCasosService.findAllDocumentos();
	}
	
	@GetMapping("/usuarioscasos/departamentos")
	public List<Departamento> listDepartamento() {
		return usuariosCasosService.findAllDepartamento();
	}
	
	@GetMapping("/usuarioscasos/nacionalidad")
	public List<Nacionalidad> listNacionalidad() {
		return usuariosCasosService.findAllNacionalidad();
	}

}
