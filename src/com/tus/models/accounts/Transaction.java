package com.tus.models.accounts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record Transaction(LocalDate transactionDate, double amount, double balance) {
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		return "Transaction date: " + this.transactionDate.format(formatter) + "    " + 
				"Amount: " + this.amount + "    " +
				"Balance: " + this.balance;
	}
}
