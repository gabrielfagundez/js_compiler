package com.language.exceptions;

@SuppressWarnings("serial")
public class SyntaxError extends RuntimeException {

	public SyntaxError(String message, Throwable cause) {
		super(message, cause);
	}

	public SyntaxError(String message) {
		super(message);
	}

	public SyntaxError(Throwable cause) {
		super(cause);
	}
	
}
