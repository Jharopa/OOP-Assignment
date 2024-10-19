package com.tus.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.tus.interfaces.Accountable;

public abstract class Account implements Accountable {
	protected int id;
	protected double balance;
	protected ArrayList<Transaction> transactions;
	
	private static AtomicInteger nextId = new AtomicInteger();
	
	public Account(double balance) {
		this.id = nextId.getAndIncrement();
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
}
