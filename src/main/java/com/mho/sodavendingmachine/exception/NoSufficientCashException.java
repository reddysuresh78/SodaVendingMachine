package com.mho.sodavendingmachine.exception;

@SuppressWarnings("serial")
public class NoSufficientCashException extends RuntimeException {
	private String message;

	public NoSufficientCashException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
