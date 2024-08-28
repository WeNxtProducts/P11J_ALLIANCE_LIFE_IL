package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_CLAIM_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CLAIM_NO_LABEL;

	private HtmlInputText COMP_CLAIM_NO;

	private HtmlOutputLabel COMP_CLAIM_POL_NO_LABEL;

	private HtmlInputText COMP_CLAIM_POL_NO;

	private HtmlOutputLabel COMP_UI_M_CLAIM_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_ASSURED_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_FAC_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_BENF_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_RI_CLOSE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CLAIM_NO;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_BUT_PV;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private boolean UI_M_BUT_MAIN_DIS = true;

	private PT_IL_CLAIM PT_IL_CLAIM_BEAN;

	private PT_IL_CLAIM_HELPER helper;
	
	private String UI_M_CLOSE_FLAG;
	
	private String UI_M_CLAIM_ADDL_STATUS;
	
	private String UI_M_CLAIM_STATUS;
	
/*	Added by sankaraNarayanan on 16/02/2016 for print Button*/
	private IP_REP_INFO IP_REP_INFO_BEAN;
	
	
	private HtmlCommandLink COMP_PRINT_COMMAND_LINK;

	private HtmlCommandButton COMP_PRINT_BUTTON;
	
	
	
	
	
	
	

	public HtmlCommandLink getCOMP_PRINT_COMMAND_LINK() {
		return COMP_PRINT_COMMAND_LINK;
	}

	public void setCOMP_PRINT_COMMAND_LINK(HtmlCommandLink cOMP_PRINT_COMMAND_LINK) {
		COMP_PRINT_COMMAND_LINK = cOMP_PRINT_COMMAND_LINK;
	}

	public HtmlCommandButton getCOMP_PRINT_BUTTON() {
		return COMP_PRINT_BUTTON;
	}

	public void setCOMP_PRINT_BUTTON(HtmlCommandButton cOMP_PRINT_BUTTON) {
		COMP_PRINT_BUTTON = cOMP_PRINT_BUTTON;
	}

	/*end*/
	//private boolean update = false;
	private boolean update = true;

	PILT007_COMPOSITE_ACTION compositeAction = null;

	public PILT007_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT007_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_CLAIM_ACTION() {
		PT_IL_CLAIM_BEAN = new PT_IL_CLAIM();
		IP_REP_INFO_BEAN = new IP_REP_INFO();   //	Added by sankaraNarayanan on 16/02/2016 for print Button
		helper = new PT_IL_CLAIM_HELPER();
		instantiateAllComponent();
	}

	/**
	 * Instantiates all components in PT_IL_CLAIM_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_CLAIM_NO = new HtmlInputText();
		COMP_CLAIM_POL_NO = new HtmlInputText();
		COMP_UI_M_CLAIM_ASSURED_NAME = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_FAC_DTL = new HtmlCommandButton();
		COMP_UI_M_BUT_BENF_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_RI_CLOSE = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
		COMP_UI_M_BUT_PV = new HtmlCommandButton();
		COMP_UI_M_BUT_MAIN = new HtmlCommandButton();
		/*Added by sankaraNarayanan on 16/02/2016 for print Button*/
		COMP_PRINT_COMMAND_LINK = new HtmlCommandLink();
		COMP_PRINT_BUTTON = new HtmlCommandButton();
		//end

	}

	public HtmlOutputLabel getCOMP_CLAIM_NO_LABEL() {
		return COMP_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_NO() {
		return COMP_CLAIM_NO;
	}

	public void setCOMP_CLAIM_NO_LABEL(HtmlOutputLabel COMP_CLAIM_NO_LABEL) {
		this.COMP_CLAIM_NO_LABEL = COMP_CLAIM_NO_LABEL;
	}

	public void setCOMP_CLAIM_NO(HtmlInputText COMP_CLAIM_NO) {
		this.COMP_CLAIM_NO = COMP_CLAIM_NO;
	}

	public HtmlOutputLabel getCOMP_CLAIM_POL_NO_LABEL() {
		return COMP_CLAIM_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_POL_NO() {
		return COMP_CLAIM_POL_NO;
	}

	public void setCOMP_CLAIM_POL_NO_LABEL(
			HtmlOutputLabel COMP_CLAIM_POL_NO_LABEL) {
		this.COMP_CLAIM_POL_NO_LABEL = COMP_CLAIM_POL_NO_LABEL;
	}

	public void setCOMP_CLAIM_POL_NO(HtmlInputText COMP_CLAIM_POL_NO) {
		this.COMP_CLAIM_POL_NO = COMP_CLAIM_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_ASSURED_NAME_LABEL() {
		return COMP_UI_M_CLAIM_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_ASSURED_NAME() {
		return COMP_UI_M_CLAIM_ASSURED_NAME;
	}

	public void setCOMP_UI_M_CLAIM_ASSURED_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_ASSURED_NAME_LABEL) {
		this.COMP_UI_M_CLAIM_ASSURED_NAME_LABEL = COMP_UI_M_CLAIM_ASSURED_NAME_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_ASSURED_NAME(
			HtmlInputText COMP_UI_M_CLAIM_ASSURED_NAME) {
		this.COMP_UI_M_CLAIM_ASSURED_NAME = COMP_UI_M_CLAIM_ASSURED_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_DTL() {
		return COMP_UI_M_BUT_FAC_DTL;
	}

	public void setCOMP_UI_M_BUT_FAC_DTL(HtmlCommandButton COMP_UI_M_BUT_FAC_DTL) {
		this.COMP_UI_M_BUT_FAC_DTL = COMP_UI_M_BUT_FAC_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BENF_DTLS() {
		return COMP_UI_M_BUT_BENF_DTLS;
	}

	public void setCOMP_UI_M_BUT_BENF_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_BENF_DTLS) {
		this.COMP_UI_M_BUT_BENF_DTLS = COMP_UI_M_BUT_BENF_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RI_CLOSE() {
		return COMP_UI_M_BUT_RI_CLOSE;
	}

	public void setCOMP_UI_M_BUT_RI_CLOSE(
			HtmlCommandButton COMP_UI_M_BUT_RI_CLOSE) {
		this.COMP_UI_M_BUT_RI_CLOSE = COMP_UI_M_BUT_RI_CLOSE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CLAIM_NO() {
		return COMP_UI_M_BUT_LOV_CLAIM_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_CLAIM_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CLAIM_NO) {
		this.COMP_UI_M_BUT_LOV_CLAIM_NO = COMP_UI_M_BUT_LOV_CLAIM_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO() {
		return COMP_UI_M_BUT_LOV_POL_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO) {
		this.COMP_UI_M_BUT_LOV_POL_NO = COMP_UI_M_BUT_LOV_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PV() {
		return COMP_UI_M_BUT_PV;
	}

	public void setCOMP_UI_M_BUT_PV(HtmlCommandButton COMP_UI_M_BUT_PV) {
		this.COMP_UI_M_BUT_PV = COMP_UI_M_BUT_PV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	public boolean isUI_M_BUT_MAIN_DIS() {
		return UI_M_BUT_MAIN_DIS;
	}

	public void setUI_M_BUT_MAIN_DIS(boolean ui_m_but_main_dis) {
		UI_M_BUT_MAIN_DIS = ui_m_but_main_dis;
	}

	public PT_IL_CLAIM getPT_IL_CLAIM_BEAN() {
		return PT_IL_CLAIM_BEAN;
	}

	public void setPT_IL_CLAIM_BEAN(PT_IL_CLAIM PT_IL_CLAIM_BEAN) {
		this.PT_IL_CLAIM_BEAN = PT_IL_CLAIM_BEAN;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public void onLoad(PhaseEvent event) {
		if (isFormFlag()) {
			Swiss_Sql_PILT007 formHelper = new Swiss_Sql_PILT007();
			try {
				formHelper.PRE_FORM(compositeAction);
				formHelper.whenNewFormInstance(compositeAction);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
			setFormFlag(false);
		}
		if (isBlockFlag()) {
			
			
			
			
			
			PT_IL_CLAIM_HELPER helper = new PT_IL_CLAIM_HELPER();
			try {

				helper.preQuery(PT_IL_CLAIM_BEAN);
				helper.executeQuery(PT_IL_CLAIM_BEAN);
				if (PT_IL_CLAIM_BEAN.getROWID() != null) {
					helper.postQuery(compositeAction);
				} else {
					helper.whenCreateRecord(compositeAction);
				}
				helper.whenNewRecordInstance(compositeAction);
				helper.claimPaid(compositeAction);
				setWizardSummary();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
			setBlockFlag(false);
			enableDisableButtons();
			
		}
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM_POL");
		if(callingForm != null && (!(callingForm.isEmpty())) && callingForm.equalsIgnoreCase("PILT002_APAC")){
			COMP_UI_M_CLAIM_ASSURED_NAME.setDisabled(true);
			COMP_CLAIM_NO.setDisabled(true);
			COMP_CLAIM_POL_NO.setDisabled(true);
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().disableAllComponent(true);
			compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().disableAllComponent(true);
			compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION().disableAllComponent(true);
			COMP_UI_M_BUT_RI_CLOSE.setDisabled(true);
			COMP_UI_M_BUT_APPROVE.setDisabled(true);
		}
		
		/*added by gopi for toi on 26/06/2018	*/	
		String Benef_cust_flag =getBeneficiary_as_customer();
		String  claim_addl_status=PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS();
		if(Benef_cust_flag!=null && "Y".equalsIgnoreCase(Benef_cust_flag)){
			if(claim_addl_status!=null&&"C".equalsIgnoreCase(claim_addl_status)){
				getCOMP_PRINT_COMMAND_LINK().setRendered(true);	
				getCOMP_PRINT_BUTTON().setRendered(true);
			}else{
				getCOMP_PRINT_COMMAND_LINK().setRendered(false);
				getCOMP_PRINT_BUTTON().setRendered(false);
			}
			
		}else{
			getCOMP_PRINT_COMMAND_LINK().setRendered(true);
			getCOMP_PRINT_BUTTON().setRendered(true);
		}
		/*end*/
		
		
		
	}
	/*added by gopinfor toi on 26/05/2018*/
	public String getBeneficiary_as_customer() {

		 String Benef_cust_flag = null;
		 Connection connection = null;
		 ResultSet rs = null;
		String query="SELECT PROD_BENF_AS_CUST_YN FROM PM_IL_PRODUCT, PT_IL_POLICY WHERE "
				+ "PROD_CODE = POL_PROD_CODE AND POL_NO=? ";	
			try {
		
			 connection = CommonUtils.getConnection();
			 rs = new CRUDHandler().executeSelectStatement(query, connection,
					 new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()});
			 if(rs.next()) {
				 Benef_cust_flag = rs.getString(1);
			 }
			
			} catch (Exception e) {
			 e.printStackTrace();
		 } 
		 return Benef_cust_flag;
	 }
	
	//end
	
	

	private void enableDisableButtons() {

		if ("Y".equalsIgnoreCase(compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN()
				.getCLAIM_CLOSE_FLAG())) {
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().
				getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
		}

	}

	public List<PT_IL_CLAIM> claimNoSuggestionBox(Object event) {
		PT_IL_CLAIM_HELPER swissSql = new PT_IL_CLAIM_HELPER();
		List<PT_IL_CLAIM> claimNoList = null;
		try {
			claimNoList = helper.claimNoList(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claimNoList;
	}

	public List<PT_IL_CLAIM> policyNumberSuggestionBox(Object event) {
		PT_IL_CLAIM_HELPER swissSql = new PT_IL_CLAIM_HELPER();
		List<PT_IL_CLAIM> claimPolicyNoList = null;
		try {
			claimPolicyNoList = swissSql.claimPolNoList(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claimPolicyNoList;
	}

	public String backAction() {
		if("PILT006_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM_SETTL"))){
			return "claimsEntry";
		}
		else{
		    return SearchConstants.BACK_TO_SEARCH_PAGE;
		}
		//return "claimsEntry";

	}

	public void saveRecord() {

		getWarningMap().put("CURRENT", "Records Saved Successfully");
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Records Saved Successfully");
		
	
	}
	
	private void setWizardSummary() throws Exception{
		if("Y".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_CLOSE_FLAG())){
			setUI_M_CLOSE_FLAG("Closed");
		}
		try {
			setUI_M_CLAIM_ADDL_STATUS(getDesc(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	private String getDesc(String code) throws Exception{
		String executeQuery = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_ADDL_STAT' AND PS_CODE =  ?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String desc = null;
		
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(executeQuery, con,
					new Object[] { code });
			if (rs.next()) {
				desc = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return desc;
		
	}

	public String getUI_M_CLOSE_FLAG() {
		return UI_M_CLOSE_FLAG;
	}

	public void setUI_M_CLOSE_FLAG(String ui_m_close_flag) {
		UI_M_CLOSE_FLAG = ui_m_close_flag;
	}

	public String getUI_M_CLAIM_ADDL_STATUS() {
		return UI_M_CLAIM_ADDL_STATUS;
	}

	public void setUI_M_CLAIM_ADDL_STATUS(String ui_m_claim_addl_status) {
		UI_M_CLAIM_ADDL_STATUS = ui_m_claim_addl_status;
	}

	
	public String getUI_M_CLAIM_STATUS() {
		return UI_M_CLAIM_STATUS;
	}

	public void setUI_M_CLAIM_STATUS(String ui_m_claim_status) {
		UI_M_CLAIM_STATUS = ui_m_claim_status;
	}
	
	
	
	
	
/*	Added by sankaraNarayanan on 16/02/2016 for print Button*/
	
	
	
	
	public String runAction(){

		Connection runActionConnection = null;


		String url = null;
		String POL_SYS_ID=null;
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		System.out.println("url   :  "+url);
		setRedirectUrl(url);

		try{
			runActionConnection = CommonUtils.getConnection();
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;
				POL_SYS_ID =String.valueOf(PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID());
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				runActionConnection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
			}



		}catch(Exception e){
			e.printStackTrace();
		}
		return "";



	}
	
private String redirectUrl;
	
	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	public String runActionAfterValidate() {

		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		try {
			String rep_template_name=null;
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
			session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
			//rep_template_name = new CommonReport().template_name(moduleId,"A","PREMIREP127");
			//setRedirectUrl(new CommonReport().genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));

			//		rep_template_name="&REP_ID="+getUI_REPORT_TYPE()+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();
			//System.out.println("request.getServerName()  :"+request.getServerName());
			setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&REP_ID=PREMIREP127&REPORT_TYPE=PREMIREP117&STATUS=A&MODULE_ID="+moduleId);
			System.out.println("End");


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
	
	
	public String callReportModalPanel(){
		runAction();
		if(redirectUrl!=null)
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		else 
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return null;
	}
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
	
	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}
	
	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}

	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton comp_cancel_button) {
		COMP_CANCEL_BUTTON = comp_cancel_button;
	}


	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel comp_report_modal_panel) {
		COMP_REPORT_MODAL_PANEL = comp_report_modal_panel;
	}
	
	
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

	
	
	/*end*/

	/*added by gopi for Death Claim Settlement Letter on 11/04/17*/
	public String callPrint(){
		String outcome="";
		outcome = "PILT007_PT_IL_CLAIM_PRINT";
		
		System.out.println("outcome                    "+outcome);
		
		return outcome;
	}
	//end
	

}
