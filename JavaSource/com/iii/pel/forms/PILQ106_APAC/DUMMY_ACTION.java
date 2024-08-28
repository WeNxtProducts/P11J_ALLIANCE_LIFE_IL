package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT016A_APAC.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class DUMMY_ACTION extends CommonReportAction{
	private DUMMY DUMMY_BEAN;
	private HtmlInputText UI_M_POL_NO;
	private HtmlInputText CUST_CODE;
	private HtmlInputText CUST_NAME;
	private HtmlInputText PROD_CODE;
	private HtmlInputText PROD_DESC;
	private HtmlCommandButton COMP_UI_M_BUT_APPROVAL ;
	private HtmlCommandLink COMP_Render_Back_Button;
	private IP_REP_INFO IP_REP_INFO_BEAN;
 	
	private HtmlCommandButton COMP_UI_M_BUT_REPORT;

	public PILQ106_APAC_COMPOSITE_ACTION compositeAction;
	private String DEFAULT_WHERE = " POL_DS_TYPE='2' "
		+ "AND POL_PLAN_CODE IN (SELECT PLAN_CODE FROM PM_IL_PLAN WHERE  PLAN_TYPE ='U') ";

	private boolean renderBackButton;
	
	public DUMMY_ACTION(){
		DUMMY_BEAN = new DUMMY();
		IP_REP_INFO_BEAN = new IP_REP_INFO();
	}
	
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}
	
	public void onLoad(PhaseEvent event){
		DUMMY_HELPER dummyHelper = new DUMMY_HELPER();
		
		try {
			
			/* Newly Added By Dhinesh on for ssp call id : FundQuery Processing */
		
			if("Y".equalsIgnoreCase(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.BLACK_FLAG"),"N")))
			{
				setBlockFlag(true);
				setFormFlag(true);
				DUMMY_BEAN = new DUMMY();
				CommonUtils.setGlobalVariable("GLOBAL.BLACK_FLAG","N");
			}
			
			/* End */
			
			if(isFormFlag()){
				dummyHelper.preForm(this,DUMMY_BEAN);
				dummyHelper.whenNewFormInstance(compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN(), 
						compositeAction.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN(), 
						compositeAction.getPS_IL_UNIT_FUND_REG_ACTION_BEAN());
				setFormFlag(false);
			}
			if(isBlockFlag()){
				dummyHelper.preQuery(DUMMY_BEAN);
				dummyHelper.executeQuery(this);
				dummyHelper.postQuery(DUMMY_BEAN);
				//dummyHelper.onPopulateDetails(compositeAction, DUMMY_BEAN);
				UI_M_POL_NO.resetValue();
				setBlockFlag(false);
			}
		} catch (Exception e) {
	         e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		}
	}
	
	// Suggestions
	public ArrayList<LovBean> suggestionUI_M_POL_NO(Object value){
		ArrayList<LovBean> suggestions = null;
		
		try {
			suggestions = new ListItemUtil().P_CALL_LOV("PILQ106_APAC", 
					"DUMMY", 
					"M_POL_NO", 
					"A", 
					"U", 
					null, 
					null, 
					null, (String)value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION_M_POL_NO", e.getMessage());
		}
		
		return suggestions;
	}

	public void validateUI_M_POL_NO(FacesContext context, UIComponent component, Object value){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		
		try {
			DUMMY_BEAN.setUI_M_POL_NO((String) value);
			helper.whenValidateItem_UI_M_POL_NO(DUMMY_BEAN);
			CUST_NAME.resetValue();
			PROD_DESC.resetValue();
			//fetchButtonAction();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	    public String  fetchButtonAction( ){
		     CommonUtils.clearMaps(this);
		    try {
			compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().onLoad();
			compositeAction.getPS_IL_UNIT_FUND_REG_ACTION_BEAN().onLoad();
			compositeAction.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN().onLoad();
			/* aDDED by Ameen on 05-04-2018 for KIC charge spliting tab */
			compositeAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().onLoad();
			/*End*/
			 
		    } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				    e.getMessage());
		    }
		    return null;
		 }
	
	public void fireFieldValidation(ActionEvent event){
		ErrorHelpUtil.validate((UIInput) event.getComponent().getParent(), getErrorMap());

		// Populating header block, in turn it populates rund_reg and fund_dtls
		try {
			//compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().onLoad(null);
			//new PT_IL_UNIT_FUND_REG_HDR_HELPER().executeQuery(compositeAction);
			
			/*Commented by Janani on 09.01.2018 for ZBLIFE-1459615 as discussed with siva,
			 * on tabbing out of pol_no field datas wont be displayed in datagrid */
			
			//new DUMMY_HELPER().onPopulateDetails(compositeAction, DUMMY_BEAN);
			
			/*End of ZBLIFE-1459615*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ON_POPULATE_DETAILS", e.getMessage());
		}

	}
	
	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	public HtmlInputText getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(HtmlInputText ui_m_pol_no) {
		UI_M_POL_NO = ui_m_pol_no;
	}

	public HtmlInputText getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(HtmlInputText cust_code) {
		CUST_CODE = cust_code;
	}

	public HtmlInputText getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(HtmlInputText cust_name) {
		CUST_NAME = cust_name;
	}

	public HtmlInputText getPROD_CODE() {
		return PROD_CODE;
	}

	public void setPROD_CODE(HtmlInputText prod_code) {
		PROD_CODE = prod_code;
	}

	public HtmlInputText getPROD_DESC() {
		return PROD_DESC;
	}

	public void setPROD_DESC(HtmlInputText prod_desc) {
		PROD_DESC = prod_desc;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
	    return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(HtmlCommandButton comp_ui_m_but_approval) {
	    COMP_UI_M_BUT_APPROVAL = comp_ui_m_but_approval;
	}
	
    public String backButton() {
    	String outcome = null;
    	String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
    	if((null != callingForm || !callingForm.isEmpty() ) && "PILT002_APAC".equals(callingForm)) {
    		getCOMP_Render_Back_Button().setRendered(true);
    		outcome = "PILT002_APAC_PT_IL_POLICY";
    	}
    	if("PILT021".equals(callingForm)){
    		getCOMP_Render_Back_Button().setRendered(true);
    		outcome = "PILT021_PT_IL_WITHDRAWAL";
    	}
    	if("PILT003_APAC".equals(callingForm)){
    		getCOMP_Render_Back_Button().setRendered(true);
    		outcome = "PILT003_APAC_PT_IL_PREM_COLL";
    	}
    	
    	/*else {
    		getCOMP_Render_Back_Button().setRendered(false);
    		outcome = callingForm;
    		// Removing integration paramters
    		CommonUtils.getSession().removeAttribute("CALLING_FORM");
    	}*/
    	 
    	return outcome;
    }
    
	public boolean isRenderBackButton() {
		return renderBackButton;
	}

	public void setRenderBackButton(boolean renderBackButton) {
		this.renderBackButton = renderBackButton;
	}

	public HtmlCommandLink getCOMP_Render_Back_Button() {
		return COMP_Render_Back_Button;
	}

	public void setCOMP_Render_Back_Button(HtmlCommandLink render_Back_Button) {
		COMP_Render_Back_Button = render_Back_Button;
	}
	
	
	//added by akash for report ...
	
	
	
	@Override
	public String runAction() {
		String redirectUrl=null;
		CommonUtils.clearMaps(this);
 		setRedirectUrl(null);
		HttpServletResponse response=null;
		Connection connection=null;
		String repid=null;
		//IP_REP_INFO_BEAN.setREP_ID("PILR_LET_FN");
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				PRE_INSERT(IP_REP_INFO_BEAN);
			} else {
				PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}

			//delegate.executeSaveAction(this.IP_REP_INFO_BEAN);
			connection=CommonUtils.getConnection();
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
																				.getResponse();
			System.out.println("0---->"+DUMMY_BEAN.getUI_M_POL_NO());
			map.put("P_POL_SYS_ID",String.valueOf(getSysId(DUMMY_BEAN.getUI_M_POL_NO())));
			/*redirectUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(),"PILR_REC001",
					repid,IP_REP_INFO_BEAN.getSelectedFileTyp(), map);*/
			redirectUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(), IP_REP_INFO_BEAN.getREP_ID(), 
					IP_REP_INFO_BEAN.getREP_ID(),
					IP_REP_INFO_BEAN.getSelectedFileTyp(),map);
			// response.sendRedirect(redirectUrl);
			
			setRedirectUrl(redirectUrl);
			
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("RunAction", e.getMessage());
	}
	return redirectUrl;
 }
	
	public Long getSysId(String polNo){
		Connection connection = null;
		ResultSet resultSet = null;
		Long polsysId = null;
		String query = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection =  CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[]{polNo});
			if(resultSet.next()){
				polsysId = resultSet.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return polsysId;
		
	}
	
	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
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
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
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

	public HtmlCommandButton getCOMP_UI_M_BUT_REPORT() {
		return COMP_UI_M_BUT_REPORT;
	}

	public void setCOMP_UI_M_BUT_REPORT(HtmlCommandButton comp_ui_m_but_report) {
		COMP_UI_M_BUT_REPORT = comp_ui_m_but_report;
	}

	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}

}
