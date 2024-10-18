package com.tus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.tus.interfaces.Account;

public record Transaction(LocalDate transactionDate, double amount, double balance) {
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		
		return "Transaction date: " + this.transactionDate.format(formatter) + "\t" + 
				"Amount: " + this.amount + "\t" +
				"Balance: " + this.balance + "\n";
	}
}
