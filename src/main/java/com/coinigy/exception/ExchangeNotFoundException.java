package com.coinigy.exception;

public class ExchangeNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExchangeNotFoundException() {
		super("No exchange found for this user");
	}
}
