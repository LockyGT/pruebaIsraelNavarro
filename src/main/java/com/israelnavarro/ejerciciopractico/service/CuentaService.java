package com.israelnavarro.ejerciciopractico.service;

import com.israelnavarro.ejerciciopractico.entity.Cuenta;

public interface CuentaService {
	Iterable<Cuenta> get();
	Cuenta post(Cuenta cuenta);
	Cuenta put(Cuenta cuenta);
	void delete(Long id);
}
