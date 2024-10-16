package com.tus.models;

import com.tus.interfaces.Account;
import java.time.LocalDate;
import java.util.ArrayList;

public final class Customer extends User {
	private ArrayList<Account> accounts;
	
	public Customer(String firstName, String lastName, LocalDate dateOfBirth, String phoneNo, String address) {
		super(firstName, lastName, dateOfBirth, phoneNo, address);
		accounts = new ArrayList<Account>();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
