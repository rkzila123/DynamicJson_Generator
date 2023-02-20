package com.rohit.json.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Student {
	
	private int rollNumber;
    private String firstName;
    private String lastName;
    private boolean permanent;
    private Address address;
    private long[] phoneNumbers;
    private List<String> cities;
    private Map<String, String> properties;
    @Override
    public String toString()
    {
        StringBuffer sb=new StringBuffer();
        sb.append("==============Student Information================\n");
        sb.append("rollNumber=").append(rollNumber).append("\n");
        sb.append("firstName=").append(firstName).append("\n");
        sb.append("lastName=").append(lastName).append("\n");
        sb.append("permanent=").append(permanent).append("\n");
        sb.append("adress=").append(address).append("\n");
        sb.append("phoneNumbers=").append(Arrays.toString(phoneNumbers)).append("\n");
        sb.append("cities=").append(Arrays.toString(cities.toArray(new String[cities.size()]))).append("\n");
        sb.append("properties=").append(properties).append("\n");
        return sb.toString();
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public boolean isPermanent() {
        return permanent;
    }
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public long[] getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public List<String> getCities() {
        return cities;
    }
    public void setCities(List<String> cities) {
        this.cities = cities;
    }
    public Map<String, String> getProperties() {
        return properties;
    }
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
 

}
