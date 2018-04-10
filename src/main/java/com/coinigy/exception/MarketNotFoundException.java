package com.coinigy.exception;

public class MarketNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarketNotFoundException() {
		super("can't find market for this pair");
	}
}
