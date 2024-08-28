package com.iii.pel.forms.PILP032_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FM_AGENT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FM_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_FM_AGENT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FM_AGENT_DESC;

	private HtmlOutputLabel COMP_UI_M_TO_AGENT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_TO_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_TO_AGENT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TO_AGENT_DESC;

	private HtmlOutputLabel COMP_UI_M_FM_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DATE;

	private HtmlOutputLabel COMP_UI_M_TO_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DATE;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DATE;

	private HtmlCommandButton COMP_UI_M_FM_AGENT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_TO_AGENT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_PROCESS;
	
	private ArrayList<DUMMY> suggestionList;

	private DUMMY DUMMY_BEAN;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		formInitialization();
		WHEN_CREATE_RECORD();
	}
	
	public void formInitialization()
	{
		System.out.println("FORM load values::::"+new CommonUtils().getGlobalObject("GLOBAL.M_PARAM_1"));
		String globalParam = (String)new CommonUtils().getGlobalObject("GLOBAL.M_PARAM_1");
		if("C".equalsIgnoreCase(globalParam))
		{
			DUMMY_BEAN.setLabelCaption(Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$LABEL$CAPTION$COMMISSION"));
		}else if("I".equalsIgnoreCase(globalParam))
		{
			DUMMY_BEAN.setLabelCaption(Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$LABEL$CAPTION$INTEREST"));
		}else if("B".equalsIgnoreCase(globalParam))
		{
			DUMMY_BEAN.setLabelCaption(Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$LABEL$CAPTION$BENEFIT"));
		}else if("Y".equalsIgnoreCase(globalParam))
		{
			DUMMY_BEAN.setLabelCaption(Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$LABEL$CAPTION$YEAREND"));
		}
		
	}
	
	public void WHEN_CREATE_RECORD()
	{
		DUMMY_ACTION_DELEGATE dummy_action_delegate = new DUMMY_ACTION_DELEGATE();
		int month = 0;
		int year = 0;
		Calendar cal = null;
		if("B".equals(new CommonUtils().getGlobalObject("GLOBAL.M_PARAM_1")))
		{
			 month = dummy_action_delegate.getMonth();
			 year = dummy_action_delegate.getYear();
		}
		cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		if("Y".equals(new CommonUtils().getGlobalObject("GLOBAL.M_PARAM_1")))
		{
			ArrayList<Date> outputList = dummy_action_delegate.getDates();
			if(outputList.size()>0)
			{
				DUMMY_BEAN.setUI_M_FM_DATE(outputList.get(0));
				DUMMY_BEAN.setUI_M_TO_DATE(outputList.get(1));
				DUMMY_BEAN.setUI_M_PROCESS_DATE(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			}
		}
	}
	

	public HtmlOutputLabel getCOMP_UI_M_FM_AGENT_CODE_LABEL() {
		return COMP_UI_M_FM_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FM_AGENT_CODE() {
		return COMP_UI_M_FM_AGENT_CODE;
	}

	public void setCOMP_UI_M_FM_AGENT_CODE_LABEL(HtmlOutputLabel COMP_UI_M_FM_AGENT_CODE_LABEL) {
		this.COMP_UI_M_FM_AGENT_CODE_LABEL = COMP_UI_M_FM_AGENT_CODE_LABEL;
	}

	public void setCOMP_UI_M_FM_AGENT_CODE(HtmlInputText COMP_UI_M_FM_AGENT_CODE) {
		this.COMP_UI_M_FM_AGENT_CODE = COMP_UI_M_FM_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_AGENT_DESC_LABEL() {
		return COMP_UI_M_FM_AGENT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FM_AGENT_DESC() {
		return COMP_UI_M_FM_AGENT_DESC;
	}

	public void setCOMP_UI_M_FM_AGENT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FM_AGENT_DESC_LABEL) {
		this.COMP_UI_M_FM_AGENT_DESC_LABEL = COMP_UI_M_FM_AGENT_DESC_LABEL;
	}

	public void setCOMP_UI_M_FM_AGENT_DESC(HtmlInputText COMP_UI_M_FM_AGENT_DESC) {
		this.COMP_UI_M_FM_AGENT_DESC = COMP_UI_M_FM_AGENT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_AGENT_CODE_LABEL() {
		return COMP_UI_M_TO_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TO_AGENT_CODE() {
		return COMP_UI_M_TO_AGENT_CODE;
	}

	public void setCOMP_UI_M_TO_AGENT_CODE_LABEL(HtmlOutputLabel COMP_UI_M_TO_AGENT_CODE_LABEL) {
		this.COMP_UI_M_TO_AGENT_CODE_LABEL = COMP_UI_M_TO_AGENT_CODE_LABEL;
	}

	public void setCOMP_UI_M_TO_AGENT_CODE(HtmlInputText COMP_UI_M_TO_AGENT_CODE) {
		this.COMP_UI_M_TO_AGENT_CODE = COMP_UI_M_TO_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_AGENT_DESC_LABEL() {
		return COMP_UI_M_TO_AGENT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TO_AGENT_DESC() {
		return COMP_UI_M_TO_AGENT_DESC;
	}

	public void setCOMP_UI_M_TO_AGENT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TO_AGENT_DESC_LABEL) {
		this.COMP_UI_M_TO_AGENT_DESC_LABEL = COMP_UI_M_TO_AGENT_DESC_LABEL;
	}

	public void setCOMP_UI_M_TO_AGENT_DESC(HtmlInputText COMP_UI_M_TO_AGENT_DESC) {
		this.COMP_UI_M_TO_AGENT_DESC = COMP_UI_M_TO_AGENT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_DATE_LABEL() {
		return COMP_UI_M_FM_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DATE() {
		return COMP_UI_M_FM_DATE;
	}

	public void setCOMP_UI_M_FM_DATE_LABEL(HtmlOutputLabel COMP_UI_M_FM_DATE_LABEL) {
		this.COMP_UI_M_FM_DATE_LABEL = COMP_UI_M_FM_DATE_LABEL;
	}

	public void setCOMP_UI_M_FM_DATE(HtmlCalendar COMP_UI_M_FM_DATE) {
		this.COMP_UI_M_FM_DATE = COMP_UI_M_FM_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DATE_LABEL() {
		return COMP_UI_M_TO_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DATE() {
		return COMP_UI_M_TO_DATE;
	}

	public void setCOMP_UI_M_TO_DATE_LABEL(HtmlOutputLabel COMP_UI_M_TO_DATE_LABEL) {
		this.COMP_UI_M_TO_DATE_LABEL = COMP_UI_M_TO_DATE_LABEL;
	}

	public void setCOMP_UI_M_TO_DATE(HtmlCalendar COMP_UI_M_TO_DATE) {
		this.COMP_UI_M_TO_DATE = COMP_UI_M_TO_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DATE_LABEL() {
		return COMP_UI_M_PROCESS_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DATE() {
		return COMP_UI_M_PROCESS_DATE;
	}

	public void setCOMP_UI_M_PROCESS_DATE_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_DATE_LABEL) {
		this.COMP_UI_M_PROCESS_DATE_LABEL = COMP_UI_M_PROCESS_DATE_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DATE(HtmlCalendar COMP_UI_M_PROCESS_DATE) {
		this.COMP_UI_M_PROCESS_DATE = COMP_UI_M_PROCESS_DATE;
	}

	public HtmlCommandButton getCOMP_UI_M_FM_AGENT_CODE_LOV() {
		return COMP_UI_M_FM_AGENT_CODE_LOV;
	}

	public void setCOMP_UI_M_FM_AGENT_CODE_LOV(HtmlCommandButton COMP_UI_M_FM_AGENT_CODE_LOV) {
		this.COMP_UI_M_FM_AGENT_CODE_LOV = COMP_UI_M_FM_AGENT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_TO_AGENT_CODE_LOV() {
		return COMP_UI_M_TO_AGENT_CODE_LOV;
	}

	public void setCOMP_UI_M_TO_AGENT_CODE_LOV(HtmlCommandButton COMP_UI_M_TO_AGENT_CODE_LOV) {
		this.COMP_UI_M_TO_AGENT_CODE_LOV = COMP_UI_M_TO_AGENT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_PROCESS() {
		return COMP_UI_M_PROCESS;
	}

	public void setCOMP_UI_M_PROCESS(HtmlCommandButton COMP_UI_M_PROCESS) {
		this.COMP_UI_M_PROCESS = COMP_UI_M_PROCESS;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public ArrayList<DUMMY> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(ArrayList<DUMMY> suggestionList) {
		this.suggestionList = suggestionList;
	}
	public ArrayList<DUMMY> FM_AGENT_SUGGESTION_LIST(Object event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		try {
			suggestionList=helper.m_fm_agent_code_key_listval(FacesContext.getCurrentInstance(), (String)event);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public void validateFM_AGENT_CODE(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		System.out.println("VALUE>>>>>>>"+input.getSubmittedValue());
		if("".equals(input.getSubmittedValue()))
		{
        	getDUMMY_BEAN().setUI_M_FM_AGENT_CODE("0");
        	getCOMP_UI_M_FM_AGENT_CODE().resetValue();
        }
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatorFM_AGENT_CODE(FacesContext context, UIComponent component, Object object)
	{
		String query = "SELECT 'X' " +
		" FROM PM_CUSTOMER" +
		" WHERE CUST_CLASS IN" +
		" (SELECT CCLAS_CODE" +
		" FROM PM_CUST_CLASS" +
		" WHERE CCLAS_TYPE IN ('002'))" +
		" AND CUST_FRZ_FLAG = 'N' AND CUST_CODE LIKE NVL(?, CUST_CODE) ";
		try{
			DUMMY_HELPER helper = new DUMMY_HELPER();
			if(object != null)
			{
				if(isExists(query,new Object[]{(String)object})){
					helper.pilp032_tisb_dummy_m_fm_agent_code_when_validate_item((String)object);
				}else{
	    			throw new Exception("Code does not exist");
	        }
			}
			}catch(Exception e){
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		
	}
	
	public void validateFM_DATE(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatorFM_DATE(FacesContext context, UIComponent component, Object object)
	{
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			Date fmDate=(Date)object;
			getDUMMY_BEAN().setUI_M_FM_DATE(fmDate);
			helper.pilp032_tisb_dummy_m_to_date_when_validate_item();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePROCESS_DATE(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatorPROCESS_DATE(FacesContext context, UIComponent component, Object object) throws ValidatorException
	{
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			Date date = (Date)object;
			helper.pilp032_tisb_dummy_m_process_date_when_validate_item(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTO_AGENT_CODE(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		if("".equals(input.getSubmittedValue()) && getDUMMY_BEAN().getUI_M_FM_AGENT_CODE().equals("0"))
		{
        	getDUMMY_BEAN().setUI_M_TO_AGENT_CODE("ZZZZZZ");
        	getCOMP_UI_M_TO_AGENT_CODE().resetValue();
        }else if("".equals(input.getSubmittedValue()) && getDUMMY_BEAN().getUI_M_FM_AGENT_CODE()!=null)
        {
        	getDUMMY_BEAN().setUI_M_TO_AGENT_CODE(getDUMMY_BEAN().getUI_M_FM_AGENT_CODE());
        	getCOMP_UI_M_TO_AGENT_CODE().resetValue();
        }
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatorTO_AGENT_CODE(FacesContext context, UIComponent component, Object object)
	{
		String query = "SELECT 'X' " +
		" FROM PM_CUSTOMER" +
		" WHERE CUST_CLASS IN" +
		" (SELECT CCLAS_CODE" +
		" FROM PM_CUST_CLASS" +
		" WHERE CCLAS_TYPE IN ('002'))" +
		" AND CUST_FRZ_FLAG = 'N' AND CUST_CODE LIKE NVL(?, CUST_CODE) ";
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			if(isExists(query,new Object[]{(String)object})){
			helper.pilp032_tisb_dummy_m_to_agent_code_when_validate_item();
			}else{
				throw new Exception("Code does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTO_DATE(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatorTO_DATE(FacesContext context, UIComponent component, Object object)
	{
		try {
			Date toDate=(Date)object;
			getDUMMY_BEAN().setUI_M_TO_DATE(toDate);
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.pilp032_tisb_dummy_m_to_date_when_validate_item();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	public String processButton() throws Exception 
	{
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.pilp032_tisb_dummy_m_process_when_button_pressed();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return null;
	}
	
	private Boolean isExists(String qry, Object[] values) {
		 Boolean exists = false;
		 Connection conn = null;
		 CRUDHandler handler = new CRUDHandler();
		 ResultSet resultSet = null;
		 try {
			conn = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(qry, conn, values);
			if (resultSet.next()) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return exists;
	}
}
