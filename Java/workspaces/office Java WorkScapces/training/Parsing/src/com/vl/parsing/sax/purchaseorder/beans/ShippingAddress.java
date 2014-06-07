package com.vl.parsing.sax.purchaseorder.beans;

public class ShippingAddress {
	private String Name;
	private String FatherName;
	private String DoorNo;
	private String Street;
	private String City;
	private String Distict;
	private String State;
	private String Country;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getDoorNo() {
		return DoorNo;
	}
	public void setDoorNo(String doorNo) {
		DoorNo = doorNo;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDistict() {
		return Distict;
	}
	public void setDistict(String distict) {
		Distict = distict;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
