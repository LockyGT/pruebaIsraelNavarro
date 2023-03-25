package com.israelnavarro.ejerciciopractico.service;

import com.israelnavarro.ejerciciopractico.entity.Cliente;

public interface ClienteService {

	Iterable<Cliente> get();
	Cliente post(Cliente cliente);
	Cliente put(Cliente cliente);
	void delete(Long id);
}
