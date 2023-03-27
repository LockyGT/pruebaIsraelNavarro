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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIMIENTO_ID")
	private Long idMovimiento;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "TIPO_MOVIMIENTO")
	private String tipoMovimiento;
	@Column(name = "VALOR")
	private String valor;
	@Column(name = "SALDO")
	private Double saldo;
	@Column(name = "ESTADO_INICIAL", columnDefinition = "TINYINT(1)")
	private Boolean estado;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUMERO_CUENTA")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Cuenta cuenta;
	
	public Movimiento(Long idMovimiento, Date date, String tipoMovimiento, String valor, Double saldo,
			Boolean estado) {
		this.idMovimiento = idMovimiento;
		this.fecha = date;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldo = saldo;
		this.estado = estado;
	}

	public Movimiento() {
	}

	/**
	 * @return the idMovimiento
	 */
	public Long getIdMovimiento() {
		return idMovimiento;
	}

	/**
	 * @param idMovimiento the idMovimiento to set
	 */
	public void setIdMovimiento(Long idMovimiento) {
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
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldoInicial the saldoInicial to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
				+ ", valor=" + valor + ", saldo=" + saldo + ", estado=" + estado + "]";
	}

}
