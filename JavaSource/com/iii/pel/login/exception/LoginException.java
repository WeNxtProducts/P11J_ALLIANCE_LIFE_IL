package com.iii.pel.login.exception;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class LoginException extends ValidatorException {
	
	private static final long serialVersionUID = 1L;
	
	public LoginException(FacesMessage message) {
		super(message);
	}
	
	public LoginException(String message){
		super(new FacesMessage(message));
	}
	
}
