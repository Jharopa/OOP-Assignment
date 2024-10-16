package com.tus;

import com.tus.services.BankService;

public class Main {

	public static void main(String[] args) {
		BankService bankService = new BankService();
		
		bankService.run();
	}
	
}
