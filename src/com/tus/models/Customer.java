package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public final class Customer extends User {
	private ArrayList<Account> accounts;
	
	public Customer(String firstName, String lastName, LocalDate dateOfBirth, String phoneNo, String address) {
		super(firstName, lastName, dateOfBirth, phoneNo, address);
		accounts = new ArrayList<Account>();
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public static Customer findCustomerById(Collection<Customer> customers, Integer id) {
		return customers.stream()
				.filter(c -> id.equals(c.getId()))
				.findFirst()
				.orElse(null);
	}
}
