package org.bdebeach.bdebeach.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Old Java Project
@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	private String descripcion;
	private String colores;
	private String tallas;
	private String img;
	@Column(nullable=false)
	private Double precio;
	
	public Producto(Long id, String nombre, String descripcion, String colores, String tallas, String img,
			Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.colores = colores;
		this.tallas = tallas;
		this.img = img;
		this.precio = precio;
	}//Constructor

	public Producto() {
	}//constructor vacio	
	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public String getColores() {
		return colores;
	}//getColores

	public void setColores(String colores) {
		this.colores = colores;
	}//setColores

	public String getTallas() {
		return tallas;
	}//getTallas

	public void setTallas(String tallas) {
		this.tallas = tallas;
	}//setTallas

	public String getImg() {
		return img;
	}//getImg

	public void setImg(String img) {
		this.img = img;
	}//setImg

	public Double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio
	
	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", colores=" + colores
				+ ", tallas=" + tallas + ", img=" + img + ", precio=" + precio + "]";
	}//toString
	
}//class Productos
