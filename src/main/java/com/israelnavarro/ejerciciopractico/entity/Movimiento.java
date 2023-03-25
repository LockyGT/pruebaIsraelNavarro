package com.israelnavarro.ejerciciopractico.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "MOVIMIENTO")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MOVIMIENTO_ID")
	private Boolean idMovimiento;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "TIPO_MOVIMIENTO")
	private String tipoMovimiento;
	@Column(name = "VALOR")
	private String valor;
	@Column(name = "SALDO_INICIAL")
	private Double saldoInicial;
	@Column(name = "ESTADO_INICIAL", columnDefinition = "TINYINT(1)")
	private Boolean estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUMERO_CUENTA")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Cuenta cuenta;
	
	public Movimiento(Boolean idMovimiento, Date date, String tipoMovimiento, String valor, Double saldoInicial,
			Boolean estado) {
		this.idMovimiento = idMovimiento;
		this.fecha = date;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
	}

	public Movimiento() {
	}

	/**
	 * @return the idMovimiento
	 */
	public Boolean getIdMovimiento() {
		return idMovimiento;
	}

	/**
	 * @param idMovimiento the idMovimiento to set
	 */
	public void setIdMovimiento(Boolean idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the tipoMovimiento
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	/**
	 * @param tipoMovimiento the tipoMovimiento to set
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
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
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento
				+ ", valor=" + valor + ", saldoInicial=" + saldoInicial + ", estado=" + estado + "]";
	}

}
