package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.tus.interfaces.Accountable;

public class SavingsAccount extends Account {
	public SavingsAccount(double balance) {
		super(balance);
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
	
	@Override
	public String toString() {
		return id + "\tSavings\t" + balance;
	}
}
