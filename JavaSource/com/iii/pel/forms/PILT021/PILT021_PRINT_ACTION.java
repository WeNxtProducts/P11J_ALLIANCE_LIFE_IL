package com.iii.pel.forms.PILT021;

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

public class PILT021_PRINT_ACTION extends CommonReportAction{
	
	public PILT021_COMPOSITE_ACTION compositeAction;
	
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


	private PT_IL_WITHDRAWAL_HELPER helper;
	
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

	public PILT021_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT021_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	private String UI_M_QUOT_REPORT;

	


	public String getUI_M_QUOT_REPORT() {
		return UI_M_QUOT_REPORT;
	}

	public void setUI_M_QUOT_REPORT(String uI_M_QUOT_REPORT) {
		UI_M_QUOT_REPORT = uI_M_QUOT_REPORT;
	}

	public PT_IL_WITHDRAWAL_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_WITHDRAWAL_HELPER helper) {
		this.helper = helper;
	}

	public PILT021_PRINT_ACTION() {
		// TODO Auto-generated constructor stub
		helper = new PT_IL_WITHDRAWAL_HELPER();
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
							compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS(),
							
							"PAR_WITH",compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN()));
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
		
		return "PILT021_PT_IL_WITHDRAWAL";
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
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;
				// POL_SYS_ID
				// =String.valueOf(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
				
				String pol_no = String.valueOf(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
						.getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID());
			
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(pol_no);
				
				int recordCount = new CRUDHandler().executeInsert(
						IP_REP_INFO_BEAN, runActionConnection);
				runActionConnection.commit();
			} else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				// IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
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
				/*setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&REP_ID=PREMIREP127&REPORT_TYPE=PREMIREP117&STATUS=A&MODULE_ID="+moduleId);
				System.out.println("End");*/
				
				String SCHEDULE_REPORT_TYPE=compositeAction.getPILT021_PRINT_ACTION_BEAN().getUI_M_QUOT_REPORT();
				
				String POL_APPRV_STATUS =compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS();
				
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
