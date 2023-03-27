package com.israelnavarro.ejerciciopractico.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUENTA")
public class Cuenta {


	@Id
	@Column(name = "NUMERO_CUENTA")
	private Integer noCuenta;
	
	@Column(name = "TIPO_CUENTA")
	private String tipoCuenta;
	
	@Column(name = "SALDO_INICIAL")
	private Double saldoInicial;
	
	@Column(name = "ESTADO")
	private Boolean estado;
	
	@Column(name="SALDO_ACTUAL")
	private Double saldoActual;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Cliente cliente;
	
	
	@JsonIgnoreProperties(value={"cuenta", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta", cascade = CascadeType.ALL)
	private List<Movimiento> movimientos;
	
	public Cuenta() { }
	
	
	public Cuenta( Integer noCuenta, String tipoCuenta, Double saldoInicial, Boolean estado) {
		
		
		this.noCuenta = noCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
	}

	/**
	 * @return the noCuenta
	 */
	public Integer getNoCuenta() {
		return noCuenta;
	}

	/**
	 * @param noCuenta the noCuenta to set
	 */
	public void setNoCuenta(Integer noCuenta) {
		this.noCuenta = noCuenta;
	}

	/**
	 * @return the tipoCuenta
	 */
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	/**
	 * @param tipoCuenta the tipoCuenta to set
	 */
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	/**
	 * @return the saldoInicial
	 */
	public Double getSaldoInicial() {
		return saldoInicial;
	}

	/**
	 * @param saldoInicial the saldoInicial to set
	 */
	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	/**
	 * @return the estado
	 */
	public Boolean getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	/**
	 * @return the saldoActual
	 */
	public Double getSaldoActual() {
		return saldoActual;
	}


	/**
	 * @param saldoActual the saldoActual to set
	 */
	public void setSaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}


	/**
	 * @return the movimientos
	 */
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}


	/**
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}


	@Override
	public String toString() {
		return "Cuenta [ noCuenta=" + noCuenta + ", tipoCuenta=" + tipoCuenta
				+ ", saldoInicial=" + saldoInicial + ", estado=" + estado + "]";
	}
	
	
}
