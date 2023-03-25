package com.israelnavarro.ejerciciopractico.repository;

import org.springframework.data.repository.CrudRepository;

import com.israelnavarro.ejerciciopractico.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
