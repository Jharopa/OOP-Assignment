package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.tus.interfaces.Accountable;

public class CurrentAccount extends Account {
	public CurrentAccount(double balance) {
		super(balance);
	}

	@Override
	public void withdraw(double amount) {
		var canWidthdraw = (balance - amount) > -100;
		
		if(canWidthdraw) {
			balance -= amount;
			transactions.add(new Transaction(LocalDate.now(), -amount, balance));
		}
	}
	
	@Override
	public String toString() {
		return id + "\tSavings\t" + balance;
	}
}
