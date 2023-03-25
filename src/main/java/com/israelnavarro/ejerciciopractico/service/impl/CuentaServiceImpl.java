package com.israelnavarro.ejerciciopractico.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelnavarro.ejerciciopractico.entity.Cuenta;
import com.israelnavarro.ejerciciopractico.repository.CuentaRepository;
import com.israelnavarro.ejerciciopractico.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

	
	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);

	@Autowired
	private CuentaRepository repository;
	
	@Override
	public Iterable<Cuenta> get() {
		log.debug("Obteniendo cuentas");
		return repository.findAll();
	}

	@Override
	public Cuenta post(Cuenta cuenta) {
		log.debug("Registrando cuenta {}",cuenta.toString());
		return repository.save(cuenta);
	}

	@Override
	public Cuenta put(Cuenta cuenta) {
		log.debug("Actualizando cuenta {}",cuenta.toString());
		return repository.save(cuenta);
	}

	@Override
	public void delete(Long id) {
		log.debug("Eliminando cuenta con ID {}",id);
		repository.deleteById(id);
		
	}

	
}
