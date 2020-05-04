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


import com.coronavirus.springboot.backend.apirest.models.entity.Compra;
import com.coronavirus.springboot.backend.apirest.models.services.ICompraService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CompraRestController {
	
	@Autowired
	ICompraService compraService;
	
	@GetMapping("/compras")
	public List<Compra> index(){
		return compraService.findAll();
	}
	
	@GetMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.OK) //esto es por defecto asi que seria redundante para este tipo de operacion
	public Compra showCliente( @PathVariable Long id) {
		return compraService.findById(id);
	}
	
	@PostMapping("/compras")
	@ResponseStatus(HttpStatus.CREATED) //aqui si es necesario para indicar que se creo contenido
	public Compra create(@RequestBody Compra compra) {		
		return compraService.save(compra);
	}
	
	@PutMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra update(@RequestBody Compra compra, @PathVariable Long id) {
		Compra compraActual = compraService.findById(id);
		
		compraActual.setNombreProducto(compra.getNombreProducto());
		compraActual.setClienteId(compra.getClienteId());		
		
		return compraService.save(compraActual);		
	}
	
	@DeleteMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		compraService.delete(id);		
	}

}
