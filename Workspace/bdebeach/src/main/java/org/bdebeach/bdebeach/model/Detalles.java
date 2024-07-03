package org.bdebeach.bdebeach.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalles {
	
	private Long id_producto;
	private Long id_pedido;
	@Column(nullable=false)
	private String color;
	private String talla;
	private int cantidad;
	
	public Detalles(Long id_producto, Long id_pedido, String color, String talla, int cantidad) {
		this.id_producto = id_producto;
		this.id_pedido = id_pedido;
		this.color = color;
		this.talla = talla;
		this.cantidad = cantidad;
	}//constructor
	
	public Detalles() {}//constructor vacío 

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Detalles [id_producto=" + id_producto + ", id_pedido=" + id_pedido + ", color=" + color + ", talla="
				+ talla + ", cantidad=" + cantidad + "]";
	}//toString
	
}//class Detalles
