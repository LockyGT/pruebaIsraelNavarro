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

import com.israelnavarro.ejerciciopractico.entity.Movimiento;
import com.israelnavarro.ejerciciopractico.service.MovimientoService;

@RestController
@RequestMapping(path = "/movimientos")
public class MovimientoController {
	@Autowired
	private MovimientoService service;
	
	@GetMapping
	public ResponseEntity<Iterable<Movimiento>>  get() {
		return new ResponseEntity<Iterable<Movimiento>>(service.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Movimiento> post( @RequestBody Movimiento movimiento) {
		return new ResponseEntity<Movimiento>(service.post(movimiento), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movimiento> put(@RequestBody Movimiento movimiento, @PathVariable Long id) {
		return new ResponseEntity<Movimiento>(service.put(movimiento), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			service.delete(id);
		}catch(DataAccessException e) {
			response.put("mensahe", "Error al eliminar el Movimiento");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Movimiento con id "+id+" ha sido eliminado");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
