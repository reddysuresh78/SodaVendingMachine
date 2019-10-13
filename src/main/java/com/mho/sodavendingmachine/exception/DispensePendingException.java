package com.mho.sodavendingmachine.exception;

@SuppressWarnings("serial")
public class DispensePendingException extends RuntimeException {
	private String message;

	public DispensePendingException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
