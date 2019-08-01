package com.tejamanne.challenges.smsservice.objects;

public class HTTPResponseBean {

	boolean login;
	boolean authorizationPresent;
	boolean success;
	String message;
	Object data;

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isAuthorizationPresent() {
		return authorizationPresent;
	}

	public void setAuthorizationPresent(boolean authorizationPresent) {
		this.authorizationPresent = authorizationPresent;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
