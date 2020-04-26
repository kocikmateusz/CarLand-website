package com.carland.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="advert")
public class Advert {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user",nullable=false)
	private User user;
	
	@Column(name="title")
	private String title;
	
	@Column(name="type")
	private String type;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="price")
	private int price;
	
	@Column(name="year")
	private short year;
	
	@Column(name="mileage")
	private int mileage;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	@Column(name="describtion")
	private String describtion;
	
	@Column(name="expiration_date")
	private Date expirationDate;
	
	
	public Advert(){
		
	}

	public Advert(User user, String title, String type, String make, String model, int price, short year,
			int mileage, String fuelType, String describtion, Date expirationDate) {
		this.user = user;
		this.title = title;
		this.type = type;
		this.make = make;
		this.model = model;
		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.describtion = describtion;
		this.expirationDate = expirationDate;
	}
	
	public Advert(int id, User user, String title, String type, String make, String model, int price, short year,
			int mileage, String fuelType, String describtion, Date expirationDate) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.type = type;
		this.make = make;
		this.model = model;
		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.describtion = describtion;
		this.expirationDate = expirationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
	
}
