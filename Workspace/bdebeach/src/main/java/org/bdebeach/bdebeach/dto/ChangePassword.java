package org.bdebeach.bdebeach.dto;

public class ChangePassword {
	private String password;
	private String nPassword;
	public ChangePassword(String password, String nPassword) {
		super();
		this.password = password;
		this.nPassword = nPassword;
	}
	public ChangePassword() {}	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getnPassword() {
		return nPassword;
	}
	public void setnPassword(String nPassword) {
		this.nPassword = nPassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", nPassword=" + nPassword + "]";
	}
	
}//class ChangePassword
