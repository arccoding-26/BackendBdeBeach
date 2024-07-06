package org.bdebeach.bdebeach.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "usuario")
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
	private String telefono;
	private String callenumero;
	private String colonia;
	private String estado;
	private String CP;
	

	public Usuario(String nombre, String apellido, String correo, String contrasena, String telefono, String callenumero, String colonia, String estado, String CP) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.callenumero = callenumero;
		this.colonia = colonia;
		this.estado = estado;
		this.CP = CP;
		}//1. Constructor (nombre, apellido, correo, contraseña, teléfono, 			calleNumero, colonia, estado, CP)
	
	public Usuario() {}//2. Constructor vacío

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido= apellido;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCalleNumero() {
		return callenumero;
	}

	public void setCalleNumero(String callenumero) {
		this.callenumero = callenumero;
	}
	
	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado= estado;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String CP) {
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
				", callenumero=" + callenumero + ", colonia=" + colonia + 
				", estado=" + estado + ", CP=" + CP + "]";
	}//toString
}//class Usuario
