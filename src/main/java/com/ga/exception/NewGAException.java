package com.ga.exception;

import com.ga.common.ClientErrorCodes;

public class NewGAException extends Exception {

	private static final long serialVersionUID = 1L;

	int code;
	String message;
	String name;
	Throwable ex;
	String description;

	public NewGAException(ClientErrorCodes clientError, String message) {
		this.code = clientError.getErrorCode();
		this.description = clientError.getDescription();
		this.name = clientError.name();
		this.message = message;
	}

	public NewGAException(ClientErrorCodes clientError, String message,
			Throwable e) {
		this.code = clientError.getErrorCode();
		this.description = clientError.getDescription();
		this.name = clientError.name();
		this.message = message;
		this.ex = e;
	}

	public NewGAException(ClientErrorCodes clientError) {
		this.code = clientError.getErrorCode();
		this.description = clientError.getDescription();
		this.name = clientError.name();
	}

	public NewGAException(ClientErrorCodes clientError, Throwable ex) {
		this.code = clientError.getErrorCode();
		this.description = clientError.getDescription();
		this.ex = ex;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Throwable getEx() {
		return ex;
	}

	public void setEx(Throwable ex) {
		this.ex = ex;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
