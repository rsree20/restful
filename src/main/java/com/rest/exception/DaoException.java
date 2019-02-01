package com.rest.exception;

public class DaoException extends Exception {

	private int reasonCode;
	private String message;

	public DaoException(int reasonCode, String message) {
		super(message);
		this.message = message;
		this.reasonCode = reasonCode;
	}

	public DaoException(String message) {
		super(message);
		this.message = message;
	}
	
	public DaoException() {

	}

	public int getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(int reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
