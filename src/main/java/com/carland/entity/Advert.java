package com.carland.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name="description")
	private String description;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	@OneToMany(mappedBy="advert")
	private Collection<Image> images;
	
	public Advert(){
		
	}

	public Advert(User user, String title, String type, String make, String model, int price, short year,
			int mileage, String fuelType, String description, LocalDate expirationDate) {
		this.user = user;
		this.title = title;
		this.type = type;
		this.make = make;
		this.model = model;
		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.description = description;
		this.expirationDate = expirationDate;
	}
	
	public Advert(int id, User user, String title, String type, String make, String model, int price, short year,
			int mileage, String fuelType, String description, LocalDate expirationDate, Collection<Image> images) {
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
		this.description = description;
		this.expirationDate = expirationDate;
		this.images = images;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Advert [id=" + id + ", user=" + user + ", title=" + title + ", type=" + type + ", make=" + make
				+ ", model=" + model + ", price=" + price + ", year=" + year + ", mileage=" + mileage + ", fuelType="
				+ fuelType + ", describtion=" + description + ", expirationDate=" + expirationDate + "]";
	}
	
	
	
	
	
}
