package org.bdebeach.bdebeach.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	private String correo;
	private String contrasena;
	private int telefono;
	private String calleNumero;
	private String colonia;
	private String estado;
	private int CP;
	

	public Usuario(String nombre, String apellido, String correo, String contrasena, 	int telefono, String calleNumero, String colonia, String estado, int CP) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.calleNumero = calleNumero;
		this.colonia = colonia;
		this.estado = estado;
		this.CP = CP;
		}//1. Constructor (nombre, apellido, correo, contraseña, teléfono, 			calleNumero, colonia, estado, CP)
	
	public Usuario() {}//2. Constructor vacío

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido= apellido;
	}
	
	public String getcorreo() {
		return correo;
	}

	public void setcorreo(String correo) {
		this.correo = correo;
	}

	public String getcontrasena() {
		return contrasena;
	}

	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int gettelefono() {
		return telefono;
	}

	public void settelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getcalleNumero() {
		return calleNumero;
	}

	public void setcalleNumero(String calleNumero) {
		this.calleNumero = calleNumero;
	}
	
	public String getcolonia() {
		return colonia;
	}

	public void setcolonia(String colonia) {
		this.colonia = colonia;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado= estado;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int CP) {
		this.CP= CP;
	}

	public Long getId() {
		return id;
	}	// getter and setters (id-->readonly, sólo get)

	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + 
				", apellido=" + apellido + ", correo=" + correo + 
				", contrasena=" + contrasena + ", telefono=" + telefono + 
				", calleNumero=" + calleNumero + ", colonia=" + colonia + 
				", estado=" + estado + ", CP=" + CP + "]";
	}//toString
}//class Usuario
