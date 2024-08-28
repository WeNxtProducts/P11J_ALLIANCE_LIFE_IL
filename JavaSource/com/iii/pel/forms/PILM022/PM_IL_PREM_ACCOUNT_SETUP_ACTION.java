package com.iii.pel.forms.PILM022;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM001.PM_IL_CLASS;
import com.iii.pel.forms.PILM001.PM_IL_CLASS_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PREM_ACCOUNT_SETUP_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_PAS_FRZ_FLAG_LABEL;
	private HtmlOutputLabel COMP_PAS_SRC_BUS_TO_LABEL;
	private HtmlOutputLabel COMP_PAS_SRC_BUS_FM_LABEL;
	private HtmlOutputLabel COMP_PAS_BUS_TO_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_BUS_FM_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_DIVN_FM_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_DIVN_TO_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_DEPT_FM_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_DEPT_TO_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_DOC_FM_TYPE_LABEL;
	private HtmlOutputLabel COMP_PAS_DOC_TO_TYPE_LABEL;
	private HtmlOutputLabel COMP_PAS_PROD_CODE_FM_LABEL;
	private HtmlOutputLabel COMP_PAS_PROD_CODE_TO_LABEL;
	private HtmlOutputLabel COMP_PAS_PLAN_CODE_TO_LABEL;
	private HtmlOutputLabel COMP_PAS_CUST_CLS_FM_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_CUST_CLS_TO_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_PLAN_CODE_FM_LABEL;
	private HtmlOutputLabel COMP_PAS_FIRST_PREM_YN_LABEL;
	private HtmlOutputLabel COMP_PAS_NB_END_FLAG_LABEL;
	private HtmlOutputLabel COMP_PAS_END_FM_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_END_TO_CODE_LABEL;
	private HtmlOutputLabel COMP_PAS_PLAN_YRS_FM_LABEL;
	private HtmlOutputLabel COMP_PAS_PLAN_YRS_TO_LABEL;
	private HtmlOutputLabel COMP_PAS_ASSURED_TYPE_LABEL;
	private HtmlOutputLabel COMP_PAS_FORCE_DIVN_YN_LABEL;
	private HtmlOutputLabel COMP_PAS_PLAN_TYPE_LABEL;
	private HtmlOutputLabel COMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL;
	private HtmlOutputLabel COMP_PAS_FORCE_DEPT_YN_LABEL;
	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	private HtmlOutputLabel COMP_PAS_MAIN_ACNT_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;
	private HtmlOutputLabel COMP_PAS_SUB_ACNT_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;
	private HtmlOutputLabel COMP_PAS_DIVN_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;
	private HtmlOutputLabel COMP_PAS_DEPT_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;
	private HtmlOutputLabel COMP_PAS_ANLY_CODE_1_LABEL;
	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;
	private HtmlOutputLabel COMP_PAS_ANLY_CODE_2_LABEL;
	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;
	private HtmlOutputLabel COMP_PAS_ACTY_CODE_1_LABEL;
	private HtmlOutputLabel COMP_PAS_ACTY_CODE_2_LABEL;
	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PAS_FRZ_FLAG;

	private HtmlInputText COMP_PAS_SRC_BUS_TO;
	private HtmlInputText COMP_PAS_SRC_BUS_FM;
	private HtmlInputText COMP_PAS_BUS_TO_CODE;
	private HtmlInputText COMP_PAS_BUS_FM_CODE;
	private HtmlInputText COMP_PAS_DIVN_FM_CODE;
	private HtmlInputText COMP_PAS_DIVN_TO_CODE;
	private HtmlInputText COMP_PAS_DEPT_FM_CODE;
	private HtmlInputText COMP_PAS_DEPT_TO_CODE;
	private HtmlInputText COMP_PAS_DOC_FM_TYPE;
	private HtmlInputText COMP_PAS_DOC_TO_TYPE;
	private HtmlInputText COMP_PAS_PROD_CODE_FM;
	private HtmlInputText COMP_PAS_PROD_CODE_TO;
	private HtmlInputText COMP_PAS_PLAN_CODE_FM;
	private HtmlInputText COMP_PAS_PLAN_CODE_TO;
	private HtmlInputText COMP_PAS_CUST_CLS_FM_CODE;
	private HtmlInputText COMP_PAS_CUST_CLS_TO_CODE;
	private HtmlInputText COMP_PAS_END_FM_CODE;
	private HtmlInputText COMP_PAS_END_TO_CODE;
	private HtmlInputText COMP_PAS_PLAN_YRS_FM;
	private HtmlInputText COMP_PAS_PLAN_YRS_TO;
	private HtmlInputText COMP_PAS_PLAN_TYPE;
	private HtmlInputText COMP_UI_M_PAS_PLAN_TYPE_DESC;
	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;
	private HtmlInputText COMP_PAS_MAIN_ACNT_CODE;
	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;
	private HtmlInputText COMP_PAS_SUB_ACNT_CODE;
	private HtmlInputText COMP_UI_M_DIVN_NAME;
	private HtmlInputText COMP_PAS_DIVN_CODE;
	private HtmlInputText COMP_UI_M_DEPT_NAME;
	private HtmlInputText COMP_PAS_DEPT_CODE;
	private HtmlInputText COMP_UI_M_ANLY_NAME;
	private HtmlInputText COMP_PAS_ANLY_CODE_1;
	private HtmlInputText COMP_UI_M_ANLY_NAME_1;
	private HtmlInputText COMP_PAS_ANLY_CODE_2;
	private HtmlInputText COMP_UI_M_ACTY_NAME;
	private HtmlInputText COMP_PAS_ACTY_CODE_1;
	private HtmlInputText COMP_UI_M_ACTY_NAME_1;
	private HtmlInputText COMP_PAS_ACTY_CODE_2;
	private HtmlInputText COMP_UI_M_ANLY_NAME_2;

	private HtmlSelectOneMenu COMP_PAS_FIRST_PREM_YN;
	private HtmlSelectOneMenu COMP_PAS_NB_END_FLAG;
	private HtmlSelectOneMenu COMP_PAS_ASSURED_TYPE;
	private HtmlSelectOneMenu COMP_PAS_FORCE_DIVN_YN;
	private HtmlSelectOneMenu COMP_PAS_FORCE_DEPT_YN;
	
	private List<SelectItem> PAS_FIRST_PREM_YN_ARRAYLIST = new ArrayList<SelectItem>();
	private List<SelectItem> PAS_NB_END_FLAG_ARRAYLIST = new ArrayList<SelectItem>();
	private List<SelectItem> PAS_ASSURED_TYPE_ARRAYLIST = new ArrayList<SelectItem>();
	private List<SelectItem> PAS_FORCE_DIVN_YN_ARRAYLIST = new ArrayList<SelectItem>();
	private List<SelectItem> PAS_FORCE_DEPT_YN_ARRAYLIST = new ArrayList<SelectItem>();
	
	List<LovBean> suggestionList = null;
	
	//ArrayList PAS_FIRST_PREM_YN_ARRAYLIST;
	/*ArrayList PAS_NB_END_FLAG_ARRAYLIST;
	ArrayList PAS_ASSURED_TYPE_ARRAYLIST;
	ArrayList PAS_FORCE_DIVN_YN_ARRAYLIST;
	ArrayList PAS_FORCE_DEPT_YN_ARRAYLIST;*/
	
	List PM_IL_PREM_ACCOUNT_SETUP_LIST = null;
	List PM_IL_SUB_ACCOUNT_SETUP_LIST = null;
	
	private PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN;

	public PM_IL_PREM_ACCOUNT_SETUP_ACTION() throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_BEAN = new PM_IL_PREM_ACCOUNT_SETUP();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		
		/*PAS_FIRST_PREM_YN_ARRAYLIST = pm_il_prem_account_setup_action_delegate.selectValueForComboBox(
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"),
				 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_FIRST_PREM_YN"));
				
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_FIRST_PREM_YN"));*/
		
		setPAS_FIRST_PREM_YN_ARRAYLIST(ListItemUtil.getDropDownListValue(
				getConnection(), "PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
				"PM_IL_PREM_ACCOUNT_SETUP.PAS_FIRST_PREM_YN", "YESNO"));
		
		/*PAS_NB_END_FLAG_ARRAYLIST = pm_il_prem_account_setup_action_delegate.selectValueForComboBox(
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_NB_END_FLAG"));
				
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_NB_END_FLAG"));*/
		
		setPAS_NB_END_FLAG_ARRAYLIST(ListItemUtil.getDropDownListValue(
				getConnection(), "PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
				"PM_IL_PREM_ACCOUNT_SETUP.PAS_NB_END_FLAG", "NB_END_FLAG"));
		
		PAS_ASSURED_TYPE_ARRAYLIST = pm_il_prem_account_setup_action_delegate.selectValueForComboBox_PAS_ASSURED_TYPE();
		/*setPAS_ASSURED_TYPE_ARRAYLIST(ListItemUtil.getDropDownListValue(
				getConnection(), "PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
				"PM_IL_PREM_ACCOUNT_SETUP.PAS_NB_END_FLAG", "NB_END_FLAG"));*/
		
		/*PAS_FORCE_DIVN_YN_ARRAYLIST = pm_il_prem_account_setup_action_delegate.selectValueForComboBox(
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_FORCE_DIVN_YN"));
				
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_FORCE_DIVN_YN"));*/
		
		setPAS_FORCE_DIVN_YN_ARRAYLIST(ListItemUtil.getDropDownListValue(
				getConnection(), "PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
				"PM_IL_PREM_ACCOUNT_SETUP.PAS_FORCE_DIVN_YN", "YESNO"));
		
		/*PAS_FORCE_DEPT_YN_ARRAYLIST = pm_il_prem_account_setup_action_delegate.selectValueForComboBox(
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"), 
				PropertyManager.getValue("PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_FORCE_DEPT_YN"));
				
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FORM_NAME"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$BLOCK_NAME$PM_IL_PREM_ACCOUNT_SETUP"),
				Messages.getString("messageProperties_PILM022", "PILM022$PM_IL_PREM_ACCOUNT_SETUP$FIELD_NAME$PAS_FORCE_DEPT_YN"));*/
		
		setPAS_FORCE_DEPT_YN_ARRAYLIST((ListItemUtil.getDropDownListValue(
				getConnection(), "PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
				"PM_IL_PREM_ACCOUNT_SETUP.PAS_FORCE_DEPT_YN", "YESNO")));
		WHEN_CREATE_RECORD();
	}

	

	

	/**
	 * @return the pAS_NB_END_FLAG_ARRAYLIST
	 */
	public List<SelectItem> getPAS_NB_END_FLAG_ARRAYLIST() {
		return PAS_NB_END_FLAG_ARRAYLIST;
	}





	/**
	 * @param pas_nb_end_flag_arraylist the pAS_NB_END_FLAG_ARRAYLIST to set
	 */
	public void setPAS_NB_END_FLAG_ARRAYLIST(
			List<SelectItem> pas_nb_end_flag_arraylist) {
		PAS_NB_END_FLAG_ARRAYLIST = pas_nb_end_flag_arraylist;
	}





	/**
	 * @return the pAS_ASSURED_TYPE_ARRAYLIST
	 */
	public List<SelectItem> getPAS_ASSURED_TYPE_ARRAYLIST() {
		return PAS_ASSURED_TYPE_ARRAYLIST;
	}





	/**
	 * @param pas_assured_type_arraylist the pAS_ASSURED_TYPE_ARRAYLIST to set
	 */
	public void setPAS_ASSURED_TYPE_ARRAYLIST(
			List<SelectItem> pas_assured_type_arraylist) {
		PAS_ASSURED_TYPE_ARRAYLIST = pas_assured_type_arraylist;
	}





	/**
	 * @return the pAS_FORCE_DIVN_YN_ARRAYLIST
	 */
	public List<SelectItem> getPAS_FORCE_DIVN_YN_ARRAYLIST() {
		return PAS_FORCE_DIVN_YN_ARRAYLIST;
	}





	/**
	 * @param pas_force_divn_yn_arraylist the pAS_FORCE_DIVN_YN_ARRAYLIST to set
	 */
	public void setPAS_FORCE_DIVN_YN_ARRAYLIST(
			List<SelectItem> pas_force_divn_yn_arraylist) {
		PAS_FORCE_DIVN_YN_ARRAYLIST = pas_force_divn_yn_arraylist;
	}





	/**
	 * @return the pAS_FORCE_DEPT_YN_ARRAYLIST
	 */
	public List<SelectItem> getPAS_FORCE_DEPT_YN_ARRAYLIST() {
		return PAS_FORCE_DEPT_YN_ARRAYLIST;
	}





	/**
	 * @param pas_force_dept_yn_arraylist the pAS_FORCE_DEPT_YN_ARRAYLIST to set
	 */
	public void setPAS_FORCE_DEPT_YN_ARRAYLIST(
			List<SelectItem> pas_force_dept_yn_arraylist) {
		PAS_FORCE_DEPT_YN_ARRAYLIST = pas_force_dept_yn_arraylist;
	}

	public HtmlOutputLabel getCOMP_PAS_FRZ_FLAG_LABEL() {
		return COMP_PAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PAS_FRZ_FLAG() {
		return COMP_PAS_FRZ_FLAG;
	}

	public void setCOMP_PAS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_PAS_FRZ_FLAG_LABEL) {
		this.COMP_PAS_FRZ_FLAG_LABEL = COMP_PAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_PAS_FRZ_FLAG) {
		this.COMP_PAS_FRZ_FLAG = COMP_PAS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PAS_SRC_BUS_TO_LABEL() {
		return COMP_PAS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_PAS_SRC_BUS_TO() {
		return COMP_PAS_SRC_BUS_TO;
	}

	public void setCOMP_PAS_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_PAS_SRC_BUS_TO_LABEL) {
		this.COMP_PAS_SRC_BUS_TO_LABEL = COMP_PAS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_PAS_SRC_BUS_TO(HtmlInputText COMP_PAS_SRC_BUS_TO) {
		this.COMP_PAS_SRC_BUS_TO = COMP_PAS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_PAS_SRC_BUS_FM_LABEL() {
		return COMP_PAS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_PAS_SRC_BUS_FM() {
		return COMP_PAS_SRC_BUS_FM;
	}

	public void setCOMP_PAS_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_PAS_SRC_BUS_FM_LABEL) {
		this.COMP_PAS_SRC_BUS_FM_LABEL = COMP_PAS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_PAS_SRC_BUS_FM(HtmlInputText COMP_PAS_SRC_BUS_FM) {
		this.COMP_PAS_SRC_BUS_FM = COMP_PAS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_PAS_BUS_TO_CODE_LABEL() {
		return COMP_PAS_BUS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_BUS_TO_CODE() {
		return COMP_PAS_BUS_TO_CODE;
	}

	public void setCOMP_PAS_BUS_TO_CODE_LABEL(HtmlOutputLabel COMP_PAS_BUS_TO_CODE_LABEL) {
		this.COMP_PAS_BUS_TO_CODE_LABEL = COMP_PAS_BUS_TO_CODE_LABEL;
	}

	public void setCOMP_PAS_BUS_TO_CODE(HtmlInputText COMP_PAS_BUS_TO_CODE) {
		this.COMP_PAS_BUS_TO_CODE = COMP_PAS_BUS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_BUS_FM_CODE_LABEL() {
		return COMP_PAS_BUS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_BUS_FM_CODE() {
		return COMP_PAS_BUS_FM_CODE;
	}

	public void setCOMP_PAS_BUS_FM_CODE_LABEL(HtmlOutputLabel COMP_PAS_BUS_FM_CODE_LABEL) {
		this.COMP_PAS_BUS_FM_CODE_LABEL = COMP_PAS_BUS_FM_CODE_LABEL;
	}

	public void setCOMP_PAS_BUS_FM_CODE(HtmlInputText COMP_PAS_BUS_FM_CODE) {
		this.COMP_PAS_BUS_FM_CODE = COMP_PAS_BUS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_DIVN_FM_CODE_LABEL() {
		return COMP_PAS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DIVN_FM_CODE() {
		return COMP_PAS_DIVN_FM_CODE;
	}

	public void setCOMP_PAS_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_PAS_DIVN_FM_CODE_LABEL) {
		this.COMP_PAS_DIVN_FM_CODE_LABEL = COMP_PAS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_PAS_DIVN_FM_CODE(HtmlInputText COMP_PAS_DIVN_FM_CODE) {
		this.COMP_PAS_DIVN_FM_CODE = COMP_PAS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_DIVN_TO_CODE_LABEL() {
		return COMP_PAS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DIVN_TO_CODE() {
		return COMP_PAS_DIVN_TO_CODE;
	}

	public void setCOMP_PAS_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_PAS_DIVN_TO_CODE_LABEL) {
		this.COMP_PAS_DIVN_TO_CODE_LABEL = COMP_PAS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_PAS_DIVN_TO_CODE(HtmlInputText COMP_PAS_DIVN_TO_CODE) {
		this.COMP_PAS_DIVN_TO_CODE = COMP_PAS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_DEPT_FM_CODE_LABEL() {
		return COMP_PAS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DEPT_FM_CODE() {
		return COMP_PAS_DEPT_FM_CODE;
	}

	public void setCOMP_PAS_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_PAS_DEPT_FM_CODE_LABEL) {
		this.COMP_PAS_DEPT_FM_CODE_LABEL = COMP_PAS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_PAS_DEPT_FM_CODE(HtmlInputText COMP_PAS_DEPT_FM_CODE) {
		this.COMP_PAS_DEPT_FM_CODE = COMP_PAS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_DEPT_TO_CODE_LABEL() {
		return COMP_PAS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DEPT_TO_CODE() {
		return COMP_PAS_DEPT_TO_CODE;
	}

	public void setCOMP_PAS_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_PAS_DEPT_TO_CODE_LABEL) {
		this.COMP_PAS_DEPT_TO_CODE_LABEL = COMP_PAS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_PAS_DEPT_TO_CODE(HtmlInputText COMP_PAS_DEPT_TO_CODE) {
		this.COMP_PAS_DEPT_TO_CODE = COMP_PAS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_DOC_FM_TYPE_LABEL() {
		return COMP_PAS_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DOC_FM_TYPE() {
		return COMP_PAS_DOC_FM_TYPE;
	}

	public void setCOMP_PAS_DOC_FM_TYPE_LABEL(HtmlOutputLabel COMP_PAS_DOC_FM_TYPE_LABEL) {
		this.COMP_PAS_DOC_FM_TYPE_LABEL = COMP_PAS_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_PAS_DOC_FM_TYPE(HtmlInputText COMP_PAS_DOC_FM_TYPE) {
		this.COMP_PAS_DOC_FM_TYPE = COMP_PAS_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_PAS_DOC_TO_TYPE_LABEL() {
		return COMP_PAS_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DOC_TO_TYPE() {
		return COMP_PAS_DOC_TO_TYPE;
	}

	public void setCOMP_PAS_DOC_TO_TYPE_LABEL(HtmlOutputLabel COMP_PAS_DOC_TO_TYPE_LABEL) {
		this.COMP_PAS_DOC_TO_TYPE_LABEL = COMP_PAS_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_PAS_DOC_TO_TYPE(HtmlInputText COMP_PAS_DOC_TO_TYPE) {
		this.COMP_PAS_DOC_TO_TYPE = COMP_PAS_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_PAS_PROD_CODE_FM_LABEL() {
		return COMP_PAS_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PROD_CODE_FM() {
		return COMP_PAS_PROD_CODE_FM;
	}

	public void setCOMP_PAS_PROD_CODE_FM_LABEL(HtmlOutputLabel COMP_PAS_PROD_CODE_FM_LABEL) {
		this.COMP_PAS_PROD_CODE_FM_LABEL = COMP_PAS_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_PAS_PROD_CODE_FM(HtmlInputText COMP_PAS_PROD_CODE_FM) {
		this.COMP_PAS_PROD_CODE_FM = COMP_PAS_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_PAS_PROD_CODE_TO_LABEL() {
		return COMP_PAS_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PROD_CODE_TO() {
		return COMP_PAS_PROD_CODE_TO;
	}

	public void setCOMP_PAS_PROD_CODE_TO_LABEL(HtmlOutputLabel COMP_PAS_PROD_CODE_TO_LABEL) {
		this.COMP_PAS_PROD_CODE_TO_LABEL = COMP_PAS_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_PAS_PROD_CODE_TO(HtmlInputText COMP_PAS_PROD_CODE_TO) {
		this.COMP_PAS_PROD_CODE_TO = COMP_PAS_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_PAS_PLAN_CODE_FM_LABEL() {
		return COMP_PAS_PLAN_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PLAN_CODE_FM() {
		return COMP_PAS_PLAN_CODE_FM;
	}

	public void setCOMP_PAS_PLAN_CODE_FM_LABEL(HtmlOutputLabel COMP_PAS_PLAN_CODE_FM_LABEL) {
		this.COMP_PAS_PLAN_CODE_FM_LABEL = COMP_PAS_PLAN_CODE_FM_LABEL;
	}

	public void setCOMP_PAS_PLAN_CODE_FM(HtmlInputText COMP_PAS_PLAN_CODE_FM) {
		this.COMP_PAS_PLAN_CODE_FM = COMP_PAS_PLAN_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_PAS_PLAN_CODE_TO_LABEL() {
		return COMP_PAS_PLAN_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PLAN_CODE_TO() {
		return COMP_PAS_PLAN_CODE_TO;
	}

	public void setCOMP_PAS_PLAN_CODE_TO_LABEL(HtmlOutputLabel COMP_PAS_PLAN_CODE_TO_LABEL) {
		this.COMP_PAS_PLAN_CODE_TO_LABEL = COMP_PAS_PLAN_CODE_TO_LABEL;
	}

	public void setCOMP_PAS_PLAN_CODE_TO(HtmlInputText COMP_PAS_PLAN_CODE_TO) {
		this.COMP_PAS_PLAN_CODE_TO = COMP_PAS_PLAN_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_PAS_CUST_CLS_FM_CODE_LABEL() {
		return COMP_PAS_CUST_CLS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_CUST_CLS_FM_CODE() {
		return COMP_PAS_CUST_CLS_FM_CODE;
	}

	public void setCOMP_PAS_CUST_CLS_FM_CODE_LABEL(HtmlOutputLabel COMP_PAS_CUST_CLS_FM_CODE_LABEL) {
		this.COMP_PAS_CUST_CLS_FM_CODE_LABEL = COMP_PAS_CUST_CLS_FM_CODE_LABEL;
	}

	public void setCOMP_PAS_CUST_CLS_FM_CODE(HtmlInputText COMP_PAS_CUST_CLS_FM_CODE) {
		this.COMP_PAS_CUST_CLS_FM_CODE = COMP_PAS_CUST_CLS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_CUST_CLS_TO_CODE_LABEL() {
		return COMP_PAS_CUST_CLS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_CUST_CLS_TO_CODE() {
		return COMP_PAS_CUST_CLS_TO_CODE;
	}

	public void setCOMP_PAS_CUST_CLS_TO_CODE_LABEL(HtmlOutputLabel COMP_PAS_CUST_CLS_TO_CODE_LABEL) {
		this.COMP_PAS_CUST_CLS_TO_CODE_LABEL = COMP_PAS_CUST_CLS_TO_CODE_LABEL;
	}

	public void setCOMP_PAS_CUST_CLS_TO_CODE(HtmlInputText COMP_PAS_CUST_CLS_TO_CODE) {
		this.COMP_PAS_CUST_CLS_TO_CODE = COMP_PAS_CUST_CLS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_FIRST_PREM_YN_LABEL() {
		return COMP_PAS_FIRST_PREM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_FIRST_PREM_YN() {
		return COMP_PAS_FIRST_PREM_YN;
	}

	public void setCOMP_PAS_FIRST_PREM_YN_LABEL(HtmlOutputLabel COMP_PAS_FIRST_PREM_YN_LABEL) {
		this.COMP_PAS_FIRST_PREM_YN_LABEL = COMP_PAS_FIRST_PREM_YN_LABEL;
	}

	public void setCOMP_PAS_FIRST_PREM_YN(HtmlSelectOneMenu COMP_PAS_FIRST_PREM_YN) {
		this.COMP_PAS_FIRST_PREM_YN = COMP_PAS_FIRST_PREM_YN;
	}

	public HtmlOutputLabel getCOMP_PAS_NB_END_FLAG_LABEL() {
		return COMP_PAS_NB_END_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_NB_END_FLAG() {
		return COMP_PAS_NB_END_FLAG;
	}

	public void setCOMP_PAS_NB_END_FLAG_LABEL(HtmlOutputLabel COMP_PAS_NB_END_FLAG_LABEL) {
		this.COMP_PAS_NB_END_FLAG_LABEL = COMP_PAS_NB_END_FLAG_LABEL;
	}

	public void setCOMP_PAS_NB_END_FLAG(HtmlSelectOneMenu COMP_PAS_NB_END_FLAG) {
		this.COMP_PAS_NB_END_FLAG = COMP_PAS_NB_END_FLAG;
	}

	public HtmlOutputLabel getCOMP_PAS_END_FM_CODE_LABEL() {
		return COMP_PAS_END_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_END_FM_CODE() {
		return COMP_PAS_END_FM_CODE;
	}

	public void setCOMP_PAS_END_FM_CODE_LABEL(HtmlOutputLabel COMP_PAS_END_FM_CODE_LABEL) {
		this.COMP_PAS_END_FM_CODE_LABEL = COMP_PAS_END_FM_CODE_LABEL;
	}

	public void setCOMP_PAS_END_FM_CODE(HtmlInputText COMP_PAS_END_FM_CODE) {
		this.COMP_PAS_END_FM_CODE = COMP_PAS_END_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_END_TO_CODE_LABEL() {
		return COMP_PAS_END_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_END_TO_CODE() {
		return COMP_PAS_END_TO_CODE;
	}

	public void setCOMP_PAS_END_TO_CODE_LABEL(HtmlOutputLabel COMP_PAS_END_TO_CODE_LABEL) {
		this.COMP_PAS_END_TO_CODE_LABEL = COMP_PAS_END_TO_CODE_LABEL;
	}

	public void setCOMP_PAS_END_TO_CODE(HtmlInputText COMP_PAS_END_TO_CODE) {
		this.COMP_PAS_END_TO_CODE = COMP_PAS_END_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_PLAN_YRS_FM_LABEL() {
		return COMP_PAS_PLAN_YRS_FM_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PLAN_YRS_FM() {
		return COMP_PAS_PLAN_YRS_FM;
	}

	public void setCOMP_PAS_PLAN_YRS_FM_LABEL(HtmlOutputLabel COMP_PAS_PLAN_YRS_FM_LABEL) {
		this.COMP_PAS_PLAN_YRS_FM_LABEL = COMP_PAS_PLAN_YRS_FM_LABEL;
	}

	public void setCOMP_PAS_PLAN_YRS_FM(HtmlInputText COMP_PAS_PLAN_YRS_FM) {
		this.COMP_PAS_PLAN_YRS_FM = COMP_PAS_PLAN_YRS_FM;
	}

	public HtmlOutputLabel getCOMP_PAS_PLAN_YRS_TO_LABEL() {
		return COMP_PAS_PLAN_YRS_TO_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PLAN_YRS_TO() {
		return COMP_PAS_PLAN_YRS_TO;
	}

	public void setCOMP_PAS_PLAN_YRS_TO_LABEL(HtmlOutputLabel COMP_PAS_PLAN_YRS_TO_LABEL) {
		this.COMP_PAS_PLAN_YRS_TO_LABEL = COMP_PAS_PLAN_YRS_TO_LABEL;
	}

	public void setCOMP_PAS_PLAN_YRS_TO(HtmlInputText COMP_PAS_PLAN_YRS_TO) {
		this.COMP_PAS_PLAN_YRS_TO = COMP_PAS_PLAN_YRS_TO;
	}

	public HtmlOutputLabel getCOMP_PAS_ASSURED_TYPE_LABEL() {
		return COMP_PAS_ASSURED_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_ASSURED_TYPE() {
		return COMP_PAS_ASSURED_TYPE;
	}

	public void setCOMP_PAS_ASSURED_TYPE_LABEL(HtmlOutputLabel COMP_PAS_ASSURED_TYPE_LABEL) {
		this.COMP_PAS_ASSURED_TYPE_LABEL = COMP_PAS_ASSURED_TYPE_LABEL;
	}

	public void setCOMP_PAS_ASSURED_TYPE(HtmlSelectOneMenu COMP_PAS_ASSURED_TYPE) {
		this.COMP_PAS_ASSURED_TYPE = COMP_PAS_ASSURED_TYPE;
	}

	public HtmlOutputLabel getCOMP_PAS_FORCE_DIVN_YN_LABEL() {
		return COMP_PAS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_FORCE_DIVN_YN() {
		return COMP_PAS_FORCE_DIVN_YN;
	}

	public void setCOMP_PAS_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_PAS_FORCE_DIVN_YN_LABEL) {
		this.COMP_PAS_FORCE_DIVN_YN_LABEL = COMP_PAS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_PAS_FORCE_DIVN_YN(HtmlSelectOneMenu COMP_PAS_FORCE_DIVN_YN) {
		this.COMP_PAS_FORCE_DIVN_YN = COMP_PAS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_PAS_PLAN_TYPE_LABEL() {
		return COMP_PAS_PLAN_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_PLAN_TYPE() {
		return COMP_PAS_PLAN_TYPE;
	}

	public void setCOMP_PAS_PLAN_TYPE_LABEL(HtmlOutputLabel COMP_PAS_PLAN_TYPE_LABEL) {
		this.COMP_PAS_PLAN_TYPE_LABEL = COMP_PAS_PLAN_TYPE_LABEL;
	}

	public void setCOMP_PAS_PLAN_TYPE(HtmlInputText COMP_PAS_PLAN_TYPE) {
		this.COMP_PAS_PLAN_TYPE = COMP_PAS_PLAN_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL() {
		return COMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAS_PLAN_TYPE_DESC() {
		return COMP_UI_M_PAS_PLAN_TYPE_DESC;
	}

	public void setCOMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL) {
		this.COMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL = COMP_UI_M_PAS_PLAN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAS_PLAN_TYPE_DESC(HtmlInputText COMP_UI_M_PAS_PLAN_TYPE_DESC) {
		this.COMP_UI_M_PAS_PLAN_TYPE_DESC = COMP_UI_M_PAS_PLAN_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_PAS_FORCE_DEPT_YN_LABEL() {
		return COMP_PAS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_FORCE_DEPT_YN() {
		return COMP_PAS_FORCE_DEPT_YN;
	}

	public void setCOMP_PAS_FORCE_DEPT_YN_LABEL(HtmlOutputLabel COMP_PAS_FORCE_DEPT_YN_LABEL) {
		this.COMP_PAS_FORCE_DEPT_YN_LABEL = COMP_PAS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_PAS_FORCE_DEPT_YN(HtmlSelectOneMenu COMP_PAS_FORCE_DEPT_YN) {
		this.COMP_PAS_FORCE_DEPT_YN = COMP_PAS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_NAME_LABEL() {
		return COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_NAME_LABEL = COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(HtmlInputText COMP_UI_M_MAIN_ACNT_NAME) {
		this.COMP_UI_M_MAIN_ACNT_NAME = COMP_UI_M_MAIN_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_PAS_MAIN_ACNT_CODE_LABEL() {
		return COMP_PAS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MAIN_ACNT_CODE() {
		return COMP_PAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_PAS_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_PAS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_PAS_MAIN_ACNT_CODE_LABEL = COMP_PAS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_PAS_MAIN_ACNT_CODE(HtmlInputText COMP_PAS_MAIN_ACNT_CODE) {
		this.COMP_PAS_MAIN_ACNT_CODE = COMP_PAS_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_NAME_LABEL() {
		return COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL) {
		this.COMP_UI_M_SUB_ACNT_NAME_LABEL = COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText COMP_UI_M_SUB_ACNT_NAME) {
		this.COMP_UI_M_SUB_ACNT_NAME = COMP_UI_M_SUB_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_PAS_SUB_ACNT_CODE_LABEL() {
		return COMP_PAS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_SUB_ACNT_CODE() {
		return COMP_PAS_SUB_ACNT_CODE;
	}

	public void setCOMP_PAS_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_PAS_SUB_ACNT_CODE_LABEL) {
		this.COMP_PAS_SUB_ACNT_CODE_LABEL = COMP_PAS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_PAS_SUB_ACNT_CODE(HtmlInputText COMP_PAS_SUB_ACNT_CODE) {
		this.COMP_PAS_SUB_ACNT_CODE = COMP_PAS_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_PAS_DIVN_CODE_LABEL() {
		return COMP_PAS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DIVN_CODE() {
		return COMP_PAS_DIVN_CODE;
	}

	public void setCOMP_PAS_DIVN_CODE_LABEL(HtmlOutputLabel COMP_PAS_DIVN_CODE_LABEL) {
		this.COMP_PAS_DIVN_CODE_LABEL = COMP_PAS_DIVN_CODE_LABEL;
	}

	public void setCOMP_PAS_DIVN_CODE(HtmlInputText COMP_PAS_DIVN_CODE) {
		this.COMP_PAS_DIVN_CODE = COMP_PAS_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_PAS_DEPT_CODE_LABEL() {
		return COMP_PAS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_DEPT_CODE() {
		return COMP_PAS_DEPT_CODE;
	}

	public void setCOMP_PAS_DEPT_CODE_LABEL(HtmlOutputLabel COMP_PAS_DEPT_CODE_LABEL) {
		this.COMP_PAS_DEPT_CODE_LABEL = COMP_PAS_DEPT_CODE_LABEL;
	}

	public void setCOMP_PAS_DEPT_CODE(HtmlInputText COMP_PAS_DEPT_CODE) {
		this.COMP_PAS_DEPT_CODE = COMP_PAS_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_LABEL() {
		return COMP_UI_M_ANLY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME() {
		return COMP_UI_M_ANLY_NAME;
	}

	public void setCOMP_UI_M_ANLY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL) {
		this.COMP_UI_M_ANLY_NAME_LABEL = COMP_UI_M_ANLY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME(HtmlInputText COMP_UI_M_ANLY_NAME) {
		this.COMP_UI_M_ANLY_NAME = COMP_UI_M_ANLY_NAME;
	}

	public HtmlOutputLabel getCOMP_PAS_ANLY_CODE_1_LABEL() {
		return COMP_PAS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PAS_ANLY_CODE_1() {
		return COMP_PAS_ANLY_CODE_1;
	}

	public void setCOMP_PAS_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_PAS_ANLY_CODE_1_LABEL) {
		this.COMP_PAS_ANLY_CODE_1_LABEL = COMP_PAS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_PAS_ANLY_CODE_1(HtmlInputText COMP_PAS_ANLY_CODE_1) {
		this.COMP_PAS_ANLY_CODE_1 = COMP_PAS_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_1_LABEL() {
		return COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME_1() {
		return COMP_UI_M_ANLY_NAME_1;
	}

	public void setCOMP_UI_M_ANLY_NAME_1_LABEL(HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL) {
		this.COMP_UI_M_ANLY_NAME_1_LABEL = COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME_1(HtmlInputText COMP_UI_M_ANLY_NAME_1) {
		this.COMP_UI_M_ANLY_NAME_1 = COMP_UI_M_ANLY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_PAS_ANLY_CODE_2_LABEL() {
		return COMP_PAS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PAS_ANLY_CODE_2() {
		return COMP_PAS_ANLY_CODE_2;
	}

	public void setCOMP_PAS_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_PAS_ANLY_CODE_2_LABEL) {
		this.COMP_PAS_ANLY_CODE_2_LABEL = COMP_PAS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_PAS_ANLY_CODE_2(HtmlInputText COMP_PAS_ANLY_CODE_2) {
		this.COMP_PAS_ANLY_CODE_2 = COMP_PAS_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_LABEL() {
		return COMP_UI_M_ACTY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME() {
		return COMP_UI_M_ACTY_NAME;
	}

	public void setCOMP_UI_M_ACTY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL) {
		this.COMP_UI_M_ACTY_NAME_LABEL = COMP_UI_M_ACTY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME(HtmlInputText COMP_UI_M_ACTY_NAME) {
		this.COMP_UI_M_ACTY_NAME = COMP_UI_M_ACTY_NAME;
	}

	public HtmlOutputLabel getCOMP_PAS_ACTY_CODE_1_LABEL() {
		return COMP_PAS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PAS_ACTY_CODE_1() {
		return COMP_PAS_ACTY_CODE_1;
	}

	public void setCOMP_PAS_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_PAS_ACTY_CODE_1_LABEL) {
		this.COMP_PAS_ACTY_CODE_1_LABEL = COMP_PAS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_PAS_ACTY_CODE_1(HtmlInputText COMP_PAS_ACTY_CODE_1) {
		this.COMP_PAS_ACTY_CODE_1 = COMP_PAS_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_1_LABEL() {
		return COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME_1() {
		return COMP_UI_M_ACTY_NAME_1;
	}

	public void setCOMP_UI_M_ACTY_NAME_1_LABEL(HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL) {
		this.COMP_UI_M_ACTY_NAME_1_LABEL = COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText COMP_UI_M_ACTY_NAME_1) {
		this.COMP_UI_M_ACTY_NAME_1 = COMP_UI_M_ACTY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_PAS_ACTY_CODE_2_LABEL() {
		return COMP_PAS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PAS_ACTY_CODE_2() {
		return COMP_PAS_ACTY_CODE_2;
	}

	public void setCOMP_PAS_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_PAS_ACTY_CODE_2_LABEL) {
		this.COMP_PAS_ACTY_CODE_2_LABEL = COMP_PAS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_PAS_ACTY_CODE_2(HtmlInputText COMP_PAS_ACTY_CODE_2) {
		this.COMP_PAS_ACTY_CODE_2 = COMP_PAS_ACTY_CODE_2;
	}


	public PM_IL_PREM_ACCOUNT_SETUP getPM_IL_PREM_ACCOUNT_SETUP_BEAN() {
		return PM_IL_PREM_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_PREM_ACCOUNT_SETUP_BEAN(PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_PREM_ACCOUNT_SETUP_BEAN = PM_IL_PREM_ACCOUNT_SETUP_BEAN;
	}

	
	
	public void setErrorMessagesInMap(ActionEvent event){
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}
	
	public List getPM_IL_PREM_ACCOUNT_SETUP_LIST() {
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}

	public void setPM_IL_PREM_ACCOUNT_SETUP_LIST(List pm_il_prem_account_setup_list) {
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_list;
	}
	
	public int executeInsertion() throws  ValidatorException, DBException{
		String message = null;
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		//PM_IL_PREM_ACCOUNT_SETUP_PRE_INSERT(PM_IL_PREM_ACCOUNT_SETUP_BEAN);
		System.out.println("FREEZE FLAG VALUE:::"+PM_IL_PREM_ACCOUNT_SETUP_BEAN.isFRZ_FLAG());
		if(PM_IL_PREM_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false)
		{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FRZ_FLAG("N");
		}else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FRZ_FLAG("Y");
		}
		int rowsUpdated = 0;
		if(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getROWID()==null)
		{
			//[ calling pre_insert : added by: Shankar bodduluri Dated: 19-Mar-2009 ]

			PM_IL_PREM_ACCOUNT_SETUP_PRE_INSERT(PM_IL_PREM_ACCOUNT_SETUP_BEAN);
			rowsUpdated = pm_il_prem_account_setup_action_delegate.insertDocumentSetupDetails(PM_IL_PREM_ACCOUNT_SETUP_BEAN);
			if(rowsUpdated>0)
			{
				message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
			}
		}else{
			rowsUpdated = pm_il_prem_account_setup_action_delegate.insertDocumentSetupDetails(PM_IL_PREM_ACCOUNT_SETUP_BEAN);
			System.out.println("UPDATED ROWS:::"+rowsUpdated);
			if(rowsUpdated>0)
			{
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap()
						.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				getWarningMap().put("UPDATE", message);
			}
		}
		return 0;
	}
	
	/*
	 * Suggestion Box for Source of Business Range
	 */
	public List sourceBusinessRangeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String sourceBusinessRangeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareSourceBusinessRangeList(sourceBusinessRangeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Source of Business Range Upto
	 */
	public List sourceBusinessRangeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String sourceBusinessRangeUptoCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareSourceBusinessRangeUptoList(sourceBusinessRangeUptoCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Business Range.
	 */
	public List businessRangeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String businessRangeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareBusinessRangeList(businessRangeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Business Range Upto
	 */
	public List businessRangeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String businessRangeUptoCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareBusinessRangeUptoList(businessRangeUptoCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Branch Range 
	 */
	public List branchRangeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String branchRangeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareBranchRangeList(branchRangeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Branch Range Upto
	 */
	public List branchRangeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String branchRangeUptoCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareBranchRangeUptoList(branchRangeUptoCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Department Range
	 */
	public List deptRangeSuggestionAction(Object event) throws DBException , ValidatorException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		if(COMP_PAS_DIVN_FM_CODE.getValue() != null){
			String deptRangeCode = (String) event;
			String branchRange = COMP_PAS_DIVN_FM_CODE.getValue().toString();
			PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareDeptRangeList(deptRangeCode, branchRange, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		}else{
			System.out.println("Components null");
		}
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Department Range Upto.
	 */
	public List deptRangeUptoSuggestionAction(Object event) throws DBException , ValidatorException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		if(COMP_PAS_DIVN_TO_CODE.getValue() != null){
			String deptRangeUptoCode = (String) event;
			String branchRangeUpto = COMP_PAS_DIVN_TO_CODE.getValue().toString();
			PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareDeptRangeUptoList(deptRangeUptoCode, branchRangeUpto, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		}else{
			System.out.println("Components null");
		}
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Document Type Range
	 */
	public List docTypeRangeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String docTypeRangeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareDocTypeRangeList(docTypeRangeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Document Type Range Upto
	 */
	public List docTypeRangeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String docTypeRangeUptoCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareDocTypeRangeUptoList(docTypeRangeUptoCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Product Range
	 */
	public List productRangeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String productRangeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareProductRangeList(productRangeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Product Range
	 */
	public List productRangeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String productRangeUptoCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareProductRangeUptoList(productRangeUptoCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Product Range
	 */
	public List planCodeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String planCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.preparePlanCodeList(planCode, PM_IL_PREM_ACCOUNT_SETUP_LIST,this);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Product Range Upto
	 */
	public List planCodeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String planCodeUpto = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.preparePlanCodeUptoList(planCodeUpto, PM_IL_PREM_ACCOUNT_SETUP_LIST,this);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Class Range 
	 */
	public List classRangeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String classRangeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareClassRangeList(classRangeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Class Range 
	 */
	public List classRangeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String classRangeUptoCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareClassRangeUptoList(classRangeUptoCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Endorsement Range 
	 */
	public List endorsementCodeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String endorsementCode = (String) event;
		System.out.println("endorsement code:::::::"+endorsementCode);
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareEndorsementCodeList(endorsementCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Endorsement Range Upto
	 */
	public List endorsementCodeUptoSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String endorsementCodeUpto = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareEndorsementCodeUptoList(endorsementCodeUpto, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	/*
	 * Suggestion Box for Plan Type
	 */
	public List planTypeSuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String planTypeCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.preparePlanTypeCodeList(planTypeCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	public void getPlanTypeDesc(ActionEvent event) {
		if (COMP_PAS_PLAN_TYPE.getSubmittedValue() != null) {
				String planType = (String) COMP_PAS_PLAN_TYPE.getSubmittedValue();
				String planTypeDesc = getPlanTypeDescforCode(planType, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_TYPE(planType);
				COMP_UI_M_PAS_PLAN_TYPE_DESC.setSubmittedValue(planTypeDesc);
		}
	}
	
	public String getPlanTypeDescforCode(String planType, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String planTypeDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(planType.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_PLAN_TYPE()))
	 		{
	 			planTypeDesc = pm_il_prem_account_setup.getUI_M_PAS_PLAN_TYPE_DESC();
	 			System.out.println("Status Desc" +planTypeDesc);
			}
		}
		return planTypeDesc;
	}
	
	/*
	 * Suggestion Box for Main Account Code
	 */
	public  List<LovBean>  mainAccountCodeSuggestionAction(Object event) throws DBException {
		/*PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String mainAccountCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareMainAccountCodeList(mainAccountCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
					"PAS_MAIN_ACNT_CODE", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public void getMainAccountDesc(ActionEvent event) {
		UIInput input=(UIInput)event.getComponent().getParent().getParent();
		System.out.println("input.getSubmittedValue():::::::::::::::::"+input.getSubmittedValue());
		if(input.getSubmittedValue()!=null)
			{
				String mainAccountCode = (String) COMP_PAS_MAIN_ACNT_CODE.getSubmittedValue();
				String mainAccountDesc = getMainAccountDescforCode(mainAccountCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_MAIN_ACNT_CODE(mainAccountCode);
				COMP_UI_M_MAIN_ACNT_NAME.setSubmittedValue(mainAccountDesc);
		}
		else
		{
			System.out.println("INSIDE ELSE$$$$$$$$$$$$$$$$$$$$$$$$$");
			getPM_IL_PREM_ACCOUNT_SETUP_BEAN().setUI_M_MAIN_ACNT_NAME("");
			getCOMP_UI_M_MAIN_ACNT_NAME().setSubmittedValue(null);
		}
	}
	
	public String getMainAccountDescforCode(String mainAccountCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String mainAccountDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		/*if(pm_il_prem_account_setup.getPAS_MAIN_ACNT_CODE()==null || pm_il_prem_account_setup.getPAS_MAIN_ACNT_CODE().isEmpty())
	 		{
	 			System.out.println("IM INSIDE EMPTY CHECK METHOD");
	 			pm_il_prem_account_setup.setUI_M_MAIN_ACNT_NAME("");
	 		}*/
	 		if(mainAccountCode.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_MAIN_ACNT_CODE()))
	 		{
	 			mainAccountDesc = pm_il_prem_account_setup.getUI_M_MAIN_ACNT_NAME();
	 			System.out.println("Status Desc" +mainAccountDesc);
			}
		}
		return mainAccountDesc;
	}
	
	/*
	 * Suggestion Box for Sub Account Code
	 */
	public List<LovBean> subAccountCodeSuggestionAction(Object event) throws DBException {
/*		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		if(COMP_PAS_SUB_ACNT_CODE.getValue() != null){
			String subAccountCode = (String) event;
			String mainAccountCode = COMP_PAS_MAIN_ACNT_CODE.getValue().toString();
			System.out.println("1111111111111111111"+mainAccountCode);
			PM_IL_SUB_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareSubAccountCodeList(mainAccountCode, subAccountCode, PM_IL_SUB_ACCOUNT_SETUP_LIST);			
		}
*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
					"PAS_SUB_ACNT_CODE", PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_MAIN_ACNT_CODE(), null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public void getSubAccountDesc(ActionEvent event) {
		System.out.println("2222222222222222222222");
		if (COMP_PAS_SUB_ACNT_CODE.getSubmittedValue() != null) {
				String subAccountCode = (String) COMP_PAS_SUB_ACNT_CODE.getSubmittedValue();
				String subAccountDesc = getSubAccountDescforCode(subAccountCode, PM_IL_SUB_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SUB_ACNT_CODE(subAccountCode);
				COMP_UI_M_SUB_ACNT_NAME.setSubmittedValue(subAccountDesc);
		}
	}
	
	public String getSubAccountDescforCode(String subAccountCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String subAccountDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(subAccountCode.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_SUB_ACNT_CODE()))
	 		{
	 			subAccountDesc = pm_il_prem_account_setup.getUI_M_MAIN_ACNT_NAME();
	 			System.out.println("Status Desc" +subAccountDesc);
			}
		}
		return subAccountDesc;
	}
	
	/*
	 * Suggestion Box for Division Account Code
	 */
	public List<LovBean> divisionCodeSuggestionAction(Object event) throws DBException {
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			
			suggestionList = itemUtil.P_CALL_LOV("PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
					"PAS_DIVN_CODE",CommonUtils.getControlBean().getM_COMP_CODE(), null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		/*PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String divisionCode = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareDivisionCodeList(divisionCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);*/			
		return suggestionList;
	}
	
	public void getDivisionCodeDesc(ActionEvent event) {
		if (COMP_PAS_DIVN_CODE.getSubmittedValue() != null) {
				String divisionCode = (String) COMP_PAS_DIVN_CODE.getSubmittedValue();
				String divisionDesc = getDivisionDescforCode(divisionCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_CODE(divisionCode);
				COMP_UI_M_DIVN_NAME.setSubmittedValue(divisionDesc);
		}
	}
	
	public String getDivisionDescforCode(String divisionCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String divisionDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(divisionCode.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_DIVN_CODE()))
	 		{
	 			divisionDesc = pm_il_prem_account_setup.getUI_M_DIVN_NAME();
	 			System.out.println("Status Desc" +divisionDesc);
			}
		}
		return divisionDesc;
	}
	
	/*
	 * Suggestion Box for Dept Account Code
	 */
	public List<LovBean> deptCodeSuggestionAction(Object event) throws DBException {
		/*PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String divisionCode = "";
		if(COMP_PAS_DEPT_CODE.getValue() != null){
			String deptCode = (String) event;
			if(COMP_PAS_DIVN_CODE.getValue()!=null){
				divisionCode = COMP_PAS_DIVN_CODE.getValue().toString();
			}
			PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareDeptCodeList(divisionCode, deptCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);			
		}*/
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			
			suggestionList = itemUtil.P_CALL_LOV("PILM022", "PM_IL_PREM_ACCOUNT_SETUP",
					"PAS_DEPT_CODE",CommonUtils.getControlBean().getM_COMP_CODE(), PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DIVN_CODE(), null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public void getDeptCodeDesc(ActionEvent event) {
		if (COMP_PAS_DEPT_CODE.getSubmittedValue() != null) {
				String deptCode = (String) COMP_PAS_DEPT_CODE.getSubmittedValue();
				String deptDesc = getDeptDescforCode(deptCode, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_CODE(deptCode);
				COMP_UI_M_DEPT_NAME.setSubmittedValue(deptDesc);
		}
	}
	
	public String getDeptDescforCode(String deptCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String deptDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(deptCode.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_DEPT_CODE()))
	 		{
	 			deptDesc = pm_il_prem_account_setup.getUI_M_DEPT_NAME();
	 			System.out.println("Status Desc" +deptDesc);
			}
		}
		return deptDesc;
	}
	
	/*
	 * Suggestion Box for Analysis Code 1
	 */
	public List analysisCode1SuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String analysisCode1 = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareAnalysisCode1List(analysisCode1, PM_IL_PREM_ACCOUNT_SETUP_LIST);			
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	public void getAnalysisCode1Desc(ActionEvent event) {
		if (COMP_PAS_ANLY_CODE_1.getSubmittedValue() != null) {
				String analysisCode1 = (String) COMP_PAS_ANLY_CODE_1.getSubmittedValue();
				String analysisCode1Desc = getAnalysisCode1(analysisCode1, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_1(analysisCode1);
				COMP_UI_M_ANLY_NAME.setSubmittedValue(analysisCode1Desc);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(analysisCode1Desc);
		}
	}
	
	public String getAnalysisCode1(String analysisCode1, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String analysisCode1Desc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(analysisCode1.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_ANLY_CODE_1()))
	 		{
	 			analysisCode1Desc = pm_il_prem_account_setup.getUI_M_ANLY_NAME();
	 			System.out.println("Status Desc" +analysisCode1Desc);
			}
		}
		return analysisCode1Desc;
	}
	
	/*
	 * Suggestion Box for Analysis Code 2
	 */
	public List analysisCode2SuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String analysisCode2 = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareAnalysisCode2List(analysisCode2, PM_IL_PREM_ACCOUNT_SETUP_LIST);			
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	public void getAnalysisCode2Desc(ActionEvent event) {
		if (COMP_PAS_ANLY_CODE_2.getSubmittedValue() != null) {
				String analysisCode2 = (String) COMP_PAS_ANLY_CODE_2.getSubmittedValue();
				String analysisCode2Desc = getAnalysisCode2(analysisCode2, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_2(analysisCode2);
				COMP_UI_M_ANLY_NAME_2.setSubmittedValue(analysisCode2Desc);
		}
	}
	
	public String getAnalysisCode2(String analysisCode2, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String analysisCode2Desc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(analysisCode2.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_ANLY_CODE_2()))
	 		{
	 			analysisCode2Desc = pm_il_prem_account_setup.getUI_M_ANLY_NAME_1();
	 			System.out.println("Status Desc" +analysisCode2Desc);
			}
		}
		return analysisCode2Desc;
	}
	
	/*
	 * Suggestion Box for Activity Code 1
	 */
	public List activityCode1SuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String activityCode1 = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareActivityCode1List(activityCode1, PM_IL_PREM_ACCOUNT_SETUP_LIST);			
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	public void getActivityCode1Desc(ActionEvent event) {
		if (COMP_PAS_ACTY_CODE_1.getSubmittedValue() != null) {
				String activityCode1 = (String) COMP_PAS_ACTY_CODE_1.getSubmittedValue();
				String activityCode1Desc = getActivityCode1(activityCode1, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_2(activityCode1);
				COMP_UI_M_ACTY_NAME.setSubmittedValue(activityCode1Desc);
		}
	}
	
	public String getActivityCode1(String activityCode1, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String activityCode1Desc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(activityCode1.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_ACTY_CODE_1()))
	 		{
	 			activityCode1Desc = pm_il_prem_account_setup.getUI_M_ACTY_NAME();
	 			System.out.println("Status Desc" +activityCode1Desc);
			}
		}
		return activityCode1Desc;
	}
	
	/*
	 * Suggestion Box for Activity Code 2
	 */
	public List activityCode2SuggestionAction(Object event) throws DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		String activityCode2 = (String) event;
		PM_IL_PREM_ACCOUNT_SETUP_LIST = pm_il_prem_account_setup_action_delegate.prepareActivityCode2List(activityCode2, PM_IL_PREM_ACCOUNT_SETUP_LIST);			
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	public void getActivityCode2Desc(ActionEvent event) {
		if (COMP_PAS_ACTY_CODE_2.getSubmittedValue() != null) {
				String activityCode2 = (String) COMP_PAS_ACTY_CODE_2.getSubmittedValue();
				String activityCode2Desc = getActivityCode2(activityCode2, PM_IL_PREM_ACCOUNT_SETUP_LIST);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_2(activityCode2);
				COMP_UI_M_ACTY_NAME_1.setSubmittedValue(activityCode2Desc);
		}
	}
	
	public String getActivityCode2(String activityCode2, List PM_IL_PREM_ACCOUNT_SETUP_LIST)
	 {
		Iterator iterator = PM_IL_PREM_ACCOUNT_SETUP_LIST.iterator();
		String activityCode2Desc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = (PM_IL_PREM_ACCOUNT_SETUP) iterator.next();
	 		if(activityCode2.equalsIgnoreCase(pm_il_prem_account_setup.getPAS_ACTY_CODE_2()))
	 		{
	 			activityCode2Desc = pm_il_prem_account_setup.getUI_M_ACTY_NAME_1();
	 			System.out.println("Status Desc" +activityCode2Desc);
			}
		}
		return activityCode2Desc;
	}
	
	/*
	 * Conversion of Triggers.
	 */
	/*
	 * Source to Business Range
	 */
	public void actionListenerPAS_SRC_BUS_FM(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_SRC_BUS_FM().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SRC_BUS_FM("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SRC_BUS_FM(inputValue);
		}
	}
	
	/*
	 * Source to Business Range Upto
	 */
	public void actionListenerPAS_SRC_BUS_TO(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_SRC_BUS_FM.getSubmittedValue().equals("0"))
			{
				COMP_PAS_SRC_BUS_TO.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_SRC_BUS_FM());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SRC_BUS_TO(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_SRC_BUS_FM());
			}else{
				COMP_PAS_SRC_BUS_TO.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SRC_BUS_TO(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SRC_BUS_TO(inputTextString);
		}
	}
	
	public void validatePAS_SRC_BUS_TO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_SRC_BUS_TO_STRING = (String)input.getSubmittedValue();
		String PAS_SRC_BUS_FM_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_SRC_BUS_FM();
		if(PAS_SRC_BUS_FM_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80033"));			
		}
		if((PAS_SRC_BUS_TO_STRING.compareToIgnoreCase(PAS_SRC_BUS_FM_STRING)) < 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80034"));	
		}
	}
	
	/*
	 * Business Range
	 */
	public void actionListenerPAS_BUS_FM_CODE(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_BUS_FM_CODE().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_BUS_FM_CODE("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_BUS_FM_CODE(inputValue);
		}
	}
	
	/*
	 * Business Range Upto
	 */
	public void actionListenerPAS_BUS_TO_CODE(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString = (String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_BUS_FM_CODE.getSubmittedValue().equals("0"))
			{
				COMP_PAS_BUS_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_BUS_FM_CODE());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_BUS_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_BUS_FM_CODE());
			}else{
				COMP_PAS_BUS_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_BUS_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_BUS_TO_CODE(inputTextString);
		}
	}
	
	public void validatePAS_BUS_TO_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_BUS_TO_CODE_STRING = (String)input.getSubmittedValue();
		String PAS_BUS_FM_CODE_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_BUS_FM_CODE();
		if(PAS_BUS_FM_CODE_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80033"));			
		}
		if((PAS_BUS_TO_CODE_STRING.compareToIgnoreCase(PAS_BUS_FM_CODE_STRING)) < 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80034"));	
		}
	}
	
	/*
	 * Branch Range
	 */
	public void actionListenerPAS_DIVN_FM_CODE(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_DIVN_FM_CODE().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_FM_CODE("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_FM_CODE(inputValue);
		}
	}
	
	/*
	 * Branch Range Upto
	 */
	public void actionListenerPAS_DIVN_TO_CODE(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString = (String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_DIVN_FM_CODE.getSubmittedValue().equals("0"))
			{
				COMP_PAS_DIVN_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DIVN_FM_CODE());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DIVN_FM_CODE());
			}else{
				COMP_PAS_DIVN_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_TO_CODE(inputTextString);
		}
	}
	
	public void validatePAS_DIVN_TO_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_DIVN_TO_CODE_STRING = (String)input.getSubmittedValue();
		String PAS_DIVN_FM_CODE_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DIVN_FM_CODE();
		if(PAS_DIVN_FM_CODE_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80033"));			
		}
		if((PAS_DIVN_TO_CODE_STRING.compareToIgnoreCase(PAS_DIVN_FM_CODE_STRING)) < 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80034"));	
		}
	}
	
	/*
	 * Department Range
	 */
	public void actionListenerPAS_DEPT_FM_CODE(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_DEPT_FM_CODE().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_FM_CODE("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_FM_CODE(inputValue);
		}
	}
	
	/*
	 * Department Range Upto
	 */
	public void actionListenerPAS_DEPT_TO_CODE(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString = (String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_DEPT_FM_CODE.getSubmittedValue().equals("0"))
			{
				COMP_PAS_DEPT_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DEPT_FM_CODE());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DEPT_FM_CODE());
			}else{
				COMP_PAS_DEPT_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_TO_CODE(inputTextString);
		}
	}
	
	public void validatePAS_DEPT_TO_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_DEPT_TO_CODE_STRING = (String)input.getSubmittedValue();
		String PAS_DEPT_FM_CODE_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DEPT_FM_CODE();
		if(PAS_DEPT_FM_CODE_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80033"));			
		}
		if((PAS_DEPT_TO_CODE_STRING.compareToIgnoreCase(PAS_DEPT_FM_CODE_STRING)) < 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80034"));	
		}
	}
	
	/*
	 * Document Type Range
	 */
	public void actionListenerPAS_DOC_FM_TYPE(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_DOC_FM_TYPE().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DOC_FM_TYPE("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DOC_FM_TYPE(inputValue);
		}
	}
	
	/*
	 * Document Range Upto
	 */
	public void actionListenerPAS_DOC_TO_TYPE(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString = (String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_DOC_FM_TYPE.getSubmittedValue().equals("0"))
			{
				COMP_PAS_DOC_TO_TYPE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DOC_FM_TYPE());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DOC_TO_TYPE(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DOC_FM_TYPE());
			}else{
				COMP_PAS_DOC_TO_TYPE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DOC_TO_TYPE(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DOC_TO_TYPE(inputTextString);
		}
	}
	
	public void validatePAS_DOC_TO_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_DOC_TO_TYPE_STRING = (String)input.getSubmittedValue();
		String PAS_DOC_FM_TYPE_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DOC_FM_TYPE();
		if(PAS_DOC_FM_TYPE_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80033"));			
		}
		if((PAS_DOC_TO_TYPE_STRING.compareToIgnoreCase(PAS_DOC_FM_TYPE_STRING)) < 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80034"));	
		}
	}
	
	/*
	 * Product Range
	 */
	public void actionListenerPAS_PROD_CODE_FM(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_PROD_CODE_FM().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PROD_CODE_FM("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PROD_CODE_FM(inputValue);
		}
	}
	
	/*
	 * Product Range Upto
	 */
	public void actionListenerPAS_PROD_CODE_TO(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString = (String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_PROD_CODE_FM.getSubmittedValue().equals("0"))
			{
				COMP_PAS_PROD_CODE_TO.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_PROD_CODE_FM());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PROD_CODE_TO(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_PROD_CODE_FM());
			}else{
				COMP_PAS_PROD_CODE_TO.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PROD_CODE_TO(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PROD_CODE_TO(inputTextString);
		}
	}
	
	public void validatePAS_PROD_CODE_TO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_PROD_CODE_TO_STRING = (String)input.getSubmittedValue();
		String PAS_PROD_CODE_FM_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_FM();
		if(PAS_PROD_CODE_FM_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80033"));			
		}
		if((PAS_PROD_CODE_TO_STRING.compareToIgnoreCase(PAS_PROD_CODE_FM_STRING)) < 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80034"));	
		}
	}
	
	/*
	 * Cover Range
	 */
	public void actionListenerPAS_PLAN_CODE_FM(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_PLAN_CODE_FM().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_CODE_FM("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_CODE_FM(inputValue);
		}
	}

	/*
	 * Cover Range Upto
	 */
	public void actionListenerPAS_PLAN_CODE_TO(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			if(!COMP_PAS_PLAN_CODE_FM.getSubmittedValue().equals("0"))
			{
				getCOMP_PAS_PLAN_CODE_TO().setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_PLAN_CODE_FM());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_CODE_TO(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_PLAN_CODE_FM());
			}else{
				getCOMP_PAS_PLAN_CODE_TO().setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_CODE_TO(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_CODE_TO(inputValue);
		}
	}
	
	/*
	 * Customer Class Range
	 */
	public void actionListenerPAS_CUST_CLS_FM_CODE(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_CUST_CLS_FM_CODE().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_CUST_CLS_FM_CODE("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_CUST_CLS_FM_CODE(inputValue);
		}
	}
	
	/*
	 * Customer Class Range Upto
	 */
	public void actionListenerPAS_CUST_CLS_TO_CODE(ActionEvent actionEvent) 
	{
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			if(!COMP_PAS_CUST_CLS_FM_CODE.getSubmittedValue().equals("0"))
			{
				getCOMP_PAS_CUST_CLS_TO_CODE().setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_CUST_CLS_FM_CODE());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_CUST_CLS_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_CUST_CLS_FM_CODE());
			}else{
				getCOMP_PAS_CUST_CLS_TO_CODE().setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_CUST_CLS_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_CODE_TO(inputValue);
		}
		
		//setErrorMessagesInMap(actionEvent);
	}
	
	/*
	 * First Premium Flag
	 */
	public void actionListenerPAS_FIRST_PREM_YN(ActionEvent actionEvent)
	{
		HtmlSelectOneMenu htmlInputText = (HtmlSelectOneMenu)actionEvent.getComponent().getParent();
		String PAS_FIRST_PREM_YN_STRING = (String)htmlInputText.getSubmittedValue();
		if("Y".equalsIgnoreCase(PAS_FIRST_PREM_YN_STRING)){
			COMP_PAS_PLAN_YRS_FM.setSubmittedValue("1");
			COMP_PAS_PLAN_YRS_FM.setReadonly(true);
			COMP_PAS_PLAN_YRS_TO.setSubmittedValue("1");
			COMP_PAS_PLAN_YRS_TO.setReadonly(true);
		}else{
			COMP_PAS_PLAN_YRS_FM.setReadonly(false);
			COMP_PAS_PLAN_YRS_TO.setReadonly(false);
		}
	}
	
	/*
	 * NB/END Flag
	 */
	public void actionListenerPAS_NB_END_FLAG(ActionEvent actionEvent)
	{
		HtmlSelectOneMenu htmlSelectOneMenu = (HtmlSelectOneMenu)actionEvent.getComponent().getParent();
		String PAS_NB_PREM_ACCOUNT_STRING = (String)htmlSelectOneMenu.getSubmittedValue();
		if("N".equalsIgnoreCase(PAS_NB_PREM_ACCOUNT_STRING)){
			COMP_PAS_END_FM_CODE.setSubmittedValue(null);
			COMP_PAS_END_FM_CODE.setDisabled(true);
			COMP_PAS_END_TO_CODE.setSubmittedValue(null);
			COMP_PAS_END_TO_CODE.setDisabled(true);
		}else{
			COMP_PAS_END_FM_CODE.setDisabled(false);
			COMP_PAS_END_FM_CODE.setReadonly(false);
			COMP_PAS_END_FM_CODE.setRequired(true);
			//COMP_PAS_END_FM_CODE.setSubmittedValue("");
			COMP_PAS_END_TO_CODE.setDisabled(false);
			COMP_PAS_END_TO_CODE.setReadonly(false);
			COMP_PAS_END_TO_CODE.setRequired(true);
			//COMP_PAS_END_TO_CODE.setSubmittedValue("");
		}
	}
	
	/*
	 * Endorsement Code
	 */
	public void actionListenerPAS_END_FM_CODE(ActionEvent actionEvent)
	{
		
		
		HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputValue = (String)htmlInputText.getSubmittedValue();
		if(inputValue.isEmpty()){
			getCOMP_PAS_END_FM_CODE().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_FM_CODE("0");
		}
		else{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_FM_CODE(inputValue);
		}
		/*UIInput input = (UIInput) component;
		String PAS_END_FM_CODE_STRING = (String)input.getSubmittedValue();
		String PAS_END_TO_CODE_STRING = getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_FM_CODE(PAS_END_FM_CODE_STRING);
		ArrayList endorsementArraylist = pm_il_prem_account_setup_action_delegate.endorsementCodeQuery(PAS_END_FM_CODE_STRING);
		if(endorsementArraylist.size() == 0){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80378"));	
		}
		
		if(PAS_END_FM_CODE_STRING != null && PAS_END_TO_CODE_STRING!= null){
			if((PAS_END_TO_CODE_STRING.compareToIgnoreCase(PAS_END_FM_CODE_STRING)) < 0){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91054"));	
			}
		}*/
	}
	
	
	
	/*
	 * Endorsement Code Upto
	 */
	public void actionListenerPAS_END_TO_CODE(ActionEvent actionEvent)
	{
		
		
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		if(inputTextString == "")
		{
			if(!COMP_PAS_END_FM_CODE.getSubmittedValue().equals("0"))
			{
				COMP_PAS_END_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_END_FM_CODE());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_END_FM_CODE());
			}else{
				COMP_PAS_END_TO_CODE.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_TO_CODE(PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM023$PM_IL_PREM_ACCOUNTS$DEFAULT_ZZZZZZ);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_TO_CODE(inputTextString);
		}
		/*UIInput input = (UIInput) component;
		String PAS_END_FM_CODE_STRING = null;
		String PAS_END_TO_CODE_STRING = (String)input.getSubmittedValue();
		if(COMP_PAS_END_FM_CODE.getValue() != null){
			PAS_END_FM_CODE_STRING = COMP_PAS_END_FM_CODE.getValue().toString();			
		}
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_TO_CODE(PAS_END_TO_CODE_STRING);
		
		if(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE() == null){
			COMP_PAS_END_FM_CODE.setValue(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE());
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_FM_CODE(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE());
		}
		
		if(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE() == null){
			COMP_PAS_END_TO_CODE.setSubmittedValue(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE());
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_END_TO_CODE(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE());
		}
		
		if(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE() != null){
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
			ArrayList endorsementArraylist = pm_il_prem_account_setup_action_delegate.endorsementCodeQuery(PAS_END_TO_CODE_STRING);
			if(endorsementArraylist.size() == 0){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80378"));	
			}
		}
		
		if(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE() != null && getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE() != null){
			if((getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE().compareToIgnoreCase(getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE())) < 0){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91054"));	
			}
		}*/
	}
	
	/*
	 * Plan Years
	 */
	public void validatePAS_PLAN_YRS_FM(ActionEvent actionEvent)
	{
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String PAS_PLAN_YRS_FM_STRING = (String)input.getSubmittedValue();
		
		if(PAS_PLAN_YRS_FM_STRING.isEmpty()){
			getCOMP_PAS_PLAN_YRS_FM().setSubmittedValue("0");
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_FM(0);
		}else{
			int PAS_PLAN_YRS_FM_DOUBLE = Integer.parseInt(PAS_PLAN_YRS_FM_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_FM(PAS_PLAN_YRS_FM_DOUBLE);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			try {
				pm_il_prem_account_setup_action_helper
						.PAS_PLAN_YRS_FM_WHEN_VALIDATE_ITEM(
								PAS_PLAN_YRS_FM_DOUBLE, this);
			} catch (ValidatorException e) {
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("somekey", e.getMessage());
			}			
		}
		
		/*if(PAS_PLAN_YRS_FM_STRING != null){
			Double PAS_PLAN_YRS_FM_DOUBLE = Double.parseDouble(PAS_PLAN_YRS_FM_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_FM(PAS_PLAN_YRS_FM_DOUBLE);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_PLAN_YRS_FM_WHEN_VALIDATE_ITEM(PAS_PLAN_YRS_FM_DOUBLE, this);			
		}*/
	}
	
	/*
	 * Plan Years To
	 */
	public void validatePAS_PLAN_YRS_TO(ActionEvent actionEvent)
	{
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String PAS_PLAN_YRS_TO_STRING = (String)input.getSubmittedValue();
		
		
		if(PAS_PLAN_YRS_TO_STRING == "")
		{
			if(!COMP_PAS_PLAN_YRS_FM.getSubmittedValue().equals("0"))
			{
				COMP_PAS_PLAN_YRS_TO.setSubmittedValue(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_PLAN_YRS_FM());
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_TO(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_PLAN_YRS_FM());
			}else{
				COMP_PAS_PLAN_YRS_TO.setSubmittedValue("99");
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_TO(99);
			}
		}else{
			setErrorMessagesInMap(actionEvent);
			int PAS_PLAN_YRS_TO_DOUBLE = Integer.parseInt(PAS_PLAN_YRS_TO_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_TO(PAS_PLAN_YRS_TO_DOUBLE);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			try {
				pm_il_prem_account_setup_action_helper
						.PAS_PLAN_YRS_TO_WHEN_VALIDATE_ITEM(PAS_PLAN_YRS_TO_DOUBLE, this);
			} catch (ValidatorException e) {
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("somekey", e.getMessage());
			}			
		}
		
		
		
		/*if(PAS_PLAN_YRS_TO_STRING != null){
			Double PAS_PLAN_YRS_TO_DOUBLE = Double.parseDouble(PAS_PLAN_YRS_TO_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_PLAN_YRS_TO(PAS_PLAN_YRS_TO_DOUBLE);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_PLAN_YRS_TO_WHEN_VALIDATE_ITEM(PAS_PLAN_YRS_TO_DOUBLE, this);			
		}*/
	}
	
	/*
	 * Assured Type
	 */
	public void validatePAS_ASSURED_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_ASSURED_TYPE_STRING = (String)input.getSubmittedValue();
		if(PAS_ASSURED_TYPE_STRING == null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91022"));	
		}
	}
	
	/*
	 * Force Branch Y/N
	 */
	public void validatePAS_FORCE_DIVN_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_ASSURED_TYPE_STRING = (String)input.getSubmittedValue();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
		pm_il_prem_account_setup_action_helper.PAS_FORCE_DIVN_YN_WHEN_VALIDATE_ITEM(PAS_ASSURED_TYPE_STRING, this);
	}
	
	/*
	 * Force Department Y/N
	 */
	public void validatePAS_FORCE_DEPT_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String PAS_FORCE_DEPT_STRING = (String)input.getSubmittedValue();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
		pm_il_prem_account_setup_action_helper.PAS_FORCE_DEPT_YN_WHEN_VALIDATE_ITEM(PAS_FORCE_DEPT_STRING, this);
	}
	
	/*
	 * Main Account 
	 */
	public void actionListenerPAS_MAIN_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) {
			setErrorMessages("");
			if(getErrorMap()!=null){
				getErrorMap().clear();
			}
		try{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_MAIN_ACNT_CODE(value!=null ? value.toString() : "");
			//HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
			//String PAS_MAIN_ACNT_CODE_STRING = htmlInputText.getSubmittedValue().toString();
			String PAS_MAIN_ACNT_CODE_STRING = value!=null ? value.toString() : "";
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_MAIN_ACNT_CODE_WHEN_VALIDATE_ITEM(this,PAS_MAIN_ACNT_CODE_STRING);
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/*
	 * Main Account 
	 */
	public void actionListenerPAS_MAIN_ACNT_CODE_HELPER(ActionEvent event) {
			setErrorMessages("");
			if(getErrorMap()!=null){
				getErrorMap().clear();
			}
			String value = getCurrentValue(event);
			try {
				if (value != null && !value.isEmpty()) {
					fireFieldValidation(event);
				}else{
					COMP_UI_M_MAIN_ACNT_NAME.setSubmittedValue(null);
					COMP_UI_M_MAIN_ACNT_NAME.setValue("");
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(null);
					COMP_UI_M_MAIN_ACNT_NAME.resetValue();
				}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/*
	 * Sub Account 
	 */
	public void actionListenerPAS_SUB_ACNT_CODE(FacesContext context,
			UIComponent component, Object value)  {
			setErrorMessages("");
			if(getErrorMap()!=null){
				getErrorMap().clear();
			}
		try{
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_SUB_ACNT_CODE(value!=null ? value.toString() : "");
			//HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
			//String PAS_MAIN_ACNT_CODE_STRING = htmlInputText.getSubmittedValue().toString();
			//String PAS_MAIN_ACNT_CODE_STRING = value!=null ? value.toString() : "";
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_SUB_ACCT_WHEN_VALIDATE_ITEM(this);
			
		}catch(ValidatorException exception){
			throw exception;
		}catch(Exception exception1){
			throw new ValidatorException(new FacesMessage(exception1.getMessage()));
		}finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	//	}
	//}
	}
	
	/*
	 * Sub Account 
	 */
	public void actionListenerPAS_SUB_ACNT_CODE_HELPER(ActionEvent event) {
			setErrorMessages("");
			if(getErrorMap()!=null){
				getErrorMap().clear();
			}
			String value = getCurrentValue(event);
			
			try {
				if (value != null && !value.isEmpty()) {
					fireFieldValidation(event);
					//String PAS_MAIN_ACNT_CODE_STRING = event!=null ? event.toString() : "";
				//	PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
					//pm_il_prem_account_setup_action_helper.PAS_SUB_ACCT_WHEN_VALIDATE_ITEM(this);
				}else{
					COMP_UI_M_SUB_ACNT_NAME.setSubmittedValue(null);
					COMP_UI_M_SUB_ACNT_NAME.setValue("");
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
					COMP_UI_M_SUB_ACNT_NAME.resetValue();
				}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	
	/*
	 * Branch Code 
	 */
	public void actionListenerPAS_DIVN_CODE(FacesContext fc, UIComponent component,
			Object value){
		try{
			/*HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
			String PAS_DIVN_CODE_STRING = (String) htmlInputText.getSubmittedValue();*/
			String PAS_DIVN_CODE_STRING = value!=null ? value.toString() : "";
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DIVN_CODE(PAS_DIVN_CODE_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_DIVN_CODE_WHEN_VALIDATE_ITEM(PAS_DIVN_CODE_STRING, this);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), fc,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	/*
	 * Empty--Branch Code 
	 */
	public void actionListenerPAS_DIVN_CODE(ActionEvent event){
		setErrorMessages("");
		if(getErrorMap()!=null){
			getErrorMap().clear();
		}
		String value = getCurrentValue(event);
		
		try {
			if (value != null && !value.isEmpty()) {
				fireFieldValidation(event);
				//String PAS_MAIN_ACNT_CODE_STRING = event!=null ? event.toString() : "";
				/*PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
				pm_il_prem_account_setup_action_helper.PAS_SUB_ACCT_WHEN_VALIDATE_ITEM(this);*/
			}else{
				COMP_UI_M_DIVN_NAME.setSubmittedValue(null);
				COMP_UI_M_DIVN_NAME.setValue("");
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(null);
				COMP_UI_M_DIVN_NAME.resetValue();
			}
		
	}catch(Exception exception){
		throw new ValidatorException(new FacesMessage(exception.getMessage()));
	}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * Department Code 
	 */
	public void validatePAS_DEPT_CODE(FacesContext fc, UIComponent component,
			Object value){
		try{
			UIInput input = (UIInput) component;
			String PAS_DEPT_CODE_STRING = (String)input.getSubmittedValue();
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_DEPT_CODE(PAS_DEPT_CODE_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();

			if(!"*".equalsIgnoreCase(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DEPT_CODE()) 
					&& PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DEPT_CODE()!=null){
				pm_il_prem_account_setup_action_helper.validatePAS_DEPT_CODE(this);
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/*
	 * Empty-Department Code 
	 */
	public void validatePAS_DEPT_CODE(ActionEvent event){
		setErrorMessages("");
		if(getErrorMap()!=null){
			getErrorMap().clear();
		}
		String value = getCurrentValue(event);
		
		try {
			if (value != null && !value.isEmpty()) {
				fireFieldValidation(event);
				//String PAS_MAIN_ACNT_CODE_STRING = event!=null ? event.toString() : "";
			//	PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
				//pm_il_prem_account_setup_action_helper.PAS_SUB_ACCT_WHEN_VALIDATE_ITEM(this);
			}else{
				COMP_UI_M_DEPT_NAME.setSubmittedValue(null);
				COMP_UI_M_DEPT_NAME.setValue("");
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(null);
				COMP_UI_M_DEPT_NAME.resetValue();
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}	
	}
	
	/*
	 * Analysis Code 1
	 */
	public void actionListenerPAS_ANLY_CODE_1(FacesContext fc, UIComponent component,
			Object value){
		try{
			setErrorMessages(null);
			if(getErrorMap()!=null){
				getErrorMap().clear();
			}
			//HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
			//String PAS_ANLY_CODE_1_STRING = htmlInputText.getSubmittedValue().toString();
			String PAS_ANLY_CODE_1_STRING = value!=null ? value.toString() : "";
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_1(PAS_ANLY_CODE_1_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_ANLY_CODE_1_WHEN_VALIDATE_ITEM(PAS_ANLY_CODE_1_STRING, this);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	
	
	public void actionListenerPAS_ANLY_CODE_1(ActionEvent event){
		String value = getCurrentValue(event);
		try {
			if (value != null && !value.isEmpty()) {
				fireFieldValidation(event);
			}else{
				COMP_UI_M_ANLY_NAME.setSubmittedValue(null);
				COMP_UI_M_ANLY_NAME.setValue("");
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME("");
				COMP_UI_M_ANLY_NAME.resetValue();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	/*	try{
			setErrorMessages(null);
			if(getErrorMap()!=null){
				getErrorMap().clear();
			}
			//HtmlInputText htmlInputText = (HtmlInputText)actionEvent.getComponent().getParent();
			//String PAS_ANLY_CODE_1_STRING = htmlInputText.getSubmittedValue().toString();
			String PAS_ANLY_CODE_1_STRING = value!=null ? value.toString() : "";
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_1(PAS_ANLY_CODE_1_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_ANLY_CODE_1_WHEN_VALIDATE_ITEM(PAS_ANLY_CODE_1_STRING, this);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}*/
	}

	
	/*
	 * Analysis Code 2
	 */
	public void validatePAS_ANLY_CODE_2(FacesContext fc, UIComponent component,
			Object value)
	{
		try{
			String PAS_ANLY_CODE_2_STRING = value!=null ? value.toString() : "";
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ANLY_CODE_1(PAS_ANLY_CODE_2_STRING);
			COMP_PAS_ANLY_CODE_1.setSubmittedValue(PAS_ANLY_CODE_2_STRING);
		//	String PAS_ANLY_CODE_2_STRING = (String)input.getSubmittedValue();
			//String PAS_ANLY_CODE_1_STRING = PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_ANLY_CODE_1();
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_ANLY_CODE_2_WHEN_VALIDATE_ITEM(PAS_ANLY_CODE_2_STRING, this);
			
			/*if(PAS_ANLY_CODE_2_STRING == null){
				throw new ValidatorException(Messages.getMessage("messageProperties_PILM022","PILM022$PM_IL_PREM_ACCOUNT_SETUP$ACTIVITY_CODE_2"));	
			}*/
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	public void validatePAS_ANLY_CODE_2(ActionEvent event){
		String value = getCurrentValue(event);
		try {
			if (value != null && !value.isEmpty()) {
				fireFieldValidation(event);
			}else{
				COMP_UI_M_ANLY_NAME_1.setSubmittedValue(null);
				COMP_UI_M_ANLY_NAME_1.setValue("");
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1("");
				COMP_UI_M_ANLY_NAME_1.resetValue();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		
	/*
	 * Activity Code 1
	 */
	public void validatePAS_ACTY_CODE_1(FacesContext fc, UIComponent component,
			Object value) 
	{
		try{
			UIInput input = (UIInput) component;
			String PAS_ACTY_CODE_1_STRING = (String)input.getSubmittedValue();
			COMP_PAS_ACTY_CODE_1.setSubmittedValue(PAS_ACTY_CODE_1_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ACTY_CODE_1(PAS_ACTY_CODE_1_STRING);
			
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_ACTY_CODE_1_WHEN_VALIDATE_ITEM(this,PAS_ACTY_CODE_1_STRING, this);
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	
	/*
	 * Activity Code 1
	 */
	public void validatePAS_ACTY_CODE_2(FacesContext fc, UIComponent component,
			Object value) 
	{
		try{
			UIInput input = (UIInput) component;
			String PAS_ACTY_CODE_2_STRING = (String)input.getSubmittedValue();
			COMP_PAS_ACTY_CODE_2.setSubmittedValue(PAS_ACTY_CODE_2_STRING);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ACTY_CODE_2(PAS_ACTY_CODE_2_STRING);
			
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
			pm_il_prem_account_setup_action_helper.PAS_ACTY_CODE_2_WHEN_VALIDATE_ITEM(this,PAS_ACTY_CODE_2_STRING);
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	/*
	 * Empty Activity Code 1
	 */
	public void validatePAS_ACTY_CODE_1(ActionEvent event) 
	{
		try{
			String value = getCurrentValue(event);
			if (value != null && !value.isEmpty()) {
				fireFieldValidation(event);
				/*String PAS_ACTY_CODE_1_STRING = value;
				COMP_PAS_ACTY_CODE_1.setSubmittedValue(PAS_ACTY_CODE_1_STRING);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ACTY_CODE_1(PAS_ACTY_CODE_1_STRING);
				
				PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
				pm_il_prem_account_setup_action_helper.PAS_ACTY_CODE_1_WHEN_VALIDATE_ITEM(this,PAS_ACTY_CODE_1_STRING, this);*/
			}else{
				COMP_UI_M_ACTY_NAME.setSubmittedValue(null);
				COMP_UI_M_ACTY_NAME.setValue(null);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME("");
				COMP_UI_M_ACTY_NAME.resetValue();
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	
	
	
	/*
	 * Empty Activity Code 1
	 */
	public void validatePAS_ACTY_CODE_2(ActionEvent event) 
	{
		try{
			String value = getCurrentValue(event);
			if (value != null && !value.isEmpty()) {
				fireFieldValidation(event);
				/*String PAS_ACTY_CODE_1_STRING = value;
				COMP_PAS_ACTY_CODE_1.setSubmittedValue(PAS_ACTY_CODE_1_STRING);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ACTY_CODE_1(PAS_ACTY_CODE_1_STRING);
				
				PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER pm_il_prem_account_setup_action_helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
				pm_il_prem_account_setup_action_helper.PAS_ACTY_CODE_1_WHEN_VALIDATE_ITEM(this,PAS_ACTY_CODE_1_STRING, this);*/
			}else{
				COMP_UI_M_ACTY_NAME_1.setSubmittedValue(null);
				COMP_UI_M_ACTY_NAME_1.setValue(null);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1("");
				COMP_UI_M_ACTY_NAME_1.resetValue();
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/*
	 * Pre-Insert Query
	 */
	public void PM_IL_PREM_ACCOUNT_SETUP_PRE_INSERT(PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup) throws ValidatorException, DBException {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		try {
			//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
			pm_il_prem_account_setup.setPAS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			pm_il_prem_account_setup.setPAS_CR_DT(new CommonUtils().getCurrentDate());
			ArrayList overLapArrayList = pm_il_prem_account_setup_action_delegate.L_OVERLAP_CHECK(this);
			System.out.println("overLapArrayList.size()  ))))))))))  "+overLapArrayList.size());
			if(overLapArrayList.size() > 0){
				System.out.println("Inside ~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#");
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"80031").getDetail());
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80031"));
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WHEN_CREATE_RECORD()
	{
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FORCE_DIVN_YN("N");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FORCE_DEPT_YN("N");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FIRST_PREM_YN("N");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ASSURED_TYPE("R");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_NB_END_FLAG("N");
		HtmlInputText END_CODE_FM = new HtmlInputText();
		END_CODE_FM.setDisabled(true);
		setCOMP_PAS_END_FM_CODE(END_CODE_FM);
		
		HtmlInputText END_CODE_TO = new HtmlInputText();
		END_CODE_TO.setDisabled(true);
		setCOMP_PAS_END_TO_CODE(END_CODE_TO);
		
	}

	public List getPM_IL_SUB_ACCOUNT_SETUP_LIST() {
		return PM_IL_SUB_ACCOUNT_SETUP_LIST;
	}

	public void setPM_IL_SUB_ACCOUNT_SETUP_LIST(List pm_il_sub_account_setup_list) {
		PM_IL_SUB_ACCOUNT_SETUP_LIST = pm_il_sub_account_setup_list;
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
		}
		return connection;
	}

	/**
	 * @param pas_first_prem_yn_arraylist the pAS_FIRST_PREM_YN_ARRAYLIST to set
	 */
	public void setPAS_FIRST_PREM_YN_ARRAYLIST(
			List<SelectItem> pas_first_prem_yn_arraylist) {
		PAS_FIRST_PREM_YN_ARRAYLIST = pas_first_prem_yn_arraylist;
	}

	/**
	 * @return the pAS_FIRST_PREM_YN_ARRAYLIST
	 */
	public List<SelectItem> getPAS_FIRST_PREM_YN_ARRAYLIST() {
		return PAS_FIRST_PREM_YN_ARRAYLIST;
	}





	/**
	 * @return the cOMP_UI_M_ANLY_NAME_2
	 */
	public HtmlInputText getCOMP_UI_M_ANLY_NAME_2() {
		return COMP_UI_M_ANLY_NAME_2;
	}





	/**
	 * @param comp_ui_m_anly_name_2 the cOMP_UI_M_ANLY_NAME_2 to set
	 */
	public void setCOMP_UI_M_ANLY_NAME_2(HtmlInputText comp_ui_m_anly_name_2) {
		COMP_UI_M_ANLY_NAME_2 = comp_ui_m_anly_name_2;
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	public void validatePlanType(ActionEvent actionEvent){
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String planType = (String)input.getSubmittedValue();
		if(planType==null || "".equalsIgnoreCase(planType)){
			COMP_UI_M_PAS_PLAN_TYPE_DESC.setSubmittedValue(null);
			COMP_UI_M_PAS_PLAN_TYPE_DESC.setValue(null);
			PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_PAS_PLAN_TYPE_DESC(null);
			COMP_UI_M_PAS_PLAN_TYPE_DESC.resetValue();
		}
	}
	
	public void beforePhase(PhaseEvent event){
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER helper = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER();
		try {
			if(isBlockFlag()){
				if(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getROWID() != null){
					executeSelectStatement();
					helper.postQuery(this, PM_IL_PREM_ACCOUNT_SETUP_BEAN);
				}else{
					helper.whenCreateRecord(this);
				}
					helper.whenNewRecordInstance(this, PM_IL_PREM_ACCOUNT_SETUP_BEAN);
					setBlockFlag(false);
				}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	private boolean update = false;
	
	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public void executeSelectStatement() throws Exception{
		String selectQuery = "SELECT ROWID, PM_IL_PREM_ACCOUNT_SETUP.* from PM_IL_PREM_ACCOUNT_SETUP " +
				" WHERE ROWID='"+PM_IL_PREM_ACCOUNT_SETUP_BEAN.getROWID()+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_PREM_ACCOUNT_SETUP> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM022.PM_IL_PREM_ACCOUNT_SETUP", 
					con);
			setPM_IL_PREM_ACCOUNT_SETUP_BEAN(list.get(0));
			setUpdate(true);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public String backToSearch(){
		return "PILM022";
	}
}
