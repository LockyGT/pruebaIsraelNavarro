package com.israelnavarro.ejerciciopractico.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.israelnavarro.ejerciciopractico.entity.Movimiento;

public interface MovimientosRepository extends CrudRepository<Movimiento, Long>{

	Iterable<Movimiento> findByCuentaClienteClienteIdAndFechaBetween(Long clienteId, Date fechaMovimiento1, Date fechaMovimiento2);
}
