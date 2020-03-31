package com.carland.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	public User(){
		
	}
	
	public User(int id, String name, String telephone, String city, String street) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.city = city;
		this.street = street;
	}
	
	public User(String name, String telephone, String city, String street) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.city = city;
		this.street = street;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	
	
}
