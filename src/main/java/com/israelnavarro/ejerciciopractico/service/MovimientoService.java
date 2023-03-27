package com.israelnavarro.ejerciciopractico.service;

import java.util.Date;
import java.util.List;

import com.israelnavarro.ejerciciopractico.dto.MovimientoDTO;
import com.israelnavarro.ejerciciopractico.entity.Movimiento;

public interface MovimientoService {

	Iterable<Movimiento> get();
	List<MovimientoDTO> getByIdClienteAndFechaMovimiento(Long clienteId, Date fechaMovimiento1, Date fechaMovimiento2);
	Movimiento post(Movimiento movimiento);
	Movimiento put(Movimiento movimiento);
	void delete(Long id);
}
