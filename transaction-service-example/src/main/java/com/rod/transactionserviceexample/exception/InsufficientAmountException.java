package com.rod.transactionserviceexample.exception;

@SuppressWarnings("serial")
public class InsufficientAmountException extends RuntimeException {

	public InsufficientAmountException(String message) {
		super(message);
	}
	
}
