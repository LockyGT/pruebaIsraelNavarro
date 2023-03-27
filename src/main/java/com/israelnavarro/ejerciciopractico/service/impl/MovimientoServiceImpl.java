package com.israelnavarro.ejerciciopractico.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelnavarro.ejerciciopractico.dto.MovimientoDTO;
import com.israelnavarro.ejerciciopractico.entity.Cuenta;
import com.israelnavarro.ejerciciopractico.entity.Movimiento;
import com.israelnavarro.ejerciciopractico.repository.CuentaRepository;
import com.israelnavarro.ejerciciopractico.repository.MovimientosRepository;
import com.israelnavarro.ejerciciopractico.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

	
	private static final Logger log = LoggerFactory.getLogger(MovimientoServiceImpl.class);

	@Autowired
	private MovimientosRepository repository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public Iterable<Movimiento> get() {
		log.debug("Obteniendo movimientos");
		return repository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public List<MovimientoDTO> getByIdClienteAndFechaMovimiento(Long clienteId, Date fechaMovimiento1, Date fechaMovimiento2) {
		List<MovimientoDTO> listaRest = new ArrayList<>();
		MovimientoDTO mDTO = null;
		Iterable<Movimiento> resultado = repository.findByCuentaClienteClienteIdAndFechaBetween(clienteId, fechaMovimiento1, fechaMovimiento2);
		Iterator<Movimiento> it= resultado.iterator();
		while(it.hasNext()) {
			Movimiento movimiento = it.next();
			mDTO.setFecha(movimiento.getFecha());
			mDTO.setCliente(movimiento.getCuenta().getCliente().getNombre());
			mDTO.setNumeroCuenta(movimiento.getCuenta().getNoCuenta().toString());
			mDTO.setTipo(movimiento.getTipoMovimiento());
			mDTO.setSaldoInicial(movimiento.getCuenta().getSaldoInicial());
			mDTO.setEstado(movimiento.getEstado().toString());
			mDTO.setMovimiento(movimiento.getValor());
			mDTO.setSaldoDisponible(calcSaldoDisponible(mDTO.getSaldoInicial(),mDTO.getCliente()));
			listaRest.add(mDTO);
		}
		return listaRest;
	}

	@Override
	public  Movimiento post(Movimiento movimiento) {
		log.debug("Rregistrando movimiento {}", movimiento.toString());
		
		Cuenta cuenta = cuentaRepository.findByClienteClienteId(movimiento.getCuenta().getCliente().getClienteId());
		
		if(cuenta.getSaldoActual() == 0) {
			return null;
		}

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

	private Double calcSaldoDisponible(Double salgoInicial, String movimiento) {
		
		String[] m = movimiento.split("\\s");
		
		if(m[0].equalsIgnoreCase("Retiro")) {
			return salgoInicial - Double.parseDouble(m[2]);
		}
		
		if(m[0].equalsIgnoreCase("Deposito")) {
			return salgoInicial - Double.parseDouble(m[2]);
		}
		return salgoInicial;
	}
}
