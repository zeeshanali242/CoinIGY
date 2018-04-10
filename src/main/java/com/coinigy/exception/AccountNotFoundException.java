package com.coinigy.exception;

public class AccountNotFoundException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public AccountNotFoundException() {
	super("Account not found for this user");
}
	
}
