package org.bdebeach.bdebeach.dto;

public class ChangePassword {
	private String contrasena;
	private String nContrasena;
	public ChangePassword(String contrasena, String nContrasena) {
		super();
		this.contrasena = contrasena;
		this.nContrasena = nContrasena;
	}
	public ChangePassword() {
		// TODO Auto-generated constructor stub
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getnContrasena() {
		return nContrasena;
	}
	public void setnContrasena(String nContrasena) {
		this.nContrasena = nContrasena;
	}
	@Override
	public String toString() {
		return "ChangePassword [contrasena=" + contrasena + ", nContrasena=" + nContrasena + "]";
	}
	
}//class ChangePassword
