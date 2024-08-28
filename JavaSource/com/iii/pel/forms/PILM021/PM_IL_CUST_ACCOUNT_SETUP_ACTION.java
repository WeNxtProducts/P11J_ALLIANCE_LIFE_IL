package com.iii.pel.forms.PILM021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PM068_A.PM_NUMBER_GEN_SETUP;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;


public class PM_IL_CUST_ACCOUNT_SETUP_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_CAS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_CAS_FRZ_FLAG;
	
	private HtmlOutputLabel COMP_CAS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_CAS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_CAS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_CAS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_CAS_CUST_FM_CLASS_LABEL;

	private HtmlInputText COMP_CAS_CUST_FM_CLASS;

	private HtmlOutputLabel COMP_CAS_CUST_TO_CLASS_LABEL;

	private HtmlInputText COMP_CAS_CUST_TO_CLASS;

	private HtmlOutputLabel COMP_CAS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_CAS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_CAS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_CAS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_CAS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_CAS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_CAS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_CAS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_CAS_BUS_TYPE_FM_LABEL;

	private HtmlInputText COMP_CAS_BUS_TYPE_FM;

	private HtmlOutputLabel COMP_CAS_BUS_TYPE_TO_LABEL;

	private HtmlInputText COMP_CAS_BUS_TYPE_TO;

	private HtmlOutputLabel COMP_CAS_ASSURED_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CAS_ASSURED_TYPE;

	private HtmlOutputLabel COMP_CAS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_CAS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_CAS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_CAS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_CAS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_CAS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_CAS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_CAS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_CAS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_CAS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_CAS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_CAS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_CAS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_CAS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_CAS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_CAS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_CAS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_CAS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlOutputLabel COMP_UI_M_BUS_TYPE_FM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BUS_TYPE_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_BUS_TYPE_TO_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BUS_TYPE_TO_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_BUS_FM;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_2;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_2;

	private HtmlCommandButton COMP_UI_M_BUT_CAS_SRC_BUS_FM;

	private HtmlCommandButton COMP_UI_M_BUT_BUS_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_BUS_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CAS_SRC_BUS_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_FM;

	private HtmlCommandButton COMP_UI_M_BUT_BUS_TO;

	private HtmlCommandButton test;

	private String errMsg;

	ResultSet rs= null;
	
	String warningmessage;

	private int lastUpdatedRowIndex;

	List<SelectItem> CAS_FORCE_DIVN_YN_LIST = new ArrayList<SelectItem>();

	List<SelectItem> CAS_FORCE_DEPT_YN_LIST = new ArrayList<SelectItem>();

	List<SelectItem> CAS_ASSURED_TYPE_LIST = new ArrayList<SelectItem>();

	private int prevRowIndex;

	int rowIndex = 0;

	DUMMY DUMMY_BEAN;

	public BP BP_BEAN;

	CRUDHandler handler = new CRUDHandler();


	//private Map<String, String> errorMap = new HashMap<String, String>();

	ArrayList<PM_IL_CUST_ACCOUNT_SETUP> detailsList;

	private Connection connection = null;

	private PM_IL_CUST_ACCOUNT_SETUP PM_IL_CUST_ACCOUNT_SETUP_BEAN;

	public PM_IL_CUST_ACCOUNT_SETUP_ACTION() {
		detailsList = new ArrayList<PM_IL_CUST_ACCOUNT_SETUP>();
		PM_IL_CUST_ACCOUNT_SETUP_BEAN = new PM_IL_CUST_ACCOUNT_SETUP();
		DUMMY_BEAN = new DUMMY();
		BP_BEAN = new BP();
	}

	public HtmlOutputLabel getCOMP_CAS_FRZ_FLAG_LABEL() {
		return COMP_CAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CAS_FRZ_FLAG() {
		return COMP_CAS_FRZ_FLAG;
	}

	public void setCOMP_CAS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_CAS_FRZ_FLAG_LABEL) {
		this.COMP_CAS_FRZ_FLAG_LABEL = COMP_CAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CAS_FRZ_FLAG) {
		this.COMP_CAS_FRZ_FLAG = COMP_CAS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_CAS_SRC_BUS_FM_LABEL() {
		return COMP_CAS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_CAS_SRC_BUS_FM() {
		return COMP_CAS_SRC_BUS_FM;
	}

	public void setCOMP_CAS_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_CAS_SRC_BUS_FM_LABEL) {
		this.COMP_CAS_SRC_BUS_FM_LABEL = COMP_CAS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_CAS_SRC_BUS_FM(HtmlInputText COMP_CAS_SRC_BUS_FM) {
		this.COMP_CAS_SRC_BUS_FM = COMP_CAS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_CAS_SRC_BUS_TO_LABEL() {
		return COMP_CAS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_CAS_SRC_BUS_TO() {
		return COMP_CAS_SRC_BUS_TO;
	}

	public void setCOMP_CAS_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_CAS_SRC_BUS_TO_LABEL) {
		this.COMP_CAS_SRC_BUS_TO_LABEL = COMP_CAS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_CAS_SRC_BUS_TO(HtmlInputText COMP_CAS_SRC_BUS_TO) {
		this.COMP_CAS_SRC_BUS_TO = COMP_CAS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_CAS_CUST_FM_CLASS_LABEL() {
		return COMP_CAS_CUST_FM_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_CAS_CUST_FM_CLASS() {
		return COMP_CAS_CUST_FM_CLASS;
	}

	public void setCOMP_CAS_CUST_FM_CLASS_LABEL(HtmlOutputLabel COMP_CAS_CUST_FM_CLASS_LABEL) {
		this.COMP_CAS_CUST_FM_CLASS_LABEL = COMP_CAS_CUST_FM_CLASS_LABEL;
	}

	public void setCOMP_CAS_CUST_FM_CLASS(HtmlInputText COMP_CAS_CUST_FM_CLASS) {
		this.COMP_CAS_CUST_FM_CLASS = COMP_CAS_CUST_FM_CLASS;
	}

	public HtmlOutputLabel getCOMP_CAS_CUST_TO_CLASS_LABEL() {
		return COMP_CAS_CUST_TO_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_CAS_CUST_TO_CLASS() {
		return COMP_CAS_CUST_TO_CLASS;
	}

	public void setCOMP_CAS_CUST_TO_CLASS_LABEL(HtmlOutputLabel COMP_CAS_CUST_TO_CLASS_LABEL) {
		this.COMP_CAS_CUST_TO_CLASS_LABEL = COMP_CAS_CUST_TO_CLASS_LABEL;
	}

	public void setCOMP_CAS_CUST_TO_CLASS(HtmlInputText COMP_CAS_CUST_TO_CLASS) {
		this.COMP_CAS_CUST_TO_CLASS = COMP_CAS_CUST_TO_CLASS;
	}

	public HtmlOutputLabel getCOMP_CAS_DIVN_FM_CODE_LABEL() {
		return COMP_CAS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_DIVN_FM_CODE() {
		return COMP_CAS_DIVN_FM_CODE;
	}

	public void setCOMP_CAS_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_CAS_DIVN_FM_CODE_LABEL) {
		this.COMP_CAS_DIVN_FM_CODE_LABEL = COMP_CAS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_CAS_DIVN_FM_CODE(HtmlInputText COMP_CAS_DIVN_FM_CODE) {
		this.COMP_CAS_DIVN_FM_CODE = COMP_CAS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CAS_DIVN_TO_CODE_LABEL() {
		return COMP_CAS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_DIVN_TO_CODE() {
		return COMP_CAS_DIVN_TO_CODE;
	}

	public void setCOMP_CAS_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_CAS_DIVN_TO_CODE_LABEL) {
		this.COMP_CAS_DIVN_TO_CODE_LABEL = COMP_CAS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_CAS_DIVN_TO_CODE(HtmlInputText COMP_CAS_DIVN_TO_CODE) {
		this.COMP_CAS_DIVN_TO_CODE = COMP_CAS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CAS_DEPT_FM_CODE_LABEL() {
		return COMP_CAS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_DEPT_FM_CODE() {
		return COMP_CAS_DEPT_FM_CODE;
	}

	public void setCOMP_CAS_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_CAS_DEPT_FM_CODE_LABEL) {
		this.COMP_CAS_DEPT_FM_CODE_LABEL = COMP_CAS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_CAS_DEPT_FM_CODE(HtmlInputText COMP_CAS_DEPT_FM_CODE) {
		this.COMP_CAS_DEPT_FM_CODE = COMP_CAS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CAS_DEPT_TO_CODE_LABEL() {
		return COMP_CAS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_DEPT_TO_CODE() {
		return COMP_CAS_DEPT_TO_CODE;
	}

	public void setCOMP_CAS_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_CAS_DEPT_TO_CODE_LABEL) {
		this.COMP_CAS_DEPT_TO_CODE_LABEL = COMP_CAS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_CAS_DEPT_TO_CODE(HtmlInputText COMP_CAS_DEPT_TO_CODE) {
		this.COMP_CAS_DEPT_TO_CODE = COMP_CAS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CAS_BUS_TYPE_FM_LABEL() {
		return COMP_CAS_BUS_TYPE_FM_LABEL;
	}

	public HtmlInputText getCOMP_CAS_BUS_TYPE_FM() {
		return COMP_CAS_BUS_TYPE_FM;
	}

	public void setCOMP_CAS_BUS_TYPE_FM_LABEL(HtmlOutputLabel COMP_CAS_BUS_TYPE_FM_LABEL) {
		this.COMP_CAS_BUS_TYPE_FM_LABEL = COMP_CAS_BUS_TYPE_FM_LABEL;
	}

	public void setCOMP_CAS_BUS_TYPE_FM(HtmlInputText COMP_CAS_BUS_TYPE_FM) {
		this.COMP_CAS_BUS_TYPE_FM = COMP_CAS_BUS_TYPE_FM;
	}

	public HtmlOutputLabel getCOMP_CAS_BUS_TYPE_TO_LABEL() {
		return COMP_CAS_BUS_TYPE_TO_LABEL;
	}

	public HtmlInputText getCOMP_CAS_BUS_TYPE_TO() {
		return COMP_CAS_BUS_TYPE_TO;
	}

	public void setCOMP_CAS_BUS_TYPE_TO_LABEL(HtmlOutputLabel COMP_CAS_BUS_TYPE_TO_LABEL) {
		this.COMP_CAS_BUS_TYPE_TO_LABEL = COMP_CAS_BUS_TYPE_TO_LABEL;
	}

	public void setCOMP_CAS_BUS_TYPE_TO(HtmlInputText COMP_CAS_BUS_TYPE_TO) {
		this.COMP_CAS_BUS_TYPE_TO = COMP_CAS_BUS_TYPE_TO;
	}

	public HtmlOutputLabel getCOMP_CAS_ASSURED_TYPE_LABEL() {
		return COMP_CAS_ASSURED_TYPE_LABEL;
	}



	public void setCOMP_CAS_ASSURED_TYPE_LABEL(HtmlOutputLabel COMP_CAS_ASSURED_TYPE_LABEL) {
		this.COMP_CAS_ASSURED_TYPE_LABEL = COMP_CAS_ASSURED_TYPE_LABEL;
	}


	public HtmlOutputLabel getCOMP_CAS_FORCE_DIVN_YN_LABEL() {
		return COMP_CAS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_CAS_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_CAS_FORCE_DIVN_YN_LABEL) {
		this.COMP_CAS_FORCE_DIVN_YN_LABEL = COMP_CAS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_CAS_FORCE_DEPT_YN_LABEL() {
		return COMP_CAS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_CAS_FORCE_DEPT_YN_LABEL(HtmlOutputLabel COMP_CAS_FORCE_DEPT_YN_LABEL) {
		this.COMP_CAS_FORCE_DEPT_YN_LABEL = COMP_CAS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_CAS_MAIN_ACNT_CODE_LABEL() {
		return COMP_CAS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_MAIN_ACNT_CODE() {
		return COMP_CAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_CAS_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_CAS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_CAS_MAIN_ACNT_CODE_LABEL = COMP_CAS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_CAS_MAIN_ACNT_CODE(HtmlInputText COMP_CAS_MAIN_ACNT_CODE) {
		this.COMP_CAS_MAIN_ACNT_CODE = COMP_CAS_MAIN_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_CAS_DIVN_CODE_LABEL() {
		return COMP_CAS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_DIVN_CODE() {
		return COMP_CAS_DIVN_CODE;
	}

	public void setCOMP_CAS_DIVN_CODE_LABEL(HtmlOutputLabel COMP_CAS_DIVN_CODE_LABEL) {
		this.COMP_CAS_DIVN_CODE_LABEL = COMP_CAS_DIVN_CODE_LABEL;
	}

	public void setCOMP_CAS_DIVN_CODE(HtmlInputText COMP_CAS_DIVN_CODE) {
		this.COMP_CAS_DIVN_CODE = COMP_CAS_DIVN_CODE;
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

	public HtmlOutputLabel getCOMP_CAS_DEPT_CODE_LABEL() {
		return COMP_CAS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CAS_DEPT_CODE() {
		return COMP_CAS_DEPT_CODE;
	}

	public void setCOMP_CAS_DEPT_CODE_LABEL(HtmlOutputLabel COMP_CAS_DEPT_CODE_LABEL) {
		this.COMP_CAS_DEPT_CODE_LABEL = COMP_CAS_DEPT_CODE_LABEL;
	}

	public void setCOMP_CAS_DEPT_CODE(HtmlInputText COMP_CAS_DEPT_CODE) {
		this.COMP_CAS_DEPT_CODE = COMP_CAS_DEPT_CODE;
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

	public HtmlOutputLabel getCOMP_CAS_ANLY_CODE_1_LABEL() {
		return COMP_CAS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CAS_ANLY_CODE_1() {
		return COMP_CAS_ANLY_CODE_1;
	}

	public void setCOMP_CAS_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_CAS_ANLY_CODE_1_LABEL) {
		this.COMP_CAS_ANLY_CODE_1_LABEL = COMP_CAS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_CAS_ANLY_CODE_1(HtmlInputText COMP_CAS_ANLY_CODE_1) {
		this.COMP_CAS_ANLY_CODE_1 = COMP_CAS_ANLY_CODE_1;
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

	public HtmlOutputLabel getCOMP_CAS_ANLY_CODE_2_LABEL() {
		return COMP_CAS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_CAS_ANLY_CODE_2() {
		return COMP_CAS_ANLY_CODE_2;
	}

	public void setCOMP_CAS_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_CAS_ANLY_CODE_2_LABEL) {
		this.COMP_CAS_ANLY_CODE_2_LABEL = COMP_CAS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_CAS_ANLY_CODE_2(HtmlInputText COMP_CAS_ANLY_CODE_2) {
		this.COMP_CAS_ANLY_CODE_2 = COMP_CAS_ANLY_CODE_2;
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

	public HtmlOutputLabel getCOMP_CAS_ACTY_CODE_1_LABEL() {
		return COMP_CAS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CAS_ACTY_CODE_1() {
		return COMP_CAS_ACTY_CODE_1;
	}

	public void setCOMP_CAS_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_CAS_ACTY_CODE_1_LABEL) {
		this.COMP_CAS_ACTY_CODE_1_LABEL = COMP_CAS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_CAS_ACTY_CODE_1(HtmlInputText COMP_CAS_ACTY_CODE_1) {
		this.COMP_CAS_ACTY_CODE_1 = COMP_CAS_ACTY_CODE_1;
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

	public HtmlOutputLabel getCOMP_CAS_ACTY_CODE_2_LABEL() {
		return COMP_CAS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_CAS_ACTY_CODE_2() {
		return COMP_CAS_ACTY_CODE_2;
	}

	public void setCOMP_CAS_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_CAS_ACTY_CODE_2_LABEL) {
		this.COMP_CAS_ACTY_CODE_2_LABEL = COMP_CAS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_CAS_ACTY_CODE_2(HtmlInputText COMP_CAS_ACTY_CODE_2) {
		this.COMP_CAS_ACTY_CODE_2 = COMP_CAS_ACTY_CODE_2;
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

	public HtmlOutputLabel getCOMP_UI_M_BUS_TYPE_FM_DESC_LABEL() {
		return COMP_UI_M_BUS_TYPE_FM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BUS_TYPE_FM_DESC() {
		return COMP_UI_M_BUS_TYPE_FM_DESC;
	}

	public void setCOMP_UI_M_BUS_TYPE_FM_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BUS_TYPE_FM_DESC_LABEL) {
		this.COMP_UI_M_BUS_TYPE_FM_DESC_LABEL = COMP_UI_M_BUS_TYPE_FM_DESC_LABEL;
	}

	public void setCOMP_UI_M_BUS_TYPE_FM_DESC(HtmlInputText COMP_UI_M_BUS_TYPE_FM_DESC) {
		this.COMP_UI_M_BUS_TYPE_FM_DESC = COMP_UI_M_BUS_TYPE_FM_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_BUS_TYPE_TO_DESC_LABEL() {
		return COMP_UI_M_BUS_TYPE_TO_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BUS_TYPE_TO_DESC() {
		return COMP_UI_M_BUS_TYPE_TO_DESC;
	}

	public void setCOMP_UI_M_BUS_TYPE_TO_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BUS_TYPE_TO_DESC_LABEL) {
		this.COMP_UI_M_BUS_TYPE_TO_DESC_LABEL = COMP_UI_M_BUS_TYPE_TO_DESC_LABEL;
	}

	public void setCOMP_UI_M_BUS_TYPE_TO_DESC(HtmlInputText COMP_UI_M_BUS_TYPE_TO_DESC) {
		this.COMP_UI_M_BUS_TYPE_TO_DESC = COMP_UI_M_BUS_TYPE_TO_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BUS_FM() {
		return COMP_UI_M_BUT_BUS_FM;
	}

	public void setCOMP_UI_M_BUT_BUS_FM(HtmlCommandButton COMP_UI_M_BUT_BUS_FM) {
		this.COMP_UI_M_BUT_BUS_FM = COMP_UI_M_BUT_BUS_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_2() {
		return COMP_UI_M_BUT_ACTY_2;
	}

	public void setCOMP_UI_M_BUT_ACTY_2(HtmlCommandButton COMP_UI_M_BUT_ACTY_2) {
		this.COMP_UI_M_BUT_ACTY_2 = COMP_UI_M_BUT_ACTY_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_1() {
		return COMP_UI_M_BUT_ACTY_1;
	}

	public void setCOMP_UI_M_BUT_ACTY_1(HtmlCommandButton COMP_UI_M_BUT_ACTY_1) {
		this.COMP_UI_M_BUT_ACTY_1 = COMP_UI_M_BUT_ACTY_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANAL_1() {
		return COMP_UI_M_BUT_ANAL_1;
	}

	public void setCOMP_UI_M_BUT_ANAL_1(HtmlCommandButton COMP_UI_M_BUT_ANAL_1) {
		this.COMP_UI_M_BUT_ANAL_1 = COMP_UI_M_BUT_ANAL_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANAL_2() {
		return COMP_UI_M_BUT_ANAL_2;
	}

	public void setCOMP_UI_M_BUT_ANAL_2(HtmlCommandButton COMP_UI_M_BUT_ANAL_2) {
		this.COMP_UI_M_BUT_ANAL_2 = COMP_UI_M_BUT_ANAL_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CAS_SRC_BUS_FM() {
		return COMP_UI_M_BUT_CAS_SRC_BUS_FM;
	}

	public void setCOMP_UI_M_BUT_CAS_SRC_BUS_FM(HtmlCommandButton COMP_UI_M_BUT_CAS_SRC_BUS_FM) {
		this.COMP_UI_M_BUT_CAS_SRC_BUS_FM = COMP_UI_M_BUT_CAS_SRC_BUS_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BUS_CODE_FM() {
		return COMP_UI_M_BUT_BUS_CODE_FM;
	}

	public void setCOMP_UI_M_BUT_BUS_CODE_FM(HtmlCommandButton COMP_UI_M_BUT_BUS_CODE_FM) {
		this.COMP_UI_M_BUT_BUS_CODE_FM = COMP_UI_M_BUT_BUS_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BUS_CODE_TO() {
		return COMP_UI_M_BUT_BUS_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_BUS_CODE_TO(HtmlCommandButton COMP_UI_M_BUT_BUS_CODE_TO) {
		this.COMP_UI_M_BUT_BUS_CODE_TO = COMP_UI_M_BUT_BUS_CODE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CAS_SRC_BUS_TO() {
		return COMP_UI_M_BUT_CAS_SRC_BUS_TO;
	}

	public void setCOMP_UI_M_BUT_CAS_SRC_BUS_TO(HtmlCommandButton COMP_UI_M_BUT_CAS_SRC_BUS_TO) {
		this.COMP_UI_M_BUT_CAS_SRC_BUS_TO = COMP_UI_M_BUT_CAS_SRC_BUS_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT() {
		return COMP_UI_M_BUT_DEPT;
	}

	public void setCOMP_UI_M_BUT_DEPT(HtmlCommandButton COMP_UI_M_BUT_DEPT) {
		this.COMP_UI_M_BUT_DEPT = COMP_UI_M_BUT_DEPT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN() {
		return COMP_UI_M_BUT_DIVN;
	}

	public void setCOMP_UI_M_BUT_DIVN(HtmlCommandButton COMP_UI_M_BUT_DIVN) {
		this.COMP_UI_M_BUT_DIVN = COMP_UI_M_BUT_DIVN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_ACNT() {
		return COMP_UI_M_BUT_MAIN_ACNT;
	}

	public void setCOMP_UI_M_BUT_MAIN_ACNT(HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT) {
		this.COMP_UI_M_BUT_MAIN_ACNT = COMP_UI_M_BUT_MAIN_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_TO() {
		return COMP_UI_M_BUT_DEPT_TO;
	}

	public void setCOMP_UI_M_BUT_DEPT_TO(HtmlCommandButton COMP_UI_M_BUT_DEPT_TO) {
		this.COMP_UI_M_BUT_DEPT_TO = COMP_UI_M_BUT_DEPT_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_FM() {
		return COMP_UI_M_BUT_DEPT_FM;
	}

	public void setCOMP_UI_M_BUT_DEPT_FM(HtmlCommandButton COMP_UI_M_BUT_DEPT_FM) {
		this.COMP_UI_M_BUT_DEPT_FM = COMP_UI_M_BUT_DEPT_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_TO() {
		return COMP_UI_M_BUT_DIVN_TO;
	}

	public void setCOMP_UI_M_BUT_DIVN_TO(HtmlCommandButton COMP_UI_M_BUT_DIVN_TO) {
		this.COMP_UI_M_BUT_DIVN_TO = COMP_UI_M_BUT_DIVN_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_FM() {
		return COMP_UI_M_BUT_DIVN_FM;
	}

	public void setCOMP_UI_M_BUT_DIVN_FM(HtmlCommandButton COMP_UI_M_BUT_DIVN_FM) {
		this.COMP_UI_M_BUT_DIVN_FM = COMP_UI_M_BUT_DIVN_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BUS_TO() {
		return COMP_UI_M_BUT_BUS_TO;
	}

	public void setCOMP_UI_M_BUT_BUS_TO(HtmlCommandButton COMP_UI_M_BUT_BUS_TO) {
		this.COMP_UI_M_BUT_BUS_TO = COMP_UI_M_BUT_BUS_TO;
	}

	public PM_IL_CUST_ACCOUNT_SETUP getPM_IL_CUST_ACCOUNT_SETUP_BEAN() {
		return PM_IL_CUST_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_CUST_ACCOUNT_SETUP_BEAN(PM_IL_CUST_ACCOUNT_SETUP PM_IL_CUST_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_CUST_ACCOUNT_SETUP_BEAN = PM_IL_CUST_ACCOUNT_SETUP_BEAN;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public void createRecord() throws DBException, SQLException{
		connection = CommonUtils.getConnection();
		getErrorMap().clear();
		getWarningMap().clear();
		if(PM_IL_CUST_ACCOUNT_SETUP_BEAN == null || PM_IL_CUST_ACCOUNT_SETUP_BEAN.getROWID() == null){
			warningmessage = " Record Inserted";
			try {
				pilm021_pm_il_cust_account_setup_pre_insert();
				if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false)
				{
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_FRZ_FLAG("N");
				}else{
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_FRZ_FLAG("Y");
				}
				create_New_Record();
			} catch (Exception e) 
			{
				 System.out.println("catch block...............................");
				 getErrorMap().put("current", e.getMessage());
		         getErrorMap().put("some", e.getMessage());
			}
			System.out.println("CALLING INSERT.........");
		}else{
			warningmessage = " Record Updated";
			try {
				pilm021_pm_il_cust_account_setup_pre_update();
				if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false)
				{
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_FRZ_FLAG("N");
				}else{
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_FRZ_FLAG("Y");
				}
				create_New_Record();
			} catch (Exception e)
			{
				System.out.println("catch block...............................");
				 getErrorMap().put("current", e.getMessage());
		         getErrorMap().put("some", e.getMessage());
			}
		}
		connection.commit();
	}

	public void create_New_Record() throws Exception{
		System.out.println("New Record >> Save This");
		int i =0;
		//CommonUtils.objectSysout(PM_IL_CUST_ACCOUNT_SETUP_BEAN);
		try {
			i = handler.executeInsert(PM_IL_CUST_ACCOUNT_SETUP_BEAN, connection);
			if(i>0){
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,(i + warningmessage));
				getWarningMap().put("SAVE",(i + warningmessage));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	// PREFORM CALLING......

	public void preForm(PhaseEvent event)  {
		// Setting default value of Analysis1
		try {
			if (isBlockFlag()) {
				BP_BEAN.setBP_CAS_ACTY_CODE_1(Messages.getString("messageProperties_PILM021", 
						"PILM021$PM_IL_CUST_ACCOUNT_SETUP$CAS_ACTY_CODE_1$caption"));

				CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
				STD_PRE_FORM();

				pilm021_pm_il_cust_account_setup_pre_block();
				if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getROWID() != null){
					prepareDetails(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getROWID());
					//pilm021_pm_il_cust_account_setup_post_query();
				}
				//POST QUERY DECLARING......
				//NEW_RECORD_INSTANCE...
				pilm021_pm_il_cust_account_setup_when_new_record_instance();
				//PRE_RECORD.......
				pilm021_pm_il_cust_account_setup_pre_record();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
		
	}

	public void STD_PRE_FORM(){

		System.out.println("INSIDE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>STD_PRE_FORM()");
	
		/*ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String)session.getAttribute("GLOBAL.M_PARAM_1"));
		//ctrlBean.setM_USER_ID((String)session.getAttribute("GLOBAL.M_USER_ID"));
		ctrlBean.setM_PROG_NAME("PIL014_A");*/
	//	ctrlBean.setM_SCR_NAME(((String)session.getAttribute("GLOBAL.M_NAME")).substring(30, 42));
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
		/*ctrlBean.setM_GOFLD_NAME("NULL");*/
		//ctrlBean.setM_LANG_CODE((String)session.getAttribute("GLOBAL.M_LANG_CODE"));
		//ctrlBean.setM_COMP_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		//ctrlBean.setM_DIVN_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(3,6));
	//	ctrlBean.setM_DEPT_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		//putCtrlBean(ctrlBean);
	}

	public String checkBoxStatus(ActionEvent actionEvent){
		return "";
	}

	public void checkBoxValidation(ActionEvent event){
	}

	public boolean P_SET_SECOND_FIELD(HtmlInputText fromText,HtmlInputText toText){
		boolean status = true;
		if("".equals(toText.getSubmittedValue().toString().trim())){
			if(fromText.getSubmittedValue().toString().equals("0") && "".equals(toText.getSubmittedValue().toString().trim())){
				toText.setSubmittedValue("zzzzzz");
				toText.updateModel(FacesContext.getCurrentInstance());
				status = false;
			}else{
				toText.setSubmittedValue(fromText.getSubmittedValue());
				toText.updateModel(FacesContext.getCurrentInstance());
				status = false;
			}
		}else{
			if((fromText.getSubmittedValue().toString().compareTo(toText.getSubmittedValue().toString()) > 0)){
				//errMsg = STD_MESSAGE_ROUTINE("ENG","10064");
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
				status = false;
			}
		}
		return status;
	}

	
	public void requiredValidation(ActionEvent event) {

		UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
		// comp
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	
	
	
//	L_VAL_FROM_TO Method for WHEN VALIDATE

	public void L_VAL_FROM_TO(HtmlInputText fromText,HtmlInputText toText){
		System.out.println("I'm In Error Message L_VAL_FROM....");
		System.out.println("U Typed Field is "+fromText.getSubmittedValue());
		if("".equals(fromText.getSubmittedValue().toString().trim())){
			getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80033"));
			//errMsg = STD_MESSAGE_ROUTINE("ENG","80033");
		}else {
			try{
				if(Integer.parseInt(toText.getSubmittedValue().toString().trim()) < Integer.parseInt(fromText.getSubmittedValue().toString().trim())){
					getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
					//errMsg = STD_MESSAGE_ROUTINE("ENG","80034");
				}
			}catch(NumberFormatException e){
				
				if((toText.getSubmittedValue().toString().trim().compareTo(fromText.getSubmittedValue().toString().trim()) < 0)){
					//errMsg = STD_MESSAGE_ROUTINE("ENG","80034");
					getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
				}
			}
		}
	}

	// FROM AND TO VALIDATION....

	public void WHEN_VALIDATE_CAS_SRC_BUS_FM(ActionEvent ae){
		System.out.println("From field Action Event method called >>>>>>.............");
		if("".equals(getCOMP_CAS_SRC_BUS_FM().getSubmittedValue().toString().trim())){
			getCOMP_CAS_SRC_BUS_FM().setSubmittedValue("0");
			getCOMP_CAS_SRC_BUS_FM().updateModel(FacesContext.getCurrentInstance());
		}
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out.println("COMP_CAS_SRC_BUS_FM in Action = "+getCOMP_CAS_SRC_BUS_FM().getValue());
	}

	public void onSelectBusinessFrom(ActionEvent ae){
		System.out.println("From field Action Event method called >>>>>>.............");
		String value = (String) ((UIInput)ae.getComponent().getParent().getParent()).getSubmittedValue();
		System.out.println("--------------->typed value: "+value);
	}

	public void WHEN_VALIDATE_CAS_SRC_BUS_TO(ActionEvent ae){
		if(P_SET_SECOND_FIELD(getCOMP_CAS_SRC_BUS_FM(),getCOMP_CAS_SRC_BUS_TO()))
			L_VAL_FROM_TO(getCOMP_CAS_SRC_BUS_FM(),getCOMP_CAS_SRC_BUS_TO());
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void WHEN_VALIDATE_CAS_CUST_FM_CLASS(ActionEvent ae){
		System.out.println("From field Action Event method called >>>>>>.............");
		if("".equals(getCOMP_CAS_CUST_FM_CLASS().getSubmittedValue().toString().trim())){
			getCOMP_CAS_CUST_FM_CLASS().setSubmittedValue("0");
			getCOMP_CAS_CUST_FM_CLASS().updateModel(FacesContext.getCurrentInstance());
			
		}
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out.println("COMP_CAS_CUST_FM_CLASS in Action = "+getCOMP_CAS_CUST_FM_CLASS().getValue());
	}

	public void WHEN_VALIDATE_CAS_CUST_TO_CLASS(ActionEvent ae){
		if(P_SET_SECOND_FIELD(getCOMP_CAS_CUST_FM_CLASS(),getCOMP_CAS_CUST_TO_CLASS()))
			L_VAL_FROM_TO(getCOMP_CAS_CUST_FM_CLASS(),getCOMP_CAS_CUST_TO_CLASS());
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void WHEN_VALIDATE_CAS_DIVN_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CAS_DIVN_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CAS_DIVN_FM_CODE().getSubmittedValue() == null){
			getCOMP_CAS_DIVN_FM_CODE().setSubmittedValue("0");
			getCOMP_CAS_DIVN_FM_CODE().updateModel(FacesContext.getCurrentInstance());
			
		}
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void WHEN_VALIDATE_CAS_DIVN_TO_CODE(ActionEvent ae){
		if(P_SET_SECOND_FIELD(getCOMP_CAS_DIVN_FM_CODE(),getCOMP_CAS_DIVN_TO_CODE()))
			L_VAL_FROM_TO(getCOMP_CAS_DIVN_FM_CODE(),getCOMP_CAS_DIVN_TO_CODE());
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void WHEN_VALIDATE_CAS_DEPT_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CAS_DEPT_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CAS_DEPT_FM_CODE().getSubmittedValue() == null){
			getCOMP_CAS_DEPT_FM_CODE().setSubmittedValue("0");
			getCOMP_CAS_DEPT_FM_CODE().updateModel(FacesContext.getCurrentInstance());
			
		}
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void WHEN_VALIDATE_CAS_DEPT_TO_CODE(ActionEvent ae){
		if(P_SET_SECOND_FIELD(getCOMP_CAS_DEPT_FM_CODE(),getCOMP_CAS_DEPT_TO_CODE()))
			L_VAL_FROM_TO(getCOMP_CAS_DEPT_FM_CODE(),getCOMP_CAS_DEPT_TO_CODE());
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void WHEN_VALIDATE_CAS_BUS_TYPE_FM(ActionEvent ae){
		if("".equals(((String)getCOMP_CAS_BUS_TYPE_FM().getSubmittedValue()).trim()) || getCOMP_CAS_BUS_TYPE_FM().getSubmittedValue() == null){
			getCOMP_CAS_BUS_TYPE_FM().setSubmittedValue("0");
			getCOMP_CAS_BUS_TYPE_FM().updateModel(FacesContext.getCurrentInstance());
			
		}
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public boolean P_SET_SECOND_FIELD1(HtmlInputText fromText,HtmlInputText toText){
		boolean status = true;
		if("".equals(toText.getSubmittedValue().toString().trim())){
			if(fromText.getSubmittedValue().toString().equals("0") && "".equals(toText.getSubmittedValue().toString().trim())){
				toText.setSubmittedValue("999999999");
				toText.updateModel(FacesContext.getCurrentInstance());
				status = false;
			}else{
				toText.setSubmittedValue(fromText.getSubmittedValue());
				toText.updateModel(FacesContext.getCurrentInstance());
				status = false;
			}
		}else{
			if((fromText.getSubmittedValue().toString().compareTo(toText.getSubmittedValue().toString()) > 0)){
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
				status = false;
			}
		}
		return status;
	}

	public void WHEN_VALIDATE_CAS_BUS_TYPE_TO(ActionEvent ae){
		if(P_SET_SECOND_FIELD1(getCOMP_CAS_BUS_TYPE_FM(),getCOMP_CAS_BUS_TYPE_TO()))
			L_VAL_FROM_TO(getCOMP_CAS_BUS_TYPE_FM(),getCOMP_CAS_BUS_TYPE_TO());
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());

	}


	/*public void Database() throws Exception{
		String sqlQuery = "SELECT * FROM PM_IL_CUST_ACCOUNT_SETUP";
		connection = CommonUtils.getConnection();
		if(connection != null){
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_MAIN_ACNT_CODE(resultSet.getString("CAS_MAIN_ACNT_CODE"));
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_DIVN_CODE(resultSet.getString("CAS_DIVN_CODE"));
					detailsList.add(PM_IL_CUST_ACCOUNT_SETUP_BEAN);
				}

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/

	// LOV STARTS.....
	
	public void validate_Bussiness_From(FacesContext context, UIComponent component ,Object value){
		List list1 = new ArrayList();
		String value1 = (String)value;
		try{
			if("0".equals(value1) || "zzzzzz".equals(value1)){
				
			}else{
			String qry = "SELECT 'X' FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE = ? ";
			if(isExists(qry, new Object[]{value1})){
				
			}else{
				throw new Exception("Code does not Exist");
			}
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validate_CustomerClass_From(FacesContext context, UIComponent component ,Object value){
		List list1 = new ArrayList();
		String value1 = (String)value;
		try{
			if("0".equals(value1) || "zzzzzz".equals(value1)){
				
			}else{
			String qry = "select 'X' from PM_CUST_CLASS where NVL(CCLAS_FRZ_FLAG,'N') = 'N' AND CCLAS_CODE = ?";
			if(isExists(qry, new Object[]{value1})){
				
			}else{
				throw new Exception("Code does not exist");
			}
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List CAS_SRC_BUS_FM_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().trim().equals("*")){
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_SRC_BUS_FM_LOV lovBox = new CAS_SRC_BUS_FM_LOV(); 
			lovBox.setPC_CODE(rs.getString("PC_CODE"));
			lovBox.setPC_DESC(rs.getString("PC_DESC"));
			lovList.add(lovBox);
		}
		
		rs.close();
		return lovList;

	}

	public List CAS_CUST_FM_CLASS_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().trim().equals("*")){
			query = "select CCLAS_CODE,CCLAS_CLASS_DESC from PM_CUST_CLASS where NVL(CCLAS_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "select CCLAS_CODE,CCLAS_CLASS_DESC from PM_CUST_CLASS where NVL(CCLAS_FRZ_FLAG,'N') = 'N' AND CCLAS_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_CUST_FM_CLASS_LOV lovBox = new CAS_CUST_FM_CLASS_LOV(); 
			lovBox.setCCLAS_CODE(rs.getString("CCLAS_CODE"));
			lovBox.setCCLAS_CLASS_DESC(rs.getString("CCLAS_CLASS_DESC"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;

	}
	
	public void validate_Divison_From(FacesContext context, UIComponent component ,Object value){
		List list1 = new ArrayList();
		String value1 = (String)value;
		try{
			if("0".equals(value1) || "zzzzzz".equals(value1)){
				
			}else{
			String qry = "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND " +
						" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND " +
						"  ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N' AND DIVN_CODE = ? )";
			if(isExists(qry, new Object[]{value1})){
				
			}else{
				throw new Exception("Codes does not exist");
			}
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List CAS_DIVN_FM_CODE_lovAction(Object obj)throws Exception {

		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
			query = "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND" +
			" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}
		else{
			query = "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND" +
			" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N' AND DIVN_CODE LIKE('"+obj.toString()+"%')) ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_DIVN_FM_CODE_LOV lovBox = new CAS_DIVN_FM_CODE_LOV(); 
			lovBox.setDIVN_CODE(rs.getString("DIVN_CODE"));
			lovBox.setDIVN_NAME(rs.getString("DIVN_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}

	public void validate_Department_From(FacesContext context, UIComponent component ,Object value){
		List list1 = new ArrayList();
		String value1 = (String)value;
		try{
			if("0".equals(value1) || "zzzzzz".equals(value1)){
				
			}else{
			String qry = "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = ? AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N' AND DEPT_CODE = ? )";
			if(isExists(qry, new Object[]{getCOMP_CAS_DIVN_FM_CODE().getValue(),value1})){
				
			}else{
				throw new Exception("Code does not Exist");
			}
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public List CAS_DEPT_FM_CODE_lovAction(Object obj)throws Exception {

		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query = "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = '"+getCOMP_CAS_DIVN_FM_CODE().getValue()+"' AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N')";

		}
		else{
			query = "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = '"+getCOMP_CAS_DIVN_FM_CODE().getValue()+"' AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N' AND DEPT_CODE LIKE('"+obj.toString()+"%'))";
		}

		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_DEPT_FM_CODE_LOV lovBox = new CAS_DEPT_FM_CODE_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovBox.setDEPT_NAME(rs.getString("DEPT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}

	public void validate_BusinessRange_From(FacesContext context, UIComponent component ,Object value){
		List list1 = new ArrayList();
		String value1 = (String)value;
		try{
			if("0".equals(value1) || "999999999".equals(value1)){
				
			}else{
				String qry = "SELECT 'X' FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES' AND PS_CODE = ? ";
				if(isExists(qry, new Object[]{value1})){
					
				}else{
					throw new Exception("Code does not Exist");
				}
			}
			
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List CAS_BUS_TYPE_FM_lovAction(Object obj) throws Exception {

		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES'";
		}
		else{
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES' AND PS_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_BUS_TYPE_FM_LOV lovBox = new CAS_BUS_TYPE_FM_LOV(); 
			lovBox.setPS_CODE(rs.getString("PS_CODE"));
			lovBox.setPS_CODE_DESC(rs.getString("PS_CODE_DESC"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}


	public List CAS_MAIN_ACNT_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().trim().equals("*")){
			query = "select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<25";
		}else{
			query = "select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE LIKE('"+obj.toString()+"%') AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){

			CAS_MAIN_ACNT_CODE_LOV lovBox = new CAS_MAIN_ACNT_CODE_LOV(); 
			lovBox.setMAIN_ACNT_CODE(rs.getString("MAIN_ACNT_CODE"));
			lovBox.setMAIN_ACNT_NAME(rs.getString("MAIN_ACNT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public List CAS_DIV_COMP_CODE_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
			query =  "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}
		else{
			query =  "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND DIVN_CODE LIKE('"+obj.toString()+"%') ";
			System.out.println("QUERY >>>>>>>>>>>>>>>>>>>>>>>>>"+query);
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_DIV_COMP_CODE_LOV lovBox = new CAS_DIV_COMP_CODE_LOV(); 
			lovBox.setDIVN_CODE(rs.getString("DIVN_CODE"));
			lovBox.setDIVN_NAME(rs.getString("DIVN_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}

	public List CAS_DEPT_CODE_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		String query =null;
		System.out.println("CAS_DIVN_VODE>>>>>>>>>>>>>>"+getCOMP_CAS_DIVN_CODE().getSubmittedValue());
		System.out.println("CAS_DIVN_VODE!!!!!!!!>>>>>>>>>>>>>>"+getCOMP_CAS_DIVN_CODE().getValue());
		if (obj.toString().trim().equals("*")) {
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			System.out.println("CAS_DIVN_VODE222222222>>>>>>>>>>>>>>"+getCOMP_CAS_DIVN_CODE().getValue());
			query =  "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+getCOMP_CAS_DIVN_CODE().getValue()+"' AND" +
			" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
			" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}
		else{
			query =  "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_CODE()+"' AND" +
			" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
			" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE LIKE('"+obj.toString()+"%') ";  
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_DEPT_CODE_LOV lovBox = new CAS_DEPT_CODE_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovBox.setDEPT_NAME(rs.getString("DEPT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}

	public List CAS_ANLY_CODE_1_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_ANLY_CODE_1_LOV lovBox = new CAS_ANLY_CODE_1_LOV(); 
			lovBox.setANLY_CODE(rs.getString("ANLY_CODE"));
			lovBox.setANLY_NAME(rs.getString("ANLY_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}
	
	public void Bring_CAS_ANLY_CODE_1(ActionEvent ae) throws Exception {
		ResultSet rs = null;
		String query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		String CAS_ANLY_CODE_1 = getCOMP_CAS_ANLY_CODE_1().getSubmittedValue().toString();
		query = query + " AND ANLY_CODE ='" + CAS_ANLY_CODE_1+"'";
		System.out.println("CAS_ANLY_CODE_1>>>>>>>>()-query" + query);
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, connection);
		while(rs.next()){
			COMP_UI_M_ANLY_NAME.setSubmittedValue(rs.getString("ANLY_NAME"));
		}
		rs.close();
	}

	public List CAS_ANLY_CODE_2_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_ANLY_CODE_1_LOV lovBox = new CAS_ANLY_CODE_1_LOV(); 
			lovBox.setANLY_CODE(rs.getString("ANLY_CODE"));
			lovBox.setANLY_NAME(rs.getString("ANLY_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}
	
	/*public void Bring_ANLY_CODE_2(ActionEvent ae) throws Exception {
		ResultSet rs = null;
		String query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		String CAS_ANLY_CODE_2 = getCOMP_CAS_ANLY_CODE_2().getSubmittedValue().toString();
		query = query + " AND ANLY_CODE ='" + CAS_ANLY_CODE_2+"'";
		System.out.println("ANLY_CODE_2>>>>>>>>()-query" + query);
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, connection);
		while(rs.next()){
			COMP_UI_M_ANLY_NAME_1.setSubmittedValue(rs.getString("ANLY_NAME"));
		}
		rs.close();
	}*/
	
	public List CAS_ACTY_CODE_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE='"+DUMMY_BEAN.getM_ACTY_1()+"'";
		}
		else{
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE='"+DUMMY_BEAN.getM_ACTY_1()+"' AND AVAL_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_ACTY_CODE_LOV lovBox = new CAS_ACTY_CODE_LOV(); 
			lovBox.setAVAL_CODE(rs.getString("AVAL_CODE"));
			lovBox.setAVAL_VALUE_NAME(rs.getString("AVAL_VALUE_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}

	public List CAS_ACTY_CODE_2_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if (obj.toString().trim().equals("*")) {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE=? ";
		}
		else{
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE=? AND AVAL_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection,new Object[]{DUMMY_BEAN.getM_ACTY_2()});
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_ACTY_CODE_LOV lovBox = new CAS_ACTY_CODE_LOV(); 
			lovBox.setAVAL_CODE(rs.getString("AVAL_CODE"));
			lovBox.setAVAL_VALUE_NAME(rs.getString("AVAL_VALUE_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;	
	}
	// FORM LEVEL VALIDATION STARTS........


	public void pilm021_pm_il_cust_account_setup_pre_record() throws SQLException,Exception
	{
		System.out.println("PRE_RECORD CALLED......");
		connection = CommonUtils.getConnection();
		try
		{
			//L_SET_TYPE_BL();
			L_SET_SUB_ACCOUNT();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			/*if(connection != null)
			{
				connection.close();
			}*/
		}
	}

	public void L_SET_SUB_ACCOUNT() throws SQLException,Exception
	{
		System.out.println("L_SET_SUB_ACCOUNT CALLED.......");
		connection = CommonUtils.getConnection();
		try
		{
			String sql_C1="SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_MAIN_ACNT_CODE()+"' ";
			ResultSet vembu_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String  /** METADATA NOT FOUND ******** */ M_ACTY_HEAD_1=null;
			String  /** METADATA NOT FOUND ******** */ M_ACTY_HEAD_2=null;
			vembu_C1=stmt_C1.executeQuery(sql_C1);
			if(vembu_C1.next())
			{
				M_ACTY_HEAD_1=vembu_C1.getString(1);
				M_ACTY_HEAD_2=vembu_C1.getString(2);
			}
			if(vembu_C1.isAfterLast() || vembu_C1.isBeforeFirst())
			{
			}
			if(M_ACTY_HEAD_1== null)
			{
				COMP_CAS_ACTY_CODE_1.setRequired(false);
				COMP_CAS_ACTY_CODE_1.setDisabled(true);
			}
			else
			{
				COMP_CAS_ACTY_CODE_1.setDisabled(false);
				COMP_CAS_ACTY_CODE_1.setRequired(true);
			}
			if(M_ACTY_HEAD_2== null)
			{
				COMP_CAS_ACTY_CODE_1.setDisabled(false);
				COMP_CAS_ACTY_CODE_1.setReadonly(true);
			}
			else
			{
				COMP_CAS_ACTY_CODE_1.setDisabled(false);
				COMP_CAS_ACTY_CODE_1.setRequired(true);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public void pilm021_pm_il_cust_account_setup_pre_block() throws SQLException,Exception
	{
		System.out.println("PREBLOCK CALLED........");
		connection = CommonUtils.getConnection();
		try
		{
			CommonUtils.getControlBean().setM_DELETE_MSG_FLAG("Y");
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void pilm021_pm_il_cust_account_setup_pre_update() throws SQLException,Exception
	{
		System.out.println("PRE_UPDATE CALLED.........");
		connection = CommonUtils.getConnection();
		try
		{
			/*String sql_C1="SELECT 'X' FROM  PM_IL_CUST_ACCOUNT_SETUP  WHERE" +
			"('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_FM_CLASS()+"'" +
			" BETWEEN CAS_CUST_FM_CLASS  AND  CAS_CUST_TO_CLASS" +
			" OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_TO_CLASS()+"'" +
			" BETWEEN CAS_CUST_FM_CLASS  AND  CAS_CUST_TO_CLASS" +
			" OR CAS_CUST_FM_CLASS" +
			" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_FM_CLASS()+"'" +
			" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_TO_CLASS()+"'" +
			" OR CAS_CUST_TO_CLASS  BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_FM_CLASS()+"'" +
			" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_TO_CLASS()+"')" +
			" AND ('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_FM_CODE()+"'" +
			" BETWEEN CAS_DIVN_FM_CODE  AND  CAS_DIVN_TO_CODE" +
			" OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_TO_CODE()+"'" +
			" BETWEEN CAS_DIVN_FM_CODE  AND  CAS_DIVN_TO_CODE" +
			" OR CAS_DIVN_FM_CODE  BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_FM_CODE()+"'" +
			" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_TO_CODE()+"'  OR CAS_DIVN_TO_CODE" +
			" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_FM_CODE()+"'" +
			" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_TO_CODE()+"')  AND ('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_FM_CODE()+"'" +
			" BETWEEN CAS_DEPT_FM_CODE  AND  CAS_DEPT_TO_CODE  OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_TO_CODE()+"'" +
			" BETWEEN CAS_DEPT_FM_CODE  AND  CAS_DEPT_TO_CODE  OR CAS_DEPT_FM_CODE" +
			" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_FM_CODE()+"' AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_TO_CODE()+"'" +
			" OR CAS_DEPT_TO_CODE  BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_FM_CODE()+"'" +
			" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_TO_CODE()+"')  AND (TO_NUMBER(CAS_BUS_TYPE_FM)" +
			" BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)  AND  TO_NUMBER(CAS_BUS_TYPE_TO) " +
			" OR TO_NUMBER(CAS_BUS_TYPE_TO)  BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)" +
			" AND  TO_NUMBER(CAS_BUS_TYPE_TO)  OR TO_NUMBER(CAS_BUS_TYPE_FM)" +
			" BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)  AND  TO_NUMBER(CAS_BUS_TYPE_TO)" +
			" OR TO_NUMBER(CAS_BUS_TYPE_TO)  BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)" +
			" AND  TO_NUMBER(CAS_BUS_TYPE_TO))  AND ('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_FM()+"'" +
			" BETWEEN CAS_SRC_BUS_FM  AND  CAS_SRC_BUS_TO  OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_TO()+"'" +
			" BETWEEN CAS_SRC_BUS_FM  AND  CAS_SRC_BUS_TO  OR CAS_SRC_BUS_FM" +
			" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_FM()+"' AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_TO()+"'" +
			" OR CAS_SRC_BUS_TO  BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_FM()+"' " +
			" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_TO()+"') AND CAS_ASSURED_TYPE  = '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ASSURED_TYPE()+"'" +
			" AND ROWID  != '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getROWID()+"'";*/

			ResultSet rs_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String M_DUMMY=null;
			PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_UPD_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			//rs_C1=stmt_C1.executeQuery(sql_C1);
			/*if(rs_C1.next())
			{
				M_DUMMY=rs_C1.getString(1);
			}
			if(!rs_C1.isLast())
			{
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80031").getDetail());
			}
			rs_C1.close();*/
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public void pilm021_pm_il_cust_account_setup_post_query() throws SQLException,Exception
	{
		System.out.println("POST QUERY CALLED.........");
		connection = CommonUtils.getConnection();
		try
		{
			String  /** METADATA NOT FOUND *********/ M_CODE_DESC=null;
			double  /** METADATA NOT FOUND *********/ M_VALUE = 0 ;
			L_GET_ACTY_DETAILS();
			if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_BUS_TYPE_FM()!="0")
			{
				P_VAL_SYSTEM("CUSTBUSTYP",PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_BUS_TYPE_FM(),M_CODE_DESC,"W",M_VALUE);
				PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_BUS_TYPE_FM_DESC(M_CODE_DESC);
			}
			if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_BUS_TYPE_TO()!="999999999999")
			{
				P_VAL_SYSTEM("CUSTBUSTYP",PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_BUS_TYPE_TO(),M_CODE_DESC,"W",M_VALUE);
				PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_BUS_TYPE_TO_DESC(M_CODE_DESC);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	//L_GET_ACTY_DETAILS FOR POST-QUERY

	public void L_GET_ACTY_DETAILS() throws SQLException,Exception
	{
		System.out.println("L_GET_ACTY_DETAILS CALLED............");
		connection = CommonUtils.getConnection();
		try
		{
			String sql_C1="SELECT    MAIN_ACTY_CODE_1, MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_MAIN_ACNT_CODE()+"' ";
			ResultSet rs_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String M_ACTY_HEAD_1=null;
			String M_ACTY_HEAD_2=null;
			rs_C1=stmt_C1.executeQuery(sql_C1);
			if(rs_C1.next())
			{
				M_ACTY_HEAD_1=rs_C1.getString(1);
				M_ACTY_HEAD_2=rs_C1.getString(2);
			}
			if(rs_C1.isAfterLast() || rs_C1.isBeforeFirst())
			{
			}
			rs_C1.close();
			DUMMY_BEAN.setM_ACTY_HEAD_1(M_ACTY_HEAD_1);
			DUMMY_BEAN.setM_ACTY_HEAD_2(M_ACTY_HEAD_2);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public HashMap<String, String> P_VAL_SYSTEM(String P_TYPE,String P_CODE,String P_CODE_DESC,String P_ERR_FLAG,double P_VALUE) throws SQLException,Exception
	{
		System.out.println("P_VAL_SYSTEM CALLED......");
		HashMap<String, String> returnMap = new HashMap<String, String>();
		String M_NAME=null;
		String M_BL_NAME=null;
		double M_VALUE = 0.0;
		connection = CommonUtils.getConnection();
		String sql_C1="SELECT    PS_CODE_DESC,    PS_BL_CODE_DESC,    PS_VALUE FROM  PP_SYSTEM  WHERE  PS_TYPE  = '"+P_TYPE+"'  AND PS_CODE  = '"+P_CODE+"' ";
		ResultSet vembu_C1 = null;
		Statement stmt_C1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		vembu_C1=stmt_C1.executeQuery(sql_C1);
		if(vembu_C1.next())
		{
			M_NAME=vembu_C1.getString(1);
			M_BL_NAME=vembu_C1.getString(2);
			M_VALUE=vembu_C1.getDouble(3);
		}
		if(vembu_C1.isAfterLast() || vembu_C1.isBeforeFirst())
		{
			if(P_ERR_FLAG == ("W") || P_ERR_FLAG == ("E"))
			{
				if("E".equals(P_ERR_FLAG))
				{
					throw new Exception("Trigger failure exception");
				}
				throw new Exception(getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "1000")));
			}
		}
		if("1".equals(CommonUtils.SUBSTR((String) CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),5,1)) || "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")))
		{
			P_CODE_DESC=M_NAME;
		}
		else
		{
			P_CODE_DESC=M_BL_NAME;
		}
		P_VALUE=M_VALUE;

		returnMap.put("P_CODE_DESC",P_CODE_DESC);
		returnMap.put("P_VALUE",P_VALUE+"");
		return returnMap;
	}

	public void pilm021_pm_il_cust_account_setup_when_new_record_instance() throws SQLException,Exception
	{
		System.out.println("NEW RECORD INSTANCE CALLED.......");
		connection = CommonUtils.getConnection();
		try
		{
			String sql_C1="SELECT    MAIN_ACTY_CODE_1,    MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_MAIN_ACNT_CODE()+"' ";
			ResultSet vembu_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C2="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = '"+DUMMY_BEAN.getM_ACTY_1()+"'  ";
			ResultSet vembu_C2=null;
			Statement stmt_C2=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C3="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = '"+DUMMY_BEAN.getM_ACTY_2()+"' ";
			ResultSet vembu_C3=null;
			Statement stmt_C3=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String  /** METADATA NOT FOUND *********/ M_TEMP1=null;
			String  /** METADATA NOT FOUND *********/ M_TEMP2=null;
			if(vembu_C1!=null)
			{
				
			}
			vembu_C1=stmt_C1.executeQuery(sql_C1);
			if(vembu_C1.next())
			{
			}
			if(DUMMY_BEAN.getM_ACTY_1() != null)
			{
				vembu_C2=stmt_C2.executeQuery(sql_C2);
				if(vembu_C2.next())
				{
					M_TEMP1=vembu_C2.getString(1);
				}
				BP_BEAN.setBP_CAS_ACTY_CODE_1(StringFunctions.initcap(M_TEMP1));
				
			}
			else
			{
				BP_BEAN.setBP_CAS_ACTY_CODE_1("Activity Code1");
			}
			if(DUMMY_BEAN.getM_ACTY_2() != null)
			{
				vembu_C3=stmt_C3.executeQuery(sql_C3);
				if(vembu_C3.next())
				{
					M_TEMP2=vembu_C3.getString(1);
				}
				BP_BEAN.setBP_CAS_ACTY_CODE_2(StringFunctions.initcap(M_TEMP2));
				
			}
			else
			{
				BP_BEAN.setBP_CAS_ACTY_CODE_2("Activity Code2");
			}
			vembu_C1.close();
			COMP_CAS_FORCE_DEPT_YN.setDisabled(true);
			if(MigratingFunctions.nvl(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DIVN_YN(),"N")=="Y")
			{
				COMP_CAS_DIVN_CODE.setReadonly(true);
				COMP_CAS_DIVN_CODE.setRequired(false);
			}
			if(MigratingFunctions.nvl(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DIVN_YN(),"N")=="N")
			{
				COMP_CAS_DIVN_CODE.setReadonly(false);
				COMP_CAS_DIVN_CODE.setRequired(true);
			}
			if(MigratingFunctions.nvl(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DEPT_YN(),"N")=="Y")
			{
				COMP_CAS_DEPT_CODE.setReadonly(true);
				COMP_CAS_DEPT_CODE.setRequired(false);
			}
			if(MigratingFunctions.nvl(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DEPT_YN(),"N")=="N")
			{
				COMP_CAS_DEPT_CODE.setReadonly(false);
				COMP_CAS_DEPT_CODE.setRequired(true);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public String PreviousPage(){
		return "PreviousPage";
	}

	public List<SelectItem> getCAS_FORCE_DIVN_YN_LIST() {
		if (CAS_FORCE_DIVN_YN_LIST.size() ==0)
		{ 
			CAS_FORCE_DIVN_YN_LIST.clear();
			CAS_FORCE_DIVN_YN_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM021","PM_IL_CUST_ACCOUNT_SETUP","PM_IL_CUST_ACCOUNT_SETUP.CAS_FORCE_DIVN_YN","YESNO");
		}
		return CAS_FORCE_DIVN_YN_LIST;
	}

	public void setCAS_FORCE_DIVN_YN_LIST(
			List<SelectItem> cas_force_divn_yn_list) {
		CAS_FORCE_DIVN_YN_LIST = cas_force_divn_yn_list;
	}

	public List<SelectItem> getCAS_FORCE_DEPT_YN_LIST() {
		if (CAS_FORCE_DEPT_YN_LIST.size() ==0)
		{ 
			CAS_FORCE_DEPT_YN_LIST.clear();
			CAS_FORCE_DEPT_YN_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM021","PM_IL_CUST_ACCOUNT_SETUP","PM_IL_CUST_ACCOUNT_SETUP.CAS_FORCE_DEPT_YN","YESNO");
		}
		return CAS_FORCE_DEPT_YN_LIST;
	}

	public void setCLMAS_FORCE_DEPT_YN_LIST(
			List<SelectItem> cas_force_dept_yn_list) {
		CAS_FORCE_DEPT_YN_LIST = cas_force_dept_yn_list;
	}

	public List<SelectItem> getCAS_ASSURED_TYPE_LIST() {
		if (CAS_ASSURED_TYPE_LIST.size() ==0)
		{ 
			CAS_ASSURED_TYPE_LIST.clear();
			CAS_ASSURED_TYPE_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM021","PM_IL_CUST_ACCOUNT_SETUP","PM_IL_CUST_ACCOUNT_SETUP.CAS_ASSURED_TYPE","ASSRTYPE");
		}
		return CAS_ASSURED_TYPE_LIST;
	}

	public void setCLMAS_ASSURED_TYPE_LIST(List<SelectItem> cas_assured_type_list) {
		CAS_ASSURED_TYPE_LIST = cas_assured_type_list;
	}


	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return con;
	}

	public HtmlSelectOneMenu getCOMP_CAS_ASSURED_TYPE() {
		return COMP_CAS_ASSURED_TYPE;
	}

	public void setCOMP_CAS_ASSURED_TYPE(HtmlSelectOneMenu comp_cas_assured_type) {
		COMP_CAS_ASSURED_TYPE = comp_cas_assured_type;
	}

	public HtmlSelectOneMenu getCOMP_CAS_FORCE_DIVN_YN() {
		return COMP_CAS_FORCE_DIVN_YN;
	}

	public void setCOMP_CAS_FORCE_DIVN_YN(HtmlSelectOneMenu comp_cas_force_divn_yn) {
		COMP_CAS_FORCE_DIVN_YN = comp_cas_force_divn_yn;
	}

	public HtmlSelectOneMenu getCOMP_CAS_FORCE_DEPT_YN() {
		return COMP_CAS_FORCE_DEPT_YN;
	}

	public void setCOMP_CAS_FORCE_DEPT_YN(HtmlSelectOneMenu comp_cas_force_dept_yn) {
		COMP_CAS_FORCE_DEPT_YN = comp_cas_force_dept_yn;
	}

	public void pilm021_pm_il_cust_account_setup_cas_main_acnt_code_when_validate_item(FacesContext context,UIComponent component,Object value) {
		ResultSet rs_C1=null;
		ResultSet vembu_C2=null;
		ResultSet vembu_C3=null;
		String M_TEMP1=null;
		String M_TEMP2=null;
		String value1 = (String)value;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> outList;
		String sql_C1="SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
		String sql_C2="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
		String sql_C3="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
		String mainAcnt = (String) value;
		PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_MAIN_ACNT_CODE(mainAcnt);

		try{
			String qry = "SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE " +
						"  NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE = ? ";
			if(isExists(qry, new Object[]{value1})){
			outList = new DBProcedures().P_VAL_MAIN_ACNT(mainAcnt, "N","E");
			if(outList.size() >0 && outList.get(0) != null){
				getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_MAIN_ACNT_NAME(outList.get(0));
			}
			L_VAL_MAIN_ACTIVITY();
			System.out.println("Query -->>> "+sql_C1);
			rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]
			                        {PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_MAIN_ACNT_CODE()});
				if(rs_C1.next())
				{
					DUMMY_BEAN.setM_ACTY_1(rs_C1.getString(1));
					DUMMY_BEAN.setM_ACTY_2(rs_C1.getString(2));
				}
			
			if(DUMMY_BEAN.getM_ACTY_1() != null)
			{
				vembu_C2=rs_C1 = handler.executeSelectStatement(sql_C2, connection,new Object[]{DUMMY_BEAN.getM_ACTY_1()});
				if(vembu_C2.next())
				{
					M_TEMP1=vembu_C2.getString(1);
				}
				BP_BEAN.setBP_CAS_ACTY_CODE_1(StringFunctions.initcap(M_TEMP1));
			}
			else
			{
				BP_BEAN.setBP_CAS_ACTY_CODE_1("Activity Code1");
			}
			if(DUMMY_BEAN.getM_ACTY_2() != null)
			{
				vembu_C3 = handler.executeSelectStatement(sql_C3, connection,new Object[]{DUMMY_BEAN.getM_ACTY_2()});
				if(vembu_C3.next())
				{
					M_TEMP2=vembu_C3.getString(1);
				}
				BP_BEAN.setBP_CAS_ACTY_CODE_2(StringFunctions.initcap(M_TEMP2));
			}
			else
			{
				BP_BEAN.setBP_CAS_ACTY_CODE_2("Activity Code2");
			}
			}else{
				throw new Exception("Code does not Exist");
			}
			
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{
			try {
				CommonUtils.closeCursor(rs_C1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(vembu_C2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(vembu_C3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void L_VAL_MAIN_ACTIVITY() throws SQLException,Exception
	{
		System.out.println("L_VAL_MAIN_ACTIVITY");
		connection = getConnection();
		try
		{
			String sql_C1=" SELECT MAIN_ACTY_CODE_1, MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_MAIN_ACNT_CODE()+"'";
			ResultSet vembu_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String  M_ACTY_HEAD_1=null;
			String  M_ACTY_HEAD_2=null;
			vembu_C1=stmt_C1.executeQuery(sql_C1);
			if(vembu_C1.next())
			{
				M_ACTY_HEAD_1=vembu_C1.getString(1);
				M_ACTY_HEAD_2=vembu_C1.getString(2);
			}
			if(vembu_C1.isAfterLast() || vembu_C1.isBeforeFirst())
			{
			}
			if(M_ACTY_HEAD_1== null)
			{
				COMP_CAS_ACTY_CODE_1.setRequired(false);
				COMP_CAS_ACTY_CODE_1.setDisabled(true);
				if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ACTY_CODE_1() != null)
				{
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ACTY_CODE_1(null);
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(null);
				}
			}
			else
			{
				COMP_CAS_ACTY_CODE_1.setDisabled(false);
				COMP_CAS_ACTY_CODE_1.setRequired(true);

				PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ACTY_CODE_1(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ACTY_CODE_1());
			}
			if(M_ACTY_HEAD_2== null)
			{
				COMP_CAS_ACTY_CODE_2.setDisabled(true);
				COMP_CAS_ACTY_CODE_2.setRequired(false);
				if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ACTY_CODE_2() != null)
				{
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ACTY_CODE_2(null);
					PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
				}
			}
			else
			{
				COMP_CAS_ACTY_CODE_2.setDisabled(false);
				COMP_CAS_ACTY_CODE_2.setRequired(true);
				PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ACTY_CODE_2(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ACTY_CODE_2());
			}
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("validate",e.getMessage());
		}
	}

	public void pilm021_pm_il_cust_account_setup_cas_divn_code_when_validate_item(FacesContext context,UIComponent component,Object value){
		
		String P_DIVN_CODE, P_NAME_FLAG, P_ERR_FLAG = null;
		ArrayList<OracleParameter> resultList = null;
		String divCode = (String) value;
		PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_DIVN_CODE(divCode);
		try{
			String qry = "select 'X' from FM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND DIVN_CODE = ? ";
			if(isExists(qry, new Object[]{divCode})){
				if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_CODE() != null) {
	            	P_DIVN_CODE = PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_CODE();
	            	P_NAME_FLAG = "N" ;
	            	P_ERR_FLAG = "E" ;
	            	resultList = new LIFELIB().P_VAL_DIVN(P_DIVN_CODE, null, P_NAME_FLAG, P_ERR_FLAG);
	            	if(resultList.size() > 0 && resultList.get(0).getValue() != null){
	        			getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_DIVN_NAME(resultList.get(0).getValue());
	            	}
	            }
	            if(MigratingFunctions.nvl(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DIVN_YN(),"N")=="N"){
	                COMP_CAS_DIVN_CODE.setRequired(true);
	            }
	            L_SET_DEPT_ATTR();
			}else{
				throw new Exception("Code does not Exist");
			}
        }catch(Exception e){
        	throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
	
	public void L_SET_DEPT_ATTR() throws SQLException,Exception
    {
		System.out.println("L_SET_DEPT_ATTR");
		connection = getConnection();
        try
        {
            if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_CODE()== null)
            {
                COMP_CAS_DEPT_CODE.setRequired(false);
                COMP_CAS_DEPT_CODE.setReadonly(true);
                if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_CODE() != null)
                {
                    PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_DEPT_CODE(null);
                    PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(null);
                    System.out.println("L_SET_DEPT_ATTRPM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_DEPT_CODE()"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_CODE());
                    System.out.println("L_SET_DEPT_ATTR Submitted "+getCOMP_CAS_DEPT_CODE().getValue());
                }
            }
            else
            {
                COMP_CAS_DEPT_CODE.setRequired(true);
                COMP_CAS_DEPT_CODE.setReadonly(false);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
	
	 public void pilm021_pm_il_cust_account_setup_cas_dept_code_when_new_item_instance() throws SQLException,Exception
	    {
		 System.out.println("pilm021_pm_il_cust_account_setup_cas_dept_code_when_new_item_instance");
		 connection = getConnection();
	        try
	        {
	            L_SET_DEPT_ATTR();
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	 
	 public void pilm021_pm_il_cust_account_setup_cas_dept_code_when_validate_item(FacesContext context,UIComponent component,Object value){
		 ArrayList<OracleParameter> resultList = null;
		 String P_DIVN_CODE,P_DEPT_CODE,P_NAME_FLAG,P_ERR_FLAG = null;
		 String deptCode = (String) value;
		 PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_DEPT_CODE(deptCode);
		  try{
			  String qry = "SELECT 'X' FROM FM_DEPARTMENT WHERE " +
			  		" DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = ? AND " +
				" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP " +
				" WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
				" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID " +
				" AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?  ";  
			  if(isExists(qry, new Object[]{PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_CODE(),deptCode})){
		            PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(null);
		            if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_CODE() != null){
		           		P_DIVN_CODE = PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_CODE();
		           		P_DEPT_CODE = PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_CODE();
		           		P_NAME_FLAG = "N";
		           		P_ERR_FLAG = "E";
		           		resultList = new LIFELIB().P_VAL_DEPT(P_DIVN_CODE, P_DEPT_CODE,null, P_NAME_FLAG, P_ERR_FLAG);
		           		if(resultList.size() > 0 && resultList.get(0).getValue() != null ){
	           			getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_DEPT_NAME(resultList.get(0).getValue());
		            	}
		            }
		            if(MigratingFunctions.nvl(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DEPT_YN(),"N")=="N"){
		                COMP_CAS_DEPT_CODE.setRequired(true);
		            }
			  }else{
				  throw new Exception("Code does not exist");
			  }
	        }catch(Exception e){
	        	e.printStackTrace();
	        	throw new ValidatorException(new FacesMessage(e.getMessage()));
	        }
	    }
	 
	 
	 public void pilm021_pm_il_cust_account_setup_cas_anly_code_1_when_validate_item(FacesContext context,UIComponent component,Object value) {
		 	ArrayList<String> outList;
		 	PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ANLY_CODE_1((String) value);
			try{
				String qry = "SELECT 'X' FROM FM_ANALYSIS WHERE " +
							" ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE  = ? ";
				if(isExists(qry, new Object[]{(String) value})){
				PM_IL_CUST_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(null);
	            if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ANLY_CODE_1() != null){
	            	outList = new DBProcedures().P_VAL_ANLY1("1",PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ANLY_CODE_1(), "N", "E");
	            	if(outList.size() > 0 && outList.get(0) != null){
	            		getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_ANLY_NAME( outList.get(0));
	            	}
	            }
	            L_SET_ANALYSIS_ATTR();
				}else{
					throw new Exception("Code does not exist");
				}
				
	        }catch(Exception e){
	        	e.printStackTrace();
	        	throw new ValidatorException(new FacesMessage(e.getMessage()));
	        }
	    }
	 
	 public void pilm021_pm_il_cust_account_setup_cas_anly_code_2_when_validate_item(FacesContext context,UIComponent component,Object value1){
			ArrayList<String> outList;
			String value = (String) value1;
			PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ANLY_CODE_2(value);
			try{
				String qry = "SELECT 'X' FROM FM_ANALYSIS where " +
						" ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ? ";
				if(isExists(qry, new Object[]{value})){
					if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ANLY_CODE_2()!= null){
	        			outList = new DBProcedures().P_VAL_ANLY1("2", PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ANLY_CODE_2(), "N", "E");
	        			if(outList.size()> 0 && outList.get(0) != null){
	        			getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_ANLY_NAME_1(outList.get(0));
	        			}
					}
				}else{
					throw new Exception("Code does not exist");
				}
	        }catch(Exception e){
	        	e.printStackTrace();
	        	throw new ValidatorException(new FacesMessage(e.getMessage()));
	        	}
	    }
	 
		public void L_SET_ANALYSIS_ATTR() throws SQLException,Exception
	    {
			connection = getConnection();
			try
	        {
	            if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ANLY_CODE_1()== null)
	            {
	                COMP_CAS_ANLY_CODE_2.setReadonly(true);
	            }
	            else
	            {
	            	COMP_CAS_ANLY_CODE_2.setReadonly(false);
	            }
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
		
		public void pilm021_pm_il_cust_account_setup_cas_acty_code_1_when_validate_item(FacesContext context,UIComponent component,Object value){
			ArrayList<String> outList = null;
			PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ACTY_CODE_1((String )value);
			try{
	            if((String)value != null){
		            	String qry ="SELECT 'X' FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE = ? AND AVAL_CODE = ? ";
		            	if(isExists(qry, new Object[]{DUMMY_BEAN.getM_ACTY_1(),(String )value})){
			            	outList = DBProcedures.P_VAL_ACTY(DUMMY_BEAN.getM_ACTY_1(), PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ACTY_CODE_1(), "N", "E");
		        			if(outList.size() > 0 && outList.get(0) != null){
		        				getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_NAME(outList.get(0));
		        			}
		            	} else{
		            			throw new Exception("Code does not exist");
	            }
	            }
	        }catch(Exception e){
	        	e.printStackTrace();
	        	getErrorMap().put("current",e.getMessage());
	        	getErrorMap().put("validate",e.getMessage());
	        }
	    }
	 
		public void pilm021_pm_il_cust_account_setup_cas_acty_code_2_when_validate_item(FacesContext context,UIComponent component,Object value) 
			throws SQLException,Exception{
			ArrayList<String> outList;
			PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ACTY_CODE_2((String)value);
			try{
	            if((String)value != null){
	            	String qry = "SELECT 'X' FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE = ?  AND AVAL_CODE = ? ";
        			if(isExists(qry, new Object[]{DUMMY_BEAN.getM_ACTY_2(), (String)value})){
		            	outList = DBProcedures.P_VAL_ACTY(DUMMY_BEAN.getM_ACTY_2(), PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ACTY_CODE_2(), "N", "E");
		        			if(outList.size() > 0 && outList.get(0) != null){
		        				getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_NAME_1(outList.get(0));
		        			}
			            }else{
			            	throw new Exception("Code does not exist");
			            }
	            }
	        }catch(Exception e){
	        	e.printStackTrace();
	        	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("validate",e.getMessage());
	        }
	    }
	 
	 
	 
	 public void ForceBranchChange(ActionEvent ae){
			String value = getCOMP_CAS_FORCE_DIVN_YN().getSubmittedValue().toString();
			if(value.equals("Y")){
				getCOMP_CAS_DIVN_CODE().setDisabled(true);
				getCOMP_CAS_DIVN_CODE().setRequired(false);
			}else{
				getCOMP_CAS_DIVN_CODE().setDisabled(false);
				getCOMP_CAS_DIVN_CODE().setRequired(true);
			}
			getCOMP_CAS_FORCE_DEPT_YN().setSubmittedValue(value);
			CAS_FORCE_DEPT_YN_WHEN_LIST_CHANGED(value);
	 }
	public void CAS_FORCE_DEPT_YN_WHEN_LIST_CHANGED(String value){
		if(value.equals("Y")){
			getCOMP_CAS_DEPT_CODE().setDisabled(true);
			getCOMP_CAS_DEPT_CODE().setRequired(false);
		}else{
			getCOMP_CAS_DEPT_CODE().setDisabled(false);
			getCOMP_CAS_DEPT_CODE().setRequired(true);
		}
	}

	public ArrayList<PM_IL_CUST_ACCOUNT_SETUP> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(ArrayList<PM_IL_CUST_ACCOUNT_SETUP> detailsList) {
		this.detailsList = detailsList;
	}
	
	 public void pilm021_pm_il_cust_account_setup_pre_insert() throws Exception
	    {
			 PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
	         PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	         L_OVERLAP_CHECK();
	   }
	 
	 public void L_OVERLAP_CHECK() throws Exception
	    {
		 System.out.println("L_OVERLAP_CHECK");
		 String M_DUMMY=null;
	        try
	        {
	        	connection = CommonUtils.getConnection();
	            String sql_C1="SELECT 'X' FROM  PM_IL_CUST_ACCOUNT_SETUP  WHERE  " +
	            		"('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_FM_CLASS()+"' BETWEEN CAS_CUST_FM_CLASS  AND  CAS_CUST_TO_CLASS  " +
	            		" OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_TO_CLASS()+"' BETWEEN CAS_CUST_FM_CLASS  AND  CAS_CUST_TO_CLASS  OR CAS_CUST_FM_CLASS " +
	            		" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_FM_CLASS()+"'  AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_TO_CLASS()+"' OR CAS_CUST_TO_CLASS " +
	            		" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_FM_CLASS()+"'  AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_CUST_TO_CLASS()+"')  " +
	            		" AND ('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_FM_CODE()+"' BETWEEN CAS_DIVN_FM_CODE  AND  CAS_DIVN_TO_CODE  " +
	            		" OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_TO_CODE()+"' BETWEEN CAS_DIVN_FM_CODE  AND  CAS_DIVN_TO_CODE  OR CAS_DIVN_FM_CODE " +
	            		" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_FM_CODE()+"' AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_TO_CODE()+"' OR CAS_DIVN_TO_CODE  " +
	            		" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_FM_CODE()+"' AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DIVN_TO_CODE()+"') " +
	            		" AND ('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_FM_CODE()+"' BETWEEN CAS_DEPT_FM_CODE  AND  CAS_DEPT_TO_CODE " +
	            		" OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_TO_CODE()+"' BETWEEN CAS_DEPT_FM_CODE  AND  CAS_DEPT_TO_CODE  OR CAS_DEPT_FM_CODE " +
	            		" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_FM_CODE()+"' AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_TO_CODE()+"' OR CAS_DEPT_TO_CODE " +
	            		" BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_FM_CODE()+"'  AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_DEPT_TO_CODE()+"')  AND (TO_NUMBER(CAS_BUS_TYPE_FM)  BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)  AND  TO_NUMBER(CAS_BUS_TYPE_TO) " +
	            		" OR TO_NUMBER(CAS_BUS_TYPE_TO)  BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)  AND  TO_NUMBER(CAS_BUS_TYPE_TO)  OR TO_NUMBER(CAS_BUS_TYPE_FM)  BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)  AND  TO_NUMBER(CAS_BUS_TYPE_TO)  OR TO_NUMBER(CAS_BUS_TYPE_TO) " +
	            		" BETWEEN TO_NUMBER(CAS_BUS_TYPE_FM)  AND  TO_NUMBER(CAS_BUS_TYPE_TO))  AND ('"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_FM()+"'" +
	            		" BETWEEN CAS_SRC_BUS_FM  AND  CAS_SRC_BUS_TO  OR '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_TO()+"'  BETWEEN CAS_SRC_BUS_FM  AND  CAS_SRC_BUS_TO  OR CAS_SRC_BUS_FM  BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_FM()+"' " +
	            		" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_TO()+"' OR CAS_SRC_BUS_TO  BETWEEN '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_FM()+"' " +
	            		" AND  '"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_SRC_BUS_TO()+"')  AND CAS_ASSURED_TYPE  = '"+getCOMP_CAS_ASSURED_TYPE().getValue()+"'";
	            ResultSet vembu_C1=null;
	            Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            vembu_C1=stmt_C1.executeQuery(sql_C1);
	            System.out.println("QUERY >>>>"+sql_C1);
	            if(vembu_C1.next())
	            {
	                M_DUMMY=vembu_C1.getString(1);
	                throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"80031"));
	            }
	            vembu_C1.close();
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	 
	 public void pilm021_pm_il_cust_account_setup_cas_force_dept_yn_when_validate_item()    {
	        try
	        {
	        	if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
	        			PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DEPT_YN(), "N"))) {
	        		COMP_CAS_DEPT_CODE.setRequired(false);
					COMP_CAS_DEPT_CODE.setDisabled(true);
				}
	        	if ("N".equalsIgnoreCase(MigratingFunctions.nvl(
	        			PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DEPT_YN(), "N"))) {
					COMP_CAS_DEPT_CODE.setDisabled(false);
					COMP_CAS_DEPT_CODE.setRequired(true);
				}
	        	getCOMP_CAS_FORCE_DEPT_YN().setSubmittedValue(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_FORCE_DEPT_YN());
	        }catch(Exception e)
	        {	e.printStackTrace();
	        	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("validate",e.getMessage());
	        }
	    }
	 
	 public void pilm021_pm_il_cust_account_setup_cas_assured_type_when_validate_item(ActionEvent ae)  {
		 System.out.println("pilm021_pm_il_cust_account_setup_cas_assured_type_when_validate_item");
		 connection = getConnection();
	        try
	        {
	        	System.out.println("BEAN VALUE :::::"+PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ASSURED_TYPE());
	        	System.out.println("SUBMITTED VALUE :::::"+getCOMP_CAS_ASSURED_TYPE().getSubmittedValue());
	        	PM_IL_CUST_ACCOUNT_SETUP_BEAN.setCAS_ASSURED_TYPE((String) getCOMP_CAS_ASSURED_TYPE().getSubmittedValue());
	        	if(PM_IL_CUST_ACCOUNT_SETUP_BEAN.getCAS_ASSURED_TYPE()== null)
	            {
	            	getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath,"91022"));
	            }
	        	CommonUtils.objectSysout(PM_IL_CUST_ACCOUNT_SETUP_BEAN);
	        }catch(Exception e){
	        	e.printStackTrace();
	        	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("validate",e.getMessage());
	        }
	    }

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public BP getBP_BEAN() {
		return BP_BEAN;
	}

	public void setBP_BEAN(BP bp_bean) {
		BP_BEAN = bp_bean;
	}

	public void setCAS_FORCE_DEPT_YN_LIST(List<SelectItem> cas_force_dept_yn_list) {
		CAS_FORCE_DEPT_YN_LIST = cas_force_dept_yn_list;
	}

	public void setCAS_ASSURED_TYPE_LIST(List<SelectItem> cas_assured_type_list) {
		CAS_ASSURED_TYPE_LIST = cas_assured_type_list;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void prepareDetails(String rowId)
	{
		PM_IL_CUST_ACCOUNT_SETUP beanClass  = new PM_IL_CUST_ACCOUNT_SETUP();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			String query = "SELECT CAS_CUST_FM_CLASS,CAS_CUST_TO_CLASS,CAS_DIVN_FM_CODE," +
					"CAS_DIVN_TO_CODE,CAS_DEPT_FM_CODE,CAS_DEPT_TO_CODE,CAS_FORCE_DIVN_YN," +
					"CAS_FORCE_DEPT_YN,CAS_MAIN_ACNT_CODE,CAS_DIVN_CODE,CAS_DEPT_CODE," +
					"CAS_ANLY_CODE_1,CAS_ANLY_CODE_2,CAS_ACTY_CODE_1,CAS_ACTY_CODE_2," +
					"CAS_FRZ_FLAG,CAS_ASSURED_TYPE,CAS_SRC_BUS_FM,CAS_SRC_BUS_TO," +
					"CAS_BUS_TYPE_FM,CAS_BUS_TYPE_TO,ROWID FROM PM_IL_CUST_ACCOUNT_SETUP WHERE ROWID = ?";
			
			System.out.println("Query:::"+query+"   ROWID:::::::"+rowId);
			Object values[] = {rowId};
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next())
			{
				beanClass.setROWID(resultSet.getString("ROWID"));
				beanClass.setCAS_DIVN_FM_CODE(resultSet.getString("CAS_DIVN_FM_CODE"));
				beanClass.setCAS_DIVN_TO_CODE(resultSet.getString("CAS_DIVN_TO_CODE"));
				beanClass.setCAS_CUST_FM_CLASS(resultSet.getString("CAS_CUST_FM_CLASS"));
				beanClass.setCAS_CUST_TO_CLASS(resultSet.getString("CAS_CUST_TO_CLASS"));
				beanClass.setCAS_DEPT_FM_CODE(resultSet.getString("CAS_DEPT_FM_CODE"));
				beanClass.setCAS_DEPT_TO_CODE(resultSet.getString("CAS_DEPT_TO_CODE"));
				beanClass.setCAS_ANLY_CODE_1(resultSet.getString("CAS_ANLY_CODE_1"));
				beanClass.setCAS_ANLY_CODE_2(resultSet.getString("CAS_ANLY_CODE_2"));
				beanClass.setCAS_ACTY_CODE_1(resultSet.getString("CAS_ACTY_CODE_1"));
				beanClass.setCAS_ACTY_CODE_2(resultSet.getString("CAS_ACTY_CODE_2"));
				beanClass.setCAS_SRC_BUS_FM(resultSet.getString("CAS_SRC_BUS_FM"));
				beanClass.setCAS_SRC_BUS_TO(resultSet.getString("CAS_SRC_BUS_TO"));
				beanClass.setCAS_BUS_TYPE_FM(resultSet.getString("CAS_BUS_TYPE_FM"));
				beanClass.setCAS_BUS_TYPE_TO(resultSet.getString("CAS_BUS_TYPE_TO"));
				beanClass.setCAS_ASSURED_TYPE(resultSet.getString("CAS_ASSURED_TYPE"));
				beanClass.setCAS_FORCE_DEPT_YN(resultSet.getString("CAS_FORCE_DEPT_YN"));
				beanClass.setCAS_FORCE_DIVN_YN(resultSet.getString("CAS_FORCE_DIVN_YN"));
				beanClass.setCAS_MAIN_ACNT_CODE(resultSet.getString("CAS_MAIN_ACNT_CODE"));
				beanClass.setCAS_DIVN_CODE(resultSet.getString("CAS_DIVN_CODE"));
				beanClass.setCAS_DEPT_CODE(resultSet.getString("CAS_DEPT_CODE"));
				
				fieldDescription(beanClass);
			}
			this.setPM_IL_CUST_ACCOUNT_SETUP_BEAN(beanClass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	 public void fieldDescription(PM_IL_CUST_ACCOUNT_SETUP CustBean)
	 {
		 	String mainAcntDesc = null;
			String divnCodeDesc = null;
			String deptCodeDesc = null;
			String analysisDesc01 = null;
			String analysisDesc02 = null;
			
			String mainAcntQuery = "SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE = ? ";
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
			//String divnCodeQuery = "select DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE = '001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE = ?";
			String divnCodeQuery = "select DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE = ?";
			String deptCodeQuery = "SELECT DEPT_NAME FROM PM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND DEPT_CODE =  ?";
			String analysisQuery01 = "SELECT ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ?";
			String analysisQuery02 = "select ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ?";
			
			mainAcntDesc = fetchClaimDesc(CustBean.getCAS_MAIN_ACNT_CODE(), mainAcntQuery, "MAIN_ACNT_NAME");
			divnCodeDesc = fetchClaimDesc(CustBean.getCAS_DIVN_CODE(), divnCodeQuery, "DIVN_NAME");
			deptCodeDesc = fetchClaimDesc(CustBean.getCAS_DEPT_CODE(), deptCodeQuery, "DEPT_NAME");
			analysisDesc01 = fetchClaimDesc(CustBean.getCAS_ANLY_CODE_1(), analysisQuery01, "ANLY_NAME");
			analysisDesc02 = fetchClaimDesc(CustBean.getCAS_ANLY_CODE_2(), analysisQuery02, "ANLY_NAME");
			
			CustBean.setUI_M_MAIN_ACNT_NAME(mainAcntDesc);
			CustBean.setUI_M_DIVN_NAME(divnCodeDesc);
			CustBean.setUI_M_DEPT_NAME(deptCodeDesc);
			CustBean.setUI_M_ANLY_NAME(analysisDesc01);
			CustBean.setUI_M_ANLY_NAME_1(analysisDesc02);
	 }
	 
	 public String fetchClaimDesc(String AccountCode,String selectQuery,String filedValue){
			String assignValue = null;
			Connection con = null;
			ResultSet rst = null;
			CRUDHandler handler = null;
			try {
				con = CommonUtils.getConnection();
				if(con!= null){
					handler = new CRUDHandler();
					Object[] values = {AccountCode};
					rst = handler.executeSelectStatement(selectQuery, con, values);
					if(rst.next()){
						assignValue = rst.getString(filedValue);
						assignValue = assignValue == null ? "" : assignValue;
					}
				}
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return assignValue;
		}
	  
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;

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
	 
	 public String delete() {
			getErrorMap().clear();
			CRUDHandler handler = new CRUDHandler();
			try {
				handler.executeDelete(PM_IL_CUST_ACCOUNT_SETUP_BEAN,
						CommonUtils.getConnection());
				getConnection().commit();
				PM_IL_CUST_ACCOUNT_SETUP_BEAN = new PM_IL_CUST_ACCOUNT_SETUP();
				resetAllComponent();
				getWarningMap().put("deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("deleteRow", e.getMessage());
			}
			return "";
		}
	 
	 /**
		 * Resets all components in PM_IL_CUST_ACCOUNT_SETUP_ACTION
		 */
		public void resetAllComponent(){
			// Reseting HtmlInputText
			COMP_CAS_SRC_BUS_FM.resetValue();
			COMP_CAS_SRC_BUS_TO.resetValue();
			COMP_CAS_CUST_FM_CLASS.resetValue();
			COMP_CAS_CUST_TO_CLASS.resetValue();
			COMP_CAS_DIVN_FM_CODE.resetValue();
			COMP_CAS_DIVN_TO_CODE.resetValue();
			COMP_CAS_DEPT_FM_CODE.resetValue();
			COMP_CAS_DEPT_TO_CODE.resetValue();
			COMP_CAS_BUS_TYPE_FM.resetValue();
			COMP_CAS_BUS_TYPE_TO.resetValue();
			COMP_CAS_MAIN_ACNT_CODE.resetValue();
			COMP_UI_M_MAIN_ACNT_NAME.resetValue();
			COMP_CAS_DIVN_CODE.resetValue();
			COMP_UI_M_DIVN_NAME.resetValue();
			COMP_CAS_DEPT_CODE.resetValue();
			COMP_UI_M_DEPT_NAME.resetValue();
			COMP_CAS_ANLY_CODE_1.resetValue();
			COMP_UI_M_ANLY_NAME.resetValue();
			COMP_CAS_ANLY_CODE_2.resetValue();
			COMP_UI_M_ANLY_NAME_1.resetValue();
			COMP_CAS_ACTY_CODE_1.resetValue();
			COMP_UI_M_ACTY_NAME.resetValue();
			COMP_CAS_ACTY_CODE_2.resetValue();
			COMP_UI_M_ACTY_NAME_1.resetValue();
			COMP_UI_M_BUS_TYPE_FM_DESC.resetValue();
			COMP_UI_M_BUS_TYPE_TO_DESC.resetValue();

			// Reseting HtmlSelectOneMenu
			COMP_CAS_ASSURED_TYPE.resetValue();
			COMP_CAS_FORCE_DIVN_YN.resetValue();
			COMP_CAS_FORCE_DEPT_YN.resetValue();
		}

		 /*As suggested by siva sir sadded by gopi for toi on 04/09/2018*/
			private HtmlOutputLabel COMP_CAS_DOC_DRCR_LABEL;
		     
			 public HtmlOutputLabel getCOMP_CAS_DOC_DRCR_LABEL() {
				return COMP_CAS_DOC_DRCR_LABEL;
			}

			public void setCOMP_CAS_DOC_DRCR_LABEL(HtmlOutputLabel cOMP_CAS_DOC_DRCR_LABEL) {
				COMP_CAS_DOC_DRCR_LABEL = cOMP_CAS_DOC_DRCR_LABEL;
			}

			public HtmlSelectOneMenu getCOMP_CAS_DOC_DRCR() {
				return COMP_CAS_DOC_DRCR;
			}

			public void setCOMP_CAS_DOC_DRCR(HtmlSelectOneMenu cOMP_CAS_DOC_DRCR) {
				COMP_CAS_DOC_DRCR = cOMP_CAS_DOC_DRCR;
			}

			private HtmlSelectOneMenu COMP_CAS_DOC_DRCR;

			//end
			
			
			
			/*As suggested by siva sir sadded by gopi for toi on 04/09/2018*/
			List<SelectItem> CAS_DOC_DRCR_LIST = new ArrayList<SelectItem>();

				/*As suggested by siva sir sadded by gopi for toi on 04/09/2018*/
				public List<SelectItem> getCAS_DOC_DRCR_LIST() {
					if (CAS_DOC_DRCR_LIST.size() ==0)
					{ 
						CAS_DOC_DRCR_LIST.clear();
						CAS_DOC_DRCR_LIST = ListItemUtil.getDropDownListValue(getConnection(),
											"PILM021","PM_IL_CUST_ACCOUNT_SETUP","PM_IL_CUST_ACCOUNT_SETUP.CAS_DOC_DRCR","IL_DRCR_TYPE");
					}
					return CAS_DOC_DRCR_LIST;
				}

				//end
				
				
			

			public void setCAS_DOC_DRCR_LIST(List<SelectItem> cAS_DOC_DRCR_LIST) {
				CAS_DOC_DRCR_LIST = cAS_DOC_DRCR_LIST;
			}
			//end
	 
}
