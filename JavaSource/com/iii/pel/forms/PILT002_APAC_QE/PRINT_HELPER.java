package com.iii.pel.forms.PILT002_APAC_QE;

import java.io.PrintStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class PRINT_HELPER
{
  public String WHEN_BUTTON_PRESSED_M_BUT_OK()
  {
		System.out.println("Inside WHEN_BUTTON_PRESSED_M_BUT_OK ");
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