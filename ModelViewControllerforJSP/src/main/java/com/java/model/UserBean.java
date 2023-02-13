package com.java.model;
public class UserBean {

	String name;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValidate() {
		if(this.password.length()>8)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "UserBean [name=" + name + ", password=" + password + "]";
	}
	
}
