package com.iii.pel.forms.PILQ101;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.pel.forms.PILP016.PRINT_ACTION;
import com.iii.premia.common.action.CommonAction;

public class PRINT_HELPER extends CommonAction{
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{

		System.out.println("******* Enter the PILQ101 print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;

		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		/*
		 * Commented by Janani on 12.9.2016 for dynamic report config
		 *  
		 * url = request.getContextPath() + "/ReportServlet?";*/


		/*Added by Janani on 12.9.2016 for dynamic report config*/

		url = request.getContextPath() + "/PREMIASchedule?";

		/*end*/

		System.out.println("url   :  "+url);
		return url;	
	}
}
