package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.tus.interfaces.Account;

public class CurrentAccount implements Account {
	private double balance;
	private ArrayList<Transaction> transactions;
	
	public CurrentAccount(double balance) {
		this.balance = balance;
		this.transactions = new  ArrayList<Transaction>();
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction(LocalDate.now(), amount, balance));
	}

	@Override
	public void withdraw(double amount) {
		var canWidthdraw = (balance - amount) > -100;
		
		if(canWidthdraw) {
			balance -= amount;
			transactions.add(new Transaction(LocalDate.now(), -amount, balance));
		}
	}
	
	boolean isOverdrawn() {
		return balance < 0;
	}
}
