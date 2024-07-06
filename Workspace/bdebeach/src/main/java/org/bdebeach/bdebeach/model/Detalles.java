package org.bdebeach.bdebeach.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detallespedido")
public class Detalles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	private Long Productos_id;
	private Long Pedido_id;
	@Column(nullable=false)
	private String color;
	private String talla;
	private Integer cantidad;
	
	//constructor
	
	public Detalles() {}//constructor vacío 

	public Detalles(Long id, Long Productos_id, Long Pedido_id, String color, String talla, Integer cantidad) {
		this.id = id;
		this.Productos_id = Productos_id;
		this.Pedido_id = Pedido_id;
		this.color = color;
		this.talla = talla;
		this.cantidad = cantidad;
	}//constructor

	public Long getId_producto() {
		return Productos_id;
	}

	public void setId_producto(Long id_producto) {
		this.Productos_id = id_producto;
	}

	public Long getId_pedido() {
		return Pedido_id;
	}

	public void setId_pedido(Long id_pedido) {
		this.Pedido_id = id_pedido;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Detalles [id=" + id + ", id_producto=" + Productos_id + ", id_pedido=" + Pedido_id + ", color=" + color
				+ ", talla=" + talla + ", cantidad=" + cantidad + "]";
	}

	//toString
	
}//class Detalles
