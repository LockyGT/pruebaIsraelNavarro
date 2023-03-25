package com.israelnavarro.ejerciciopractico.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelnavarro.ejerciciopractico.entity.Cliente;
import com.israelnavarro.ejerciciopractico.repository.ClienteRepository;
import com.israelnavarro.ejerciciopractico.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Iterable<Cliente> get() {
		
		log.debug("Obteniendo clientes...");
		return repository.findAll();
	}

	@Override
	public Cliente post(Cliente cliente) {
		log.debug("Registrando cliente {}", cliente.toString());
		return repository.save(cliente);
	}

	@Override
	public Cliente put(Cliente cliente) {
		log.debug("Actualizando cliente {}", cliente.toString());
		return repository.save(cliente);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	
}
