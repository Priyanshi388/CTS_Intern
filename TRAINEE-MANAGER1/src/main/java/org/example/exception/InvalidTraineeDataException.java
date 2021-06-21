package org.example.exception;

public class InvalidTraineeDataException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTraineeDataException(String message) {
		super(message);
	}
}
