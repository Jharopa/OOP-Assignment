package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.tus.interfaces.Account;

public class SavingsAccount implements Account {
	private double balance;
	private ArrayList<Transaction> transactions;
	
	public SavingsAccount(double balance) {
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
		var canWidthdraw = amount < (balance / 2) && (balance - amount) >= 100;
		
		if(canWidthdraw) {
			balance -= amount;
			transactions.add(new Transaction(LocalDate.now(), -amount, balance));
		}
	}
	
	public void payDividends() {
		double dividends = (balance / 2) * 0.0036;
		balance += dividends;
		transactions.add(new Transaction(LocalDate.now(), dividends, balance));
	}

}
