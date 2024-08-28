package com.iii.pel.forms.PILT004;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;


import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
public class PRINT_HELPER extends CommonAction {

	
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
			
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		/*url = request.getContextPath() + "/ReportServlet?";*/
		url = request.getContextPath() + "/PREMIASchedule?";
		
		
		System.out.println("url   :  "+url);
	return url;	
	}
	
}