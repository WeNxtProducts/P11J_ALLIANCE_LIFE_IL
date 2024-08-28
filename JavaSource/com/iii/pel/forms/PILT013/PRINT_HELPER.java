package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.quartz.xml.ValidationException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
public class PRINT_HELPER extends CommonReportAction {	
	
	/* COMMENDED BY GOPI on 03.04.2017 for dynamic report config for base product*/
	
	/*public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		

		String url = null;		
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		
	 * Commented by Janani on 12.9.2016 for dynamic report config
	 * 
	 * url = request.getContextPath() + "/ReportServlet?";
		
		Added by Janani on 12.9.2016 for dynamic report config
		
		url = request.getContextPath() + "/PREMIASchedule?";
		
		end
		
		System.out.println("url   :  "+url);
	return url;	
	}*/
	
/*Added by GOPI on 03.04.2017 for dynamic report config for base product*/
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK(PRINT_ACTION PRINT_ACTION_BEAN) throws Exception
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
		String ScheduleReportType = null;
		
		ScheduleReportType = PRINT_ACTION_BEAN.getScheduleReportType();
		
		System.out.println("ScheduleReportType in WHEN_BUTTON_PRESSED_M_BUT               :"+ScheduleReportType);
		
		
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
		if(ScheduleReportType.equalsIgnoreCase("2"))   /*2-- Mdocs*/
		{
			url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		}
		else
		{
			url = request.getContextPath() + "/PREMIASchedule?";
		}
		
		
		
		System.out.println("url   :  "+url);
	return url;	
	}
	
	
	/*End*/
	
	/*added by Dhinesh on 5-7-16 for FALCONQC-1714897*/
	//added by krithika for FALCONQC-1714897
	public void WHEN_REPORT_TYPE_VALUE_CHANGE(String listvalue,String appr_status)throws Exception
	{
		System.out.println("value of list---->"+listvalue);
		System.out.println("value of appr_status---->"+appr_status);
		String test=appr_status;
		if(listvalue.equalsIgnoreCase("Payment")) 
		{
			callReportModalPanel();
		}

		else if(listvalue.equalsIgnoreCase("MaturityNotice")) 
		{
			callReportModalPanel();
		}

		else if(listvalue.equalsIgnoreCase("SurrenderDischargeForm")) 
		{
			callReportModalPanel();
		}
		
		else if(listvalue.equalsIgnoreCase("MaturityPayoutReviewSheet")) 
		{
			callReportModalPanel();
		}
		else if(listvalue.equalsIgnoreCase("PAIDUPREVIEWSHEET")) 
		{
			System.out.println("inside paid up");
			callReportModalPanel();
		}
		else if(listvalue.equalsIgnoreCase("SURRENDERREVIEWSHEET")) 
		{
			System.out.println("inside the SURRENDER REVIEWSHEET ");
			callReportModalPanel();
		}
		
		
		else if(listvalue.equalsIgnoreCase("MaturityDischargeForm"))
			{
			if(appr_status.equalsIgnoreCase("A"))
			{
			System.out.println("ionside MaturityDischargeForm");
			callReportModalPanel();
			}
			else
			{
				System.out.println("inside else if ");
			
				throw new ValidatorException(new FacesMessage("This report can be generated only for Approved Transactions!!!"));
				
		}
			}
		else
		{
			throw new ValidationException("This report can be generated only for Approved Transactions!!!");
		
		
		}
		
	}
	/*end*/
}
