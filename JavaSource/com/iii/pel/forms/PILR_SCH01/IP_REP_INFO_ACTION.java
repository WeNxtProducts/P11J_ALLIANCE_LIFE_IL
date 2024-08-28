package com.iii.pel.forms.PILR_SCH01;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class IP_REP_INFO_ACTION  extends CommonAction{

	private HtmlOutputLabel COMP_FROM_DT_LABEL;

	private HtmlCalendar COMP_FROM_DT;

	private HtmlOutputLabel COMP_TO_DT_LABEL;

	private HtmlCalendar COMP_TO_DT;

	private HtmlOutputLabel COMP_FROM_BRANCH_LABEL;

	private HtmlInputText  COMP_FROM_BRANCH;

	private HtmlOutputLabel COMP_TO_BRANCH_LABEL;

	private HtmlInputText  COMP_TO_BRANCH;

	private HtmlOutputLabel COMP_POLICY_NO_LABEL;

	private HtmlInputText  COMP_POLICY_NO;

	private HtmlOutputLabel COMP_TO_POLICY_NO_LABEL;

	private HtmlInputText  COMP_TO_POLICY_NO;

	private HtmlOutputLabel COMP_FROM_CLAIM_TYPE_LABEL;

	private HtmlInputText  COMP_FROM_CLAIM_TYPE;

	private HtmlOutputLabel COMP_TO_CLAIM_TYPE_LABEL;

	private HtmlInputText  COMP_TO_CLAIM_TYPE;

	private HtmlSelectOneRadio COMP_SELECT_FILE_TYPE;
	
	private HtmlCommandButton COMP_UI_BUT_MAIN;

	private IP_REP_INFO IP_REP_INFO_BEAN;

	private List fromBranchList;

	private List toBranchList;

	private List fromClaimList;

	private List policyList;

	private List toPolicyList;

	private List toClaimList;

	private List fromClaimTypeList;

	private List toClaimTypeList;

	private List fromPlanList;

	private List toPlanList;

	private String reportsDatePattern=PELConstants.dbDateFormat;

	public IP_REP_INFO_ACTION(){

		IP_REP_INFO_BEAN=new IP_REP_INFO();
//		CommonUtils.setGlobalVariable("GLOBAL.M_CURR_CODE", "BND");//TODO HARD CODED CURR CODE
//		CommonUtils.setGlobalVariable("MENU_PARAMETER_01", "PILR_SCH01");
//		System.out.println("report id :"+CommonUtils.getGlobalVariable("MENU_PARAMETER_01"));
//		IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("MENU_PARAMETER_01"));
		IP_REP_INFO_BEAN.setREP_VALUE_58(CommonUtils.getControlBean().getM_DIVN_CODE());
		IP_REP_INFO_BEAN.setREP_VALUE_59(CommonUtils.getControlBean().getM_DEPT_CODE());
		IP_REP_INFO_BEAN.setREP_VALUE_60(CommonUtils.getControlBean().getM_COMP_CODE());
		String POL_NO = CommonUtils.getGlobalVariable("PILT002_APAC_POL_NO");
		if(POL_NO != null){
			IP_REP_INFO_BEAN.setREP_VALUE_1(POL_NO);
			CommonUtils.setGlobalVariable("MENU_PARAMETER_01", "PILR_SCH01");
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("MENU_PARAMETER_01"));
//			Implemented when found the solution to open the Policy Screen in the Same window
//			IP_REP_INFO_BEAN.setUI_BUT_MAIN_REND(true);
			IP_REP_INFO_BEAN.setUI_BUT_MAIN_REND(false);
		}
	}

	public HtmlOutputLabel getCOMP_FROM_DT_LABEL() {
		return COMP_FROM_DT_LABEL;
	}

	public void setCOMP_FROM_DT_LABEL(HtmlOutputLabel comp_from_dt_label) {
		COMP_FROM_DT_LABEL = comp_from_dt_label;
	}

	public HtmlCalendar getCOMP_FROM_DT() {
		return COMP_FROM_DT;
	}

	public void setCOMP_FROM_DT(HtmlCalendar comp_from_dt) {
		COMP_FROM_DT = comp_from_dt;
	}

	public HtmlOutputLabel getCOMP_TO_DT_LABEL() {
		return COMP_TO_DT_LABEL;
	}

	public void setCOMP_TO_DT_LABEL(HtmlOutputLabel comp_to_dt_label) {
		COMP_TO_DT_LABEL = comp_to_dt_label;
	}

	public HtmlCalendar getCOMP_TO_DT() {
		return COMP_TO_DT;
	}

	public void setCOMP_TO_DT(HtmlCalendar comp_to_dt) {
		COMP_TO_DT = comp_to_dt;
	}

	public HtmlOutputLabel getCOMP_FROM_BRANCH_LABEL() {
		return COMP_FROM_BRANCH_LABEL;
	}

	public void setCOMP_FROM_BRANCH_LABEL(HtmlOutputLabel COMP_FROM_BRANCH_LABEL) {
		this.COMP_FROM_BRANCH_LABEL = COMP_FROM_BRANCH_LABEL;
	}

	public HtmlInputText getCOMP_FROM_BRANCH() {
		return COMP_FROM_BRANCH;
	}

	public void setCOMP_FROM_BRANCH(HtmlInputText COMP_FROM_BRANCH) {
		this.COMP_FROM_BRANCH = COMP_FROM_BRANCH;
	}

	public HtmlOutputLabel getCOMP_TO_BRANCH_LABEL() {
		return COMP_TO_BRANCH_LABEL;
	}

	public void setCOMP_TO_BRANCH_LABEL(HtmlOutputLabel COMP_TO_BRANCH_LABEL) {
		this.COMP_TO_BRANCH_LABEL = COMP_TO_BRANCH_LABEL;
	}

	public HtmlInputText getCOMP_TO_BRANCH() {
		return COMP_TO_BRANCH;
	}

	public void setCOMP_TO_BRANCH(HtmlInputText COMP_TO_BRANCH) {
		this.COMP_TO_BRANCH = COMP_TO_BRANCH;
	}

	public HtmlOutputLabel getCOMP_POLICY_NO_LABEL() {
		return COMP_POLICY_NO_LABEL;
	}

	public void setCOMP_POLICY_NO_LABEL(HtmlOutputLabel COMP_POLICY_NO_LABEL) {
		this.COMP_POLICY_NO_LABEL = COMP_POLICY_NO_LABEL;
	}

	public HtmlInputText getCOMP_POLICY_NO() {
		return COMP_POLICY_NO;
	}

	public void setCOMP_POLICY_NO(HtmlInputText COMP_POLICY_NO) {
		this.COMP_POLICY_NO = COMP_POLICY_NO;
	}

	public HtmlOutputLabel getCOMP_TO_POLICY_NO_LABEL() {
		return COMP_TO_POLICY_NO_LABEL;
	}

	public void setCOMP_TO_POLICY_NO_LABEL(HtmlOutputLabel COMP_TO_POLICY_NO_LABEL) {
		this.COMP_TO_POLICY_NO_LABEL = COMP_TO_POLICY_NO_LABEL;
	}

	public HtmlInputText getCOMP_TO_POLICY_NO() {
		return COMP_TO_POLICY_NO;
	}

	public void setCOMP_TO_CLAIM_NO(HtmlInputText COMP_TO_POLICY_NO) {
		this.COMP_TO_POLICY_NO = COMP_TO_POLICY_NO;
	}

	public HtmlOutputLabel getCOMP_FROM_CLAIM_TYPE_LABEL() {
		return COMP_FROM_CLAIM_TYPE_LABEL;
	}

	public void setCOMP_FROM_CLAIM_TYPE_LABEL(HtmlOutputLabel COMP_FROM_CLAIM_TYPE_LABEL) {
		this.COMP_FROM_CLAIM_TYPE_LABEL = COMP_FROM_CLAIM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_FROM_CLAIM_TYPE() {
		return COMP_FROM_CLAIM_TYPE;
	}

	public void setCOMP_FROM_CLAIM_TYPE(HtmlInputText COMP_FROM_CLAIM_TYPE) {
		this.COMP_FROM_CLAIM_TYPE = COMP_FROM_CLAIM_TYPE;
	}

	public HtmlOutputLabel getCOMP_TO_CLAIM_TYPE_LABEL() {
		return COMP_TO_CLAIM_TYPE_LABEL;
	}

	public void setCOMP_TO_CLAIM_TYPE_LABEL(HtmlOutputLabel COMP_TO_CLAIM_TYPE_LABEL) {
		this.COMP_TO_CLAIM_TYPE_LABEL = COMP_TO_CLAIM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_TO_CLAIM_TYPE() {
		return COMP_TO_CLAIM_TYPE;
	}

	public void setCOMP_TO_CLAIM_TYPE(HtmlInputText COMP_TO_CLAIM_TYPE) {
		this.COMP_TO_CLAIM_TYPE = COMP_TO_CLAIM_TYPE;
	}	

	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}


	public List getFromBranchList() {
		return fromBranchList;
	}

	public void setFromBranchList(List fromBranchList) {
		this.fromBranchList = fromBranchList;
	}



	public List getToBranchList() {
		return toBranchList;
	}

	public void setToBranchList(List toBranchList) {
		this.toBranchList = toBranchList;
	}


	public List getFromClaimList() {
		return fromClaimList;
	}

	public void setFromClaimList(List fromClaimList) {
		this.fromClaimList = fromClaimList;
	}

	public List getToClaimList() {
		return toClaimList;
	}

	public void setToClaimList(List toClaimList) {
		this.toClaimList = toClaimList;
	}

	public List getFromClaimTypeList() {
		return fromClaimTypeList;
	}

	public void setFromClaimTypeList(List fromClaimTypeList) {
		this.fromClaimTypeList = fromClaimTypeList;
	}

	public List getToClaimTypeList() {
		return toClaimTypeList;
	}

	public void setToClaimTypeList(List toClaimTypeList) {
		this.toClaimTypeList = toClaimTypeList;
	}

	public List getFromPlanList() {
		return fromPlanList;
	}

	public void setFromPlanList(List fromPlanList) {
		this.fromPlanList = fromPlanList;
	}

	public List getToPlanList() {
		return toPlanList;
	}

	public void setToPlanList(List toPlanList) {
		this.toPlanList = toPlanList;
	}



	public List suggestionActionPolicy(Object event) {
		String PolicyCode = (String) event;
		policyList = new IP_REP_INFO_DELEGATE()
		.preparePolicyCodeList(PolicyCode, policyList);

		return policyList;
	}
	public List suggestionActionToClaimType(Object event) {
		String toClaimType = (String) event;
		toClaimTypeList = new IP_REP_INFO_DELEGATE()
		.prepareToClaimTypeList(toClaimType, toClaimTypeList);

		return toClaimTypeList;
	}
	public List suggestionActionFromClaimType(Object event) {
		String fromClaimType = (String) event;
		fromClaimTypeList = new IP_REP_INFO_DELEGATE()
		.prepareFromClaimTypeList(fromClaimType, fromClaimTypeList);

		return fromClaimTypeList;
	}
	public List suggestionActionToPlan(Object event) {
		String toPlanCode = (String) event;
		toPlanList = new IP_REP_INFO_DELEGATE()
		.prepareToPlanCodeList(toPlanCode, toPlanList);

		return toPlanList;
	}
	public List suggestionActionFromPlan(Object event) {
		String fromPlanCode = (String) event;
		fromPlanList = new IP_REP_INFO_DELEGATE()
		.prepareFromPlanCodeList(fromPlanCode, fromPlanList);

		return fromPlanList;
	}

	public void getSelectedFileType(ActionEvent e) {
		HtmlSelectOneRadio input = (HtmlSelectOneRadio) e.getComponent().getParent();
		String inputString = (String) input.getSubmittedValue();
		if(inputString!=null){
			if(check_Empty().equals("")){
				IP_REP_INFO_BEAN.setSelectedFileType(inputString);
				IP_REP_INFO_BEAN.setTargetValue("_blank");
			}else{
				IP_REP_INFO_BEAN.setTargetValue(null);
				IP_REP_INFO_BEAN.setSelectedFileType(null);
				COMP_SELECT_FILE_TYPE.resetValue();
				getErrorMap().put("current", check_Empty());
			}
		}
		COMP_SELECT_FILE_TYPE.resetValue();
	}

	/*	public String runAction() {
		CommonUtils.clearMaps(this);
		String repKeyNo = null;
		String redirectUrl = null;
		String ROWID = IP_REP_INFO_BEAN.getROWID();
		HttpServletResponse response=null;
		try {
			if(check_Empty().equals("")){
				if (IP_REP_INFO_BEAN.getSelectedFileType() != null) {
					getErrorMap().clear();
					if (ROWID == null) {
						repKeyNo = new ReportUtils().getRepKeyNo();
						IP_REP_INFO_BEAN.setREP_KEY_NO(repKeyNo);
						IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
						IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());
						IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					} else {
						IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());
						IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					}
					String sql_query=IP_REP_INFO_SQL_QUERY_CONSTANTS.POL_SYS_ID_QUERY;
					CRUDHandler handler = new CRUDHandler();
					ResultSet rs1 = handler.executeSelectStatement(sql_query, CommonUtils.getConnection(),new Object [] {IP_REP_INFO_BEAN.getREP_VALUE_1()});
					if(rs1.next()){
						IP_REP_INFO_BEAN.setREP_VALUE_1(rs1.getString(1));
					}

					new IP_REP_INFO_DELEGATE().executeSaveAction(this.IP_REP_INFO_BEAN);
					response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

					redirectUrl = new CommonUtils().getReportRedirectString(
							IP_REP_INFO_BEAN.getREP_KEY_NO(), 
							IP_REP_INFO_BEAN.getREP_ID(), 
							IP_REP_INFO_BEAN.getSelectedFileType());
					response.sendRedirect(redirectUrl);
				}else{
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please select one report type");
					setErrorMessages("Please select one report type");
				}
			}else{
				getErrorMap().put("current", check_Empty());
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirectUrl;
	}
	 */
	public String runAction(){
		String repKeyNo=null;  
		HttpServletResponse response = null;
		try {
			if(check_Empty().equals("")){
				if (IP_REP_INFO_BEAN.getSelectedFileType() != null) {
					getErrorMap().clear();
					if(IP_REP_INFO_BEAN.getROWID()==null){
						repKeyNo=new IP_REP_INFO_DELEGATE().getRepKeyNo();
						IP_REP_INFO_BEAN.setREP_KEY_NO(repKeyNo);
						System.out.println("rep_value6 is "+IP_REP_INFO_BEAN.getREP_VALUE_6());
						System.out.println("Global variable red id is "+CommonUtils.getGlobalVariable("MENU_PARAMETER_01"));
						//IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("MENU_PARAMETER_01"));
						IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());
						IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					}else{

						IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());
						IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());

					}

					String sql_query=IP_REP_INFO_SQL_QUERY_CONSTANTS.POL_SYS_ID_QUERY;
					CRUDHandler handler = new CRUDHandler();
					ResultSet rs1 = handler.executeSelectStatement(sql_query, CommonUtils.getConnection(),new Object [] {IP_REP_INFO_BEAN.getREP_VALUE_1()});
					if(rs1.next()){
						IP_REP_INFO_BEAN.setREP_VALUE_1(rs1.getString(1));
					}
					new IP_REP_INFO_DELEGATE().executeSaveAction(this.IP_REP_INFO_BEAN);
					response=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

					System.out.println("IP_REP_INFO_BEAN.getREP_KEY_NO() :"+IP_REP_INFO_BEAN.getREP_KEY_NO());
					System.out.println("IP_REP_INFO_BEAN.getREP_ID() :"+IP_REP_INFO_BEAN.getREP_ID());

					String lang_Code=CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
					String COMP_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE");
					String CURR_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_CURR_CODE");

					if(IP_REP_INFO_BEAN.getSelectedFileType()!=null){

						response.sendRedirect("/PEL/report?repKeyNo="+IP_REP_INFO_BEAN.getREP_KEY_NO()+
								"&reportId="+IP_REP_INFO_BEAN.getREP_ID()+"&langCode="+lang_Code+"&COMP_CODE="+
								COMP_CODE+"&CURR_CODE="+CURR_CODE+"&fileType="+IP_REP_INFO_BEAN.getSelectedFileType());
					}
				}else{
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please select one report type");
					setErrorMessages("Please select one report type");
				}
				
				String POL_NO = CommonUtils.getGlobalVariable("PILT002_APAC_POL_NO");
				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_NO);
			}else{
				getErrorMap().put("current", check_Empty());
			}
		}catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}

	public String check_Empty() {
		String return_Value = "";
		String required = " : "+Messages.getString(PELConstants.pelErrorMessagePath, "FRM_10005");
		if(IP_REP_INFO_BEAN.getREP_VALUE_1() == null || IP_REP_INFO_BEAN.getREP_VALUE_1().trim().length()<=0){
			return_Value =  Messages.getString("messageProperties_PILR_SCH01", "PILR_SCH01$INT_REP_INFO$POLICY_NO$caption")+required;
		}
		return return_Value;
	}

	public void submitFromDate(ActionEvent e) {
		HtmlCalendar input = (HtmlCalendar) e.getComponent().getParent();
		Date inputdate = input.getAsDate(input.getSubmittedValue());
		System.out.println("From Date :" + inputdate);
		if (inputdate != null) {
			String strngDate=changeDatetoString(inputdate);
			System.out.println("String Date :"+strngDate);
			IP_REP_INFO_BEAN.setREP_VALUE_1(strngDate);
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_1());
		}
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void submitToDate(ActionEvent e) {
		HtmlCalendar input = (HtmlCalendar) e.getComponent().getParent();
		Date inputdate = getCOMP_TO_DT().getAsDate(input.getAsDate(input.getSubmittedValue()));
		System.out.println("TO Date to be Set :" + inputdate);
		if (inputdate != null) {
			String strngDate=changeDatetoString(inputdate);
			System.out.println("String Date :"+strngDate);
			IP_REP_INFO_BEAN.setTO_DATE(inputdate);
			IP_REP_INFO_BEAN.setREP_VALUE_2(strngDate);
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_2());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();


	public void submitFromBranch(ActionEvent e) {
		WHEN_VALIDATE_COMP_FROM_BRANCH_CODE();
		System.out.println("From Branch Validation Called ....");
		/*if("".equals(getCOMP_FROM_BRANCH().getSubmittedValue())){
			System.out.println("Here from branch value is Empty...");
			getCOMP_FROM_BRANCH().setSubmittedValue("0");
		}*/
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = input.getSubmittedValue().toString();
		System.out.println("From Branch to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_5(inputString);
			System.out.println("From Branch :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_5());
		}
		ErrorHelpUtil.validate(input, getErrorMap());

		//helper.pilr_rep009_ui_m_branch_fm_when_validate_item();

	}


	public void submitToBranch(ActionEvent e) {
		WHEN_VALIDATE_COMP_TO_BRANCH_CODE();
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = input.getSubmittedValue().toString();
		System.out.println("submitToBranch to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_6(inputString);
			System.out.println("submitToBranch :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_6());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	public void submitPolicy(ActionEvent e) {
		//WHEN_VALIDATE_COMP_POLCIY_CODE();
		try {
			HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
			String inputString = input.getSubmittedValue().toString();
			IP_REP_INFO_BEAN.setREP_VALUE_1(inputString);

			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	public void submitFromClaimType(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = input.getSubmittedValue().toString();
		System.out.println("submitFromClaimType to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_7(inputString+"");
			System.out.println("submitFromClaimType :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_7());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatePOLICY_NO(FacesContext context, UIComponent component,Object value) throws ValidatorException{
		String validation_Query = IP_REP_INFO_SQL_QUERY_CONSTANTS.VALIDATE_POLICY_NO_LOV;
		Object [] values = {IP_REP_INFO_BEAN.getREP_VALUE_1()};
		if(!validate_LOV(validation_Query,values)){
			IP_REP_INFO_BEAN.setREP_VALUE_1(null);
			COMP_POLICY_NO.resetValue();
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "3202"));
		}
	}

	public boolean validate_LOV(String query,Object [] values){
		boolean status = false;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet ;
		try {
			if(!values[0].equals("0") && !values[0].equals("zzzzzzz")){
				resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(), values);
				if(resultSet.next()){
					status = true;
				}
			}else{
				status = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	public void submitToClaimType(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = input.getSubmittedValue().toString();
		System.out.println("submitToClaimType to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_8(inputString+"");
			System.out.println("submitToClaimType :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_8());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void submitFromPlan(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("from Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_9(inputString+"");
			System.out.println("FromPlan :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_9());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void submitToPlan(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("from Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_10(inputString+"");
			System.out.println("ToPlan :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_10());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlSelectOneRadio getCOMP_SELECT_FILE_TYPE() {
		return COMP_SELECT_FILE_TYPE;
	}

	public void setCOMP_SELECT_FILE_TYPE(HtmlSelectOneRadio comp_select_file_type) {
		COMP_SELECT_FILE_TYPE = comp_select_file_type;
	}

	public String changeDatetoString(Date dateObject){
		String stringDate=null;
		DateFormat format=new SimpleDateFormat(PELConstants.dbDateFormat);
		stringDate=format.format(dateObject);
		return stringDate; 

	}

	public Date changeStringToDate(String stringDate){
		Date returnDate=null;
		DateFormat format=new SimpleDateFormat(PELConstants.dbDateFormat);
		try {
			returnDate=format.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnDate;
	}


	public String getReportsDatePattern() {
		return reportsDatePattern;
	}

	public void setReportsDatePattern(String reportsDatePattern) {
		this.reportsDatePattern = reportsDatePattern;
	}


	public void validateToAndFromDate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException{

		String fromDateString=IP_REP_INFO_BEAN.getREP_VALUE_1();
		String toDateString=IP_REP_INFO_BEAN.getREP_VALUE_2();

		System.out.println("fromDateString :"+fromDateString+" ::::"+"toDateString :"+toDateString);
		Date fromDate=changeStringToDate(fromDateString);
		Date toDate=changeStringToDate(toDateString);
		if(toDate.before(fromDate)){
			throw new ValidatorException(new FacesMessage("ToDate should not be less then FromDate"));
		}


	}

	public void WHEN_VALIDATE_COMP_POLCIY_CODE(){
		if("".equals(getCOMP_POLICY_NO().getSubmittedValue())){
			System.out.println("Here from branch value is Empty...");
			getCOMP_POLICY_NO().setSubmittedValue("0");
		}
	}



	public void WHEN_VALIDATE_COMP_FROM_BRANCH_CODE(){
		if("".equals(getCOMP_FROM_BRANCH().getSubmittedValue().toString()) ){
			getCOMP_FROM_BRANCH().setSubmittedValue(P_SET_FIRST_FIELD(getCOMP_FROM_BRANCH().getSubmittedValue().toString(),getCOMP_TO_BRANCH().getSubmittedValue().toString()));
		}else if(!"".equals(getCOMP_TO_BRANCH().getSubmittedValue().toString()))
			L_VAL_FROM_TO(getCOMP_FROM_BRANCH().getSubmittedValue().toString(),getCOMP_TO_BRANCH().getSubmittedValue().toString());
	}


	public void WHEN_VALIDATE_COMP_TO_BRANCH_CODE(){
		if("".equals(getCOMP_TO_BRANCH().getSubmittedValue().toString())){
			getCOMP_TO_BRANCH().setSubmittedValue(P_SET_SECOND_FIELD(getCOMP_FROM_BRANCH().getSubmittedValue().toString(),getCOMP_TO_BRANCH().getSubmittedValue().toString()));
		}else{
			L_VAL_FROM_TO(getCOMP_FROM_BRANCH().getSubmittedValue().toString(),getCOMP_TO_BRANCH().getSubmittedValue().toString());
		}
	}

	public void UI_M_BRANCH_FM_WHEN_VALIDATE(ActionEvent event)
	{
		IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();
		helper.pilr_rep009_ui_m_branch_fm_when_validate_item();
	}

	public void UI_M_BRANCH_TO_WHEN_VALIDATE(ActionEvent event)
	{
		IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();
		helper.pilr_rep009_ui_m_branch_to_when_validate_item();
	}

	public void UI_M_CLAIM_FM_WHEN_VALIDATE(ActionEvent event)
	{
		IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();
		helper.pilr_rep009_ui_m_claim_fm_when_validate_item();
	}

	public void UI_M_CLAIM_TO_WHEN_VALIDATE(ActionEvent event)
	{
		IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();
		helper.pilr_rep009_ui_m_claim_to_when_validate_item();
	}

	public void UI_M_CLAIM_TYPE_FM_WHEN_VALIDATE(ActionEvent event)
	{
		IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();
		helper.pilr_rep009_ui_m_claim_type_fm_when_validate_item();
	}

	public void UI_M_CLAIM_TYPE_TO_WHEN_VALIDATE(ActionEvent event)
	{
		IP_REP_INFO_DELEGATE helper = new IP_REP_INFO_DELEGATE();
		helper.pilr_rep009_ui_m_claim_type_to_when_validate_item();
	}

	public void setCOMP_TO_POLICY_NO(HtmlInputText comp_to_policy_no) {
		COMP_TO_POLICY_NO = comp_to_policy_no;
	}

	public List getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List policyList) {
		this.policyList = policyList;
	}

	public List getToPolicyList() {
		return toPolicyList;
	}

	public void setToPolicyList(List toPolicyList) {
		this.toPolicyList = toPolicyList;
	}

	public boolean L_VAL_FROM_TO (String P_FROM_CODE,String P_TO_CODE){
		if("".equals(P_FROM_CODE)){
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80033").getDetail());
		}else{
			if(P_TO_CODE.compareTo(P_FROM_CODE) < 0){
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80034").getDetail());
			}else{
				getErrorMap().clear();
			}
		}
		return false;
	}

	public String goPT_IL_POLICY(){
		IP_REP_INFO_BEAN.setTargetValue(null);
		IP_REP_INFO_BEAN.setSelectedFileType(null);
		COMP_SELECT_FILE_TYPE.resetValue();
		System.out.println("Target value >> "+IP_REP_INFO_BEAN.getTargetValue()+" Selected File type >> "+IP_REP_INFO_BEAN.getSelectedFileType());
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if(session.get("PILR_SCH01_IP_REP_INFO_ACTION") != null){
			session.remove("PILR_SCH01_IP_REP_INFO_ACTION");
		}
		return "PILT002_APAC_PT_IL_POLICY";
	}

	public String P_SET_FIRST_FIELD(String M_FIELD_NAME,String M_FIELD_NAME2){
		if("".equals(M_FIELD_NAME)){
			M_FIELD_NAME = "0";
		}
		return M_FIELD_NAME;
	} 
	
	public String P_SET_SECOND_FIELD(String M_FIELD_NAME1,String M_FIELD_NAME2){
		if("".equals(M_FIELD_NAME2)){
			if(M_FIELD_NAME1.equals("0")){
				M_FIELD_NAME2 = "zzzzzzzzz";
			}else{
				M_FIELD_NAME2 = M_FIELD_NAME1;
			}
		}
		return M_FIELD_NAME2;
	}

	public void submitFileType(ActionEvent event){
		UIInput input=(UIInput) event.getComponent().getParent();
		String selectedFileType=input.getSubmittedValue().toString();
		System.out.println("Clicked Value :"+selectedFileType);
		if(selectedFileType!=null){
			IP_REP_INFO_BEAN.setSelectedFileType(selectedFileType);
		}

	}

	public HtmlCommandButton getCOMP_UI_BUT_MAIN() {
		return COMP_UI_BUT_MAIN;
	}

	public void setCOMP_UI_BUT_MAIN(HtmlCommandButton comp_ui_but_main) {
		COMP_UI_BUT_MAIN = comp_ui_but_main;
	}

}
