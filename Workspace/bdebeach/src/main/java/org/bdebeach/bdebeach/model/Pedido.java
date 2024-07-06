package org.bdebeach.bdebeach.model;

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
	private Long Usuario_id;
	private String fecha;
	private String status;
	private String metodopago; 
	private Double total;
	
	public Pedido(Long Usuario_id, String fecha, String status, String metodopago, Double total) {
		this.Usuario_id = Usuario_id;
		this.fecha = fecha;
		this.status = status;
		this.metodopago = metodopago;
		this.total = total;
	}//constructor
	
	public Pedido() {
	}//constructor vacío

	public Long getId_user() {
		return Usuario_id;
	}//getId_user

	public void setId_user(Long id_user) {
		this.Usuario_id = id_user;
	}//setId_user

	public String getFecha() {
		return fecha;
	}//getFecha

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}//setFecha

	public String getStatus() {
		return status;
	}//getStatus

	public void setStatus(String status) {
		this.status = status;
	}//setStatus

	public String getmPago() {
		return metodopago;
	}//getmPago

	public void setmPago(String mPago) {
		this.metodopago = mPago;
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
		return "Pedido [id=" + id + ", id_user=" + Usuario_id + ", fecha=" + fecha + ", status=" + status + ", mPago="
				+ metodopago + ", total=" + total + "]";
	}//toString
}//class Pedido