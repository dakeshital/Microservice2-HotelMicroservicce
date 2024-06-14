package com.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Ressource not found..!!");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}		
	
	

}
