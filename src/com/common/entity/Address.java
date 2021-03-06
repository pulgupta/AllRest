package com.common.entity;

public class Address {

	private String houseNumber;
	private String street;
	private String landmark;
	private String city;
	
	
	public Address() {
		super();
	}

	public Address(String houseNumber, String street, String landmark, String city) {
		super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", street=" + street + ", landmark=" + landmark + ", city="
				+ city + "]";
	}
	
	
}
