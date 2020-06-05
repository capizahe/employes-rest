package com.parameta.rest.exception;

public class WrongParametersExeption extends RuntimeException{
	
	private static final long serialVersionUID = 7805897102781579095L;
	
	public WrongParametersExeption(String message) {
		super(message);
	}

}
