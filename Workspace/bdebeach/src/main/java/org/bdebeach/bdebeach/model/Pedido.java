package org.bdebeach.bdebeach.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private Long id_user;
	private Date fecha;
	private String status;
	private String mPago; //mPago significa= metodo de pago
	private Double total;
	
	public Pedido(Long id_user, Date fecha, String status, String mPago, Double total) {
		this.id_user = id_user;
		this.fecha = fecha;
		this.status = status;
		this.mPago = mPago;
		this.total = total;
	}//contructor
	
	public Pedido() {
	}//constructor vacío

	public Long getId_user() {
		return id_user;
	}//getId_user

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}//setId_user

	public Date getFecha() {
		return fecha;
	}//getFecha

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}//setFecha

	public String getStatus() {
		return status;
	}//getStatus

	public void setStatus(String status) {
		this.status = status;
	}//setStatus

	public String getmPago() {
		return mPago;
	}//getmPago

	public void setmPago(String mPago) {
		this.mPago = mPago;
	}//setmPago

	public Double getTotal() {
		return total;
	}//getTotal

	public void setTotal(Double total) {
		this.total = total;
	}//setTotal

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", id_user=" + id_user + ", fecha=" + fecha + ", status=" + status + ", mPago="
				+ mPago + ", total=" + total + "]";
	}//toString
}//class Pedido