package com.israelnavarro.ejerciciopractico.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israelnavarro.ejerciciopractico.entity.Cuenta;
import com.israelnavarro.ejerciciopractico.service.CuentaService;

@RestController
@RequestMapping(path = "/cuentas")
public class CuentaController {

	@Autowired
	private CuentaService service;
	
	@GetMapping
	public ResponseEntity<Iterable<Cuenta>>  get() {
		return new ResponseEntity<Iterable<Cuenta>>(service.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cuenta> post( @RequestBody Cuenta cuenta) {
		return new ResponseEntity<Cuenta>(service.post(cuenta), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cuenta> put(@RequestBody Cuenta cuenta, @PathVariable Long id) {
		return new ResponseEntity<Cuenta>(service.put(cuenta), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			service.delete(id);
		}catch(DataAccessException e) {
			response.put("mensahe", "Error al eliminar el cliente");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente con id "+id+" ha sido eliminado");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
