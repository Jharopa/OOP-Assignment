package com.tus.models.accounts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.tus.utils.StringUtils;

public abstract sealed class Account implements Accountable permits SavingsAccount, CurrentAccount{
	protected int id;
	protected double balance;
	protected ArrayList<Transaction> transactions;
	
	private static AtomicInteger nextId = new AtomicInteger();
	
	public Account(double balance) {
		this.id = nextId.incrementAndGet();
		this.balance = balance;
		this.transactions = new  ArrayList<Transaction>();
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(double amount) throws AccountException {
		if (amount <= 0) {
			throw new AccountException("Deposit amount must be an non-zero value");
		}
		
		balance += amount;
		transactions.add(new Transaction(LocalDate.now(), amount, balance));
	}

	@Override
	public void withdraw(double amount) throws AccountException {
	}
	
	public void listTransactions() {
		if (transactions.size() == 0) {
			System.out.println("No transactions available");
		} else {
			String header = StringUtils.makeHeader("Account " + id + " Transactions");
			
			System.out.println(header);
			transactions.forEach(t -> System.out.println(t));
		}
	}
	
	public static Account findAccountById(Collection<Account> accounts, Integer id) {
		return accounts.stream()
				.filter(a -> id.equals(a.getId()))
				.findFirst()
				.orElse(null);
	}
}
