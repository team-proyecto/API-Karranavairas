package com.coronavirus.springboot.backend.apirest.controllers;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coronavirus.springboot.backend.apirest.models.entity.Cliente;
import com.coronavirus.springboot.backend.apirest.models.entity.Departamento;
import com.coronavirus.springboot.backend.apirest.models.entity.Distrito;
import com.coronavirus.springboot.backend.apirest.models.entity.Nacionalidad;
import com.coronavirus.springboot.backend.apirest.models.entity.Provincia;
import com.coronavirus.springboot.backend.apirest.models.entity.TipoDocumento;
import com.coronavirus.springboot.backend.apirest.models.entity.UsuarioCaso;
import com.coronavirus.springboot.backend.apirest.models.services.IGpsService;
import com.coronavirus.springboot.backend.apirest.models.services.IUsuariosCasosService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
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
	
	@GetMapping("/usuarioscasos/page/{page}")
	public Page<UsuarioCaso> index(@PathVariable Integer page){
		return usuariosCasosService.findAll(PageRequest.of(page, 2));
	}
	
	@GetMapping("/usuarioscasos/reporte")
	public List<UsuarioCaso> reportePorFechaRegistro(@RequestParam Date fechaInicio,@RequestParam Date fechaFinal){
		return usuariosCasosService.findByFechaRegistro(fechaInicio, fechaFinal);
	}
	
	@GetMapping("/usuarioscasos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		UsuarioCaso usuarioCaso = null;
		Map<String, Object> response =  new HashMap<>();
		
		try {
			usuarioCaso  = usuariosCasosService.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(usuarioCaso == null)
		{
			response.put("mensaje", "El usuarioCaso ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
				
		return new ResponseEntity<UsuarioCaso>(usuarioCaso,HttpStatus.OK);		
	}
	
	@PostMapping("/usuarioscasos")
	public ResponseEntity<?> save(@Valid @RequestBody UsuarioCaso usuarioCaso, BindingResult result) {
		
		UsuarioCaso usuarioCasoNew = null;
		Map<String, Object> response =  new HashMap<>();
		
		//devuelve los errores por campo en forma de lista
		if(result.hasErrors()) {						
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());			
			
			response.put("errors", errors);
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			usuarioCasoNew  = usuariosCasosService.save(usuarioCaso);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
			
		response.put("mensaje", "El usuarioCaso ha sido creado con éxito!");
		response.put("usuarioCaso",  usuarioCasoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);		
	}
	
	@PutMapping("/usuarioscasos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody UsuarioCaso usuarioCasoNuevo,BindingResult result, @PathVariable Long id) {
		
		UsuarioCaso usuarioCasoActualizado;
		usuarioCasoActualizado = usuariosCasosService.findById(id);
		
		UsuarioCaso usuarioCasoUpdated = null;
		
		Map<String, Object> response =  new HashMap<>();
		
		if(result.hasErrors()) {					
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());			
			response.put("errors", errors);
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(usuarioCasoActualizado == null)
		{
			response.put("mensaje", "Error: no se pudo editar, el usuarioCaso ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
		usuarioCasoActualizado.setTelefono(usuarioCasoNuevo.getTelefono());
		usuarioCasoActualizado.setNombre(usuarioCasoNuevo.getNombre());
		usuarioCasoActualizado.setApellido(usuarioCasoNuevo.getApellido());
		usuarioCasoActualizado.setDireccionDomicilio(usuarioCasoNuevo.getDireccionDomicilio());
		usuarioCasoActualizado.setTipoDocumento(usuarioCasoNuevo.getTipoDocumento());
		usuarioCasoActualizado.setNumeroDocumento(usuarioCasoNuevo.getNumeroDocumento());
		usuarioCasoActualizado.setCodigoConfirmacion(usuarioCasoNuevo.getCodigoConfirmacion());
		usuarioCasoActualizado.setCondicionUso(usuarioCasoNuevo.getCondicionUso());
		usuarioCasoActualizado.setDistrito(usuarioCasoNuevo.getDistrito());
		usuarioCasoActualizado.setEstado(usuarioCasoNuevo.getEstado());
		usuarioCasoActualizado.setFechaRegistro(usuarioCasoNuevo.getFechaRegistro());
		usuarioCasoActualizado.setGps(usuarioCasoNuevo.getGps());
		usuarioCasoActualizado.setNacimiento(usuarioCasoNuevo.getNacimiento());
		usuarioCasoActualizado.setNacionalidad(usuarioCasoNuevo.getNacionalidad());
		usuarioCasoActualizado.setReporteMedico(usuarioCasoNuevo.getReporteMedico());
		usuarioCasoActualizado.setReporteEconomico(usuarioCasoNuevo.getReporteEconomico());
		usuarioCasoActualizado.setTipoUsuario(usuarioCasoNuevo.getTipoUsuario());		
		
		usuarioCasoUpdated = usuariosCasosService.save(usuarioCasoActualizado);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuarioCaso en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuarioCaso ha sido actualizado con éxito!");
		response.put("usuarioCaso",  usuarioCasoUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuarioscasos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {	
		
		Map<String, Object> response =  new HashMap<>();
		
		try {						
			usuariosCasosService.delete(id);		
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al eliminar el usuarioCaso en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuarioCaso ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);	
	}
	
	
	@GetMapping("/usuarioscasos/documentos")
	public List<TipoDocumento> listDocumentos(){
		return usuariosCasosService.findAllDocumentos();
	}
	
	@GetMapping("/usuarioscasos/nacionalidad")
	public List<Nacionalidad> listNacionalidad() {
		return usuariosCasosService.findAllNacionalidad();
	}
	
	//para departamentos
	@GetMapping("/usuarioscasos/departamentos")
	public List<Departamento> listDepartamento() {
		return usuariosCasosService.findAllDepartamento();
	}	
	
	//para provincias
	@GetMapping("/usuarioscasos/departamentos/{id}")
	public Departamento listDepartamento(@PathVariable Long id) {
		return usuariosCasosService.findByIDDepartamento(id);
	}	
	
	//para distritos
	@GetMapping("/usuarioscasos/provincias/{id}")
	public Provincia listProvincias(@PathVariable Long id){
		return usuariosCasosService.findIDProvincia(id);
	}
	
	@GetMapping("/usuarioscasos/distrito")
	public List<Distrito> listDistritos(){
		return usuariosCasosService.findAllDistrito();
	}

}
