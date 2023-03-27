package com.israelnavarro.ejerciciopractico.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.israelnavarro.ejerciciopractico.dto.MovimientoDTO;
import com.israelnavarro.ejerciciopractico.service.MovimientoService;

@RestController
@RequestMapping(path = "/reportes")
public class ReportesController {

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private MovimientoService service;

	@GetMapping
	public ResponseEntity<?> getByCuentaClienteClienteIdAndFechaBetween(
			@RequestParam(name = "idUsuario") Long clienteId, 
			@RequestParam(name = "fechaInicio") String fechaInicio,
			@RequestParam(name = "fechaFin") String fechaFin) {
		List<MovimientoDTO> list = null;
		try {
			Date fechaInicioD = formato.parse(fechaInicio);
			Date fechaFinD = formato.parse(fechaFin);
			
			 list = service.getByIdClienteAndFechaMovimiento(clienteId, fechaInicioD, fechaFinD);

		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje", "Verifique si ha enviado el formato correo en las fechas");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<List<MovimientoDTO>>(list, HttpStatus.OK);
	}
}