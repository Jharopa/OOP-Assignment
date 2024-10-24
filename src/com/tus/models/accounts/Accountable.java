package com.tus.models.accounts;

import com.tus.enums.AccountType;

public sealed interface Accountable permits Account {
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
