package com.israelnavarro.ejerciciopractico.service;

import com.israelnavarro.ejerciciopractico.entity.Movimiento;

public interface MovimientoService {

	Iterable<Movimiento> get();
	Movimiento post(Movimiento movimiento);
	Movimiento put(Movimiento movimiento);
	void delete(Long id);
}
