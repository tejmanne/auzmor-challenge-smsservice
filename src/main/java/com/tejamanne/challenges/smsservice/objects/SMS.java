package com.tejamanne.challenges.smsservice.objects;

import java.io.Serializable;

public class SMS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SMS() {

	}

	public SMS(String message, String error) {
		this.message = message;
		this.error = error;
	}

	String message;

	String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
