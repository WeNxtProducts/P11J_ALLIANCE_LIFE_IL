package com.iii.pel.forms.PILP134;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILP134_PRINT_ACTION extends CommonReportAction{
	
	public PILP134_COMPOSITE_ACTION compositeAction;
	
	private HtmlOutputLabel COMP_UI_M_QUOT_REPORT_LABEL;
	
	public HtmlOutputLabel getCOMP_UI_M_QUOT_REPORT_LABEL() {
		return COMP_UI_M_QUOT_REPORT_LABEL;
	}

	public void setCOMP_UI_M_QUOT_REPORT_LABEL(
			HtmlOutputLabel cOMP_UI_M_QUOT_REPORT_LABEL) {
		COMP_UI_M_QUOT_REPORT_LABEL = cOMP_UI_M_QUOT_REPORT_LABEL;
	}


	private HtmlSelectOneMenu COMP_UI_M_QUOT_REPOR;
	
	public HtmlSelectOneMenu getCOMP_UI_M_QUOT_REPOR() {
		return COMP_UI_M_QUOT_REPOR;
	}

	public void setCOMP_UI_M_QUOT_REPOR(HtmlSelectOneMenu cOMP_UI_M_QUOT_REPOR) {
		COMP_UI_M_QUOT_REPOR = cOMP_UI_M_QUOT_REPOR;
	}


	/*private PT_IL_POLICY_HELPER helper;*/
	
	String CLAIM_STATUS="";
	
	/*private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("FalconReports");*/
	
	private List<SelectItem> listUI_M_QUOT_REPORT_TYPE = new ArrayList<SelectItem>();
	
	
	public List<SelectItem> getListUI_M_QUOT_REPORT_TYPE() {
		return listUI_M_QUOT_REPORT_TYPE;
	}

	public void setListUI_M_QUOT_REPORT_TYPE(
			List<SelectItem> listUI_M_QUOT_REPORT_TYPE) {
		this.listUI_M_QUOT_REPORT_TYPE = listUI_M_QUOT_REPORT_TYPE;
	}

	public PILP134_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP134_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	private String UI_M_QUOT_REPORT;

	


	public String getUI_M_QUOT_REPORT() {
		return UI_M_QUOT_REPORT;
	}

	public void setUI_M_QUOT_REPORT(String uI_M_QUOT_REPORT) {
		UI_M_QUOT_REPORT = uI_M_QUOT_REPORT;
	}

	/*public PT_IL_POLICY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POLICY_HELPER helper) {
		this.helper = helper;
	}
*/
	public PILP134_PRINT_ACTION() {
		// TODO Auto-generated constructor stub
		//helper = new PT_IL_POLICY_HELPER();
		IP_REP_INFO_BEAN =new IP_REP_INFO();
	}
	
	/*added by gopi for dynamic schedule print on 12/05/17*/
	
	private IP_REP_INFO IP_REP_INFO_BEAN;
	
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO iP_REP_INFO_BEAN) {
		IP_REP_INFO_BEAN = iP_REP_INFO_BEAN;
	}
			private void prepareDropDowns(){
				try{
					Connection connection = CommonUtils.getConnection();
				
					listUI_M_QUOT_REPORT_TYPE=(CommonReportAction.getDropDownListValue(connection, 
							"N", 
							"CUST_UPD","C"));
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
		
	/*
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();*/
	
	public void onLoad(PhaseEvent event){
		CommonUtils.clearMaps(this);
		try
		{
			System.out.println("inside onload");
			prepareDropDowns();
	}catch(Exception Ex){
		Ex.printStackTrace();
	}
	
}
	
	public void validatorUI_M_QUOT_REPORT(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_M_QUOT_REPORT((String)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_M_QUOT_REPORT());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String backButton() {
		
		return "PILP134_CUSTOMER_DETL_UPD";
	}
	
	
	

	public String runAction() {

		Connection runActionConnection = null;

		String url = null;
		String POL_SYS_ID = null;
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		url = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath()
				+ "/XDocSchedule?";
		System.out.println("url   :  " + url);
		setRedirectUrl(url);

		try {

			runActionConnection = CommonUtils.getConnection();
			String National_id = compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1();
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;
				// POL_SYS_ID
				// =String.valueOf(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
			//String National_id = compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1();
				/*Date as_on_date = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getAS_ON_DT();*/
				/*String date = CommonUtils
						.getDateAsStringForOracleProcedureCall(as_on_date);*/
				/*String types_of_quotation = compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getUI_M_QUOT_TYPE();*/
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(National_id);
				/*IP_REP_INFO_BEAN.setREP_VALUE_2(date);
				IP_REP_INFO_BEAN.setREP_VALUE_3(types_of_quotation);*/

				int recordCount = new CRUDHandler().executeInsert(
						IP_REP_INFO_BEAN, runActionConnection);
				runActionConnection.commit();
			} else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(National_id);
				int updateRecordCount = new CRUDHandler().executeUpdate(
						IP_REP_INFO_BEAN, runActionConnection);
				runActionConnection.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getRedirectUrl();

	}
	

	//end
	
	
	
	
         StringBuffer url=null;
	
         FacesContext context = FacesContext.getCurrentInstance();
         HttpServletRequest request = (HttpServletRequest) context
		.getExternalContext().getRequest();
         HttpSession session = request.getSession();
         
         public String runActionAfterValidate() {
	
         CommonUtils.clearMaps(this);
	
         HttpServletResponse response = null;
		 try{
			
				String rep_template_name=null;
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
				session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
				String SCHEDULE_REPORT_TYPE=compositeAction.getPILP134_PRINT_ACTION_BEAN().getUI_M_QUOT_REPORT();
				
				String POL_APPRV_STATUS ="N";
				rep_template_name="&REP_ID="+SCHEDULE_REPORT_TYPE+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+SCHEDULE_REPORT_TYPE;
				System.out.println("request.getServerName()  :"+request.getServerName());
				setRedirectUrl(getRedirectUrl()+rep_template_name);
				System.out.println("End");
				if(rep_template_name == null)
				{
					throw new Exception((Messages.getString(
							PELConstants.pelErrorMessagePath, "77775",
							new Object[]{"Not a valid report"})));
				}
			
				if (getRedirectUrl() != null) {
					response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					response.sendRedirect(getRedirectUrl());
				}
		
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	/*END*/

/*added by gopi for dynamic schedule print on 12/05/17*/

public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

	try {

		iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
		iP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
		iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
				.getGlobalVariable("GLOBAL.M_COMP_CODE"));
		iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
				.getGlobalVariable("GLOBAL.M_LANG_CODE"));
		iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));
		iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

	} catch (ParseException e) {
		e.printStackTrace();
	}

}

public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

	try {
		IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
		IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
				.getGlobalVariable("GLOBAL.M_COMP_CODE"));
		IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
				.getGlobalVariable("GLOBAL.M_LANG_CODE"));
		IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));
		IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

	} catch (ParseException e) {
		e.printStackTrace();
	}
}
//end
	
}
