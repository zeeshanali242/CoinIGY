package com.coinigy.exception;

public class AccountNotActiveException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotActiveException() {
		 super("Account not active for this pair");
	}
}
