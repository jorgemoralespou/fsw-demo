package com.example.switchyard.restproxy.rest.model;

public class UserIdentity {
	public String username;
	public String role;
	
	public Boolean isValid = false; 
	
	public UserIdentity() {
	}
	
	
	public UserIdentity(String username, String role) {
		this.username = username;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Boolean isValid() {
		return isValid;
	}

	public void setValid(Boolean isValid) {
		this.isValid = isValid;
	}


	@Override
	public String toString() {
		return "UserIdentity [username=" + username + ", role=" + role + ", isValid=" + isValid + "]";
	}
}
