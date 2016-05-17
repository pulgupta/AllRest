package com.common.entity;

public class FamilyDetails {

	private String fahtersName;
	private String mothersName;
	
	
	
	public FamilyDetails() {
		super();
	}
	public FamilyDetails(String fahtersName, String mothersName) {
		super();
		this.fahtersName = fahtersName;
		this.mothersName = mothersName;
	}
	public String getFahtersName() {
		return fahtersName;
	}
	public void setFahtersName(String fahtersName) {
		this.fahtersName = fahtersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	@Override
	public String toString() {
		return "FamilyDetails [fahtersName=" + fahtersName + ", mothersName=" + mothersName + "]";
	}
	
	
	
}
