package com.tus.interfaces;

import com.tus.enums.AccountType;
import com.tus.models.Account;
import com.tus.models.CurrentAccount;
import com.tus.models.SavingsAccount;

public interface Accountable {
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
	
	public static Account createAccount(AccountType type, double initialBalance) {
		return switch (type) {
			case Savings -> new SavingsAccount(initialBalance);
			case Current -> new CurrentAccount(initialBalance);
		};
	}
}
