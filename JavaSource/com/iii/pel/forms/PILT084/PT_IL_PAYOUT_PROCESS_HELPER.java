package com.iii.pel.forms.PILT084;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class PT_IL_PAYOUT_PROCESS_HELPER {
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{

		String url = null;

		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		url = request.getContextPath() + "/PREMIASchedule?";
		System.out.println("url   :  "+url);
		return url;	
	}

}
