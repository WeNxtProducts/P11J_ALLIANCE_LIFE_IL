package com.iii.pel.forms.PILM001;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ClassCodeValidator implements Validator 
{
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException 
	{
		if(new PILM001_CRUD().validateClassCode((String)arg2))
		{
			FacesMessage message=new FacesMessage("Class Code Already Exists!");
			throw new ValidatorException(message);
		}	
		
	}

}
