package com.tus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import com.tus.interfaces.Printable;

public sealed abstract class User implements Printable permits Teller, Customer {
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String phoneNo;
	private String address;
	
	private static AtomicInteger nextId = new AtomicInteger();
	
	public User(String firstName, String lastName, LocalDate dateOfBirth, String phoneNo, String address) {
		id = nextId.incrementAndGet();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	public int getId() {
		return id;
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
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		return "User ID: " + id + "\n" + 
				"Name: " + firstName + " " + lastName + "\n" +
				"DOB: " + dateOfBirth.format(formatter) + "\n" +
				"Contact Number: " + phoneNo + "\n" +
				"Address: " + address + "\n";
	}
}
