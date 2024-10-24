package com.tus.models.accounts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class CurrentAccount extends Account {
	public CurrentAccount() {
		this(0);
	}
	
	public CurrentAccount(double balance) {
		super(balance);
	}

	@Override
	public void withdraw(double amount) throws AccountException {
		if (amount <= 0) {
			throw new AccountException("Withdrawl amount must be an non-zero value");
		}
		
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
