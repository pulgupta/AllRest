package com.common.entity;

public class Student {

	private String name;
	private String className;
	private FamilyDetails familyDetails;
	private Address houseAddress;
	private Address mailingAddress;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public FamilyDetails getFamilyDetails() {
		return familyDetails;
	}
	public void setFamilyDetails(FamilyDetails familyDetails) {
		this.familyDetails = familyDetails;
	}
	public Address getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(Address houseAddress) {
		this.houseAddress = houseAddress;
	}
	public Address getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(Address mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	
	
	
}
