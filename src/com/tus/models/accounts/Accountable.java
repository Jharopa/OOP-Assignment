package com.tus.models.accounts;

public sealed interface Accountable permits Account {
	double getBalance();
	void deposit(double amount) throws AccountException;
	void withdraw(double amount) throws AccountException;
	
	public static Account createAccount(AccountType type, double initialBalance) {
		return switch (type) {
			case Savings -> new SavingsAccount(initialBalance);
			case Current -> new CurrentAccount(initialBalance);
		};
	}
}
