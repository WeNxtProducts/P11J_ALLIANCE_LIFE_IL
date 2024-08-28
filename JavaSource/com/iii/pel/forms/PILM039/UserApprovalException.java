package com.iii.pel.forms.PILM039;

public class UserApprovalException extends Exception {
	private String errorCode;

	public UserApprovalException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String toString(){
		return "Code: "+getErrorCode()+", Message: "+getMessage();
	}
}
