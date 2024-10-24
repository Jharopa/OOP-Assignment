package com.tus.models.accounts;

public class AccountException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AccountException() {
		this("Generic AccountException thrown");
	}
	
	public AccountException(String message) {
		super(message);
	}
}
