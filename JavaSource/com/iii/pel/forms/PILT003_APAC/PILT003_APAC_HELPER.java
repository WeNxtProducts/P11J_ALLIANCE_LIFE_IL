package com.iii.pel.forms.PILT003_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT003_APAC_HELPER {
	public String WHEN_BUTTON_PRESSED_M_BUT_OK(PILT003_APAC_PRINTACTION  PRINTACTION) throws Exception
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
		String REPORT_CATG = null;
		String reportQuery1 = "select pmrth_report_catg from pm_rep_tab_hdr where pmrth_rep_id=?";
		ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection()
				,new Object[]{PRINTACTION.getUI_M_SCHEDULE_TYPE()});
		while(reportRSSS.next())
		{
			REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
		}
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if("S".equalsIgnoreCase(REPORT_CATG))   /*2-- Mdocs*/
		{
			url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/PREMIASchedule?";
			
		}
		else
		{
			url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		}
		
		System.out.println("url   :  "+url);
		return url;	
	}

}
