package com.israelnavarro.ejerciciopractico.repository;

import org.springframework.data.repository.CrudRepository;

import com.israelnavarro.ejerciciopractico.entity.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long>{

	Cuenta findByClienteClienteId(Long idCliente);
}
