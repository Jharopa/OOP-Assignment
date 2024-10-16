package com.tus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public sealed abstract class User permits Teller, Customer {
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String phoneNo;
	private String address;
	
	public User(String firstName, String lastName, LocalDate dateOfBirth, String phoneNo, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.address = address;
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
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		return "Name: " + firstName + " " + lastName + "\n" +
				"DOB: " + dateOfBirth.format(formatter) + "\n" +
				"Contact Number: " + phoneNo + "\n" +
				"Address: " + address + "\n";
	}
}
