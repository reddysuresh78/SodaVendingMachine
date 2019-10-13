package com.mho.sodavendingmachine.exception;

@SuppressWarnings("serial")
public class SoldOutException extends RuntimeException {
	private String message;

	public SoldOutException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
