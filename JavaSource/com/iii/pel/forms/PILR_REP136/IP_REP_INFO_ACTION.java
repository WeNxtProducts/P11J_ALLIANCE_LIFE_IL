package com.iii.pel.forms.PILR_REP136;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class IP_REP_INFO_ACTION  extends CommonAction{
	
	private HtmlOutputLabel COMP_PROD_TYPE_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_TYPE;
	
	private HtmlOutputLabel COMP_FM_AGENCY_CODE_LABEL;
	
	private HtmlInputText COMP_FM_AGENCY_CODE;
	
	private HtmlOutputLabel COMP_TO_AGENCY_CODE_LABEL;
	
	private HtmlInputText COMP_TO_AGENCY_CODE;
	
	private HtmlOutputLabel COMP_FM_UNIT_CODE_LABEL;
	
	private HtmlOutputLabel COMP_TO_UNIT_CODE_LABEL;
	
	private HtmlInputText COMP_FM_UNIT_CODE;
	
	private HtmlInputText COMP_TO_UNIT_CODE;
	
	private HtmlOutputLabel COMP_FM_MKT_CODE_LABEL;
	
	private HtmlInputText COMP_FM_MKT_CODE;
	
	private HtmlOutputLabel COMP_TO_MKT_CODE_LABEL;
	
	private HtmlInputText COMP_TO_MKT_CODE;
	
	private HtmlOutputLabel COMP_FM_AGENT_CODE_LABEL;
	
	private HtmlInputText COMP_FM_AGENT_CODE;
	
	private HtmlOutputLabel COMP_TO_AGENT_CODE_LABEL;
	
	private HtmlInputText COMP_TO_AGENT_CODE;
	
	private HtmlOutputLabel COMP_FM_DT_LABEL;
	
	private HtmlCalendar COMP_FM_DT;
	
	private HtmlOutputLabel COMP_TO_DT_LABEL;
	
	private HtmlCalendar COMP_TO_DT;
	
	
	private List<PILR_REP136_LovBean> agencyCodeSBList;
	
	private List<PILR_REP136_LovBean> unitCodeSBList;
	
	private List<PILR_REP136_LovBean> marketCodeSBList;
	
	private List<PILR_REP136_LovBean> agentCodeSBList;
	
	private List<PILR_REP136_LovBean> agentSBList;
	
	private HtmlSelectOneRadio COMP_SELECT_FILE_TYPE;
		
	private IP_REP_INFO IP_REP_INFO_BEAN;
	
	private String reportsDatePattern=PELConstants.dbDateFormat;
	
	private List<SelectItem> productTypeList;
	
	public IP_REP_INFO_ACTION(){
		
		IP_REP_INFO_BEAN=new IP_REP_INFO();
		CommonUtils.setGlobalVariable("MENU_PARAMETER_01", "PILR_REP136");
		IP_REP_INFO_BEAN.setREP_VALUE_58(CommonUtils.getControlBean().getM_DIVN_CODE());
		IP_REP_INFO_BEAN.setREP_VALUE_59(CommonUtils.getControlBean().getM_DEPT_CODE());
		IP_REP_INFO_BEAN.setREP_VALUE_60(CommonUtils.getControlBean().getM_COMP_CODE());
		try
		{
			productTypeList=ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILR136", "REP_PARAM","REP_PARAM.M_PROD_TYPE","AGT_PROD_TYP");
			IP_REP_INFO_BEAN.setREP_VALUE_1("P");
		}catch(Exception e){e.printStackTrace();}
	}
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}

	public String runAction(){
		String repKeyNo=null;
		String redirectUrl=null;
		try {
				if(IP_REP_INFO_BEAN.getROWID()==null){
					repKeyNo=new IP_REP_INFO_DELEGATE().getRepKeyNo();
					IP_REP_INFO_BEAN.setREP_KEY_NO(repKeyNo);
					IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("MENU_PARAMETER_01"));
					IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());
					IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				}else{
					
					IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());
					IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					
				}
		
				System.out.println("Rep Key No :"+repKeyNo);
				new IP_REP_INFO_DELEGATE().executeSaveAction(this.IP_REP_INFO_BEAN);
				HttpServletResponse response=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
				
				System.out.println("IP_REP_INFO_BEAN.getREP_KEY_NO() :"+IP_REP_INFO_BEAN.getREP_KEY_NO());
				System.out.println("IP_REP_INFO_BEAN.getREP_ID() :"+IP_REP_INFO_BEAN.getREP_ID());
				
				String lang_Code=CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
				String COMP_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE");
				String CURR_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_CURR_CODE");
				
				if(IP_REP_INFO_BEAN.getSelectedFileType()!=null){
					
					redirectUrl="/PEL/report"+"?repKeyNo="+IP_REP_INFO_BEAN.getREP_KEY_NO()+
					"&reportId="+IP_REP_INFO_BEAN.getREP_ID()+"&langCode="+lang_Code+"&COMP_CODE="+
					COMP_CODE+"&CURR_CODE="+CURR_CODE+"&fileType="+IP_REP_INFO_BEAN.getSelectedFileType();
				}
				
				/*response.sendRedirect("http://10.44.17.164:8080/PEL/report?repKeyNo="+IP_REP_INFO_BEAN.getREP_KEY_NO()+
										"&reportId="+IP_REP_INFO_BEAN.getREP_ID()+"&langCode="+lang_Code+"&COMP_CODE="+
										COMP_CODE+"&CURR_CODE="+CURR_CODE);*/
				response.sendRedirect(redirectUrl);
				
		}catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return redirectUrl;
	}
	
	public void submitFromDate(ActionEvent e) {
		HtmlCalendar input = (HtmlCalendar) e.getComponent().getParent();
		Date inputdate = input.getAsDate(input.getSubmittedValue());
		System.out.println("From Date :" + inputdate);
		if (inputdate != null) {
			String strngDate=changeDatetoString(inputdate);
			System.out.println("String Date :"+strngDate);
			IP_REP_INFO_BEAN.setFROM_DATE(inputdate);
			//<!--[ BugId:PREMIAGDC-000070 Siva Phanikumar.Keerthi 25-Feb-09 
			  //    Change the property from REP_VALUE_1 to REP_VALUE_10 in the fromDate ActionEvene method -->

			IP_REP_INFO_BEAN.setREP_VALUE_10(strngDate);
			
			//<!-- BugId:PREMIAGDC-000070 Siva Phanikumar.Keerthi 25-Feb-09 
			  //    Change the property from REP_VALUE_1 to REP_VALUE_10 in the fromDate ActionEvene method -->]
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_1());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	
	}
	
	/*public void submitToDate(ActionEvent e) {
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
	}*/
	
	public void submitFromDivn(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("From Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_3(inputString+"");
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_3());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	
	}
	
	public void submitToDivn(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("To Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_4(inputString+"");
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_4());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	
	}
	
	public void submitFromDept(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("from Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_5(inputString+"");
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_5());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void submitToDept(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("from Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_6(inputString+"");
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_6());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void submitFromClass(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("from Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_7(inputString+"");
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_7());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void submitToClass(ActionEvent e) {
		HtmlInputText input = (HtmlInputText) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		System.out.println("from Divn to be Set :" + inputString);
		if (inputString != null) {
			IP_REP_INFO_BEAN.setREP_VALUE_8(inputString+"");
			System.out.println("ToClass :"
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
	
	public void getSelectedFileType(ActionEvent e) {
		HtmlSelectOneRadio input = (HtmlSelectOneRadio) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		ErrorHelpUtil.validate(input, getErrorMap());
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
		

	//<!--[ BugId:PREMIAGDC-000070 Siva Phanikumar.Keerthi 25-Feb-09 
	//Change the property from REP_VALUE_1 to REP_VALUE_10 and REP_VALUE_2  to REP_VALUE_11 in the fromDate and ToDate validation method -->
		
		String fromDateString=IP_REP_INFO_BEAN.getREP_VALUE_10();
		String toDateString=IP_REP_INFO_BEAN.getREP_VALUE_11();
		
		//<!--[ BugId:PREMIAGDC-000070 Siva Phanikumar.Keerthi 25-Feb-09 
		//Change the property from REP_VALUE_1 to REP_VALUE_10 and REP_VALUE_2  to REP_VALUE_11 in the fromDate and ToDate validation method -->]
		
		System.out.println("fromDateString :"+fromDateString+" ::::"+"toDateString :"+toDateString);
		Date fromDate=changeStringToDate(fromDateString);
		Date toDate=changeStringToDate(toDateString);
		if(toDate.before(fromDate)){
			throw new ValidatorException(new FacesMessage("ToDate should not be less then FromDate"));
		}
		
		
	}
	public HtmlOutputLabel getCOMP_PROD_TYPE_LABEL() {
		return COMP_PROD_TYPE_LABEL;
	}
	public void setCOMP_PROD_TYPE_LABEL(HtmlOutputLabel comp_prod_type_label) {
		COMP_PROD_TYPE_LABEL = comp_prod_type_label;
	}
	
	public HtmlOutputLabel getCOMP_FM_AGENCY_CODE_LABEL() {
		return COMP_FM_AGENCY_CODE_LABEL;
	}
	public void setCOMP_FM_AGENCY_CODE_LABEL(
			HtmlOutputLabel comp_fm_agency_code_label) {
		COMP_FM_AGENCY_CODE_LABEL = comp_fm_agency_code_label;
	}
	public HtmlInputText getCOMP_FM_AGENCY_CODE() {
		return COMP_FM_AGENCY_CODE;
	}
	public void setCOMP_FM_AGENCY_CODE(HtmlInputText comp_fm_agency_code) {
		COMP_FM_AGENCY_CODE = comp_fm_agency_code;
	}
	public HtmlOutputLabel getCOMP_TO_AGENCY_CODE_LABEL() {
		return COMP_TO_AGENCY_CODE_LABEL;
	}
	public void setCOMP_TO_AGENCY_CODE_LABEL(
			HtmlOutputLabel comp_to_agency_code_label) {
		COMP_TO_AGENCY_CODE_LABEL = comp_to_agency_code_label;
	}
	public HtmlInputText getCOMP_TO_AGENCY_CODE() {
		return COMP_TO_AGENCY_CODE;
	}
	public void setCOMP_TO_AGENCY_CODE(HtmlInputText comp_to_agency_code) {
		COMP_TO_AGENCY_CODE = comp_to_agency_code;
	}
	public HtmlOutputLabel getCOMP_FM_UNIT_CODE_LABEL() {
		return COMP_FM_UNIT_CODE_LABEL;
	}
	public void setCOMP_FM_UNIT_CODE_LABEL(HtmlOutputLabel comp_fm_unit_code_label) {
		COMP_FM_UNIT_CODE_LABEL = comp_fm_unit_code_label;
	}
	public HtmlInputText getCOMP_TO_UNIT_CODE() {
		return COMP_TO_UNIT_CODE;
	}
	public void setCOMP_TO_UNIT_CODE(HtmlInputText comp_to_unit_code) {
		COMP_TO_UNIT_CODE = comp_to_unit_code;
	}
	public HtmlOutputLabel getCOMP_FM_MKT_CODE_LABEL() {
		return COMP_FM_MKT_CODE_LABEL;
	}
	public void setCOMP_FM_MKT_CODE_LABEL(HtmlOutputLabel comp_fm_mkt_code_label) {
		COMP_FM_MKT_CODE_LABEL = comp_fm_mkt_code_label;
	}
	public HtmlInputText getCOMP_FM_MKT_CODE() {
		return COMP_FM_MKT_CODE;
	}
	public void setCOMP_FM_MKT_CODE(HtmlInputText comp_fm_mkt_code) {
		COMP_FM_MKT_CODE = comp_fm_mkt_code;
	}
	public HtmlOutputLabel getCOMP_FM_AGENT_CODE_LABEL() {
		return COMP_FM_AGENT_CODE_LABEL;
	}
	public void setCOMP_FM_AGENT_CODE_LABEL(HtmlOutputLabel comp_fm_agent_code_label) {
		COMP_FM_AGENT_CODE_LABEL = comp_fm_agent_code_label;
	}
	public HtmlInputText getCOMP_FM_AGENT_CODE() {
		return COMP_FM_AGENT_CODE;
	}
	public void setCOMP_FM_AGENT_CODE(HtmlInputText comp_fm_agent_code) {
		COMP_FM_AGENT_CODE = comp_fm_agent_code;
	}
	public HtmlOutputLabel getCOMP_TO_AGENT_CODE_LABEL() {
		return COMP_TO_AGENT_CODE_LABEL;
	}
	public void setCOMP_TO_AGENT_CODE_LABEL(HtmlOutputLabel comp_to_agent_code_label) {
		COMP_TO_AGENT_CODE_LABEL = comp_to_agent_code_label;
	}
	public HtmlInputText getCOMP_TO_AGENT_CODE() {
		return COMP_TO_AGENT_CODE;
	}
	public void setCOMP_TO_AGENT_CODE(HtmlInputText comp_to_agent_code) {
		COMP_TO_AGENT_CODE = comp_to_agent_code;
	}
	
	public HtmlCalendar getCOMP_FM_DT() {
		return COMP_FM_DT;
	}
	public void setCOMP_FM_DT(HtmlCalendar comp_fm_dt) {
		COMP_FM_DT = comp_fm_dt;
	}
	public HtmlOutputLabel getCOMP_TO_DT_LABEL() {
		return COMP_TO_DT_LABEL;
	}
	public void setCOMP_TO_DT_LABEL(HtmlOutputLabel comp_to_dt_label) {
		COMP_TO_DT_LABEL = comp_to_dt_label;
	}
	
	public HtmlOutputLabel getCOMP_TO_UNIT_CODE_LABEL() {
		return COMP_TO_UNIT_CODE_LABEL;
	}
	public void setCOMP_TO_UNIT_CODE_LABEL(HtmlOutputLabel comp_to_unit_code_label) {
		COMP_TO_UNIT_CODE_LABEL = comp_to_unit_code_label;
	}
	public HtmlCalendar getCOMP_TO_DT() {
		return COMP_TO_DT;
	}
	public void setCOMP_TO_DT(HtmlCalendar comp_to_dt) {
		COMP_TO_DT = comp_to_dt;
	}
	public HtmlInputText getCOMP_FM_UNIT_CODE() {
		return COMP_FM_UNIT_CODE;
	}
	public void setCOMP_FM_UNIT_CODE(HtmlInputText comp_fm_unit_code) {
		COMP_FM_UNIT_CODE = comp_fm_unit_code;
	}
	public HtmlOutputLabel getCOMP_TO_MKT_CODE_LABEL() {
		return COMP_TO_MKT_CODE_LABEL;
	}
	public void setCOMP_TO_MKT_CODE_LABEL(HtmlOutputLabel comp_to_mkt_code_label) {
		COMP_TO_MKT_CODE_LABEL = comp_to_mkt_code_label;
	}
	public HtmlInputText getCOMP_TO_MKT_CODE() {
		return COMP_TO_MKT_CODE;
	}
	public void setCOMP_TO_MKT_CODE(HtmlInputText comp_to_mkt_code) {
		COMP_TO_MKT_CODE = comp_to_mkt_code;
	}
	public HtmlOutputLabel getCOMP_FM_DT_LABEL() {
		return COMP_FM_DT_LABEL;
	}
	public void setCOMP_FM_DT_LABEL(HtmlOutputLabel comp_fm_dt_label) {
		COMP_FM_DT_LABEL = comp_fm_dt_label;
	}
	public List<PILR_REP136_LovBean> agencyCodeLov(Object object)
	{
		agencyCodeSBList=new IP_REP_INFO_DELEGATE().agencyCodeLov((String)object);
		return agencyCodeSBList;
	}
	public List<PILR_REP136_LovBean> unitCodeLov(Object object)
	{
		unitCodeSBList=new IP_REP_INFO_DELEGATE().unitCodeLov((String)object);
		return unitCodeSBList;
	}
	public List<PILR_REP136_LovBean> marketCodeLov(Object object)
	{
		marketCodeSBList=new IP_REP_INFO_DELEGATE().marketCodeLov((String)object);
		return marketCodeSBList;
	}
	public List<PILR_REP136_LovBean> agentCodeLov(Object object)
	{
		agentCodeSBList=new IP_REP_INFO_DELEGATE().agentCodeLov((String)object);
		return agentCodeSBList;
	}
	public List<PILR_REP136_LovBean> getAgencyCodeSBList() {
		return agencyCodeSBList;
	}
	public void setAgencyCodeSBList(List<PILR_REP136_LovBean> agencyCodeSBList) {
		this.agencyCodeSBList = agencyCodeSBList;
	}
	public List<PILR_REP136_LovBean> getUnitCodeSBList() {
		return unitCodeSBList;
	}
	public void setUnitCodeSBList(List<PILR_REP136_LovBean> unitCodeSBList) {
		this.unitCodeSBList = unitCodeSBList;
	}
	public List<PILR_REP136_LovBean> getMarketCodeSBList() {
		return marketCodeSBList;
	}
	public void setMarketCodeSBList(List<PILR_REP136_LovBean> marketCodeSBList) {
		this.marketCodeSBList = marketCodeSBList;
	}
	public List<PILR_REP136_LovBean> getAgentCodeSBList() {
		return agentCodeSBList;
	}
	public void setAgentCodeSBList(List<PILR_REP136_LovBean> agentCodeSBList) {
		this.agentCodeSBList = agentCodeSBList;
	}
	public List<PILR_REP136_LovBean> getAgentSBList() {
		return agentSBList;
	}
	public void setAgentSBList(List<PILR_REP136_LovBean> agentSBList) {
		this.agentSBList = agentSBList;
	}
	public List<SelectItem> getProductTypeList() {
		return productTypeList;
	}
	public void setProductTypeList(List<SelectItem> productTypeList) {
		this.productTypeList = productTypeList;
	}
	public HtmlSelectOneMenu getCOMP_PROD_TYPE() {
		return COMP_PROD_TYPE;
	}
	public void setCOMP_PROD_TYPE(HtmlSelectOneMenu comp_prod_type) {
		COMP_PROD_TYPE = comp_prod_type;
	}
	
	//<!--[ BugId:PREMIAGDC-000070 Siva Phanikumar.Keerthi 25-Feb-09 
	  //    Newly added method -->
	
	public void submitToDate(ActionEvent e) {
		HtmlCalendar input = (HtmlCalendar) e.getComponent().getParent();
		Date inputdate = getCOMP_TO_DT().getAsDate(input.getAsDate(input.getSubmittedValue()));
		System.out.println("TO Date to be Set :" + inputdate);
		if (inputdate != null) {
			String strngDate=changeDatetoString(inputdate);
			System.out.println("String Date :"+strngDate);
			IP_REP_INFO_BEAN.setTO_DATE(inputdate);
			IP_REP_INFO_BEAN.setREP_VALUE_11(strngDate);
			System.out.println("FROM Date :"
					+ IP_REP_INFO_BEAN.getREP_VALUE_2());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}	
	
	//<!-- BugId:PREMIAGDC-000070 Siva Phanikumar.Keerthi 25-Feb-09 
	  //    Newly added method -->]
	
	// Added by Shankar Bodduluri
	
	public void L_VAL_FROM_TO(String P_FROM_CODE,String P_TO_CODE){
		if(P_TO_CODE == null || P_TO_CODE.isEmpty()) {
		}else{
			if(P_TO_CODE.compareTo(P_FROM_CODE) < 0){
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
			}
		}
	}
	String toCode = "zzzzzzzzz";
	String fromCode = "0";
	public void COMP_FM_AGENCY_CODE_Validate(ActionEvent actionEvent){
		String FM_AGENCY_CODE = null; 
		FM_AGENCY_CODE = (String) getCOMP_FM_AGENCY_CODE().getSubmittedValue();
		if(FM_AGENCY_CODE==null || FM_AGENCY_CODE.trim().isEmpty()){
			IP_REP_INFO_BEAN.setREP_VALUE_2(fromCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_2(FM_AGENCY_CODE);
			IP_REP_INFO_BEAN.setREP_VALUE_3(FM_AGENCY_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_2(), IP_REP_INFO_BEAN.getREP_VALUE_3());
		COMP_FM_AGENCY_CODE.resetValue();
		COMP_TO_AGENCY_CODE.resetValue();
	}
	public void COMP_TO_AGENCY_CODE_Validate(ActionEvent actionEvent){
		String TO_AGENCY_CODE = null; 
		TO_AGENCY_CODE = (String) getCOMP_TO_AGENCY_CODE().getSubmittedValue();
		if (TO_AGENCY_CODE == null || TO_AGENCY_CODE.trim().isEmpty()) {
			IP_REP_INFO_BEAN.setREP_VALUE_3(toCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_3(TO_AGENCY_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_2(), IP_REP_INFO_BEAN.getREP_VALUE_3());
		COMP_TO_AGENCY_CODE.resetValue();
	}
	public void COMP_FM_UNIT_CODE_Validate(ActionEvent actionEvent){
		String FM_UNIT_CODE = null; 
		FM_UNIT_CODE = (String) getCOMP_FM_UNIT_CODE().getSubmittedValue();
		if(FM_UNIT_CODE==null || FM_UNIT_CODE.trim().isEmpty()){
			IP_REP_INFO_BEAN.setREP_VALUE_4(fromCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_4(FM_UNIT_CODE);
			IP_REP_INFO_BEAN.setREP_VALUE_5(FM_UNIT_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_4(), IP_REP_INFO_BEAN.getREP_VALUE_5());
		COMP_FM_UNIT_CODE.resetValue();
		COMP_TO_UNIT_CODE.resetValue();
	}
	public void COMP_TO_UNIT_CODE_Validate(ActionEvent actionEvent){
		String TO_UNIT_CODE = null; 
		TO_UNIT_CODE = (String) getCOMP_TO_UNIT_CODE().getSubmittedValue();
		if (TO_UNIT_CODE == null || TO_UNIT_CODE.trim().isEmpty()) {
			IP_REP_INFO_BEAN.setREP_VALUE_5(toCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_5(TO_UNIT_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_4(), IP_REP_INFO_BEAN.getREP_VALUE_5());
		COMP_TO_UNIT_CODE.resetValue();
	}
	public void COMP_FM_MKT_CODE_Validate(ActionEvent actionEvent){
		String FM_MKT_CODE = null; 
		FM_MKT_CODE = (String) getCOMP_FM_MKT_CODE().getSubmittedValue();
		if(FM_MKT_CODE==null || FM_MKT_CODE.trim().isEmpty()){
			IP_REP_INFO_BEAN.setREP_VALUE_6(fromCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_6(FM_MKT_CODE);
			IP_REP_INFO_BEAN.setREP_VALUE_7(FM_MKT_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_6(), IP_REP_INFO_BEAN.getREP_VALUE_7());
		COMP_FM_MKT_CODE.resetValue();
		COMP_TO_MKT_CODE.resetValue();
	}
	public void COMP_TO_MKT_CODE_Validate(ActionEvent actionEvent){
		String TO_MKT_CODE = null; 
		TO_MKT_CODE = (String) getCOMP_TO_MKT_CODE().getSubmittedValue();
		if (TO_MKT_CODE == null || TO_MKT_CODE.trim().isEmpty()) {
			IP_REP_INFO_BEAN.setREP_VALUE_7(toCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_7(TO_MKT_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_6(), IP_REP_INFO_BEAN.getREP_VALUE_7());
		COMP_TO_MKT_CODE.resetValue();
	}
	public void COMP_FM_AGENT_CODE_Validate(ActionEvent actionEvent){
		String FM_AGENT_CODE = null; 
		FM_AGENT_CODE = (String) getCOMP_FM_AGENT_CODE().getSubmittedValue();
		if(FM_AGENT_CODE==null || FM_AGENT_CODE.trim().isEmpty()){
			IP_REP_INFO_BEAN.setREP_VALUE_8(fromCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_8(FM_AGENT_CODE);
			IP_REP_INFO_BEAN.setREP_VALUE_9(FM_AGENT_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_8(), IP_REP_INFO_BEAN.getREP_VALUE_9());
		COMP_FM_AGENT_CODE.resetValue();
		COMP_TO_AGENT_CODE.resetValue();
	}
	public void COMP_TO_AGENT_CODE_Validate(ActionEvent actionEvent){
		String TO_AGENT_CODE = null; 
		TO_AGENT_CODE = (String) getCOMP_TO_AGENT_CODE().getSubmittedValue();
		if (TO_AGENT_CODE == null || TO_AGENT_CODE.trim().isEmpty()) {
			IP_REP_INFO_BEAN.setREP_VALUE_9(toCode);
		}else{
			IP_REP_INFO_BEAN.setREP_VALUE_9(TO_AGENT_CODE);			
		}
		L_VAL_FROM_TO(IP_REP_INFO_BEAN.getREP_VALUE_8(), IP_REP_INFO_BEAN.getREP_VALUE_9());
		COMP_TO_AGENT_CODE.resetValue();
	}
	
}
