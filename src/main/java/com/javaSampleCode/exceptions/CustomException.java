package com.javaSampleCode.exceptions;

public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String errorMessage;

	public CustomException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public CustomException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public CustomException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "CustomException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
