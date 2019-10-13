package com.mho.sodavendingmachine.exception;

@SuppressWarnings("serial")
public class NoProductChosenException extends RuntimeException {
	private String message;

	public NoProductChosenException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
