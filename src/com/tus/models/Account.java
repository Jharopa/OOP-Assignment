package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.tus.interfaces.Accountable;
import com.tus.utils.StringUtils;

public abstract class Account implements Accountable {
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
	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction(LocalDate.now(), amount, balance));
	}

	@Override
	public void withdraw(double amount) {
	}
	
	public void listTransactions() {
		if (transactions.size() == 0) {
			System.out.println("No transactions available");
		}
		else {
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
