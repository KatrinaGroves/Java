package com.ntier.lambdas.starters;

public class UnknownAirportException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnknownAirportException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownAirportException(String message) {
		super(message);
	}
	
}
