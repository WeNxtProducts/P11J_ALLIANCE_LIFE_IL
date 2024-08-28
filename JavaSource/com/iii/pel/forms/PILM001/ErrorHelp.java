package com.iii.pel.forms.PILM001;

import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class ErrorHelp {

	public static void validate(UIInput input,String inputName,Map<String,String> errorMap){
		System.out.println("ErrorHelp.validate() Error Map ["+errorMap+"]");
		if (input != null) {
			String username = (String) input.getSubmittedValue();
			if (username != null) {
				FacesContext fc = FacesContext.getCurrentInstance();
				input.validate(fc); // iterates over input's validators
				if (!input.isValid()) {
					setErrorMessage(fc, input, inputName,errorMap);
				} else {
					errorMap.remove(inputName);
					errorMap.remove("current");
				}

			}
		}
	}
	private static void setErrorMessage(FacesContext fc, UIInput input, String key, Map<String,String> errorMap) {
		// set errorMessage to the first message for the zip field
		Iterator it = fc.getMessages(input.getClientId(fc));
		if (it.hasNext()) {
			FacesMessage facesMessage = (FacesMessage) it.next();
		
			errorMap.put(key, facesMessage.getSummary());
			errorMap.put("current", facesMessage.getSummary());

		}
	}
	
	
}
