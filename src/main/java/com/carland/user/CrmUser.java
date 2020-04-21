package com.carland.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmUser {

	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String username;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String name;
	
	@NotNull(message = "is required")
	@Size(min = 9, max=9, message = "must count 9 digits")
	private String telephoneNumber;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String city;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String street;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String postalCode;

	
	public CrmUser() {
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
}
