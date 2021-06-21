package org.example.exception;

public class InvalidTraineeOperationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidTraineeOperationException(String msg) {
		super(msg);
	}

}
