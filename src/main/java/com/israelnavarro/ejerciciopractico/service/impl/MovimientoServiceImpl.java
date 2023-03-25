package com.israelnavarro.ejerciciopractico.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelnavarro.ejerciciopractico.entity.Movimiento;
import com.israelnavarro.ejerciciopractico.repository.MovimientosRepository;
import com.israelnavarro.ejerciciopractico.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

	
	private static final Logger log = LoggerFactory.getLogger(MovimientoServiceImpl.class);

	@Autowired
	private MovimientosRepository repository;
	
	@Override
	public Iterable<Movimiento> get() {
		log.debug("Obteniendo movimientos");
		return repository.findAll();
	}

	@Override
	public Movimiento post(Movimiento movimiento) {
		log.debug("Rregistrando movimiento {}", movimiento.toString());
		return repository.save(movimiento);
	}

	@Override
	public Movimiento put(Movimiento movimiento) {
		log.debug("Actualizando movimiento {}", movimiento.toString());
		return repository.save(movimiento);
	}

	@Override
	public void delete(Long id) {
		log.debug("Eliminando movimiento con ID {}", id);
		repository.deleteById(id);
		
	}

	
}
