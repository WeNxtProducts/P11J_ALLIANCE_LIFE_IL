package com.iii.pel.forms.PILM016_APAC;

import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import com.iii.apps.persistence.Table;

@Table(name="")
public class ERROR_HELP {

	private String messageValues;
	/*public String getErrorMessages() {
		String messageList;
		if((errorMap == null) || (errorMap.size()== 0)){
			messageList = "";
		}else{
			Map<String,String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=2><UL>\n";
			for(String message:error.values()){
	
				messageList = messageList+"<LI>"+message+"\n";
			}
			messageList = messageList + "</UL></FONT>\n"; 
		}
	
		return messageList;
	}*/
	public void setErrorMessages(String messageValues) {
		this.messageValues = messageValues;
	}
	public void validate(UIInput input,String id,Map<String,String> errorMap){
		if (input != null) {
			String username = (String) input.getSubmittedValue();
			if (username != null) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				input.validate(facesContext); // iterates over input's validators
				
				if (!input.isValid()) {
					
					setErrorMessage(facesContext, input, id,errorMap);
				} else {
					
					errorMap.remove(id);
					errorMap.remove("current");
				}

			}
		}
	}
	private void setErrorMessage(FacesContext fc, UIInput input, String key,Map<String,String> errorMap) {
		// set errorMessage to the first message for the zip field
		Iterator iterator = fc.getMessages(input.getClientId(fc));
		if (iterator.hasNext()) {
			FacesMessage facesMessage = (FacesMessage) iterator.next();
			System.out.println("Login.setErrorMessage()");
			errorMap.put(key, facesMessage.getSummary());
			errorMap.put("current", facesMessage.getSummary());

		}
	}
	

	
	

}
