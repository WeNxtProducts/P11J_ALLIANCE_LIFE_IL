package com.iii.pel.forms.PT001_A_TISB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_APF_WITHDRAWL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_APW_AGENT_CODE_LABEL;

	private HtmlInputText COMP_APW_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_DESC;

	private HtmlOutputLabel COMP_APW_ACS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_APW_ACS_TYPE;

	private HtmlOutputLabel COMP_APW_REASON_CODE_LABEL;

	private HtmlInputText COMP_APW_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_DESC;

	private HtmlOutputLabel COMP_APW_REMARKS_LABEL;

	private HtmlInputText COMP_APW_REMARKS;

	private HtmlOutputLabel COMP_APW_WD_DT_LABEL;

	private HtmlCalendar COMP_APW_WD_DT;

	private HtmlOutputLabel COMP_APW_ACC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_APW_ACC_TYPE;

	private HtmlOutputLabel COMP_APW_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_APW_PROCESS_DT;

	private HtmlOutputLabel COMP_APW_DRCR_DOC_NO_LABEL;

	private HtmlInputText COMP_APW_DRCR_DOC_NO;

	private HtmlOutputLabel COMP_APW_APPRV_DT_LABEL;

	private HtmlCalendar COMP_APW_APPRV_DT;

	private HtmlOutputLabel COMP_APW_DRCR_TXN_CODE_LABEL;

	private HtmlInputText COMP_APW_DRCR_TXN_CODE;

	private HtmlOutputLabel COMP_APW_DRCR_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_APW_DRCR_ACNT_YEAR;

	private HtmlOutputLabel COMP_APW_DRCR_DOC_DT_LABEL;

	private HtmlCalendar COMP_APW_DRCR_DOC_DT;

	private HtmlOutputLabel COMP_UI_M_COMM;

	private HtmlOutputLabel COMP_UI_M_BENEFIT;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_APPRV;

	private PT_AGENT_APF_WITHDRAWL PT_AGENT_APF_WITHDRAWL_BEAN;
	
	private ArrayList<SelectItem> acsTypeList;
	
	private ArrayList<SelectItem> accTypeList;
	
	private List agentCodeList;
	
	private List reasonCodeList;

	public PT_AGENT_APF_WITHDRAWL_ACTION() {
		PT_AGENT_APF_WITHDRAWL_BEAN = new PT_AGENT_APF_WITHDRAWL();
		
		acsTypeList = new PT_AGENT_APF_WITHDRAWL_DELEGATE().selectValueForComboBox("APFCLMTYP");
		
		accTypeList = new PT_AGENT_APF_WITHDRAWL_DELEGATE().selectValueForComboBox("APFACCTTYP");
		
		
		WHEN_CREATE_RECORD(PT_AGENT_APF_WITHDRAWL_BEAN);
	}

	public HtmlOutputLabel getCOMP_APW_AGENT_CODE_LABEL() {
		return COMP_APW_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APW_AGENT_CODE() {
		return COMP_APW_AGENT_CODE;
	}

	public void setCOMP_APW_AGENT_CODE_LABEL(HtmlOutputLabel COMP_APW_AGENT_CODE_LABEL) {
		this.COMP_APW_AGENT_CODE_LABEL = COMP_APW_AGENT_CODE_LABEL;
	}

	public void setCOMP_APW_AGENT_CODE(HtmlInputText COMP_APW_AGENT_CODE) {
		this.COMP_APW_AGENT_CODE = COMP_APW_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_DESC_LABEL() {
		return COMP_UI_M_AGENT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_DESC() {
		return COMP_UI_M_AGENT_DESC;
	}

	public void setCOMP_UI_M_AGENT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_DESC_LABEL) {
		this.COMP_UI_M_AGENT_DESC_LABEL = COMP_UI_M_AGENT_DESC_LABEL;
	}

	public void setCOMP_UI_M_AGENT_DESC(HtmlInputText COMP_UI_M_AGENT_DESC) {
		this.COMP_UI_M_AGENT_DESC = COMP_UI_M_AGENT_DESC;
	}

	public HtmlOutputLabel getCOMP_APW_ACS_TYPE_LABEL() {
		return COMP_APW_ACS_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APW_ACS_TYPE() {
		return COMP_APW_ACS_TYPE;
	}

	public void setCOMP_APW_ACS_TYPE_LABEL(HtmlOutputLabel COMP_APW_ACS_TYPE_LABEL) {
		this.COMP_APW_ACS_TYPE_LABEL = COMP_APW_ACS_TYPE_LABEL;
	}

	public void setCOMP_APW_ACS_TYPE(HtmlSelectOneMenu COMP_APW_ACS_TYPE) {
		this.COMP_APW_ACS_TYPE = COMP_APW_ACS_TYPE;
	}

	public HtmlOutputLabel getCOMP_APW_REASON_CODE_LABEL() {
		return COMP_APW_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APW_REASON_CODE() {
		return COMP_APW_REASON_CODE;
	}

	public void setCOMP_APW_REASON_CODE_LABEL(HtmlOutputLabel COMP_APW_REASON_CODE_LABEL) {
		this.COMP_APW_REASON_CODE_LABEL = COMP_APW_REASON_CODE_LABEL;
	}

	public void setCOMP_APW_REASON_CODE(HtmlInputText COMP_APW_REASON_CODE) {
		this.COMP_APW_REASON_CODE = COMP_APW_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_DESC_LABEL() {
		return COMP_UI_M_REASON_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_DESC() {
		return COMP_UI_M_REASON_DESC;
	}

	public void setCOMP_UI_M_REASON_DESC_LABEL(HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL) {
		this.COMP_UI_M_REASON_DESC_LABEL = COMP_UI_M_REASON_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_DESC(HtmlInputText COMP_UI_M_REASON_DESC) {
		this.COMP_UI_M_REASON_DESC = COMP_UI_M_REASON_DESC;
	}

	public HtmlOutputLabel getCOMP_APW_REMARKS_LABEL() {
		return COMP_APW_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_APW_REMARKS() {
		return COMP_APW_REMARKS;
	}

	public void setCOMP_APW_REMARKS_LABEL(HtmlOutputLabel COMP_APW_REMARKS_LABEL) {
		this.COMP_APW_REMARKS_LABEL = COMP_APW_REMARKS_LABEL;
	}

	public void setCOMP_APW_REMARKS(HtmlInputText COMP_APW_REMARKS) {
		this.COMP_APW_REMARKS = COMP_APW_REMARKS;
	}

	public HtmlOutputLabel getCOMP_APW_WD_DT_LABEL() {
		return COMP_APW_WD_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APW_WD_DT() {
		return COMP_APW_WD_DT;
	}

	public void setCOMP_APW_WD_DT_LABEL(HtmlOutputLabel COMP_APW_WD_DT_LABEL) {
		this.COMP_APW_WD_DT_LABEL = COMP_APW_WD_DT_LABEL;
	}

	public void setCOMP_APW_WD_DT(HtmlCalendar COMP_APW_WD_DT) {
		this.COMP_APW_WD_DT = COMP_APW_WD_DT;
	}

	public HtmlOutputLabel getCOMP_APW_ACC_TYPE_LABEL() {
		return COMP_APW_ACC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APW_ACC_TYPE() {
		return COMP_APW_ACC_TYPE;
	}

	public void setCOMP_APW_ACC_TYPE_LABEL(HtmlOutputLabel COMP_APW_ACC_TYPE_LABEL) {
		this.COMP_APW_ACC_TYPE_LABEL = COMP_APW_ACC_TYPE_LABEL;
	}

	public void setCOMP_APW_ACC_TYPE(HtmlSelectOneMenu COMP_APW_ACC_TYPE) {
		this.COMP_APW_ACC_TYPE = COMP_APW_ACC_TYPE;
	}

	public HtmlOutputLabel getCOMP_APW_PROCESS_DT_LABEL() {
		return COMP_APW_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APW_PROCESS_DT() {
		return COMP_APW_PROCESS_DT;
	}

	public void setCOMP_APW_PROCESS_DT_LABEL(HtmlOutputLabel COMP_APW_PROCESS_DT_LABEL) {
		this.COMP_APW_PROCESS_DT_LABEL = COMP_APW_PROCESS_DT_LABEL;
	}

	public void setCOMP_APW_PROCESS_DT(HtmlCalendar COMP_APW_PROCESS_DT) {
		this.COMP_APW_PROCESS_DT = COMP_APW_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_APW_DRCR_DOC_NO_LABEL() {
		return COMP_APW_DRCR_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_APW_DRCR_DOC_NO() {
		return COMP_APW_DRCR_DOC_NO;
	}

	public void setCOMP_APW_DRCR_DOC_NO_LABEL(HtmlOutputLabel COMP_APW_DRCR_DOC_NO_LABEL) {
		this.COMP_APW_DRCR_DOC_NO_LABEL = COMP_APW_DRCR_DOC_NO_LABEL;
	}

	public void setCOMP_APW_DRCR_DOC_NO(HtmlInputText COMP_APW_DRCR_DOC_NO) {
		this.COMP_APW_DRCR_DOC_NO = COMP_APW_DRCR_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_APW_APPRV_DT_LABEL() {
		return COMP_APW_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APW_APPRV_DT() {
		return COMP_APW_APPRV_DT;
	}

	public void setCOMP_APW_APPRV_DT_LABEL(HtmlOutputLabel COMP_APW_APPRV_DT_LABEL) {
		this.COMP_APW_APPRV_DT_LABEL = COMP_APW_APPRV_DT_LABEL;
	}

	public void setCOMP_APW_APPRV_DT(HtmlCalendar COMP_APW_APPRV_DT) {
		this.COMP_APW_APPRV_DT = COMP_APW_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_APW_DRCR_TXN_CODE_LABEL() {
		return COMP_APW_DRCR_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APW_DRCR_TXN_CODE() {
		return COMP_APW_DRCR_TXN_CODE;
	}

	public void setCOMP_APW_DRCR_TXN_CODE_LABEL(HtmlOutputLabel COMP_APW_DRCR_TXN_CODE_LABEL) {
		this.COMP_APW_DRCR_TXN_CODE_LABEL = COMP_APW_DRCR_TXN_CODE_LABEL;
	}

	public void setCOMP_APW_DRCR_TXN_CODE(HtmlInputText COMP_APW_DRCR_TXN_CODE) {
		this.COMP_APW_DRCR_TXN_CODE = COMP_APW_DRCR_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_APW_DRCR_ACNT_YEAR_LABEL() {
		return COMP_APW_DRCR_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_APW_DRCR_ACNT_YEAR() {
		return COMP_APW_DRCR_ACNT_YEAR;
	}

	public void setCOMP_APW_DRCR_ACNT_YEAR_LABEL(HtmlOutputLabel COMP_APW_DRCR_ACNT_YEAR_LABEL) {
		this.COMP_APW_DRCR_ACNT_YEAR_LABEL = COMP_APW_DRCR_ACNT_YEAR_LABEL;
	}

	public void setCOMP_APW_DRCR_ACNT_YEAR(HtmlInputText COMP_APW_DRCR_ACNT_YEAR) {
		this.COMP_APW_DRCR_ACNT_YEAR = COMP_APW_DRCR_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_APW_DRCR_DOC_DT_LABEL() {
		return COMP_APW_DRCR_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APW_DRCR_DOC_DT() {
		return COMP_APW_DRCR_DOC_DT;
	}

	public void setCOMP_APW_DRCR_DOC_DT_LABEL(HtmlOutputLabel COMP_APW_DRCR_DOC_DT_LABEL) {
		this.COMP_APW_DRCR_DOC_DT_LABEL = COMP_APW_DRCR_DOC_DT_LABEL;
	}

	public void setCOMP_APW_DRCR_DOC_DT(HtmlCalendar COMP_APW_DRCR_DOC_DT) {
		this.COMP_APW_DRCR_DOC_DT = COMP_APW_DRCR_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_COMM() {
		return COMP_UI_M_COMM;
	}

	public void setCOMP_UI_M_COMM(HtmlOutputLabel COMP_UI_M_COMM) {
		this.COMP_UI_M_COMM = COMP_UI_M_COMM;
	}

	public HtmlOutputLabel getCOMP_UI_M_BENEFIT() {
		return COMP_UI_M_BENEFIT;
	}

	public void setCOMP_UI_M_BENEFIT(HtmlOutputLabel COMP_UI_M_BENEFIT) {
		this.COMP_UI_M_BENEFIT = COMP_UI_M_BENEFIT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPRV() {
		return COMP_UI_M_BUT_APPRV;
	}

	public void setCOMP_UI_M_BUT_APPRV(HtmlCommandButton COMP_UI_M_BUT_APPRV) {
		this.COMP_UI_M_BUT_APPRV = COMP_UI_M_BUT_APPRV;
	}

	public PT_AGENT_APF_WITHDRAWL getPT_AGENT_APF_WITHDRAWL_BEAN() {
		return PT_AGENT_APF_WITHDRAWL_BEAN;
	}

	public void setPT_AGENT_APF_WITHDRAWL_BEAN(PT_AGENT_APF_WITHDRAWL PT_AGENT_APF_WITHDRAWL_BEAN) {
		this.PT_AGENT_APF_WITHDRAWL_BEAN = PT_AGENT_APF_WITHDRAWL_BEAN;
	}

	public ArrayList<SelectItem> getAcsTypeList() {
		return acsTypeList;
	}

	public void setAcsTypeList(ArrayList<SelectItem> acsTypeList) {
		this.acsTypeList = acsTypeList;
	}

	public ArrayList<SelectItem> getAccTypeList() {
		return accTypeList;
	}

	public void setAccTypeList(ArrayList<SelectItem> accTypeList) {
		this.accTypeList = accTypeList;
	}
	
	
	public List suggestionActionAgentCode(Object event)
	{
		String agentCode=(String)event;
		agentCodeList=new PT_AGENT_APF_WITHDRAWL_DELEGATE().suggestionActionAgentCode(agentCode,agentCodeList);
		return agentCodeList;
	}

	
	public void getAgentDesc(ActionEvent event)
	{
		COMP_UI_M_AGENT_DESC.setSubmittedValue(null);
		if(COMP_APW_AGENT_CODE.getSubmittedValue()!=null)
		{
			String agentCode=(String)COMP_APW_AGENT_CODE.getSubmittedValue();
			Iterator iterator = agentCodeList.iterator();
			String agentDesc = null;
			while (iterator.hasNext()) {
				PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl = (PT_AGENT_APF_WITHDRAWL) iterator.next();
				if (agentCode.equalsIgnoreCase(pt_agent_apf_withdrawl.getAPW_AGENT_CODE())) {
					agentDesc = pt_agent_apf_withdrawl.getUI_M_AGENT_DESC();
				}
			}
			getPT_AGENT_APF_WITHDRAWL_BEAN().setUI_M_AGENT_DESC(agentDesc);
			COMP_UI_M_AGENT_DESC.resetValue();
		}
		
	}
	
	
	public List suggestionActionReasonCode(Object event)
	{
		String reasonCode=(String)event;
		reasonCodeList=new PT_AGENT_APF_WITHDRAWL_DELEGATE().suggestionActionReasonCode(reasonCode,reasonCodeList);
		return reasonCodeList;
	}

	
	public void getReasonDesc(ActionEvent event)
	{
		COMP_UI_M_REASON_DESC.setSubmittedValue(null);
		if(COMP_APW_REASON_CODE.getSubmittedValue()!=null)
		{
			String reasonCode=(String)COMP_APW_REASON_CODE.getSubmittedValue();
			Iterator iterator = reasonCodeList.iterator();
			String reasonDesc = null;
			while (iterator.hasNext()) {
				PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl = (PT_AGENT_APF_WITHDRAWL) iterator.next();
				if (reasonCode.equalsIgnoreCase(pt_agent_apf_withdrawl.getAPW_REASON_CODE())) {
					reasonDesc = pt_agent_apf_withdrawl.getUI_M_REASON_DESC();
				}
			}
			getPT_AGENT_APF_WITHDRAWL_BEAN().setUI_M_REASON_DESC(reasonDesc);
			COMP_UI_M_REASON_DESC.resetValue();
		}
		
	}

	public void fireFieldValidation(ActionEvent event)
	{
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validateAgentCode(FacesContext fc, UIComponent component, 
			Object value){
		try{
			if(value!=null){
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_AGENT_CODE((String)value);
				String DBVALUE = new PT_AGENT_APF_WITHDRAWL_DELEGATE().validateAgentCode((String)value);
				if(DBVALUE==null)
				{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91005"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validateReasonCode(FacesContext fc, UIComponent component, 
			Object value){
		try{
			if(value!=null){
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_REASON_CODE((String) value);
				String DBVALUE = new PT_AGENT_APF_WITHDRAWL_DELEGATE().validateReasonCode((String)value);
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void processButtonAction(ActionEvent	event)
	{
		getErrorMap().clear();
		getWarningMap().clear();
		String sysId = null;
		PT_AGENT_APF_WITHDRAWL_DELEGATE pt_agent_apf_withdrawl_delegate = new PT_AGENT_APF_WITHDRAWL_DELEGATE();
		CommonUtils commonUtils=new CommonUtils();
		try{
			if(getPT_AGENT_APF_WITHDRAWL_BEAN().getAPW_AGENT_CODE()!=null)
			{
				if(getPT_AGENT_APF_WITHDRAWL_BEAN().getROWID()==null)
				{
					sysId = pt_agent_apf_withdrawl_delegate.generateSysId();
					PRE_INSERT(getPT_AGENT_APF_WITHDRAWL_BEAN());
				}else{
					sysId = getPT_AGENT_APF_WITHDRAWL_BEAN().getAPW_SYS_ID();
					getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_UPD_DT(commonUtils.getCurrentDate());
					getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				}
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_SYS_ID(sysId);
				pt_agent_apf_withdrawl_delegate.insertWithdrawalDetails(getPT_AGENT_APF_WITHDRAWL_BEAN());
				new PT_AGENT_APF_WITHDRAWL_DELEGATE().INS_AGENT_PF_WITHDRAWL(sysId);
				CommonUtils.getConnection().commit();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Completed Successfully");
				getWarningMap().put("CURRENT", "Process Completed Successfully");
				PT_AGENT_APF_WITHDRAWL_DTL_ACTION pt_agent_apf_withdrawl_dtl_action = (PT_AGENT_APF_WITHDRAWL_DTL_ACTION)new CommonUtils().getMappedBeanFromSession("PT001_A_TISB_PT_AGENT_APF_WITHDRAWL_DTL_ACTION");
				if(pt_agent_apf_withdrawl_dtl_action==null){
					pt_agent_apf_withdrawl_dtl_action = new PT_AGENT_APF_WITHDRAWL_DTL_ACTION();
				}
				List<PT_AGENT_APF_WITHDRAWL_DTL> outputList = new PT_AGENT_APF_WITHDRAWL_DELEGATE().getAGENT_PF_WITHDRAWLDetails(sysId);
				if(outputList!=null && outputList.size()>0){
					pt_agent_apf_withdrawl_dtl_action.setDataList_PT_AGENT_APF_WITHDRAWL_DTL(outputList);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void approvalButtonAction(ActionEvent event)
	{
		getErrorMap().clear();
		getWarningMap().clear();
		String approvalMessage=null;
		try {
			new PT_AGENT_APF_WITHDRAWL_DELEGATE().INS_WITH_ACNT_ENTRIES(getPT_AGENT_APF_WITHDRAWL_BEAN().getAPW_SYS_ID());
			approvalMessage=Messages.getString("messageProperties_PT001_A_TISB", "PT001_A_TISB$APPROVAL_PROCESS__MESSAGE$SUCCESS");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, approvalMessage);
			getWarningMap().put("CURRENT", approvalMessage);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("CURRENT", e.getMessage());
			}	
	}
	
	public void PRE_INSERT(PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl)
	{
		pt_agent_apf_withdrawl.setAPW_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		pt_agent_apf_withdrawl.setAPW_CR_UID(new CommonUtils().getControlBean().getM_USER_ID());
	}
	
	
	public void WHEN_CREATE_RECORD(PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl)
	{
		pt_agent_apf_withdrawl.setAPW_ACC_TYPE("ACC001");
		pt_agent_apf_withdrawl.setAPW_ACS_TYPE("1");
	}
	
	public void validateWDDate(FacesContext fc, UIComponent component, 
			Object value) {
		try{
			if(value!=null){
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_WD_DT((Date)value);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateProcessDate(FacesContext fc, UIComponent component, 
			Object value){
		try{
			if(value!=null){
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_PROCESS_DT((Date)value);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateApprovalDate(FacesContext fc, UIComponent component, 
			Object value) {
		try{
			if(value!=null){
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_APPRV_DT((Date)value);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateDocumentDate(FacesContext fc, UIComponent component, 
			Object value){
		try{
			if(value!=null){
				getPT_AGENT_APF_WITHDRAWL_BEAN().setAPW_APPRV_DT((Date)value);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateDocNo(FacesContext context , UIComponent component ,Object value){
		Integer objValue = (Integer)value;
		try{
			if(objValue < 0 ){
				throw new Exception("Value can not be less then 0 ");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public List getAgentCodeList() {
		return agentCodeList;
	}

	public void setAgentCodeList(List agentCodeList) {
		this.agentCodeList = agentCodeList;
	}

	public List getReasonCodeList() {
		return reasonCodeList;
	}

	public void setReasonCodeList(List reasonCodeList) {
		this.reasonCodeList = reasonCodeList;
	}
}
