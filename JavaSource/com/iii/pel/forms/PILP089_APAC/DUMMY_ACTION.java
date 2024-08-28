package com.iii.pel.forms.PILP089_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_DECL_NO_LABEL;

	private HtmlInputText COMP_UI_M_DECL_NO;
	
	private HtmlInputText COMP_UI_M_PROD_CODE_FM;
	
	private HtmlInputText COMP_UI_M_PROD_CODE_TO;
	
	private HtmlInputText COMP_UI_M_POLICY_FM;
	
	private HtmlInputText COMP_UI_M_POLICY_TO;
	
	private HtmlSelectOneMenu COMP_UI_M_ACNT_YEAR_FM;
	
	private HtmlSelectOneMenu COMP_UI_M_ACNT_YEAR_TO;
	
	private HtmlCalendar COMP_UI_M_ACNT_FM_DATE_1;
	
	private HtmlCalendar COMP_UI_M_ACNT_TO_DATE_1;
	
	private HtmlCalendar COMP_UI_M_ACNT_FM_DATE_2;
	
	private HtmlCalendar COMP_UI_M_ACNT_TO_DATE_2;
	
	private HtmlOutputLabel COMP_UI_M_PROD_CODE_FM_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_PROD_CODE_TO_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_POLICY_FM_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_POLICY_TO_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_YEAR_FM_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_YEAR_TO_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_FM_DATE_1_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_TO_DATE_1_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_FM_DATE_2_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_TO_DATE_2_LABEL;
	
	private HtmlCommandButton COMP_UI_BUT_PROCESS;
	
	private HtmlCommandButton COMP_UI_BUT_OK;
	
	private HtmlCommandButton COMP_UI_BUT_CANCEL;
	
	private HtmlCommandButton COMP_UI_BUT_SELECTALL;
	
	private List<SelectItem> listUI_M_ACNT_YEAR_FM = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_ACNT_YEAR_TO = new ArrayList<SelectItem>();
	
	String DEFAULT_0 = "0";
	String DEFAULT_ZZ = "zzzzzzzzz";
	
	private DUMMY DUMMY_BEAN;

	public PILP089_APAC_COMPOSITE_ACTION compositeAction;
	
	private List<LovBean> suggestionList = null;

	private DUMMY_HELPER helper;

	private List<String> listPP_PROCESS_YN = new ArrayList<String>();

	public List<String> getListPP_PROCESS_YN() {
		return listPP_PROCESS_YN;
	}

	public void setListPP_PROCESS_YN(List<String> listPP_PROCESS_YN) {
		this.listPP_PROCESS_YN = listPP_PROCESS_YN;
	}

	public DUMMY_ACTION() {

		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
	}

	
	
	public HtmlOutputLabel getCOMP_UI_M_DECL_NO_LABEL() {
		return COMP_UI_M_DECL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DECL_NO() {
		return COMP_UI_M_DECL_NO;
	}

	public void setCOMP_UI_M_DECL_NO_LABEL(HtmlOutputLabel COMP_UI_M_DECL_NO_LABEL) {
		this.COMP_UI_M_DECL_NO_LABEL = COMP_UI_M_DECL_NO_LABEL;
	}

	public void setCOMP_UI_M_DECL_NO(HtmlInputText COMP_UI_M_DECL_NO) {
		this.COMP_UI_M_DECL_NO = COMP_UI_M_DECL_NO;
	}

	
	/*public void saveRecord() {
		try {
			if (getDUMMY1_BEAN().getROWID() != null) {
				
			}
		}catch(Exception exception){
		}*/


	/**
	 * @return the dUMMY_BEAN
	 */
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	/**
	 * @param dummy_bean the dUMMY_BEAN to set
	 */
	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * @return the cOMP_UI_M_PROD_CODE_FM
	 */
	public HtmlInputText getCOMP_UI_M_PROD_CODE_FM() {
		return COMP_UI_M_PROD_CODE_FM;
	}

	/**
	 * @param comp_ui_m_prod_code_fm the cOMP_UI_M_PROD_CODE_FM to set
	 */
	public void setCOMP_UI_M_PROD_CODE_FM(HtmlInputText comp_ui_m_prod_code_fm) {
		COMP_UI_M_PROD_CODE_FM = comp_ui_m_prod_code_fm;
	}

	/**
	 * @return the cOMP_UI_M_PROD_CODE_TO
	 */
	public HtmlInputText getCOMP_UI_M_PROD_CODE_TO() {
		return COMP_UI_M_PROD_CODE_TO;
	}

	/**
	 * @param comp_ui_m_prod_code_to the cOMP_UI_M_PROD_CODE_TO to set
	 */
	public void setCOMP_UI_M_PROD_CODE_TO(HtmlInputText comp_ui_m_prod_code_to) {
		COMP_UI_M_PROD_CODE_TO = comp_ui_m_prod_code_to;
	}

	/**
	 * @return the cOMP_UI_M_POLICY_FM
	 */
	public HtmlInputText getCOMP_UI_M_POLICY_FM() {
		return COMP_UI_M_POLICY_FM;
	}

	/**
	 * @param comp_ui_m_policy_fm the cOMP_UI_M_POLICY_FM to set
	 */
	public void setCOMP_UI_M_POLICY_FM(HtmlInputText comp_ui_m_policy_fm) {
		COMP_UI_M_POLICY_FM = comp_ui_m_policy_fm;
	}

	/**
	 * @return the cOMP_UI_M_POLICY_TO
	 */
	public HtmlInputText getCOMP_UI_M_POLICY_TO() {
		return COMP_UI_M_POLICY_TO;
	}

	/**
	 * @param comp_ui_m_policy_to the cOMP_UI_M_POLICY_TO to set
	 */
	public void setCOMP_UI_M_POLICY_TO(HtmlInputText comp_ui_m_policy_to) {
		COMP_UI_M_POLICY_TO = comp_ui_m_policy_to;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_YEAR_FM
	 */
	

	/**
	 * @param comp_ui_m_acnt_year_fm the cOMP_UI_M_ACNT_YEAR_FM to set
	 */
	

	public HtmlCalendar getCOMP_UI_M_ACNT_FM_DATE_1() {
		return COMP_UI_M_ACNT_FM_DATE_1;
	}

	public void setCOMP_UI_M_ACNT_FM_DATE_1(HtmlCalendar comp_ui_m_acnt_fm_date_1) {
		COMP_UI_M_ACNT_FM_DATE_1 = comp_ui_m_acnt_fm_date_1;
	}

	public HtmlCalendar getCOMP_UI_M_ACNT_TO_DATE_1() {
		return COMP_UI_M_ACNT_TO_DATE_1;
	}

	public void setCOMP_UI_M_ACNT_TO_DATE_1(HtmlCalendar comp_ui_m_acnt_to_date_1) {
		COMP_UI_M_ACNT_TO_DATE_1 = comp_ui_m_acnt_to_date_1;
	}

	public HtmlCalendar getCOMP_UI_M_ACNT_FM_DATE_2() {
		return COMP_UI_M_ACNT_FM_DATE_2;
	}

	public void setCOMP_UI_M_ACNT_FM_DATE_2(HtmlCalendar comp_ui_m_acnt_fm_date_2) {
		COMP_UI_M_ACNT_FM_DATE_2 = comp_ui_m_acnt_fm_date_2;
	}

	public HtmlCalendar getCOMP_UI_M_ACNT_TO_DATE_2() {
		return COMP_UI_M_ACNT_TO_DATE_2;
	}

	public void setCOMP_UI_M_ACNT_TO_DATE_2(HtmlCalendar comp_ui_m_acnt_to_date_2) {
		COMP_UI_M_ACNT_TO_DATE_2 = comp_ui_m_acnt_to_date_2;
	}

	public HtmlCommandButton getCOMP_UI_BUT_SELECTALL() {
		return COMP_UI_BUT_SELECTALL;
	}

	public void setCOMP_UI_BUT_SELECTALL(HtmlCommandButton comp_ui_but_selectall) {
		COMP_UI_BUT_SELECTALL = comp_ui_but_selectall;
	}

	public String getDEFAULT_0() {
		return DEFAULT_0;
	}

	public void setDEFAULT_0(String default_0) {
		DEFAULT_0 = default_0;
	}

	public String getDEFAULT_ZZ() {
		return DEFAULT_ZZ;
	}

	public void setDEFAULT_ZZ(String default_zz) {
		DEFAULT_ZZ = default_zz;
	}

	public List<LovBean> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<LovBean> suggestionList) {
		this.suggestionList = suggestionList;
	}


	/**
	 * @return the helper
	 */
	public DUMMY_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the cOMP_UI_M_PROD_CODE_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_FM_LABEL() {
		return COMP_UI_M_PROD_CODE_FM_LABEL;
	}

	/**
	 * @param comp_ui_m_prod_code_fm_label the cOMP_UI_M_PROD_CODE_FM_LABEL to set
	 */
	public void setCOMP_UI_M_PROD_CODE_FM_LABEL(
			HtmlOutputLabel comp_ui_m_prod_code_fm_label) {
		COMP_UI_M_PROD_CODE_FM_LABEL = comp_ui_m_prod_code_fm_label;
	}

	/**
	 * @return the cOMP_UI_M_PROD_CODE_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_TO_LABEL() {
		return COMP_UI_M_PROD_CODE_TO_LABEL;
	}

	/**
	 * @param comp_ui_m_prod_code_to_label the cOMP_UI_M_PROD_CODE_TO_LABEL to set
	 */
	public void setCOMP_UI_M_PROD_CODE_TO_LABEL(
			HtmlOutputLabel comp_ui_m_prod_code_to_label) {
		COMP_UI_M_PROD_CODE_TO_LABEL = comp_ui_m_prod_code_to_label;
	}

	/**
	 * @return the cOMP_UI_M_POLICY_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_POLICY_FM_LABEL() {
		return COMP_UI_M_POLICY_FM_LABEL;
	}

	/**
	 * @param comp_ui_m_policy_fm_label the cOMP_UI_M_POLICY_FM_LABEL to set
	 */
	public void setCOMP_UI_M_POLICY_FM_LABEL(
			HtmlOutputLabel comp_ui_m_policy_fm_label) {
		COMP_UI_M_POLICY_FM_LABEL = comp_ui_m_policy_fm_label;
	}

	/**
	 * @return the cOMP_UI_M_POLICY_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_POLICY_TO_LABEL() {
		return COMP_UI_M_POLICY_TO_LABEL;
	}

	/**
	 * @param comp_ui_m_policy_to_label the cOMP_UI_M_POLICY_TO_LABEL to set
	 */
	public void setCOMP_UI_M_POLICY_TO_LABEL(
			HtmlOutputLabel comp_ui_m_policy_to_label) {
		COMP_UI_M_POLICY_TO_LABEL = comp_ui_m_policy_to_label;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_YEAR_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ACNT_YEAR_FM_LABEL() {
		return COMP_UI_M_ACNT_YEAR_FM_LABEL;
	}

	/**
	 * @param comp_ui_m_acnt_year_fm_label the cOMP_UI_M_ACNT_YEAR_FM_LABEL to set
	 */
	public void setCOMP_UI_M_ACNT_YEAR_FM_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_year_fm_label) {
		COMP_UI_M_ACNT_YEAR_FM_LABEL = comp_ui_m_acnt_year_fm_label;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_YEAR_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ACNT_YEAR_TO_LABEL() {
		return COMP_UI_M_ACNT_YEAR_TO_LABEL;
	}

	/**
	 * @param comp_ui_m_acnt_year_to_label the cOMP_UI_M_ACNT_YEAR_TO_LABEL to set
	 */
	public void setCOMP_UI_M_ACNT_YEAR_TO_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_year_to_label) {
		COMP_UI_M_ACNT_YEAR_TO_LABEL = comp_ui_m_acnt_year_to_label;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_FM_DATE_1_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ACNT_FM_DATE_1_LABEL() {
		return COMP_UI_M_ACNT_FM_DATE_1_LABEL;
	}

	/**
	 * @param comp_ui_m_acnt_fm_date_1_label the cOMP_UI_M_ACNT_FM_DATE_1_LABEL to set
	 */
	public void setCOMP_UI_M_ACNT_FM_DATE_1_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_fm_date_1_label) {
		COMP_UI_M_ACNT_FM_DATE_1_LABEL = comp_ui_m_acnt_fm_date_1_label;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_TO_DATE_1_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ACNT_TO_DATE_1_LABEL() {
		return COMP_UI_M_ACNT_TO_DATE_1_LABEL;
	}

	/**
	 * @param comp_ui_m_acnt_to_date_1_label the cOMP_UI_M_ACNT_TO_DATE_1_LABEL to set
	 */
	public void setCOMP_UI_M_ACNT_TO_DATE_1_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_to_date_1_label) {
		COMP_UI_M_ACNT_TO_DATE_1_LABEL = comp_ui_m_acnt_to_date_1_label;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_FM_DATE_2_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ACNT_FM_DATE_2_LABEL() {
		return COMP_UI_M_ACNT_FM_DATE_2_LABEL;
	}

	/**
	 * @param comp_ui_m_acnt_fm_date_2_label the cOMP_UI_M_ACNT_FM_DATE_2_LABEL to set
	 */
	public void setCOMP_UI_M_ACNT_FM_DATE_2_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_fm_date_2_label) {
		COMP_UI_M_ACNT_FM_DATE_2_LABEL = comp_ui_m_acnt_fm_date_2_label;
	}

	/**
	 * @return the cOMP_UI_M_ACNT_TO_DATE_2_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_ACNT_TO_DATE_2_LABEL() {
		return COMP_UI_M_ACNT_TO_DATE_2_LABEL;
	}

	/**
	 * @param comp_ui_m_acnt_to_date_2_label the cOMP_UI_M_ACNT_TO_DATE_2_LABEL to set
	 */
	public void setCOMP_UI_M_ACNT_TO_DATE_2_LABEL(
			HtmlOutputLabel comp_ui_m_acnt_to_date_2_label) {
		COMP_UI_M_ACNT_TO_DATE_2_LABEL = comp_ui_m_acnt_to_date_2_label;
	}

	/**
	 * @return the cOMP_UI_BUT_PROCESS
	 */
	public HtmlCommandButton getCOMP_UI_BUT_PROCESS() {
		return COMP_UI_BUT_PROCESS;
	}

	/**
	 * @param comp_ui_but_process the cOMP_UI_BUT_PROCESS to set
	 */
	public void setCOMP_UI_BUT_PROCESS(HtmlCommandButton comp_ui_but_process) {
		COMP_UI_BUT_PROCESS = comp_ui_but_process;
	}

	/**
	 * @return the cOMP_UI_BUT_OK
	 */
	public HtmlCommandButton getCOMP_UI_BUT_OK() {
		return COMP_UI_BUT_OK;
	}

	/**
	 * @param comp_ui_but_ok the cOMP_UI_BUT_OK to set
	 */
	public void setCOMP_UI_BUT_OK(HtmlCommandButton comp_ui_but_ok) {
		COMP_UI_BUT_OK = comp_ui_but_ok;
	}

	/**
	 * @return the cOMP_UI_BUT_CANCEL
	 */
	public HtmlCommandButton getCOMP_UI_BUT_CANCEL() {
		return COMP_UI_BUT_CANCEL;
	}

	/**
	 * @param comp_ui_but_cancel the cOMP_UI_BUT_CANCEL to set
	 */
	public void setCOMP_UI_BUT_CANCEL(HtmlCommandButton comp_ui_but_cancel) {
		COMP_UI_BUT_CANCEL = comp_ui_but_cancel;
	}
	
	public void onLoad(PhaseEvent event) {
		compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN().dropDownMethod();
		populate_Acnt_year();
		try {
			whenNewBlockInstance();
		}catch(Exception exception){
			}
		
	}
	
	public void whenNewBlockInstance(){
		try{
			DUMMY_BEAN.setUI_M_PROCESS_DT(new CommonUtils().getCurrentDate());
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	/**
	 * The common method cannot be used because the query has to split and pass
	 * the in parameter value.
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> productCodeFromSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILP089_APAC", "DUMMY",
					"M_PROD_CODE_FM", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	public void productCodeFrom_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue!=null && inputValue.isEmpty()){
			COMP_UI_M_PROD_CODE_FM.setSubmittedValue(DEFAULT_0);
			DUMMY_BEAN.setUI_M_PROD_CODE_FM(DEFAULT_0);
		}else{
			COMP_UI_M_PROD_CODE_FM.setSubmittedValue(inputValue);
			DUMMY_BEAN.setUI_M_PROD_CODE_FM(inputValue);
		}
	}
	
	/**
	 * The common method cannot be used because the query has to split and pass
	 * the in parameter value.
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> productToSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILP089_APAC", "DUMMY",
					"M_PROD_CODE_TO", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	public void productCodeTo_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue!=null && inputValue.isEmpty()){
			COMP_UI_M_PROD_CODE_TO.setSubmittedValue(DEFAULT_ZZ);
			DUMMY_BEAN.setUI_M_PROD_CODE_TO(DEFAULT_ZZ);
		}else{
			COMP_UI_M_PROD_CODE_TO.setSubmittedValue(inputValue);
			DUMMY_BEAN.setUI_M_PROD_CODE_TO(inputValue);
		}
	}
	
	/**
	 * The common method cannot be used because the query has to split and pass
	 * the in parameter value.
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> policyFromSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILP089_APAC", "DUMMY",
					"M_POLICY_FM", CommonUtils.nvl(DUMMY_BEAN.getUI_M_PROD_CODE_FM(), "0"), 
					CommonUtils.nvl(DUMMY_BEAN.getUI_M_PROD_CODE_TO(), "zzzzzzzzzzzzzzzzzzzzzz"), null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	/**
	 * The common method cannot be used because the query has to split and pass
	 * the in parameter value.
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> policyToSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = new ArrayList<LovBean>();
			suggestionList = itemUtil.P_CALL_LOV("PILP089_APAC", "DUMMY",
					"M_POLICY_TO", DUMMY_BEAN.getUI_M_PROD_CODE_FM(), DUMMY_BEAN.getUI_M_PROD_CODE_TO(),
					 null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public void actionListenerM_POLICY_FM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue.isEmpty()){
			COMP_UI_M_POLICY_FM.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
			DUMMY_BEAN.setUI_M_POLICY_FM(PELConstants.PROCESS_FROMVALUE);
		}
		else{
			DUMMY_BEAN.setUI_M_POLICY_FM(inputValue);
		}
		COMP_UI_M_POLICY_FM.resetValue();
	}
	
	public void actionListenerM_POLICY_TO(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		if(inputTextString.isEmpty())
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(DUMMY_BEAN.getUI_M_POLICY_FM()))
			{
				COMP_UI_M_POLICY_TO.setSubmittedValue(DUMMY_BEAN.getUI_M_POLICY_FM());
				DUMMY_BEAN.setUI_M_POLICY_TO(DUMMY_BEAN.getUI_M_POLICY_FM());
			}else{
				COMP_UI_M_POLICY_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				DUMMY_BEAN.setUI_M_POLICY_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			DUMMY_BEAN.setUI_M_POLICY_TO(inputTextString);
		}
	}
	
	public void actionListenerM_PROD_CODE_FM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue.isEmpty()){
			COMP_UI_M_PROD_CODE_FM.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
			DUMMY_BEAN.setUI_M_PROD_CODE_FM(PELConstants.PROCESS_FROMVALUE);
		}
		else{
			DUMMY_BEAN.setUI_M_PROD_CODE_FM(inputValue);
		}
		COMP_UI_M_PROD_CODE_FM.resetValue();
	}
	
	public void actionListenerM_PROD_CODE_TO(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		if(inputTextString.isEmpty())
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(DUMMY_BEAN.getUI_M_PROD_CODE_FM()))
			{
				COMP_UI_M_PROD_CODE_TO.setSubmittedValue(DUMMY_BEAN.getUI_M_PROD_CODE_FM());
				DUMMY_BEAN.setUI_M_PROD_CODE_TO(DUMMY_BEAN.getUI_M_PROD_CODE_FM());
			}else{
				COMP_UI_M_PROD_CODE_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				DUMMY_BEAN.setUI_M_PROD_CODE_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			DUMMY_BEAN.setUI_M_PROD_CODE_TO(inputTextString);
		}
	}
	/**
	 * 
	 * @param actionEvent
	 */
	public void policyFrom_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue!=null && inputValue.isEmpty()){
			COMP_UI_M_POLICY_FM.setSubmittedValue(DEFAULT_0);
			DUMMY_BEAN.setUI_M_POLICY_FM(DEFAULT_0);
		}else{
			COMP_UI_M_POLICY_FM.setSubmittedValue(inputValue);
			DUMMY_BEAN.setUI_M_POLICY_FM(inputValue);
		}
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	public void policyTo_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue!=null && inputValue.isEmpty()){
			COMP_UI_M_POLICY_TO.setSubmittedValue(DEFAULT_ZZ);
			DUMMY_BEAN.setUI_M_POLICY_TO(DEFAULT_ZZ);
		}else{
			COMP_UI_M_POLICY_TO.setSubmittedValue(inputValue);
			DUMMY_BEAN.setUI_M_POLICY_TO(inputValue);
		}
	}
	public void actionListenerM_ACNT_YEAR_FM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		try{
		if(inputValue == null ||"".equals(inputValue)){
			//COMP_UI_M_ACNT_YEAR_FM.setSubmittedValue(0);
			DUMMY_BEAN.setUI_M_ACNT_YEAR_FM(0);
		}
		else{
			DUMMY_BEAN.setUI_M_ACNT_YEAR_FM(Integer.valueOf(inputValue));
		}
		//COMP_UI_M_ACNT_YEAR_FM.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void validate_M_ACNT_YEAR_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			DUMMY_BEAN.setUI_M_ACNT_YEAR_FM((Integer) value);
			helper.when_validate_item_M_ACNT_YEAR_FM(DUMMY_BEAN);
			COMP_UI_M_ACNT_FM_DATE_1.resetValue();
			COMP_UI_M_ACNT_TO_DATE_1.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void actionListenerM_ACNT_YEAR_TO(ActionEvent actionEvent)
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		try{
		if(inputValue == null ||"".equals(inputValue)){
			COMP_UI_M_ACNT_YEAR_TO.setSubmittedValue(99);
			DUMMY_BEAN.setUI_M_ACNT_YEAR_TO(99);
		}
		else{
			DUMMY_BEAN.setUI_M_ACNT_YEAR_TO(Integer.valueOf(inputValue));
		}
		COMP_UI_M_ACNT_YEAR_TO.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void validate_M_ACNT_YEAR_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			DUMMY_BEAN.setUI_M_ACNT_YEAR_TO((Integer) value);
			helper.when_validate_item_M_ACNT_YEAR_TO(DUMMY_BEAN);
			COMP_UI_M_ACNT_FM_DATE_2.resetValue();
			COMP_UI_M_ACNT_TO_DATE_2.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	/**
	 * 
	 */
	public void processButtonPress(){
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler =null;
		String deleteQuery = "DELETE FROM pw_il_pa_profit";
		
		String C1 = "select POL_NO,POL_PROD_CODE,POL_END_NO,POL_SYS_ID,POL_PLAN_CODE,POL_APPRV_DT "+
		 "from pt_il_policy p "+
		 "where POL_NO BETWEEN NVL(?,'0') AND NVL (?,'zzzzzzzzzzzz') "+
	     "AND POL_PROD_CODE BETWEEN NVL(?,'0') AND NVL(?,'zzzzzzzzzzzz') "+
	     "AND NVL (pol_status, 'N') IN ('A', 'E') "+
	     "AND NVL (pol_apprv_status, 'N') = 'A' "+
	     "AND POL_DS_TYPE = 2  "+
	     "AND NOT EXISTS(SELECT 'X' "+
	                     " FROM PM_IL_PLAN "+
	                     "WHERE PLAN_CODE = P.POL_PLAN_CODE "+
	                      " AND PLAN_TYPE = 'U') "+
	     "AND TRUNC(POL_APPRV_DT)<=TRUNC(?)";
		
		String M_POL_NO=null;
		String M_POL_PROD_CODE=null;
		String M_POL_END_NO=null;
		Long M_POL_SYS_ID;
		String M_POL_PLAN_CODE=null;
		Date M_POL_APPRV_DT=null;
		
		String insertQuery = " INSERT INTO pw_il_pa_profit(PP_POL_NO, "+
                               "PP_POL_PROD_CODE, "+
                               "PP_POL_END_NO, "+
                               "PP_POL_SYS_ID, "+
		                        "PP_POL_PLAN_CODE, "+  
                                "PP_POL_APPRV_DT, "+
		                        " PP_PROCESS_YN) "+
		                     "VALUES(?,  ?, ?, ?, ?, ?, 'N')";
		
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			Object[] object = new Object[]{DUMMY_BEAN.getUI_M_POLICY_FM(),
										 DUMMY_BEAN.getUI_M_POLICY_TO(),
										 DUMMY_BEAN.getUI_M_PROD_CODE_FM(),
										 DUMMY_BEAN.getUI_M_PROD_CODE_TO(),
										 new CommonUtils().getCurrentDate()};
			int i = handler.executeDeleteStatement(deleteQuery, connection);
			System.out.println("i=====================>"+i);
			resultSet = handler.executeSelectStatement(C1, connection,object);
			while(resultSet.next()){
				M_POL_NO = resultSet.getString(1);
				M_POL_PROD_CODE = resultSet.getString(2);
				M_POL_END_NO = resultSet.getString(3);
				M_POL_SYS_ID = resultSet.getLong(4);
				M_POL_PLAN_CODE = resultSet.getString(5);
				M_POL_APPRV_DT = resultSet.getDate(6);
				
				int insertInt = handler.executeInsertStatement(insertQuery, connection,new Object[]{
																								M_POL_NO,
																								M_POL_PROD_CODE,
																								M_POL_END_NO,
																								M_POL_SYS_ID,
																								M_POL_PLAN_CODE,
																								M_POL_APPRV_DT,
																										
																								});
				System.out.println("insertInt=======>"+insertInt);
			}
			CommonUtils.getConnection().commit();
			
			List<PW_IL_PA_PROFIT> dataList = null;
			dataList = compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN().getDataList_PW_IL_PA_PROFIT();
			if(dataList != null && dataList.size()>0){
				dataList.clear();
			}
			helper.executeQuery(compositeAction);
			if (dataList != null && dataList.size() > 0) {
				PW_IL_PA_PROFIT PW_IL_PA_PROFIT_BEAN = dataList.get(0);
				PW_IL_PA_PROFIT_BEAN.setRowSelected(true);
				compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN()
						.setPW_IL_PA_PROFIT_BEAN(PW_IL_PA_PROFIT_BEAN);
			}
			
		}catch(Exception exception){
			getErrorMap().put("current", exception.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void selectAllButtonPress(){
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String M_FLAG = null;
		String updateQuery = "UPDATE PW_IL_PA_PROFIT  SET PP_PROCESS_YN = 'Y'";
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(COMP_UI_BUT_SELECTALL!=null &&
					COMP_UI_BUT_SELECTALL.getValue()!=null &&
					"Select All".equalsIgnoreCase(COMP_UI_BUT_SELECTALL.getValue().toString())){
				M_FLAG = "A";
				int i = handler.executeUpdateStatement(updateQuery, connection);
				System.out.println("Update In"+i);
				COMP_UI_BUT_SELECTALL.setValue("Deselect All");
				
			}
			
			if(M_FLAG==null){
				int i = handler.executeUpdateStatement("UPDATE PW_IL_PA_PROFIT  SET PP_PROCESS_YN = 'N'", connection);
				System.out.println("Update In======>"+i);
				COMP_UI_BUT_SELECTALL.setValue("Select All");
			}
			
			//Again Execute Query
			//processButtonPress();
			if("A".equalsIgnoreCase(M_FLAG)){
				for (int i = 0; i < compositeAction
						.getPW_IL_PA_PROFIT_ACTION_BEAN()
						.getDataList_PW_IL_PA_PROFIT().size(); i++) {
					compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN()
							.getDataList_PW_IL_PA_PROFIT().get(i).setPP_PROCESS_YN(
									"Y");
				}
			}else{
				for (int i = 0; i < compositeAction
				.getPW_IL_PA_PROFIT_ACTION_BEAN()
				.getDataList_PW_IL_PA_PROFIT().size(); i++) {
			compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN()
					.getDataList_PW_IL_PA_PROFIT().get(i).setPP_PROCESS_YN(
							"N");
				}
			}
		}catch(Exception exception){
			exception.printStackTrace();
			getErrorMap().put("current", exception.getMessage());
		}
	}
	
	
	public void whenOKbuttonPress(){
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String M_FLAG = null;
		String updateQuery = "UPDATE PW_IL_PA_PROFIT  SET PP_PROCESS_YN = 'Y'";
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			
			if("Y".equalsIgnoreCase(compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN().getPW_IL_PA_PROFIT_BEAN().getPP_PROCESS_YN())){
				
			
			
			P9ILPK_WAK_DRIP_P_INVEST_PAID_AMT(DUMMY_BEAN.getUI_M_PROD_CODE_FM(), 
					DUMMY_BEAN.getUI_M_PROD_CODE_TO(), 
					DUMMY_BEAN.getUI_M_POLICY_FM(), 
					DUMMY_BEAN.getUI_M_POLICY_TO(), 
					DUMMY_BEAN.getUI_M_ACNT_YEAR_FM(), 
					DUMMY_BEAN.getUI_M_ACNT_YEAR_TO(), 
					DUMMY_BEAN.getUI_M_ACNT_FM_DATE_1(), 
					DUMMY_BEAN.getUI_M_ACNT_TO_DATE_1(), 
					DUMMY_BEAN.getUI_M_ACNT_FM_DATE_2() , 
					DUMMY_BEAN.getUI_M_ACNT_TO_DATE_2(), 
					DUMMY_BEAN.getUI_M_PROCESS_DT());
			P9ILPK_WAK_DRIP_P_PA_PROFIT_CALC(DUMMY_BEAN.getUI_M_PROD_CODE_FM(), 
					DUMMY_BEAN.getUI_M_PROD_CODE_TO(), 
					DUMMY_BEAN.getUI_M_POLICY_FM(), 
					DUMMY_BEAN.getUI_M_POLICY_TO(), 
					DUMMY_BEAN.getUI_M_ACNT_YEAR_FM(), 
					DUMMY_BEAN.getUI_M_ACNT_YEAR_TO(), 
					DUMMY_BEAN.getUI_M_ACNT_FM_DATE_1(), 
					DUMMY_BEAN.getUI_M_ACNT_TO_DATE_1(), 
					DUMMY_BEAN.getUI_M_ACNT_FM_DATE_2() , 
					DUMMY_BEAN.getUI_M_ACNT_TO_DATE_2(), 
					DUMMY_BEAN.getUI_M_PROCESS_DT());
			
			String deleteQuery = "DELETE FROM PW_IL_PA_PROFIT  WHERE PP_PROCESS_YN = 'Y'";
			int deleteInt = handler.executeDeleteStatement(deleteQuery, connection);
			System.out.println("DELETE=========> "+deleteInt);
			
			getWarningMap().put("current", "Processing Completed");
			
			//execute query
			}else{
				throw new Exception("Not able to Process");
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			getErrorMap().put("current", exception.getMessage());
		}
	}
	
	/**
	 * 
	 * @param M_PROD_CODE_FM
	 * @param M_PROD_CODE_TO
	 * @param M_POLICY_FM
	 * @param M_POLICY_TO
	 * @param M_ACNT_YEAR_FM
	 * @param M_ACNT_YEAR_TO
	 * @param M_ACNT_FM_DATE_1
	 * @param M_ACNT_TO_DATE_1
	 * @param M_ACNT_FM_DATE_2
	 * @param M_ACNT_TO_DATE_2
	 * @param M_PROCESS_DT
	 * @throws Exception
	 */
	public static void P9ILPK_WAK_DRIP_P_INVEST_PAID_AMT(Object M_PROD_CODE_FM,
														 Object M_PROD_CODE_TO, 
														 Object M_POLICY_FM,
														 Object M_POLICY_TO, 
														 Object M_ACNT_YEAR_FM, 
														 Object M_ACNT_YEAR_TO,
														 Object M_ACNT_FM_DATE_1,
														 Object M_ACNT_TO_DATE_1,
														 Object M_ACNT_FM_DATE_2,
														 Object M_ACNT_TO_DATE_2,
														 Object M_PROCESS_DT) throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();

			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_PROD_CODE_FM);
			
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_PROD_CODE_TO);
			
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_POLICY_FM);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_POLICY_TO);
			
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_YEAR_FM);
			
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_YEAR_TO);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN_OUT, M_ACNT_FM_DATE_1);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_TO_DATE_1);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_FM_DATE_2);
			OracleParameter param10 = new OracleParameter("IN10",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_TO_DATE_2);
			OracleParameter param11 = new OracleParameter("IN11",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_PROCESS_DT);
			OracleParameter param12 = new OracleParameter("IN12",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, "X");

			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			parameterList.add(param6);
			parameterList.add(param7);
			parameterList.add(param8);
			parameterList.add(param9);
			parameterList.add(param10);
			parameterList.add(param11);
			parameterList.add(param12);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			procHandler.executeProc(parameterList, connection,
					"P9ILPK_WAK_DRIP.P_INVEST_PAID_AMT");
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param M_PROD_CODE_FM
	 * @param M_PROD_CODE_TO
	 * @param M_POLICY_FM
	 * @param M_POLICY_TO
	 * @param M_ACNT_YEAR_FM
	 * @param M_ACNT_YEAR_TO
	 * @param M_ACNT_FM_DATE_1
	 * @param M_ACNT_TO_DATE_1
	 * @param M_ACNT_FM_DATE_2
	 * @param M_ACNT_TO_DATE_2
	 * @param M_PROCESS_DT
	 * @throws Exception
	 */
	public static void P9ILPK_WAK_DRIP_P_PA_PROFIT_CALC(Object M_PROD_CODE_FM,
														 Object M_PROD_CODE_TO, 
														 Object M_POLICY_FM,
														 Object M_POLICY_TO, 
														 Object M_ACNT_YEAR_FM, 
														 Object M_ACNT_YEAR_TO,
														 Object M_ACNT_FM_DATE_1,
														 Object M_ACNT_TO_DATE_1,
														 Object M_ACNT_FM_DATE_2,
														 Object M_ACNT_TO_DATE_2,
														 Object M_PROCESS_DT) throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();

			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_PROD_CODE_FM);
			
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_PROD_CODE_TO);
			
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_POLICY_FM);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_POLICY_TO);
			
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_YEAR_FM);
			
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_YEAR_TO);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN_OUT, M_ACNT_FM_DATE_1);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_TO_DATE_1);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_FM_DATE_2);
			OracleParameter param10 = new OracleParameter("IN10",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_ACNT_TO_DATE_2);
			OracleParameter param11 = new OracleParameter("IN11",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, M_PROCESS_DT);
			OracleParameter param12 = new OracleParameter("IN12",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, "X");

			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			parameterList.add(param6);
			parameterList.add(param7);
			parameterList.add(param8);
			parameterList.add(param9);
			parameterList.add(param10);
			parameterList.add(param11);
			parameterList.add(param12);


			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			procHandler.executeProc(parameterList, connection,
					"P9ILPK_WAK_DRIP.P_PA_PROFIT_CALC");
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
	}
	
	public List<LovBean> lovM_PROD_CODE_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			System.out.println("Lov is Working");
			suggestionList = listitemutil.P_CALL_LOV("PILP089_APAC",
					"DUMMY", "M_PROD_CODE_FM",
					null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovM_PROD_CODE_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			System.out.println("Lov is Working");
			suggestionList = listitemutil.P_CALL_LOV("PILP089_APAC",
					"DUMMY", "M_PROD_CODE_TO",
					null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_POLICY_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			System.out.println("Lov is Working");
			suggestionList = listitemutil.P_CALL_LOV("PILP089_APAC",
					"DUMMY", "M_POLICY_FM",
					CommonUtils.nvl(DUMMY_BEAN.getUI_M_PROD_CODE_FM(),"0"), 
					CommonUtils.nvl(DUMMY_BEAN.getUI_M_PROD_CODE_TO(),"zzzzzzzzzzzzzzzzzzzzzz"),
					null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovM_POLICY_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			System.out.println("Lov is Working");
			suggestionList = listitemutil.P_CALL_LOV("PILP089_APAC",
					"DUMMY", "M_POLICY_TO",
					DUMMY_BEAN.getUI_M_PROD_CODE_FM(), 
					DUMMY_BEAN.getUI_M_PROD_CODE_TO(),
					null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public void saveRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			getWarningMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void setCOMP_UI_M_ACNT_YEAR_FM(HtmlSelectOneMenu comp_ui_m_acnt_year_fm) {
		COMP_UI_M_ACNT_YEAR_FM = comp_ui_m_acnt_year_fm;
	}

	public void setCOMP_UI_M_ACNT_YEAR_TO(HtmlSelectOneMenu comp_ui_m_acnt_year_to) {
		COMP_UI_M_ACNT_YEAR_TO = comp_ui_m_acnt_year_to;
	}

	public List<SelectItem> getListUI_M_ACNT_YEAR_FM() {
		return listUI_M_ACNT_YEAR_FM;
	}

	public void setListUI_M_ACNT_YEAR_FM(List<SelectItem> listUI_M_ACNT_YEAR_FM) {
		this.listUI_M_ACNT_YEAR_FM = listUI_M_ACNT_YEAR_FM;
	}

	public List<SelectItem> getListUI_M_ACNT_YEAR_TO() {
		return listUI_M_ACNT_YEAR_TO;
	}

	public void setListUI_M_ACNT_YEAR_TO(List<SelectItem> listUI_M_ACNT_YEAR_TO) {
		this.listUI_M_ACNT_YEAR_TO = listUI_M_ACNT_YEAR_TO;
	}
	public void populate_Acnt_year() {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
	    String query=" SELECT CAY_ACNT_YEAR FROM FM_COMP_ACNT_YEAR ";
	    listUI_M_ACNT_YEAR_FM.clear();
	    listUI_M_ACNT_YEAR_TO.clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				int year=resultSet.getInt(1);
				listUI_M_ACNT_YEAR_FM.add(new SelectItem(year));
				listUI_M_ACNT_YEAR_TO.add(new SelectItem(year));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
	}

	public HtmlSelectOneMenu getCOMP_UI_M_ACNT_YEAR_FM() {
		return COMP_UI_M_ACNT_YEAR_FM;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_ACNT_YEAR_TO() {
		return COMP_UI_M_ACNT_YEAR_TO;
	}

}