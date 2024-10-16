package com.tus.models;

import java.time.LocalDate;
import java.util.Arrays;

public final class Teller extends User {
	private String password;
	
	public Teller(String firstName, String lastName, LocalDate dateOfBirth, String phoneNo, String address, String password) {
		super(firstName, lastName, dateOfBirth, phoneNo, address);
		this.password = password;
	}
	
	@Override
	public String toString() {
		var array = new char[password.length()];
		Arrays.fill(array, '*');
		
		return super.toString() + "Password: " + new String(array) + "\n";
	}
}
