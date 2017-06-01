package com.boz.HandlerExceptionResolver;

public class ValidationMessageException extends RuntimeException {
	public ValidationMessageException(String msg){
		super(msg);
	}
}
