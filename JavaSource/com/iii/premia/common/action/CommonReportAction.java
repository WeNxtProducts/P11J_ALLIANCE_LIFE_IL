package com.iii.premia.common.action;


import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class CommonReportAction  extends CommonAction{
	
	private String redirectUrl;
	
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
	
	private HtmlCommandButton COMP_STD_DOC_PRINT;
	
	public CommonReportAction(){
		initiatecomponent();
	}

	public void initiatecomponent(){
		COMP_REPORT_MODAL_PANEL = new HtmlModalPanel();
		COMP_CANCEL_BUTTON = new HtmlAjaxCommandButton();;
		COMP_STD_DOC_PRINT = new HtmlCommandButton();
	}

	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
				response.sendRedirect(getRedirectUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		cancelModalPanel();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String callReportModalPanel(){
		runAction();
		if(redirectUrl!=null)
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		else 
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return null;
	}


	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel comp_report_modal_panel) {
		COMP_REPORT_MODAL_PANEL = comp_report_modal_panel;
	}

	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}

	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton comp_cancel_button) {
		COMP_CANCEL_BUTTON = comp_cancel_button;
	}

	public HtmlCommandButton getCOMP_STD_DOC_PRINT() {
		return COMP_STD_DOC_PRINT;
	}

	public void setCOMP_STD_DOC_PRINT(HtmlCommandButton comp_std_doc_print) {
		COMP_STD_DOC_PRINT = comp_std_doc_print;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String runAction() {
		return getRedirectUrl();
	}
	
	
	public java.util.Date getDefaultFromDate() throws ParseException{
		Calendar calendar  = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(PELConstants.pelDateFormat);
		
		int firstDay = calendar.getActualMinimum(Calendar.DATE);
		calendar.set(Calendar.DATE, firstDay);
		java.util.Date date = calendar.getTime(); 
		String s = df.format(date);
		java.util.Date firstDayOfMonth = df.parse(s);
		
		return firstDayOfMonth;
	}
	
	
	public java.util.Date getDefaultToDate() throws ParseException{
		java.util.Date date = new java.util.Date();
		DateFormat df = new SimpleDateFormat(PELConstants.pelDateFormat);
		String s = df.format(date);
		java.util.Date today = df.parse(s);
		return today;
	}
	



/*Added by Janani on 12.9.2016 for dynamic report config*/

public static List<SelectItem> getDropDownListValue(Connection connection,String pol_status, String report_type, String typevalue){
	
	System.out.println("enters inside getDropDownListValue in commonREport action");
	
	
	List<SelectItem> listValues = null;
	String query = null;
	System.out.println("pol_status          :"+pol_status        +
			"report_type        :"+report_type        +"typevalue          :"+typevalue);
	
	
	
	query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
			  "FROM pm_rep_tab_dtl " +
			 " WHERE SYS_PARAM = ? " +
			   " AND ITEM_NAME = ? " +
			   " AND PMLIT_FLAG = ? "			   ;
			
		
		CRUDHandler handler = null;
		Object[] values = {pol_status , report_type ,typevalue,};
		try {
			handler = new CRUDHandler();
			System.out.println("query            :"+query);
			System.out.println("connection            :"+connection);
			System.out.println("values            :"+values);
			
			/*Added by Ram on 08/09/2016*/
			int resultCount = 0;
			/*End*/
			
			ResultSet rst = handler.executeSelectStatement(query, connection, values);
			listValues = new ArrayList<SelectItem>();
			while(rst.next()){
				
				System.out.println("INSIDE WHILE LOOP");
				
				listValues.add(new SelectItem(rst.getString("PMLIT_KEY"),rst.getString("PMLIT_VALUE")));
				resultCount++;
			}
			rst.close();
			rst.getStatement().close();
			/*Added by Ram on 08/09/2016*/
			if(resultCount == 0)
			{
				listValues.add(new SelectItem("0","--Select--"));
			}
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return listValues;
}



/*cover code parameter added by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
public static List<SelectItem> getDropDownListValue_1(Connection connection, String pol_status, String report_type, String typevalue,String prod_code,String Addl_sts,String Cover_code,String Endorsement_code){
		
		List<SelectItem> listValues = null;
		String query = null;
		ResultSet rst=null;
		try {
			/*aDDED BY SANKARA NARAYANAN FOR list the report type based on aditional status 16-02-2017*/
			
			

			System.out.println("pol_status                 :"+pol_status+"   report_type        "+report_type+"      typevalue         "+typevalue+"    prod_code       "+
					prod_code+"     Addl_sts        "+Addl_sts);
			
			
			
		if(Addl_sts==null){
		query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
					  "FROM pm_rep_tab_dtl " +
					 " WHERE SYS_PARAM = ? " +
					   " AND ITEM_NAME = ? " +
					   " AND PMLIT_FLAG = ? "+
					   " AND PMLIT_PROD_CODE LIKE ? ";
		Object[] values = {pol_status , report_type ,typevalue,"%"+prod_code+"%"};
		 rst = new CRUDHandler().executeSelectStatement(query, connection, values);
		}else{
			/*modified by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
			/*query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
					  "FROM pm_rep_tab_dtl " +
					 " WHERE SYS_PARAM = ? " +
					   " AND ITEM_NAME = ? " +
					   " AND PMLIT_FLAG = ? "+
					   " AND PMLIT_PROD_CODE LIKE ?"+
					   "AND PMILT_ADDL_STS LIKE ?";*/
			/*query ="SELECT PMLIT_KEY, PMLIT_VALUE FROM pm_rep_tab_dtl WHERE SYS_PARAM = ? AND ITEM_NAME = ? "
					+ "AND PMLIT_FLAG = ? AND PMLIT_PROD_CODE LIKE ?"
					+ "AND (PMILT_ADDL_STS LIKE ? "
					+ "AND PMLIT_RIDER_CODE is null)"
					+ "OR (PMLIT_RIDER_CODE = NVL(?,'XXX') AND PMLIT_FLAG =?)";*/
			
			
			query ="SELECT PMLIT_KEY, PMLIT_VALUE, PMLIT_END_CODE FROM pm_rep_tab_dtl WHERE SYS_PARAM =? AND ITEM_NAME =? AND PMLIT_FLAG =?"
					+ " AND PMLIT_PROD_CODE LIKE ? AND ((PMILT_ADDL_STS LIKE ? AND PMLIT_RIDER_CODE is null) OR "
					+ "(PMLIT_RIDER_CODE = NVL(?, 'XXX') AND PMLIT_FLAG =?)) AND ((NVL(PMLIT_END_CODE,'XXX') =NVL(?,'XXX')"
					+ " AND PMLIT_END_CODE IS NOT NULL) OR (PMLIT_END_CODE IS NULL))";
			Object[] values= {pol_status , report_type ,typevalue,"%"+prod_code+"%","%"+Addl_sts+"%",Cover_code,typevalue,Endorsement_code};
			
			
			
			rst = new CRUDHandler().executeSelectStatement(query, connection, values);
		}
		/*END*/
		listValues = new ArrayList<SelectItem>();
				while(rst.next()){
					System.out.println("*****************");
						System.out.println("INSIDE WHILE LOOP"+rst.getString("PMLIT_KEY")+"******"+rst.getString("PMLIT_VALUE"));
					
					listValues.add(new SelectItem(rst.getString("PMLIT_KEY"),rst.getString("PMLIT_VALUE")));
				}
				rst.close();
				rst.getStatement().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return listValues;
	}
/* end*/

/*Added by Ram on 28/11/2016 for Dynamic Report configuration without using interfacing screen*/
public static String getReportIdwithoutInterface(Connection connection, String menuId){
	
	List<SelectItem> listValues = null;
	String query = null;
	/*Modified Query on 03/12/2016 for non-menu screens*/
	query = "SELECT * FROM PM_REP_TAB_HDR" +
				 " WHERE PMRTH_MODULE_ID = ? AND PMRTH_REP_STATUS = 'I'";
	/*End*/
				String reportId = null;   
		CRUDHandler handler = null;
		Object[] values = {menuId};
		try {
			handler = new CRUDHandler();
						
			ResultSet rst = handler.executeSelectStatement(query, connection, values);
			listValues = new ArrayList<SelectItem>();
			while(rst.next()){
				 
					 
					reportId = rst.getString("PMRTH_REP_ID");
					 
			}
			rst.close();
			rst.getStatement().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return reportId;
}
	
	/*End*/


}