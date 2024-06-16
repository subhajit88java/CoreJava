package com.subhajit.models;

public class SharedBean {
	
	private String message;
	
	public SharedBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SharedBean [money=" + message + "]";
	}

}
