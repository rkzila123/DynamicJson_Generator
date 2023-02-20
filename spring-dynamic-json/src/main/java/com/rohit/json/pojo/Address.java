package com.rohit.json.pojo;

public class Address {
	private String addressLine;
	private String city;
	private String state;
	private int zipCode;
	@Override
	public String toString()
	{
	    StringBuffer sb=new StringBuffer();
	    sb.append("AddressLine=").append(addressLine).append("\n");
	    sb.append("city=").append(city).append("\n");
	    sb.append("state=").append(state).append("\n");
	    sb.append("zipCode=").append(zipCode).append("\n");
	    return sb.toString();
	}
	public String getAddressLine() {
	    return addressLine;
	}
	public void setAddressLine(String addressLine) {
	    this.addressLine = addressLine;
	}
	public String getCity() {
	    return city;
	}
	public void setCity(String city) {
	    this.city = city;
	}
	public String getState() {
	    return state;
	}
	public void setState(String state) {
	    this.state = state;
	}
	public int getZipCode() {
	    return zipCode;
	}
	public void setZipCode(int zipCode) {
	    this.zipCode = zipCode;
	}

}
